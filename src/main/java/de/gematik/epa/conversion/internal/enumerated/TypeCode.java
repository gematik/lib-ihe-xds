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

/**
 * See
 * https://github.com/gematik/api-ePA/tree/fa02e96e58cd6138416b7c6684387fa8d7a2d4eb/src/vocabulary/value_sets
 */
@AllArgsConstructor
@Getter
public enum TypeCode implements CodeInterface {
  ABRECHNUNGSDOKUMENTE("ABRE", "Abrechnungsdokumente"),
  ADMINISTRATIVE_CHECKLISTEN("ADCH", "Administrative Checklisten"),
  ANTRAEGE_UND_DEREN_BESCHEIDE("ANTR", "Anträge und deren Bescheide"),
  ANAESTHESIEDOKUMENTE("ANAE", "Anästhesiedokumente"),
  ARZTBERICHTE("BERI", "Arztberichte"),
  AERZTLICHE_BESCHEINIGUNGEN("BESC", "Ärztliche Bescheinigungen"),
  ERGEBNISSE_DIAGNOSTIK("BEFU", "Ergebnisse Diagnostik"),
  BESTRAHLUNGSDOKUMENTATION("BSTR", "Bestrahlungsdokumentation"),
  EINWEISUNG_AUFNAHME_DOKUMENTE("AUFN", "Einweisungs- und Aufnahmedokumente"),
  EINWILLIGUNGEN_AUFKLAERUNGEN("EINW", "Einwilligungen/Aufklärungen"),
  ERGEBNISSE_FUNKTIONSDIAGNOSTIK("FUNK", "Ergebnisse Funktionsdiagnostik"),
  ERGEBNISSE_BILDGEBENDER_DIAGNOSTIK("BILD", "Ergebnisse bildgebender Diagnostik"),
  FALLBESPRECHUNGEN("FALL", "Fallbesprechungen"),
  FOTODOKUMENTATION("FOTO", "Fotodokumentation"),
  THERAPIEDOKUMENTATION("FPRO", "Therapiedokumentation"),
  ERGEBNISSE_IMMUNOLOGIE("IMMU", "Ergebnisse Immunologie"),
  INTENSIVMEDIZINISCHE_DOKUMENTE("INTS", "Intensivmedizinische Dokumente"),
  KOMPLEXBEHANDLUNGSOEGEN("KOMP", "Komplexbehandlungsbögen"),
  MEDIKAMENTOESE_THERAPIEN("MEDI", "Medikamentöse Therapien"),
  ERGEBNISSE_MIKROBIOLOGIE("MKRO", "Ergebnisse Mikrobiologie"),
  OP_DOKUMENTE("OPDK", "OP-Dokumente"),
  ONKOLOGISCHE_DOKUMENTE("ONKO", "Onkologische Dokumente"),
  PATHOLOGIEBEFUNDBERICHTE("PATH", "Pathologiebefundberichte"),
  PATIENTENEIGENE_DOKUMENTE("PATD", "Patienteneigene Dokumente"),
  PATIENTENINFORMATIONEN("PATI", "Patienteninformationen"),
  PFLEGEDOKUMENTATION("PFLG", "Pflegedokumentation"),
  PATIENTENEINVERSTAENDNISERKLAERUNG("57016-8", "Patienteneinverständniserklärung"),
  QUALITAETSSICHERUNG("QUAL", "Qualitätssicherung"),
  RETTUNGSDIENSTLICHE_DOKUMENTE("RETT", "Rettungsdienstliche Dokumente"),
  SCHRIFTWECHSEL_ADMINISTRATIV("SCHR", "Schriftwechsel (administrativ)"),
  SCHWANGERSCHAFTS_UND_GEBURTSDOKUMENTATION("GEBU", "Schwangerschafts- und Geburtsdokumentation"),
  SOZIALDIENSTDOKUMENTE("SOZI", "Sozialdienstdokumente"),
  STUDIENDOKUMENTE("STUD", "Studiendokumente"),
  TRANSFUSIONSDOKUMENTE("TRFU", "Transfusionsdokumente"),
  TRANSPLANTATIONSDOKUMENTE("TRPL", "Transplantationsdokumente"),
  VERORDNUNGEN("VERO", "Verordnungen"),
  VERTRAEGE("VERT", "Verträge"),
  ERGEBNISSE_VIROLOGIE("VIRO", "Ergebnisse Virologie"),
  WUNDDOKUMENTATION("WUND", "Wunddokumentation"),
  GRIS("GRIS", "Auswertung Gesundheitsrisiken");

  private static final String CODING_SCHEME = "1.3.6.1.4.1.19376.3.276.1.5.9";

  private final String value;
  private final String name;

  public static TypeCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, TypeCode.class);
  }

  @Override
  public String getCodingScheme() {
    return CODING_SCHEME;
  }
}
