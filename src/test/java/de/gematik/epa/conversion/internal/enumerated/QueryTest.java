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
package de.gematik.epa.conversion.internal.enumerated;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.gematik.epa.ihe.model.query.Query;
import de.gematik.epa.ihe.model.query.QueryKey;
import de.gematik.epa.ihe.model.query.ReturnType;
import de.gematik.epa.ihe.model.request.FindRequest;
import de.gematik.epa.unit.util.MessageUtils;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class QueryTest {

  @Test
  void fillPatientIdSlotForFindFolders() {
    var insurantId = MessageUtils.createInsurantId();
    FindRequest request =
        new FindRequest(insurantId, ReturnType.LEAF_CLASS, Query.FIND_FOLDERS, Map.of());
    var actual = assertDoesNotThrow(() -> request.query().fillPatientIdSlot(request.insurantId()));
    assertNotNull(actual);
    assertEquals(1, actual.size());
    assertEquals(
        "('" + insurantId.getPatientIdValue() + "')",
        actual.get(0).getValueList().getValue().get(0));
  }

  @Test
  void fillPatientIdSlotForGetFolderAndContents() {
    Map<QueryKey, List<String>> queryMetadata = new HashMap<>();
    queryMetadata.put(QueryKey.XDS_FOLDER_ENTRY_UUID, List.of("1.2.3"));
    FindRequest request =
        new FindRequest(
            MessageUtils.createInsurantId(), null, Query.GET_FOLDER_AND_CONTENTS, queryMetadata);
    assertNull(Query.GET_FOLDER_AND_CONTENTS.getPatientIdSlotName());
    var slotType1 =
        assertDoesNotThrow(
            () -> Query.GET_FOLDER_AND_CONTENTS.fillPatientIdSlot(request.insurantId()));
    assertEquals(0, slotType1.size());
  }

  @Test
  void fillPatientIdSlotForGetRelatedApprovedDocuments() {
    Map<QueryKey, List<String>> queryMetadata = new HashMap<>();
    queryMetadata.put(QueryKey.XDS_DOCUMENT_ENTRY_ENTRY_UUID, List.of("1.2.3"));
    FindRequest request =
        new FindRequest(
            MessageUtils.createInsurantId(),
            null,
            Query.GET_RELATED_APPROVED_DOCUMENTS,
            queryMetadata);
    assertNull(Query.GET_RELATED_APPROVED_DOCUMENTS.getPatientIdSlotName());
    var slotType1 =
        assertDoesNotThrow(
            () -> Query.GET_RELATED_APPROVED_DOCUMENTS.fillPatientIdSlot(request.insurantId()));
    assertEquals(0, slotType1.size());
  }

  @Test
  void fillPatientIdSlotForFindDocumentsByComment() {
    var insurantId = MessageUtils.createInsurantId();
    FindRequest request =
        new FindRequest(
            insurantId, ReturnType.LEAF_CLASS, Query.FIND_DOCUMENTS_BY_COMMENT, Map.of());
    var query = request.query();
    assertEquals("FindDocumentsByComment", query.getKeyword());
    assertEquals("urn:uuid:2609dda5-2b97-44d5-a795-3e999c24ca99", query.getUrn());
    var actual = assertDoesNotThrow(() -> request.query().fillPatientIdSlot(request.insurantId()));
    assertNotNull(actual);
    assertEquals(1, actual.size());
    assertEquals(
        "('" + insurantId.getPatientIdValue() + "')",
        actual.get(0).getValueList().getValue().get(0));
  }

  @Test
  void fillPatientIdSlotForFindDocumentsByReferenceId() {
    var insurantId = MessageUtils.createInsurantId();
    FindRequest request =
        new FindRequest(
            insurantId, ReturnType.LEAF_CLASS, Query.FIND_DOCUMENTS_BY_REFERENCE_ID, Map.of());
    var query = request.query();
    assertEquals("FindDocumentsByReferenceId", query.getKeyword());
    assertEquals("urn:uuid:12941a89-e02e-4be5-967c-ce4bfc8fe492", query.getUrn());
    var actual = assertDoesNotThrow(() -> request.query().fillPatientIdSlot(request.insurantId()));
    assertNotNull(actual);
    assertEquals(1, actual.size());
    assertEquals(
        "('" + insurantId.getPatientIdValue() + "')",
        actual.get(0).getValueList().getValue().get(0));
  }

  @Test
  void fillPatientIdSlotForGetDocumentsAndAssociations() {
    Map<QueryKey, List<String>> queryMetadata = new EnumMap<>(QueryKey.class);
    queryMetadata.put(QueryKey.XDS_DOCUMENT_ENTRY_ENTRY_UUID, List.of("1.2.3"));
    FindRequest request =
        new FindRequest(
            MessageUtils.createInsurantId(),
            null,
            Query.GET_DOCUMENTS_AND_ASSOCIATIONS,
            queryMetadata);
    assertNull(Query.GET_DOCUMENTS_AND_ASSOCIATIONS.getPatientIdSlotName());
    var slotType1 =
        assertDoesNotThrow(
            () -> Query.GET_DOCUMENTS_AND_ASSOCIATIONS.fillPatientIdSlot(request.insurantId()));
    assertEquals(0, slotType1.size());
  }

  @Test
  void testGetDocumentsAndAssociationsQuery() {
    var query = Query.GET_DOCUMENTS_AND_ASSOCIATIONS;
    assertEquals("GetDocumentsAndAssociations", query.getKeyword());
    assertEquals("urn:uuid:bab9529a-4a10-40b3-a01f-f68a615d247a", query.getUrn());
    assertNull(query.getPatientIdSlotName());
  }

  @Test
  void testGetDocumentsAndAssociationsDeserialization() {
    var query = assertDoesNotThrow(() -> Query.fromValue("GetDocumentsAndAssociations"));
    assertEquals(Query.GET_DOCUMENTS_AND_ASSOCIATIONS, query);
  }

  @Test
  void testInvalidQueryValueThrowsException() {
    var exception =
        assertThrows(IllegalArgumentException.class, () -> Query.fromValue("InvalidQueryName"));
    assertTrue(exception.getMessage().contains("Unknown query type"));
  }
}
