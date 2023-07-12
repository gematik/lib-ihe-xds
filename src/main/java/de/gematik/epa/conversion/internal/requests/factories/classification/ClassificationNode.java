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

package de.gematik.epa.conversion.internal.requests.factories.classification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClassificationNode {
  SUBMISSION_SET_ID_CLASSIFICATION("urn:uuid:a54d6aa5-d40d-43f9-88c5-b4633d873bdd"),
  FOLDER_ID_CLASSIFICATION("urn:uuid:d9d542f3-6cc4-48b6-8870-ea235fbc94c2");

  private final String urn;
}
