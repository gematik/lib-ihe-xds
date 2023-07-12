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

import com.fasterxml.jackson.annotation.JsonValue;

public enum PatientIdNames {
  XDS_DOCUMENT_ENTRY_PATIENT_ID("$XDSDocumentEntryPatientId"),
  XDS_FOLDER_PATIENT_ID("$XDSFolderPatientId"),
  XDS_SUBMISSIONSET_PATIENT_ID("$XDSSubmissionSetPatientId"),
  GET_ALL_PATIENT_ID("$patientId");

  private final String keyword;

  PatientIdNames(String keyword) {
    this.keyword = keyword;
  }

  @JsonValue
  public String value() {
    return keyword;
  }
}
