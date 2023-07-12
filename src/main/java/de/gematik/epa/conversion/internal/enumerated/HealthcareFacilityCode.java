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

package de.gematik.epa.conversion.internal.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * See <a
 * href="https://github.com/gematik/api-ePA/tree/fa02e96e58cd6138416b7c6684387fa8d7a2d4eb/src/vocabulary/value_sets">...</a>
 */
@AllArgsConstructor
@Getter
public enum HealthcareFacilityCode implements CodeInterface {
  AMBULANTER_PFLEGEDIENST(
      "APD", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Ambulanter Pflegedienst"),
  APOTHEKE("APO", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Apotheke"),
  AERZTLICHER_BEREITSCHAFTSDIENST(
      "BER", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Ärztlicher Bereitschaftsdienst"),
  ARZTPRAXIS("PRA", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Arztpraxis"),
  BETRIEBSAERZTLICHE_ABTEILUNG(
      "BAA", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Betriebsärztliche Abteilung"),
  GESUNDHEITSBEHOERDE("BHR", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Gesundheitsbehörde"),
  HEBAMME_GEBURTSHAUS("HEB", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Hebamme/Geburtshaus"),
  HOSPIZ("HOS", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Hospiz"),
  KRANKENHAUS("KHS", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Krankenhaus"),
  MEDIZINISCHES_VERSORGUNGSZENTRUM(
      "MVZ", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Medizinisches Versorgungszentrum"),
  MEDIZINISCH_TECHNISCHES_HANDWERK(
      "HAN", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Medizinisch-technisches Handwerk"),
  MEDIZINISCHE_REHABILITATION(
      "REH", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Medizinische Rehabilitation"),
  NICHT_AERZTLICHE_HEILBERUFS_PRAXIS(
      "HEI", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Nicht-ärztliche Heilberufs-Praxis"),
  PFLEGEHEIM("PFL", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Pflegeheim"),
  RETTUNGSDIENST("RTN", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Rettungsdienst"),
  SELBSTHILFE("SEL", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Selbsthilfe"),
  TELEMEDIZINISCHES_ZENTRUM(
      "TMZ", Einrichtungsart.INNERHALB_PAT_VERSORGUNG, "Telemedizinisches Zentrum"),
  BILDUNGSEINRICHTUNG("BIL", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Bildungseinrichtung"),
  FORSCHUNGSEINRICHTUNG("FOR", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Forschungseinrichtung"),
  GEN_ANALYSEDIENSTE("GEN", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Gen-Analysedienste"),
  MEDIZINISCHER_DIENST_KRANKENVERSICHERUNG(
      "MDK",
      Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG,
      "Medizinischer Dienst der Krankenversicherung"),
  PATIENT_AUSSERHALB_BETREUUNG(
      "PAT", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Patient außerhalb der Betreuung"),
  SPENDEDIENSTE("SPE", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Spendedienste"),
  VERSICHERUNGSTRAEGER("VER", Einrichtungsart.AUSSERHALB_PAT_VERSORGUNG, "Versicherungsträger");

  private final String value;
  private final String codingScheme;
  private final String name;

  public static HealthcareFacilityCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, HealthcareFacilityCode.class);
  }

  private static class Einrichtungsart {
    public static final String INNERHALB_PAT_VERSORGUNG = "1.3.6.1.4.1.19376.3.276.1.5.2";
    public static final String AUSSERHALB_PAT_VERSORGUNG = "1.3.6.1.4.1.19376.3.276.1.5.3";
  }
}
