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

import static de.gematik.epa.ihe.model.query.PatientIdNames.XDS_DOCUMENT_ENTRY_PATIENT_ID;
import static de.gematik.epa.ihe.model.query.QueryKey.XDS_DOCUMENT_ENTRY_REFERENCE_ID_LIST;
import static de.gematik.epa.ihe.model.query.QueryKey.XDS_DOCUMENT_ENTRY_STATUS;
import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.ihe.model.query.Query;
import de.gematik.epa.ihe.model.query.QueryKey;
import de.gematik.epa.ihe.model.query.ReturnType;
import de.gematik.epa.ihe.model.request.FindRequest;
import de.gematik.epa.ihe.model.simple.InsurantId;
import de.gematik.epa.unit.util.MessageUtils;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AdhocQueryUtilsTest {

  private final InsurantId patientId = MessageUtils.createInsurantId();

  private final String unformattedPatientId = patientId.getPatientIdValue();

  @Test
  void generateFindRequestBody() {
    Map<QueryKey, List<String>> queryMetadata = new EnumMap<>(QueryKey.class);
    String documentEntryStatus = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";
    queryMetadata.put(XDS_DOCUMENT_ENTRY_STATUS, List.of(documentEntryStatus));

    var query = Query.FIND_DOCUMENTS;
    var testdata =
        new FindRequest(
            MessageUtils.createInsurantId(), ReturnType.OBJECT_REF, query, queryMetadata);
    var result = assertDoesNotThrow(() -> AdhocQueryUtils.generateFindRequestBody(testdata));
    assertNotNull(result);

    int slotCount = queryMetadata.size() + (query.getPatientIdSlotName() == null ? 0 : 1);
    assertEquals(2, slotCount);
    assertEquals(2, result.getAdhocQuery().getSlot().size());

    String actualStatus =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_STATUS.getKeyword()))
            .findFirst()
            .map(slot -> slot.getValueList().getValue().get(0))
            .orElse(null);
    String formattedStatus = "('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')";
    assertEquals(formattedStatus, actualStatus);

    String actualPatientId =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_PATIENT_ID.value()))
            .flatMap(slot -> slot.getValueList().getValue().stream())
            .findFirst()
            .orElse(null);
    String formattedPatientId = "('X110454647^^^&1.2.276.0.76.4.8&ISO')";
    assertEquals(formattedPatientId, actualPatientId);
  }

  @Test
  void formatUnformattedListElementTest() {
    var formattedPatientId =
        assertDoesNotThrow(
            () -> AdhocQueryUtils.formatIfUnformattedListElement(unformattedPatientId));
    assertEquals("('" + unformattedPatientId + "')", formattedPatientId);
  }

  @Test
  void testIsFormattedAsListWithBracketedValue() {
    String value = "('example')";
    boolean actualResult = AdhocQueryUtils.isFormattedAsList(value);
    assertTrue(actualResult);
  }

  @Test
  void testIsFormattedAsListWithUnbracketedValue() {
    String value = "example";
    boolean actualResult = AdhocQueryUtils.isFormattedAsList(value);
    assertFalse(actualResult);
  }

  @Test
  void testIsFormattedAsListWithIllFormattedValue() {
    String value = "example')";
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> AdhocQueryUtils.isFormattedAsList(value),
        "The parameter value is ill formatted. It either is bracketed like \"('value')\" or it is not bracketed like \"value\"! But the received parameter value is \"example')\"");
  }

  @ParameterizedTest
  @EnumSource(
      value = Query.class,
      names = {"FIND_DOCUMENTS_BY_COMMENT", "FIND_DOCUMENTS", "FIND_DOCUMENTS_BY_TITLE"})
  void generateFindRequestBody(Query query) {
    Map<QueryKey, List<String>> queryMetadata = new EnumMap<>(QueryKey.class);
    String documentEntryStatus = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";
    queryMetadata.put(XDS_DOCUMENT_ENTRY_STATUS, List.of(documentEntryStatus));

    var testdata =
        new FindRequest(
            MessageUtils.createInsurantId(), ReturnType.OBJECT_REF, query, queryMetadata);
    var result =
        Assertions.assertDoesNotThrow(() -> AdhocQueryUtils.generateFindRequestBody(testdata));
    assertNotNull(result);

    int slotCount = queryMetadata.size() + (query.getPatientIdSlotName() == null ? 0 : 1);
    assertEquals(2, slotCount);
    assertEquals(2, result.getAdhocQuery().getSlot().size());
    assertNull(result.getAdhocQuery().getHome());

    String actualStatus =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_STATUS.getKeyword()))
            .findFirst()
            .map(slot -> slot.getValueList().getValue().get(0))
            .orElse(null);
    String formattedStatus = "('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')";
    assertEquals(formattedStatus, actualStatus);

    String actualPatientId =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_PATIENT_ID.value()))
            .flatMap(slot -> slot.getValueList().getValue().stream())
            .findFirst()
            .orElse(null);
    String formattedPatientId = "('X110454647^^^&1.2.276.0.76.4.8&ISO')";
    assertEquals(formattedPatientId, actualPatientId);
  }

  @Test
  void generateFindDocumentsByReferenceIdRequest() {
    Map<QueryKey, List<String>> queryMetadata = new EnumMap<>(QueryKey.class);

    String documentEntryStatus = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";
    queryMetadata.put(XDS_DOCUMENT_ENTRY_STATUS, List.of(documentEntryStatus));

    String referenceId = "1.2.3.4.5.6^^^^urn.gematik.iti.xds.2023.rootDocumentUniqueId";
    queryMetadata.put(XDS_DOCUMENT_ENTRY_REFERENCE_ID_LIST, List.of(referenceId));

    var testdata =
        new FindRequest(
            MessageUtils.createInsurantId(),
            ReturnType.LEAF_CLASS,
            Query.FIND_DOCUMENTS_BY_REFERENCE_ID,
            queryMetadata);
    var result =
        Assertions.assertDoesNotThrow(() -> AdhocQueryUtils.generateFindRequestBody(testdata));
    assertNotNull(result);

    int slotCount =
        queryMetadata.size() + (Query.FIND_DOCUMENTS.getPatientIdSlotName() == null ? 0 : 1);
    assertEquals(3, slotCount);
    assertEquals(3, result.getAdhocQuery().getSlot().size());
    assertNull(result.getAdhocQuery().getHome());

    String actualStatus =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_STATUS.getKeyword()))
            .findFirst()
            .map(slot -> slot.getValueList().getValue().get(0))
            .orElse(null);
    String formattedStatus = "('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')";
    assertEquals(formattedStatus, actualStatus);

    String actualPatientId =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_PATIENT_ID.value()))
            .flatMap(slot -> slot.getValueList().getValue().stream())
            .findFirst()
            .orElse(null);
    String formattedPatientId = "('X110454647^^^&1.2.276.0.76.4.8&ISO')";
    assertEquals(formattedPatientId, actualPatientId);

    String actualReferenceId =
        result.getAdhocQuery().getSlot().stream()
            .filter(slot -> slot.getName().equals(XDS_DOCUMENT_ENTRY_REFERENCE_ID_LIST.value()))
            .flatMap(slot -> slot.getValueList().getValue().stream())
            .findFirst()
            .orElse(null);
    String formattedReferenceId =
        "('1.2.3.4.5.6^^^^urn.gematik.iti.xds.2023.rootDocumentUniqueId')";
    assertEquals(formattedReferenceId, actualReferenceId);
  }
}
