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
 * For additional notes and disclaimer from gematik and in case of changes
 * by gematik, find details in the "Readme" file.
 * #L%
 */
package de.gematik.epa.conversion.internal.requests.factories.externalidentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExternalIdentifierScheme {
  DOCUMENT_ENTRY_PATIENT(
      "urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427", "XDSDocumentEntry.patientId"),
  DOCUMENT_ENTRY_UNIQUE(
      "urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab", "XDSDocumentEntry.uniqueId"),
  FOLDER_PATIENT("urn:uuid:f64ffdf0-4b97-4e06-b79f-a52b38ec2f8a", "XDSFolder.patientId"),
  FOLDER_UNIQUE("urn:uuid:75df8f67-9973-4fbe-a900-df66cefecc5a", "XDSFolder.uniqueId"),
  SUBMISSION_SET_PATIENT(
      "urn:uuid:6b5aea1a-874d-4603-a4bc-96a0a7b38446", "XDSSubmissionSet.patientId"),
  SUBMISSION_SET_UNIQUE(
      "urn:uuid:96fdda7c-d067-4183-912e-bf5ee74998a8", "XDSSubmissionSet.uniqueId");

  private final String id;
  private final String name;
}
