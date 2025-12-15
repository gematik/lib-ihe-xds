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
package de.gematik.epa.conversion.internal.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum ConfidentialityCode implements CodeInterface {
  NORMAL("N", "normal"),
  RESTRICTED("R", "restricted"),
  VERY_RESTRICTED("V", "very restricted"),
  CON("CON", "Dokument verbergen");

  private static final String CODING_SCHEME = "2.16.840.1.113883.5.25";

  // https://gemspec.gematik.de/ig/fhir/terminology/1.0.5-4/ValueSet-epa-xds-confidentiality-code-vs.xml.html
  private static final String CODING_SCHEME_CON = "1.2.276.0.76.5.491";

  private final String value;
  private final String name;

  @Override
  public String getCodingScheme() {
    return this == CON ? CODING_SCHEME_CON : CODING_SCHEME;
  }

  public static ConfidentialityCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, ConfidentialityCode.class);
  }
}
