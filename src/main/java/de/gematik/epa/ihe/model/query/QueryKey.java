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

package de.gematik.epa.ihe.model.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.Getter;
import lombok.NonNull;

@Getter
public enum QueryKey {
  XDS_DOCUMENT_ENTRY_STATUS("$XDSDocumentEntryStatus"),
  XDS_DOCUMENT_ENTRY_TITLE("$XDSDocumentEntryTitle"),
  XDS_DOCUMENT_ENTRY_ENTRY_UUID("$XDSDocumentEntryEntryUUID"),
  XDS_DOCUMENT_ENTRY_UNIQUE_ID("$XDSDocumentEntryUniqueId"),
  XDS_DOCUMENT_ENTRY_FORMAT_CODE("$XDSDocumentEntryFormatCode"),
  XDS_DOCUMENT_ENTRY_TYPE_CODE("$XDSDocumentEntryTypeCode"),
  XDS_DOCUMENT_ENTRY_CLASS_CODE("$XDSDocumentEntryClassCode"),
  XDS_FOLDER_CODE_LIST("$XDSFolderCodeList"),
  XDS_FOLDER_STATUS("$XDSFolderStatus"),
  XDS_SUBMISSION_SET_STATUS("$XDSSubmissionSetStatus"),
  XDS_FOLDER_ENTRY_UUID("$XDSFolderEntryUUID"),
  XDS_FOLDER_UNIQUE_ID("$XDSFolderUniqueId"),
  XDS_DOCUMENT_ENTRY_COMMENT("$XDSDocumentEntryComment"),
  XDS_DOCUMENT_ENTRY_REFERENCE_ID_LIST("$XDSDocumentEntryReferenceIdList");

  private final String keyword;

  QueryKey(String keyword) {
    this.keyword = keyword;
  }

  @JsonCreator
  public static QueryKey fromValue(@NonNull String value) {
    final String modifiedValue = value.startsWith("$") ? value : "$".concat(value);
    return Arrays.stream(values())
        .filter(queryType -> queryType.getKeyword().equalsIgnoreCase(modifiedValue))
        .findFirst()
        .orElseThrow();
  }

  @JsonValue
  public String value() {
    return keyword;
  }
}
