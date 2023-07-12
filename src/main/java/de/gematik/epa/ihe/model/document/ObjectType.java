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

package de.gematik.epa.ihe.model.document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ObjectType {
  DOCUMENT_ENTRY("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"),
  FOLDER("urn:uuid:d9d542f3-6cc4-48b6-8870-ea235fbc94c2"),
  SUBMISSION_SET("urn:uuid:a54d6aa5-d40d-43f9-88c5-b4633d873bdd");
  private final String id;
}
