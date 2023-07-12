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

package de.gematik.epa.conversion;

import static de.gematik.epa.unit.util.ExternalIdentifierTestUtils.assertExternalIdentifiers;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getNodeRepresentationValue;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getNodeRepresentationValueList;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getSlotTimeValue;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getValueFromSlot;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.gematik.epa.conversion.internal.DateUtil;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.unit.util.AuthorToSlotTestUtils;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import org.junit.jupiter.api.Test;

class ProvideAndRegisterUtilsCreateExtrinsicObjectTest extends AbstractRegistryObjectTest {

  private static final int MAX_SLOT_NUMBER = 5;
  // 2x eventCode, 2x confCode, 2x author, rest codes 1x
  private static final int EXPECTED_CLASSIFICATION_NUMBER = 11;
  private static final int EMPTY = 0;
  private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";

  @Test
  // Test basiert auf xml Datei mit vollständigen Daten
  void createExtrinsicObjectsWithAllAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    final List<JAXBElement<ExtrinsicObjectType>> extrinsicObjects =
        ProvideAndRegisterUtils.createExtrinsicObjects(documentGenerators);

    final ExtrinsicObjectType extrinsicObjectType = extrinsicObjects.get(0).getValue();

    final DocumentMetadata documentMetadata =
        documentSubmissionRequest.documents().get(0).documentMetadata();

    assertHomeCommunityId(extrinsicObjectType, documentSubmissionRequest);
    assertMimeType(extrinsicObjectType, documentMetadata);
    assertName(extrinsicObjectType, documentMetadata.title());
    assertDescription(extrinsicObjectType, documentMetadata);
    assertSlots(extrinsicObjectType, documentMetadata);
    assertClassifications(extrinsicObjectType, documentMetadata);
    assertExternalIdentifiers(
        extrinsicObjectType,
        documentSubmissionRequest,
        ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT.getName(),
        ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE.getName());
  }

  @Test
  // Test basiert auf xml Datei von Iryna
  void createExtrinsicObjectsWithCustomAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST);

    final List<JAXBElement<ExtrinsicObjectType>> extrinsicObjects =
        ProvideAndRegisterUtils.createExtrinsicObjects(documentGenerators);
    final ExtrinsicObjectType extrinsicObjectType = extrinsicObjects.get(0).getValue();

    // no classifications, as metadata is empty
    assertEquals(EMPTY, extrinsicObjectType.getClassification().size());

    assertNull(extrinsicObjectType.getName());
    // Wird von Ihe überschrieben, wenn kein MimeType gesetzt
    assertEquals(APPLICATION_OCTET_STREAM, extrinsicObjectType.getMimeType());
    assertNull(extrinsicObjectType.getDescription());
    assertEquals(EMPTY, extrinsicObjectType.getSlot().size());
  }

  private void assertMimeType(
      ExtrinsicObjectType extrinsicObjectType, DocumentMetadata documentMetadata) {
    assertEquals(documentMetadata.mimeType(), extrinsicObjectType.getMimeType());
  }

  private void assertDescription(
      ExtrinsicObjectType extrinsicObjectType, DocumentMetadata documentMetadata) {
    // metadata.comment empty in given json
    assertEquals(
        documentMetadata.comments(),
        extrinsicObjectType.getDescription().getLocalizedString().get(0).getValue());
  }

  private void assertSlots(
      ExtrinsicObjectType extrinsicObjectType, DocumentMetadata documentMetadata) {
    final int size = extrinsicObjectType.getSlot().size();
    assertEquals(MAX_SLOT_NUMBER, size);

    String languageCode = getValueFromSlot(extrinsicObjectType, SlotName.LANGUAGE_CODE.getName());
    assertEquals(documentMetadata.languageCode(), languageCode);

    String uri = getValueFromSlot(extrinsicObjectType, SlotName.URI.getName());
    assertEquals(documentMetadata.uri(), uri);

    assertSlotTime(
        extrinsicObjectType,
        SlotName.CREATION_TIME.getName(),
        DateUtil.format(documentMetadata.creationTime()));
    assertSlotTime(
        extrinsicObjectType,
        SlotName.SERVICE_STOP_TIME.getName(),
        DateUtil.format(documentMetadata.serviceStopTime()));
    assertSlotTime(
        extrinsicObjectType,
        SlotName.SERVICE_START_TIME.getName(),
        DateUtil.format(documentMetadata.serviceStartTime()));
  }

  private void assertSlotTime(ExtrinsicObjectType extrinsicObjectType, String name, String time) {
    String actual = getSlotTimeValue(extrinsicObjectType, name);
    assertEquals(time, actual);
  }

  private void assertClassificationCode(
      ExtrinsicObjectType extrinsicObjectType, String codeScheme, String expectedValue) {
    String actual = getNodeRepresentationValue(extrinsicObjectType, codeScheme);
    assertNotNull(actual);
    assertEquals(expectedValue, actual);
  }

  private void assertClassificationCodeList(
      ExtrinsicObjectType extrinsicObjectType, String codeValue, List<String> expectedCodeList) {
    List<String> codeList = getNodeRepresentationValueList(extrinsicObjectType, codeValue);
    assertTrue(expectedCodeList.containsAll(codeList) && codeList.containsAll(expectedCodeList));
  }

  private void assertClassifications(
      ExtrinsicObjectType extrinsicObjectType, DocumentMetadata documentMetadata) {
    final int size = extrinsicObjectType.getClassification().size();

    assertEquals(EXPECTED_CLASSIFICATION_NUMBER, size);

    assertClassificationCodeList(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_CONFIDENTIALITY.getUrn(),
        documentMetadata.confidentialityCode());
    assertClassificationCodeList(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_EVENT.getUrn(),
        documentMetadata.eventCodeList());

    assertClassificationCode(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_CLASS.getUrn(),
        documentMetadata.classCode());
    assertClassificationCode(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_FORMAT.getUrn(),
        documentMetadata.formatCode());
    assertClassificationCode(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_HEALTHCARE_FACILITY.getUrn(),
        documentMetadata.healthcareFacilityTypeCode());
    assertClassificationCode(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_PRACTICE_SETTING.getUrn(),
        documentMetadata.practiceSettingCode());
    assertClassificationCode(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_TYPE.getUrn(),
        documentMetadata.typeCode());

    int expectedNumberOfAuthors = 2;
    AuthorToSlotTestUtils.assertAuthor(
        extrinsicObjectType,
        documentMetadata.author().get(0),
        ClassificationScheme.DOCUMENT_ENTRY_AUTHOR.getUrn(),
        expectedNumberOfAuthors);
  }
}
