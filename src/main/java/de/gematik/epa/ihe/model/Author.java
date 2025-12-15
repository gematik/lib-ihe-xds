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
package de.gematik.epa.ihe.model;

import de.gematik.epa.ihe.model.simple.AuthorInstitution;
import java.util.List;

public record Author(
    String identifier,
    String familyName,
    String givenName,
    String otherName,
    String nameAffix,
    String title,
    String oid,
    List<AuthorInstitution> authorInstitution,
    List<String> authorRole,
    List<String> authorSpecialty,
    List<String> authorTelecommunication) {

  /** Sets the OID to 1.2.276.0.76.4.16 */
  public Author(
      String identifier,
      String familyName,
      String givenName,
      String otherName,
      String nameAffix,
      String title,
      List<AuthorInstitution> authorInstitution,
      List<String> authorRole,
      List<String> authorSpecialty,
      List<String> authorTelecommunication) {
    this(
        identifier,
        familyName,
        givenName,
        otherName,
        nameAffix,
        title,
        "1.2.276.0.76.4.16",
        authorInstitution,
        authorRole,
        authorSpecialty,
        authorTelecommunication);
  }

  public String formatted() {
    return "%s^%s^%s^%s^%s^%s^^^%s"
        .formatted(identifier, familyName, givenName, otherName, nameAffix, title, determineOid())
        .replace("null", "");
  }

  private String determineOid() {
    if (identifier != null) {
      return "&%s&ISO".formatted(oid != null ? oid : "1.2.276.0.76.4.16");
    }
    return "";
  }
}
