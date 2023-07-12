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

package de.gematik.epa.conversion.internal.response;

import static de.gematik.epa.conversion.internal.AuthorUtils.seperateAuthorName;
import static de.gematik.epa.conversion.internal.AuthorUtils.toAuthorInstitution;
import static de.gematik.epa.conversion.internal.AuthorUtils.toAuthorRole;
import static de.gematik.epa.conversion.internal.AuthorUtils.toAuthorSpecialty;
import static de.gematik.epa.conversion.internal.AuthorUtils.toAuthorTelecommunication;

import de.gematik.epa.conversion.internal.DateUtil;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationNode;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.Author;
import jakarta.xml.bind.JAXBElement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.IdentifiableType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

public class RegistryObjectListMapper {
  private RegistryObjectListMapper() {}

  public static List<JAXBElement<? extends IdentifiableType>> getRegistryPackageByClassification(
      List<JAXBElement<? extends IdentifiableType>> identifiable,
      ClassificationNode classificationNode) {
    return identifiable.stream()
        .filter(obj -> obj.getValue().getClass().equals(RegistryPackageType.class))
        .filter(
            c ->
                ((RegistryPackageType) c.getValue())
                    .getClassification().stream()
                        .filter(type -> type.getClassificationNode() != null)
                        .allMatch(
                            type ->
                                type.getClassificationNode().equals(classificationNode.getUrn())))
        .toList();
  }

  public static String comments(RegistryObjectType registryObject) {
    if (registryObject.getDescription() != null) {
      return registryObject.getDescription().getLocalizedString().get(0).getValue();
    }
    return null;
  }

  public static List<Author> toAuthor(
      RegistryObjectType registryObject, ClassificationScheme classificationScheme) {
    var authors =
        registryObject.getClassification().stream()
            .filter(a -> classificationScheme.getUrn().equals(a.getClassificationScheme()))
            .toList();
    List<Author> documentAuthors = new ArrayList<>();
    for (ClassificationType author : authors) {
      String[] name = seperateAuthorName(author);
      Author documentAuthor =
          new Author(
              name[0], // identifier
              name[1], // familyName
              name[2], // givenName
              name[3], // otherName
              name[4], // nameAffix
              name[5], // title
              toAuthorInstitution(author),
              toAuthorRole(author),
              toAuthorSpecialty(author),
              toAuthorTelecommunication(author));
      documentAuthors.add(documentAuthor);
    }

    return documentAuthors;
  }

  public static String title(RegistryObjectType registryObject) {
    // there is max one title
    if (registryObject.getName() != null) {
      return registryObject.getName().getLocalizedString().get(0).getValue();
    }
    return null;
  }

  public static String externalIdentifierValue(
      RegistryObjectType registryObject, ExternalIdentifierScheme externalIdentifierScheme) {
    var externalIdentifier =
        registryObject.getExternalIdentifier().stream()
            .filter(
                e ->
                    e.getIdentificationScheme() != null
                        && e.getIdentificationScheme().equals(externalIdentifierScheme.getId()))
            .findFirst()
            .orElse(null);

    return externalIdentifier == null ? null : externalIdentifier.getValue();
  }

  public static String entryUUID(RegistryObjectType registryObject) {
    return registryObject.getId();
  }

  public static String availabilityStatus(RegistryObjectType registryObject) {
    return registryObject.getStatus();
  }

  public static LocalDateTime lastUpdateTime(RegistryPackageType registryPackage) {
    return RegistryObjectListMapper.getLocalDateTime(registryPackage, SlotName.LAST_UPDATE_TIME);
  }

  public static List<String> codeList(RegistryPackageType registryPackage) {
    return RegistryObjectListMapper.getCodeFromClassifications(
        registryPackage, ClassificationScheme.FOLDER_LIST);
  }

  public static String getCodeFromClassification(
      RegistryObjectType registryObject, ClassificationScheme documentEntryFormat) {
    return registryObject.getClassification().stream()
        .filter(
            c ->
                c.getClassificationScheme() != null
                    && c.getClassificationScheme().equals(documentEntryFormat.getUrn()))
        .findFirst()
        .map(ClassificationType::getNodeRepresentation)
        .orElse(null);
  }

  public static List<String> getCodeFromClassifications(
      RegistryObjectType registryObject, ClassificationScheme documentEntryEvent) {
    return registryObject.getClassification().stream()
        .filter(
            c ->
                c.getClassificationScheme() != null
                    && c.getClassificationScheme().equals(documentEntryEvent.getUrn()))
        .map(ClassificationType::getNodeRepresentation)
        .toList();
  }

  public static LocalDateTime getLocalDateTime(
      RegistryObjectType registryObject, SlotName slotName) {
    var firstFoundSlot =
        registryObject.getSlot().stream()
            .filter(c -> c.getName().equals(slotName.getName()))
            .findFirst();

    if (firstFoundSlot.isPresent()) {
      // Es gibt immer nur max eine Value
      final String dateString = firstFoundSlot.get().getValueList().getValue().get(0);
      return DateUtil.format(dateString);
    }
    return null;
  }

  public static String homeCommunityId(RegistryObjectType registryObject) {
    return registryObject.getHome();
  }
}
