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
 * For additional notes and disclaimer from gematik and in case of changes by gematik find details in the "Readme" file.
 * #L%
 */
package de.gematik.epa.conversion.internal.response;

import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.*;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import jakarta.xml.bind.JAXBElement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.IdentifiableType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;

public class DocumentMetadataMapper {

  private DocumentMetadataMapper() {}

  public static List<DocumentMetadata> mapDocumentMetadata(AdhocQueryResponse adhocQueryResponse) {
    final RegistryObjectListType registryObjectList = adhocQueryResponse.getRegistryObjectList();
    var documentMetadataList = new ArrayList<DocumentMetadata>();

    if (registryObjectList != null) {
      fillDocumentsMetadataList(registryObjectList.getIdentifiable(), documentMetadataList);
    }
    return documentMetadataList.isEmpty() ? null : documentMetadataList;
  }

  private static void fillDocumentsMetadataList(
      List<JAXBElement<? extends IdentifiableType>> identifiable,
      List<DocumentMetadata> documentMetadataList) {
    final List<JAXBElement<? extends IdentifiableType>> extrinsicObject =
        identifiable.stream()
            .filter(d -> d.getValue().getClass().equals(ExtrinsicObjectType.class))
            .toList();
    for (JAXBElement<? extends IdentifiableType> jaxbElement : extrinsicObject) {
      final ExtrinsicObjectType value = (ExtrinsicObjectType) jaxbElement.getValue();
      DocumentMetadata documentMetadata =
          new DocumentMetadata(
              toAuthor(value, ClassificationScheme.DOCUMENT_ENTRY_AUTHOR),
              RegistryObjectListMapper.availabilityStatus(value),
              confidentialityCode(value),
              classCode(value),
              RegistryObjectListMapper.comments(value),
              creationTime(value),
              RegistryObjectListMapper.entryUUID(value),
              eventCodeList(value),
              formatCode(value),
              null,
              healthcareFacilityTypeCode(value),
              languageCode(value),
              null,
              mimeType(value),
              practiceSettingCode(value),
              referenceIdList(value),
              serviceStartTime(value),
              serviceStopTime(value),
              size(value),
              RegistryObjectListMapper.title(value),
              typeCode(value),
              RegistryObjectListMapper.externalIdentifierValue(
                  value, ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE),
              uri(value),
              repositoryUniqueId(value),
              RegistryObjectListMapper.homeCommunityId(value),
              RegistryObjectListMapper.externalIdentifierValue(
                  value, ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT),
              sourcePatientId(value));
      documentMetadataList.add(documentMetadata);
    }
  }

  static List<String> confidentialityCode(ExtrinsicObjectType value) {
    return getCodeFromClassifications(value, ClassificationScheme.DOCUMENT_ENTRY_CONFIDENTIALITY);
  }

  static String classCode(ExtrinsicObjectType value) {
    return getCodeFromClassification(value, ClassificationScheme.DOCUMENT_ENTRY_CLASS);
  }

  static LocalDateTime creationTime(ExtrinsicObjectType value) {
    return RegistryObjectListMapper.getLocalDateTime(value, SlotName.CREATION_TIME);
  }

  static List<String> eventCodeList(ExtrinsicObjectType value) {
    return getCodeFromClassifications(value, ClassificationScheme.DOCUMENT_ENTRY_EVENT);
  }

  static String formatCode(ExtrinsicObjectType value) {
    return getCodeFromClassification(value, ClassificationScheme.DOCUMENT_ENTRY_FORMAT);
  }

  static String healthcareFacilityTypeCode(ExtrinsicObjectType value) {
    return getCodeFromClassification(
        value, ClassificationScheme.DOCUMENT_ENTRY_HEALTHCARE_FACILITY);
  }

  static String languageCode(ExtrinsicObjectType value) {
    return SlotFactory.getValueFromSlot(value.getSlot(), SlotName.LANGUAGE_CODE);
  }

  static String mimeType(ExtrinsicObjectType value) {
    return value.getMimeType();
  }

  static String practiceSettingCode(ExtrinsicObjectType value) {
    return getCodeFromClassification(value, ClassificationScheme.DOCUMENT_ENTRY_PRACTICE_SETTING);
  }

  static LocalDateTime serviceStartTime(ExtrinsicObjectType value) {
    return RegistryObjectListMapper.getLocalDateTime(value, SlotName.SERVICE_START_TIME);
  }

  static LocalDateTime serviceStopTime(ExtrinsicObjectType value) {
    return RegistryObjectListMapper.getLocalDateTime(value, SlotName.SERVICE_STOP_TIME);
  }

  static Integer size(ExtrinsicObjectType value) {
    String sizeValue = SlotFactory.getValueFromSlot(value.getSlot(), SlotName.SIZE);
    return sizeValue != null ? Integer.parseInt(sizeValue) : null;
  }

  static String typeCode(ExtrinsicObjectType value) {
    return getCodeFromClassification(value, ClassificationScheme.DOCUMENT_ENTRY_TYPE);
  }

  static String uri(ExtrinsicObjectType value) {
    return SlotFactory.getValueFromSlot(value.getSlot(), SlotName.URI);
  }

  static List<String> referenceIdList(ExtrinsicObjectType value) {
    return value.getSlot().stream()
        .filter(slot -> SlotName.REFERENCE_ID_LIST.getName().equals(slot.getName()))
        .flatMap(slot -> slot.getValueList().getValue().stream())
        .toList();
  }

  static String repositoryUniqueId(ExtrinsicObjectType value) {
    return SlotFactory.getValueFromSlot(value.getSlot(), SlotName.REPOSITORY_UNIQUE_ID);
  }

  static String sourcePatientId(ExtrinsicObjectType value) {
    return SlotFactory.getValueFromSlot(value.getSlot(), SlotName.SOURCE_PATIENT_ID);
  }
}
