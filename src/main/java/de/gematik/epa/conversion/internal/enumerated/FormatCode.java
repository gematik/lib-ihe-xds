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
package de.gematik.epa.conversion.internal.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum FormatCode implements CodeInterface {
  ARBEITSUNFAEHIGKEITSBESCHEINIGUNG(
      "urn:gematik:ig:Arbeitsunfaehigkeitsbescheinigung:v1.1",
      CodingScheme.DOK_DE,
      "Arbeitsunfähigkeitsbescheinigung (gematik) v1.1"),
  ARZTBRIEF("urn:gematik:ig:Arztbrief:r3.1", CodingScheme.DOK_DE, "Arztbrief"),
  IMPFPASS("urn:gematik:ig:Impfausweis:v1.1.0", CodingScheme.DOK_DE, "Impfpass"),
  KINDERUNTERSUCHUNGSHEFT_NOTIZEN(
      "urn:gematik:ig:KinderuntersuchungsheftNotizen:v1.0.0",
      CodingScheme.DOK_DE,
      "Kinderuntersuchungsheft Notizen"),
  KINDERUNTERSUCHUNGSHEFT_NOTIZEN_V101(
      "urn:gematik:ig:KinderuntersuchungsheftNotizen:v1.0.1",
      CodingScheme.DOK_DE,
      "Kinderuntersuchungsheft Notizen"),
  KINDERUNTERSUCHUNGSHEFT_TEILNAHMEKARTE(
      "urn:gematik:ig:KinderuntersuchungsheftTeilnahmekarte:v1.0.0",
      CodingScheme.DOK_DE,
      "Kinderuntersuchungsheft Teilnahmekarte"),
  KINDERUNTERSUCHUNGSHEFT_UNTERSUCHUNGEN(
      "urn:gematik:ig:KinderuntersuchungsheftUntersuchungen:v1.0.0",
      CodingScheme.DOK_DE,
      "Kinderuntersuchungsheft Untersuchungen"),
  KINDERUNTERSUCHUNGSHEFT_UNTERSUCHUNGEN_V101(
      "urn:gematik:ig:KinderuntersuchungsheftUntersuchungen:v1.0.1",
      CodingScheme.DOK_DE,
      "Kinderuntersuchungsheft Untersuchungen"),
  MEDIKATIONSPLAN("urn:gematik:ig:Medikationsplan:r3.1", CodingScheme.DOK_DE, "Medikationsplan"),
  MUTTERPASS("urn:gematik:ig:Mutterpass:v1.1.0", CodingScheme.DOK_DE, "Mutterpass"),
  NOTFALLDATENSATZ("urn:gematik:ig:Notfalldatensatz:r3.1", CodingScheme.DOK_DE, "Notfalldatensatz"),
  PERSOENLICHE_ERKLAERUNGEN(
      "urn:gematik:ig:DatensatzPersoenlicheErklaerungen:r3.1",
      CodingScheme.DOK_DE,
      "Persönliche Erklärungen"),
  REZEPT("urn:gematik:ig:VerordnungsdatensatzMedikation:r4.0", CodingScheme.DOK_DE, "Rezept"),
  ZAHNBONUSHEFT("urn:gematik:ig:Zahnbonusheft:v1.1.0", CodingScheme.DOK_DE, "Zahnbonusheft"),
  BEFUND("urn:ihe:iti:xds:2017:mimeTypeSufficient", CodingScheme.IHE, "Befund"),
  PATIENTEN_KURZ_AKTE("urn:gematik:ig:pka:v1.0", CodingScheme.DOK_DE, "Patientenkurzakte"),
  DIGA("urn:gematik:ig:diga:v1.1", CodingScheme.DOK_DE, "DiGA (gematik) v1.1"),
  EDMP_DATENSATZ(
      "urn:gematik:ig:DMP-DM2:v6", CodingScheme.DOK_DE, "eDMP Diabetes mellitus Typ 2 (gematik)");

  private final String value;
  private final String codingScheme;
  private final String name;

  public static FormatCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, FormatCode.class);
  }

  private static class CodingScheme {
    private static final String DOK_DE = "1.3.6.1.4.1.19376.3.276.1.5.6";
    private static final String IHE = "1.3.6.1.4.1.19376.1.2.3";
  }
}
