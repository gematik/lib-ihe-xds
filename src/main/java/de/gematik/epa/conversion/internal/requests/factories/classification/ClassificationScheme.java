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
package de.gematik.epa.conversion.internal.requests.factories.classification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClassificationScheme {
  DOCUMENT_ENTRY_CLASS("urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a"),
  DOCUMENT_ENTRY_CONFIDENTIALITY("urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f"),
  DOCUMENT_ENTRY_EVENT("urn:uuid:2c6b8cb7-8b2a-4051-b291-b1ae6a575ef4"),
  DOCUMENT_ENTRY_FORMAT("urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d"),
  DOCUMENT_ENTRY_HEALTHCARE_FACILITY("urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1"),
  DOCUMENT_ENTRY_PRACTICE_SETTING("urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead"),
  DOCUMENT_ENTRY_TYPE("urn:uuid:f0306f51-975f-434e-a61c-c59651d33983"),
  DOCUMENT_ENTRY_AUTHOR("urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d"),
  FOLDER_LIST("urn:uuid:1ba97051-7806-41a8-a48b-8fce7af683c5"),
  SUBMISSION_SET_AUTHOR("urn:uuid:a7058bb9-b4e4-4307-ba5b-e3f0ab85e12d"),
  SUBMISSION_SET_CONTENT_TYPE("urn:uuid:aa543740-bdda-424e-8c96-df4873be8500");

  private final String urn;
}
