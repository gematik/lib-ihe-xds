/*-
 * #%L
 * lib-ihe-xds
 * %%
 * Copyright (C) 2023 - 2026 gematik GmbH
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
package de.gematik.epa.conversion.internal.response;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.conversion.internal.enumerated.ClassCode;
import de.gematik.epa.conversion.internal.enumerated.ConfidentialityCode;
import de.gematik.epa.conversion.internal.enumerated.FormatCode;
import de.gematik.epa.conversion.internal.enumerated.HealthcareFacilityCode;
import de.gematik.epa.conversion.internal.enumerated.PracticeSettingCode;
import de.gematik.epa.conversion.internal.enumerated.TypeCode;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import java.time.LocalDateTime;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import org.junit.jupiter.api.Test;

class DocumentMetadataMapperTest extends RegistryObjectListUtils {

  @Test
  void confidentialityCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    ClassificationType classificationN = new ClassificationType();
    classificationN.setClassificationScheme(
        ClassificationScheme.DOCUMENT_ENTRY_CONFIDENTIALITY.getUrn());
    classificationN.setNodeRepresentation(ConfidentialityCode.NORMAL.getValue());
    extrinsicObjectType.getClassification().add(classificationN);

    ClassificationType classificationV = new ClassificationType();
    classificationV.setClassificationScheme(
        ClassificationScheme.DOCUMENT_ENTRY_CONFIDENTIALITY.getUrn());
    classificationV.setNodeRepresentation(ConfidentialityCode.VERY_RESTRICTED.getValue());
    extrinsicObjectType.getClassification().add(classificationV);

    final List<String> strings = DocumentMetadataMapper.confidentialityCode(extrinsicObjectType);
    assertEquals(2, strings.size());
    assertEquals("N", strings.get(0));
    assertEquals("V", strings.get(1));
  }

  @Test
  void testMimeType() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    final String expectedMimeType = "application/pdf";
    extrinsicObjectType.setMimeType(expectedMimeType);

    final String mimeType = DocumentMetadataMapper.mimeType(extrinsicObjectType);
    assertEquals(expectedMimeType, mimeType);
  }

  @Test
  void confidentialityCodeEmpty() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    ClassificationType classification = new ClassificationType();
    classification.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_CLASS.getUrn());
    extrinsicObjectType.getClassification().add(classification);

    final List<String> confidentialityCodes =
        DocumentMetadataMapper.confidentialityCode(extrinsicObjectType);
    assertEquals(0, confidentialityCodes.size());
  }

  @Test
  void testToClassCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_CLASS,
        ClassCode.MEDIZINISCHER_AUSWEIS.getValue());

    final String classCode = DocumentMetadataMapper.classCode(extrinsicObjectType);
    assertEquals("AUS", classCode);
  }

  @Test
  void testToFormatCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_FORMAT,
        FormatCode.KINDERUNTERSUCHUNGSHEFT_UNTERSUCHUNGEN.getValue());

    final String formatCode = DocumentMetadataMapper.formatCode(extrinsicObjectType);
    assertEquals("urn:gematik:ig:KinderuntersuchungsheftUntersuchungen:v1.0.0", formatCode);
  }

  @Test
  void testToEDMPFormatCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_FORMAT,
        FormatCode.EDMP_DM2.getValue());

    final String formatCode = DocumentMetadataMapper.formatCode(extrinsicObjectType);
    assertEquals("urn:gematik:ig:DMP-DM2:v6", formatCode);
  }

  @Test
  void testToHealthcareFacilityCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_HEALTHCARE_FACILITY,
        HealthcareFacilityCode.AMBULANTER_PFLEGEDIENST.getValue());

    final String healthcareFacilityCode =
        DocumentMetadataMapper.healthcareFacilityTypeCode(extrinsicObjectType);
    assertEquals("APD", healthcareFacilityCode);
  }

  @Test
  void testToPracticeSettingCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_PRACTICE_SETTING,
        PracticeSettingCode.ALLGEMEINCHIRURGIE.getValue());

    final String practiceSettingCode =
        DocumentMetadataMapper.practiceSettingCode(extrinsicObjectType);
    assertEquals("ALCH", practiceSettingCode);
  }

  @Test
  void testToTypeCode() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_TYPE,
        TypeCode.AERZTLICHE_BESCHEINIGUNGEN.getValue());

    final String typeCode = DocumentMetadataMapper.typeCode(extrinsicObjectType);
    assertEquals("BESC", typeCode);
  }

  @Test
  void toEventCodeList() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    ClassificationType classificationN = new ClassificationType();
    classificationN.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_EVENT.getUrn());
    classificationN.setNodeRepresentation("H1");
    extrinsicObjectType.getClassification().add(classificationN);

    final List<String> strings = DocumentMetadataMapper.eventCodeList(extrinsicObjectType);
    assertEquals(1, strings.size());
    assertEquals("H1", strings.get(0));
  }

  @Test
  void testToDates() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    createSlot(extrinsicObjectType, SlotName.CREATION_TIME, "20230309084331");
    createSlot(extrinsicObjectType, SlotName.SERVICE_START_TIME, "20210301092855");
    createSlot(extrinsicObjectType, SlotName.SERVICE_STOP_TIME, "20210301093855");

    final LocalDateTime creationTime = DocumentMetadataMapper.creationTime(extrinsicObjectType);
    final LocalDateTime expectedCreationTime = LocalDateTime.of(2023, 3, 9, 8, 43, 31);
    assertEquals(expectedCreationTime, creationTime);

    final LocalDateTime serviceStartTime =
        DocumentMetadataMapper.serviceStartTime(extrinsicObjectType);
    final LocalDateTime expectedServiceStartTime = LocalDateTime.of(2021, 3, 1, 9, 28, 55);
    assertEquals(expectedServiceStartTime, serviceStartTime);

    final LocalDateTime serviceStopTime =
        DocumentMetadataMapper.serviceStopTime(extrinsicObjectType);
    final LocalDateTime expectedServiceStopTime = LocalDateTime.of(2021, 3, 1, 9, 38, 55);
    assertEquals(expectedServiceStopTime, serviceStopTime);
  }

  @Test
  void testLanguageCode() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    createSlot(extrinsicObjectType, SlotName.LANGUAGE_CODE, "de-DE");

    final String languageCode = DocumentMetadataMapper.languageCode(extrinsicObjectType);
    assertEquals("de-DE", languageCode);
  }

  @Test
  void testURI() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    createSlot(extrinsicObjectType, SlotName.URI, "Medikationsplan.xml");

    final String uri = DocumentMetadataMapper.uri(extrinsicObjectType);
    assertEquals("Medikationsplan.xml", uri);
  }

  @Test
  void testReferenceIdList() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    createSlot(
        extrinsicObjectType,
        SlotName.REFERENCE_ID_LIST,
        "1.2.3.12.78.23^^^&1.2.3.4&ISO^urn:ihe:iti:xds:2013:uniqueId");

    final List<String> referenceIdList =
        DocumentMetadataMapper.referenceIdList(extrinsicObjectType);
    assertEquals(
        "1.2.3.12.78.23^^^&1.2.3.4&ISO^urn:ihe:iti:xds:2013:uniqueId", referenceIdList.get(0));
  }

  @Test
  void testSize() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    Integer expected = 85009;
    createSlot(extrinsicObjectType, SlotName.SIZE, expected.toString());
    var actual = DocumentMetadataMapper.size(extrinsicObjectType);
    assertEquals(expected, actual);
  }

  @Test
  void testRepositoryUniqueId() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    String expectedRepositoryUniqueId = "1.2.276.0.76.3.1.315.3.2.1.1";
    createSlot(extrinsicObjectType, SlotName.REPOSITORY_UNIQUE_ID, expectedRepositoryUniqueId);

    final String repositoryUniqueId =
        DocumentMetadataMapper.repositoryUniqueId(extrinsicObjectType);
    assertEquals(expectedRepositoryUniqueId, repositoryUniqueId);
  }
}
