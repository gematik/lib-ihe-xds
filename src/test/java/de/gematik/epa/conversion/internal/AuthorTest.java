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
package de.gematik.epa.conversion.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.gematik.epa.ihe.model.Author;
import java.util.List;
import org.junit.jupiter.api.Test;

class AuthorTest {

  @Test
  void formatAuthorWithIdentifierWithoutOid() {
    Author nullAuthor = new Author("1", null, null, null, null, null, null, null, null, null, null);
    assertEquals("1^^^^^^^^&1.2.276.0.76.4.16&ISO", nullAuthor.formatted());
  }

  @Test
  void formatAuthorWithoutIdentifierOid() {
    Author nullAuthor =
        new Author(null, null, null, null, null, null, null, null, null, null, null);
    assertEquals("^^^^^^^^", nullAuthor.formatted());
  }

  @Test
  void formatAuthorWithFamilyAndGivenName() {
    Author nullAuthor =
        new Author(null, "Blankenburg", "Sigrid", null, null, null, null, null, null, null, null);
    assertEquals("^Blankenburg^Sigrid^^^^^^", nullAuthor.formatted());
  }

  @Test
  void formatAuthorWithFamilyAndGivenNameIdentifier() {
    Author nullAuthor =
        new Author(
            "123456789", "Blankenburg", "Sigrid", null, null, null, null, null, null, null, null);
    assertEquals(
        "123456789^Blankenburg^Sigrid^^^^^^&1.2.276.0.76.4.16&ISO", nullAuthor.formatted());
  }

  @Test
  void formatDefaultOidAuthor() {
    Author defaultOidAuthor =
        new Author(
            "9-SMC-B-Testkarte-883110000119267",
            "DIGA-Hersteller",
            "Sina Gr..fin ..zTEST-ONLY",
            null,
            "1.2.276.0.76.4.282",
            "Prof. Dr.",
            List.of(),
            List.of(),
            List.of(),
            List.of());
    assertEquals(
        "9-SMC-B-Testkarte-883110000119267^DIGA-Hersteller^Sina Gr..fin ..zTEST-ONLY^^1.2.276.0.76.4.282^Prof. Dr.^^^&1.2.276.0.76.4.16&ISO",
        defaultOidAuthor.formatted());
  }

  @Test
  void formatCustomOidAuthor() {
    Author customOidAuthor =
        new Author(
            "9-SMC-B-Testkarte-883110000119267",
            "DIGA-Hersteller",
            "Sina Gr..fin ..zTEST-ONLY",
            null,
            "1.2.276.0.76.4.282",
            "Prof. Dr.",
            "1.2.276.0.76.4.282",
            List.of(),
            List.of(),
            List.of(),
            List.of());
    assertEquals(
        "9-SMC-B-Testkarte-883110000119267^DIGA-Hersteller^Sina Gr..fin ..zTEST-ONLY^^1.2.276.0.76.4.282^Prof. Dr.^^^&1.2.276.0.76.4.282&ISO",
        customOidAuthor.formatted());
  }
}
