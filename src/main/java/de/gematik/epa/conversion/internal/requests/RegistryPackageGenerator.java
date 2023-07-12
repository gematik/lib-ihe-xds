/*
 * Copyright 2023 gematik GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.gematik.epa.conversion.internal.requests;

import de.gematik.epa.conversion.internal.requests.DocumentGenerator.DocumentGeneratorList;
import de.gematik.epa.conversion.internal.requests.factories.OasisObjectType;
import de.gematik.epa.conversion.internal.requests.factories.RegistryObjectFactory;
import de.gematik.epa.conversion.internal.requests.factories.classification.RegistryPackageTypeClassificationFactory;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierFactory;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

@UtilityClass
public class RegistryPackageGenerator {

  public static List<RegistryPackageType> createFolderRegistryPackages(
      DocumentSubmissionRequest documentSubmissionRequest,
      List<AssociationType1> documentToFolderAssociations,
      DocumentGeneratorList documentGenerators) {
    return documentGenerators.stream()
        .filter(dg -> Objects.nonNull(dg.folderMetadata()))
        .filter(dg -> Objects.isNull(dg.folderMetadata().entryUUID()))
        .map(
            dg ->
                createFolderRegistryPackage(
                    documentSubmissionRequest, dg, documentToFolderAssociations))
        .toList();
  }

  public static RegistryPackageType createFolderRegistryPackage(
      DocumentSubmissionRequest documentSubmissionRequest,
      DocumentGenerator documentData,
      List<AssociationType1> documentToFolderAssociations) {

    var folderMetadata =
        Objects.requireNonNull(
            documentData.folderMetadata(),
            "DocumentGenerator does not contain Document with folderMetadata present "
                + documentData);

    var association =
        documentToFolderAssociations.stream()
            .filter(asso -> asso.getTargetObject().equals(documentData.id()))
            .findFirst()
            .orElseThrow(
                () -> new IllegalArgumentException("Association for the new folder is missing"));

    var registryPackage =
        createNewFolderRegistryPackage(
            association.getSourceObject(),
            documentSubmissionRequest.recordIdentifier().getHomeCommunityId());

    RegistryObjectFactory.setName(registryPackage, folderMetadata.title());
    RegistryObjectFactory.setDescription(registryPackage, folderMetadata.comments());

    Optional.ofNullable(folderMetadata.availabilityStatus()).ifPresent(registryPackage::setStatus);

    RegistryPackageTypeClassificationFactory.createFolderClassifications(
        folderMetadata, registryPackage);

    ExternalIdentifierFactory.forFolder(
        registryPackage,
        folderMetadata,
        documentSubmissionRequest.recordIdentifier().getInsurantId());

    return registryPackage;
  }

  public static RegistryPackageType createNewFolderRegistryPackage(
      String id, String homeCommunityId) {
    var registryPackage = createNewRegistryPackage(homeCommunityId);
    registryPackage.setId(id);
    return registryPackage;
  }

  public static RegistryPackageType createNewRegistryPackage(String homeCommunityId) {
    var registryPackage = new RegistryPackageType();
    registryPackage.setObjectType(OasisObjectType.REGISTRY_PACKAGE.getValue());
    registryPackage.setHome(homeCommunityId);

    return registryPackage;
  }

  public static List<JAXBElement<RegistryPackageType>> toRegistryPackageJaxbElements(
      List<RegistryPackageType> registryPackages) {
    return registryPackages.stream()
        .map(RegistryPackageGenerator::toRegistryPackageJaxbElement)
        .toList();
  }

  public static JAXBElement<RegistryPackageType> toRegistryPackageJaxbElement(
      RegistryPackageType registryPackage) {
    return new oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectFactory()
        .createRegistryPackage(registryPackage);
  }
}
