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
package de.gematik.epa.conversion.internal.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum ClassCode implements CodeInterface {
  DOK_ADMINISTRATIV("ADM", ClassType.DEFAULT, "Administratives Dokument"),
  ANFORDERUNG("ANF", ClassType.DEFAULT, "Anforderung"),
  ASSESSMENT("ASM", ClassType.DEFAULT, "Assessment"),
  BEFUNDBERICHT("BEF", ClassType.DEFAULT, "Befundbericht"),
  BILDDATEN("BIL", ClassType.DEFAULT, "Bilddaten"),
  BRIEF("BRI", ClassType.DEFAULT, "Brief"),
  DOK_NOTIZEN("DOK", ClassType.DEFAULT, "Dokumente ohne besondere Form (Notizen)"),
  DURCHFUEHRUNGSPROTOKOLL("DUR", ClassType.DEFAULT, "Durchführungsprotokoll"),
  FORSCHUNG("FOR", ClassType.DEFAULT, "Forschung"),
  GUTACHTEN_UND_QUALITAETSMANAGEMENT("GUT", ClassType.DEFAULT, "Gutachten und Qualitätsmanagement"),
  LABORERGEBNISSE("LAB", ClassType.DEFAULT, "Laborergebnisse"),
  MEDIZINISCHER_AUSWEIS("AUS", ClassType.DEFAULT, "Medizinischer Ausweis"),
  PLANUNGSDOKUMENT("PLA", ClassType.DEFAULT, "Planungsdokument"),
  PATIENTENEINVERSTAENDNISERKLAERUNG(
      "57016-8", ClassType.LOINC, "Patienteneinverständniserklärung"),
  VERORDNUNG("VER", ClassType.DEFAULT, "Verordnung"),
  VIDEODATEN("VID", ClassType.DEFAULT, "Videodaten");

  private final String value;
  private final String codingScheme;
  private final String name;

  public static ClassCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, ClassCode.class);
  }

  private static class ClassType {
    public static final String DEFAULT = "1.3.6.1.4.1.19376.3.276.1.5.8";
    public static final String LOINC = "2.16.840.1.113883.6.1";
  }
}
