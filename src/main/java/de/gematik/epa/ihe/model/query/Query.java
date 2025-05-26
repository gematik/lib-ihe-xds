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
package de.gematik.epa.ihe.model.query;

import static de.gematik.epa.conversion.AdhocQueryUtils.formatIfUnformattedListElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.gematik.epa.ihe.model.simple.InsurantId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;

/**
 * As seen in: { "queryData": { "XDSDocumentEntryStatus":
 * "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved" }, "query": "FindDocuments",
 * "leiBerechtigung": "arztpraxis", "kvnr": "X110417159", "returnType": "leafClass" }
 */
@Getter
public enum Query {
  FIND_DOCUMENTS(
      "FindDocuments",
      "urn:uuid:14d4debf-8f97-4251-9a74-a90016b0af0d",
      PatientIdNames.XDS_DOCUMENT_ENTRY_PATIENT_ID),
  FIND_DOCUMENTS_BY_TITLE(
      "FindDocumentsByTitle",
      "urn:uuid:ab474085-82b5-402d-8115-3f37cb1e2405",
      PatientIdNames.XDS_DOCUMENT_ENTRY_PATIENT_ID),
  FIND_FOLDERS(
      "FindFolders",
      "urn:uuid:958f3006-baad-4929-a4de-ff1114824431",
      PatientIdNames.XDS_FOLDER_PATIENT_ID),
  GET_ALL(
      "GetAll", "urn:uuid:10b545ea-725c-446d-9b95-8aeb444eddf3", PatientIdNames.GET_ALL_PATIENT_ID),
  GET_FOLDER_AND_CONTENTS(
      "GetFolderAndContents", "urn:uuid:b909a503-523d-4517-8acf-8e5834dfc4c7", null),
  GET_RELATED_APPROVED_DOCUMENTS(
      "GetRelatedApprovedDocuments", "urn:uuid:1c1f1cea-ad3a-11ed-afa1-0242ac120002", null),
  FIND_DOCUMENTS_BY_COMMENT(
      "FindDocumentsByComment",
      "urn:uuid:2609dda5-2b97-44d5-a795-3e999c24ca99",
      PatientIdNames.XDS_DOCUMENT_ENTRY_PATIENT_ID),
  FIND_DOCUMENTS_BY_REFERENCE_ID(
      "FindDocumentsByReferenceId",
      "urn:uuid:12941a89-e02e-4be5-967c-ce4bfc8fe492",
      PatientIdNames.XDS_DOCUMENT_ENTRY_PATIENT_ID);

  private final String keyword;
  private final String urn;
  private final PatientIdNames patientIdSlotName;

  Query(String keyword, String urn, PatientIdNames patientIdSlotName) {
    this.keyword = keyword;
    this.urn = urn;
    this.patientIdSlotName = patientIdSlotName;
  }

  public List<SlotType1> fillPatientIdSlot(InsurantId insurantId) {
    List<SlotType1> slots = new ArrayList<>();
    if (this.patientIdSlotName != null) {
      var slot = new SlotType1();
      var valueListType = new ValueListType();
      slot.setName(patientIdSlotName.value());
      valueListType.getValue().add(formatIfUnformattedListElement(insurantId.getPatientIdValue()));
      slot.setValueList(valueListType);
      slots.add(slot);
    }
    return slots;
  }

  @JsonCreator
  public static Query fromValue(@NonNull String value) {
    return Arrays.stream(values())
        .filter(queryType -> queryType.getKeyword().equals(value))
        .findFirst()
        .orElseThrow();
  }

  @JsonValue
  public String value() {
    return keyword;
  }
}
