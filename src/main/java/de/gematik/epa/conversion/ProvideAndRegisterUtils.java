/*-
 * #%L
 * lib-ihe-xds
 * %%
 * Copyright (C) 2023 - 2025 gematik GmbH
 * %%
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
 *
 * *******
 *
 * For additional notes and disclaimer from gematik and in case of changes
 * by gematik, find details in the "Readme" file.
 * #L%
 */
package de.gematik.epa.conversion;

import de.gematik.epa.conversion.internal.AssociationGenerator;
import de.gematik.epa.conversion.internal.DateUtil;
import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.conversion.internal.requests.ExtrinsicObjectGenerator;
import de.gematik.epa.conversion.internal.requests.RegistryPackageGenerator;
import de.gematik.epa.conversion.internal.requests.factories.classification.RegistryPackageTypeClassificationFactory;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.request.DocumentReplaceRequest;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.ihe.model.request.SubmissionRequestInterface;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
import jakarta.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.lcm._3.SubmitObjectsRequest;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

@UtilityClass
public class ProvideAndRegisterUtils {

  public static ProvideAndRegisterDocumentSetRequestType toProvideAndRegisterDocumentSetRequest(
      SubmissionRequestInterface<?> submissionRequest) {

    var docGenerators =
        DocumentGenerator.generators(submissionRequest.documents(), submissionRequest.insurantId());

    var submitObjectRequest = createSubmitObjectsRequest(submissionRequest, docGenerators);
    var provideAndRegisterDocumentSetRequest = new ProvideAndRegisterDocumentSetRequestType();
    provideAndRegisterDocumentSetRequest.setSubmitObjectsRequest(submitObjectRequest);
    provideAndRegisterDocumentSetRequest.getDocument().addAll(docGenerators.iheDocuments());
    return provideAndRegisterDocumentSetRequest;
  }

  public static SubmitObjectsRequest createSubmitObjectsRequest(
      SubmissionRequestInterface<?> submissionRequest,
      DocumentGenerator.DocumentGeneratorList docGenerators) {
    var submitObjectRequest = new SubmitObjectsRequest();

    var registryObjectList = new RegistryObjectListType();
    submitObjectRequest.setRegistryObjectList(registryObjectList);

    registryObjectList.getIdentifiable().addAll(createExtrinsicObjects(docGenerators));

    if (submissionRequest instanceof DocumentSubmissionRequest documentSubmissionRequest) {
      registryObjectList
          .getIdentifiable()
          .addAll(
              createFolderRegistryPackagesAndAssociations(
                  documentSubmissionRequest, docGenerators));
    }

    var submissionSetRegistryPackage = createSubmissionSetRegistryPackage(submissionRequest);

    registryObjectList
        .getIdentifiable()
        .addAll(createSubmissionSetAssociations(submissionSetRegistryPackage, registryObjectList));

    if (submissionRequest instanceof DocumentReplaceRequest) {
      registryObjectList.getIdentifiable().addAll(createReplaceAssociations(docGenerators));
    }

    registryObjectList
        .getIdentifiable()
        .add(
            0,
            de.gematik.epa.conversion.internal.requests.RegistryPackageGenerator
                .toRegistryPackageJaxbElement(submissionSetRegistryPackage));

    return submitObjectRequest;
  }

  public static RegistryPackageType createSubmissionSetRegistryPackage(
      SubmissionRequestInterface<?> submissionRequestInterface) {
    var submissionSetMetadata = submissionRequestInterface.submissionSetMetadata();

    var registryPackage =
        de.gematik.epa.conversion.internal.requests.RegistryPackageGenerator
            .createNewRegistryPackage();
    registryPackage.setId(UUID.randomUUID().toString());

    registryPackage
        .getSlot()
        .add(SlotFactory.slot(SlotName.SUBMISSION_TIME.getName(), DateUtil.now()));

    RegistryPackageTypeClassificationFactory.createSubmissionSetClassifications(
        submissionSetMetadata, registryPackage);

    ExternalIdentifierFactory.forSubmissionSet(
        registryPackage, submissionRequestInterface.insurantId());

    return registryPackage;
  }

  public static List<JAXBElement<ExtrinsicObjectType>> createExtrinsicObjects(
      DocumentGenerator.DocumentGeneratorList docGenerators) {
    return ExtrinsicObjectGenerator.toJaxbElements(docGenerators.extrinsicObjects());
  }

  public static List<JAXBElement<ExtrinsicObjectType>> createExtrinsicObjectsRMU(
      DocumentGenerator.DocumentGeneratorList docGenerators) {
    return ExtrinsicObjectGenerator.toJaxbElements(docGenerators.extrinsicObjectsRMU());
  }

  public static List<JAXBElement<? extends RegistryObjectType>>
      createFolderRegistryPackagesAndAssociations(
          DocumentSubmissionRequest documentSubmissionRequest,
          DocumentGenerator.DocumentGeneratorList docGenerators) {
    var associations = AssociationGenerator.createFolderToDocumentAssociations(docGenerators);

    var folderRegistryPackages =
        RegistryPackageGenerator.createFolderRegistryPackages(
            documentSubmissionRequest, associations, docGenerators);

    var jaxbAssociations = AssociationGenerator.toAssociationJaxbElements(associations);
    var jaxbRegistryPackages =
        RegistryPackageGenerator.toRegistryPackageJaxbElements(folderRegistryPackages);

    List<JAXBElement<? extends RegistryObjectType>> resultList =
        new ArrayList<>(jaxbRegistryPackages);
    resultList.addAll(jaxbAssociations);
    return resultList;
  }

  public static List<JAXBElement<AssociationType1>> createSubmissionSetAssociations(
      RegistryPackageType submissionSet, RegistryObjectListType registryObjectList) {
    return registryObjectList.getIdentifiable().stream()
        .map(JAXBElement::getValue)
        .map(
            identifiable -> {
              var association =
                  de.gematik.epa.conversion.internal.AssociationGenerator
                      .createNewMemberAssociation(identifiable.getId());
              association.setSourceObject(submissionSet.getId());
              return association;
            })
        .map(AssociationGenerator::toAssociationJaxbElement)
        .toList();
  }

  private static List<JAXBElement<AssociationType1>> createReplaceAssociations(
      DocumentGenerator.DocumentGeneratorList docGenerators) {
    return AssociationGenerator.toAssociationJaxbElements(
        AssociationGenerator.createDocumentReplaceAssociations(docGenerators));
  }
}
