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

package de.gematik.epa.conversion.internal.enumerated;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.ihe.model.query.Query;
import de.gematik.epa.ihe.model.query.QueryKey;
import de.gematik.epa.ihe.model.query.ReturnType;
import de.gematik.epa.ihe.model.request.FindRequest;
import de.gematik.epa.unit.util.MessageUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class QueryTest {

  @Test
  void fillPatientIdSlotForFindFolders() {
    var insurantId = MessageUtils.createInsurantId();
    FindRequest request =
        new FindRequest(
            MessageUtils.createRecordIdentifier(insurantId, "urn:oid:1.2.276.0.76.3.1.315.3.2.1.1"),
            ReturnType.LEAF_CLASS,
            Query.FIND_FOLDERS,
            Map.of());
    var actual = assertDoesNotThrow(() -> request.query().fillPatientIdSlot(request));
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
            MessageUtils.createRecordIdentifier(),
            null,
            Query.GET_FOLDER_AND_CONTENTS,
            queryMetadata);
    assertNull(Query.GET_FOLDER_AND_CONTENTS.getPatientIdSlotName());
    var slotType1 =
        assertDoesNotThrow(() -> Query.GET_FOLDER_AND_CONTENTS.fillPatientIdSlot(request));
    assertEquals(0, slotType1.size());
  }

  @Test
  void fillPatientIdSlotForGetRelatedApprovedDocuments() {
    Map<QueryKey, List<String>> queryMetadata = new HashMap<>();
    queryMetadata.put(QueryKey.XDS_DOCUMENT_ENTRY_ENTRY_UUID, List.of("1.2.3"));
    FindRequest request =
        new FindRequest(
            MessageUtils.createRecordIdentifier(),
            null,
            Query.GET_RELATED_APPROVED_DOCUMENTS,
            queryMetadata);
    assertNull(Query.GET_RELATED_APPROVED_DOCUMENTS.getPatientIdSlotName());
    var slotType1 =
        assertDoesNotThrow(() -> Query.GET_RELATED_APPROVED_DOCUMENTS.fillPatientIdSlot(request));
    assertEquals(0, slotType1.size());
  }
}
