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

package de.gematik.epa.conversion.internal;

import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.conversion.internal.requests.DocumentGenerator.DocumentGeneratorList;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;

@UtilityClass
public class AssociationGenerator {

  private static final String ASSOCIATION_TYPE_HAS_MEMBER =
      "urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember";

  public static final String ASSOCIATION_TYPE_REPLACE = "urn:ihe:iti:2007:AssociationType:RPLC";

  public static List<AssociationType1> createFolderToDocumentAssociations(
      DocumentGeneratorList docGenerators) {
    return docGenerators.stream()
        .filter(dg -> Objects.nonNull(dg.folderMetadata()))
        .map(dg -> createFolderToDocumentAssociation(dg.folderMetadata(), dg.id()))
        .toList();
  }

  public static List<AssociationType1> createDocumentReplaceAssociations(
      DocumentGeneratorList docGenerators) {
    return docGenerators.stream()
        .filter(dg -> Objects.nonNull(dg.idOfDocumentToReplace()))
        .map(AssociationGenerator::createReplaceAssociation)
        .toList();
  }

  public static List<JAXBElement<AssociationType1>> toAssociationJaxbElements(
      List<AssociationType1> associations) {
    return associations.stream().map(AssociationGenerator::toAssociationJaxbElement).toList();
  }

  public static JAXBElement<AssociationType1> toAssociationJaxbElement(
      AssociationType1 association) {
    return new oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectFactory()
        .createAssociation(association);
  }

  public static AssociationType1 createNewMemberAssociation(String targetId) {
    var association = createNewAssociation(targetId);
    association.setAssociationType(ASSOCIATION_TYPE_HAS_MEMBER);
    return association;
  }

  // region private

  private static AssociationType1 createFolderToDocumentAssociation(
      FolderMetadata folderMetadata, String documentId) {
    if (Objects.nonNull(folderMetadata.entryUUID())) {
      return createDocumentAssociationForExistingDynamicFolder(
          documentId, folderMetadata.entryUUID());
    } else {
      return createDocumentAssociationForNewFolder(documentId);
    }
  }

  private static AssociationType1 createDocumentAssociationForExistingDynamicFolder(
      String documentId, String entryUUID) {
    var association = createNewMemberAssociation(documentId);
    association.setSourceObject(entryUUID);
    return association;
  }

  private static AssociationType1 createDocumentAssociationForNewFolder(String documentId) {
    var association = createNewMemberAssociation(documentId);
    association.setSourceObject(UUID.randomUUID().toString());
    return association;
  }

  private static AssociationType1 createReplaceAssociation(DocumentGenerator docGenerator) {
    var association = createNewAssociation(docGenerator.idOfDocumentToReplace());
    association.setAssociationType(ASSOCIATION_TYPE_REPLACE);
    association.setSourceObject(docGenerator.id());
    return association;
  }

  private static AssociationType1 createNewAssociation(String targetId) {
    var association = new AssociationType1();
    association.setTargetObject(targetId);
    association.setId(UUID.randomUUID().toString());

    return association;
  }

  // endregion private

}
