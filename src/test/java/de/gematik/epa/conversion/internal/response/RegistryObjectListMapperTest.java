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

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import java.time.LocalDateTime;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExternalIdentifierType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;
import org.junit.jupiter.api.Test;

class RegistryObjectListMapperTest extends RegistryObjectListUtils {

  private final String expectedTitle = "title";
  private final String expectedStatus = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";
  private final String expectedUUID = "urn:uuid:66c12f3b-0cdb-4cba-ba6c-9875d917146f";
  private final String expectedComment = "I am a comment";
  private final String expectedUniqueId = "2.25.193805246743443392003";

  @Test
  void testFolderComments() {
    var registryObjectType = new RegistryPackageType();
    InternationalStringType internationalStringType = getInternationalStringType(expectedComment);
    registryObjectType.setDescription(internationalStringType);
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.comments(registryObjectType));
    assertNotNull(actual);
    assertFalse(actual.isEmpty());
    assertEquals(expectedComment, actual);
  }

  @Test
  void testFolderCommentsIsNull() {
    var registryObjectType = new RegistryPackageType();
    registryObjectType.setDescription(null);
    String result = assertDoesNotThrow(() -> RegistryObjectListMapper.comments(registryObjectType));
    assertNull(result);
  }

  @Test
  void testDocumentComments() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    extrinsicObjectType.setDescription(getInternationalStringType(expectedComment));
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.comments(extrinsicObjectType));
    assertNotNull(actual);
    assertFalse(actual.isEmpty());
    assertEquals(expectedComment, actual);
  }

  @Test
  void testFolderTitle() {
    var registryObjectType = new RegistryPackageType();
    InternationalStringType internationalStringType = getInternationalStringType(expectedTitle);
    registryObjectType.setName(internationalStringType);
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.title(registryObjectType));
    assertNotNull(actual);
    assertEquals(expectedTitle, actual);
  }

  @Test
  void testFolderTitleIsNull() {
    var registryObjectType = new RegistryPackageType();
    registryObjectType.setName(null);
    String result = assertDoesNotThrow(() -> RegistryObjectListMapper.title(registryObjectType));
    assertNull(result);
  }

  @Test
  void testDocumentTitle() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    extrinsicObjectType.setName(getInternationalStringType(expectedTitle));
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.title(extrinsicObjectType));
    assertNotNull(actual);
    assertEquals(expectedTitle, actual);
  }

  @Test
  void testFolderUniqueId() {
    var registryPackage = new RegistryPackageType();
    var externalIdentifier = new ExternalIdentifierType();
    InternationalStringType internationalStringType =
        getInternationalStringType(ExternalIdentifierScheme.FOLDER_UNIQUE.getName());
    externalIdentifier.setName(internationalStringType);
    externalIdentifier.setIdentificationScheme(ExternalIdentifierScheme.FOLDER_UNIQUE.getId());
    externalIdentifier.setValue(expectedUniqueId);

    registryPackage.getExternalIdentifier().add(externalIdentifier);

    final String actual =
        assertDoesNotThrow(
            () ->
                RegistryObjectListMapper.externalIdentifierValue(
                    registryPackage, ExternalIdentifierScheme.FOLDER_UNIQUE));
    assertNotNull(actual);
    assertEquals(expectedUniqueId, actual);
  }

  @Test
  void testFolderUniqueIdIsNull() {
    var registryPackage = new RegistryPackageType();
    var externalIdentifier = new ExternalIdentifierType();
    InternationalStringType internationalStringType =
        getInternationalStringType(ExternalIdentifierScheme.FOLDER_UNIQUE.getName());
    externalIdentifier.setName(internationalStringType);
    externalIdentifier.setIdentificationScheme(ExternalIdentifierScheme.FOLDER_UNIQUE.getId());
    externalIdentifier.setValue(null);

    registryPackage.getExternalIdentifier().add(externalIdentifier);

    final String actual =
        assertDoesNotThrow(
            () ->
                RegistryObjectListMapper.externalIdentifierValue(
                    registryPackage, ExternalIdentifierScheme.FOLDER_UNIQUE));
    assertNull(actual);
  }

  @Test
  void testDocumentUniqueId() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    var externalIdentifier = new ExternalIdentifierType();
    InternationalStringType internationalStringType =
        getInternationalStringType(ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE.getName());
    externalIdentifier.setName(internationalStringType);
    externalIdentifier.setIdentificationScheme(
        ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE.getId());
    externalIdentifier.setValue(expectedUniqueId);

    extrinsicObjectType.getExternalIdentifier().add(externalIdentifier);

    final String uniqueId =
        RegistryObjectListMapper.externalIdentifierValue(
            extrinsicObjectType, ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE);
    assertNotNull(uniqueId);
    assertEquals(expectedUniqueId, uniqueId);
  }

  @Test
  void testFolderLastUpdateTime() {
    var registryPackage = new RegistryPackageType();
    createSlot(registryPackage, SlotName.LAST_UPDATE_TIME, "20230409084331");
    final LocalDateTime actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.lastUpdateTime(registryPackage));
    final LocalDateTime expected = LocalDateTime.of(2023, 4, 9, 8, 43, 31);
    assertNotNull(actual);
    assertEquals(expected, actual);
  }

  @Test
  void testFolderCodeList() {
    var registryPackage = new RegistryPackageType();
    ClassificationType classification = new ClassificationType();
    final String expected = "childsrecord";
    classification.setClassificationScheme(ClassificationScheme.FOLDER_LIST.getUrn());
    classification.setNodeRepresentation(expected);
    registryPackage.getClassification().add(classification);

    final List<String> actual = RegistryObjectListMapper.codeList(registryPackage);
    assertFalse(actual.isEmpty());
    assertEquals(1, actual.size());
    assertEquals(expected, actual.get(0));
  }

  @Test
  void testFolderAvailabilityStatus() {
    var registryPackage = new RegistryPackageType();
    registryPackage.setStatus(expectedStatus);
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.availabilityStatus(registryPackage));
    assertFalse(actual.isEmpty());
    assertEquals(expectedStatus, actual);
  }

  @Test
  void testDocumentAvailabilityStatus() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    extrinsicObjectType.setStatus(expectedStatus);
    final String availabilityStatus =
        assertDoesNotThrow(() -> RegistryObjectListMapper.availabilityStatus(extrinsicObjectType));
    assertEquals(expectedStatus, availabilityStatus);
  }

  @Test
  void testFolderEntryUUID() {
    var registryPackage = new RegistryPackageType();
    registryPackage.setId(expectedUUID);
    final String actual =
        assertDoesNotThrow(() -> RegistryObjectListMapper.entryUUID(registryPackage));
    assertFalse(actual.isEmpty());
    assertEquals(expectedUUID, actual);
  }

  @Test
  void testDocumentEntryUUID() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    extrinsicObjectType.setId(expectedUUID);
    final String actualId =
        assertDoesNotThrow(() -> RegistryObjectListMapper.entryUUID(extrinsicObjectType));
    assertEquals(expectedUUID, actualId);
  }

  @Test
  void testHomeCommunityId() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    final String expectedHomeCommunityId = "urn:oid:1.2.276.0.76.3.1.315.3.2.1.1";
    extrinsicObjectType.setHome(expectedHomeCommunityId);
    final String homeCommunityId =
        assertDoesNotThrow(() -> RegistryObjectListMapper.homeCommunityId(extrinsicObjectType));
    assertEquals(expectedHomeCommunityId, homeCommunityId);
  }

  @Test
  void testPatientId() {
    var extrinsicObjectType = new ExtrinsicObjectType();
    var externalIdentifier = new ExternalIdentifierType();
    final String expectedPatientId = "X110435031^^^&amp;1.2.276.0.76.4.8&amp;ISO";
    InternationalStringType internationalStringType =
        getInternationalStringType(ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT.getId());
    externalIdentifier.setName(internationalStringType);
    externalIdentifier.setIdentificationScheme(
        ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT.getId());
    externalIdentifier.setValue(expectedPatientId);

    extrinsicObjectType.getExternalIdentifier().add(externalIdentifier);

    final String patientId =
        assertDoesNotThrow(
            () ->
                RegistryObjectListMapper.externalIdentifierValue(
                    extrinsicObjectType, ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT));
    assertEquals(expectedPatientId, patientId);
  }

  @Test
  void testGetLocalDateTimeIsNull() {
    RegistryPackageType registryPackageType = new RegistryPackageType();
    var slot = SlotName.LAST_UPDATE_TIME;
    var slotLocalDateTime =
        assertDoesNotThrow(
            () -> RegistryObjectListMapper.getLocalDateTime(registryPackageType, slot));
    assertNull(slotLocalDateTime);
  }
}
