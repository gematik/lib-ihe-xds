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

/**
 * See
 * https://github.com/gematik/api-ePA/tree/fa02e96e58cd6138416b7c6684387fa8d7a2d4eb/src/vocabulary/value_sets
 */
@AllArgsConstructor
@Getter
public enum PracticeSettingCode implements CodeInterface {
  ALLGEMEINMEDIZIN("ALLG", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Allgemeinmedizin"),
  ANAESTHESIOLOGIE("ANAE", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Anästhesiologie"),
  ARBEITSMEDIZIN("ARBE", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Arbeitsmedizin"),
  AUGENHEILKUNDE("AUGE", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Augenheilkunde"),
  CHIRURGIE("CHIR", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Chirurgie"),
  ALLGEMEINCHIRURGIE("ALCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Allgemeinchirurgie"),
  GEFAESSCHIRURGIE("GFCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Gefäßchirurgie"),
  HERZCHIRURGIE("HZCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Herzchirurgie"),
  KINDERCHIRURGIE("KDCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kinderchirurgie"),
  ORTHOPAEDIE("ORTH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Orthopädie"),
  PLASTISCHE_AESTHETISCHE_CHIRURGIE(
      "PLCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Plastische und Ästhetische Chirurgie"),
  THORAXCHIRURGIE("THCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Thoraxchirurgie"),
  UNFALLCHIRURGIE("UNFC", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Unfallchirurgie"),
  VISZERALCHIRURGIE("VICH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Viszeralchirurgie"),
  FRAUENHEILKUNDE_GEBURTSHILFE(
      "FRAU", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Frauenheilkunde und Geburtshilfe"),
  GYNAEKOLOGISCHE_ENDOKRINOLOGIE_REPRODUKTIONSMEDIZIN(
      "GEND",
      Fachrichtung.AERZTLICHE_FACHRICHTUNGEN,
      "Gynäkologische Endokrinologie und Reproduktionsmedizin"),
  GYNAEKOLOGISCHE_ONKOLOGIE(
      "GONK", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Gynäkologische Onkologie"),
  PERINATALMEDIZIN("PERI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Perinatalmedizin"),
  GERIATRIE("GERI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Geriatrie"),
  HALS_NASEN_OHREN_HEILKUNDE(
      "HNOH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Hals-Nasen-Ohrenheilkunde"),
  SPRACH_STIMM_HOERSTOERUNGEN_KIND(
      "HRST", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Sprach-, Stimm- und kindliche Hörstörungen"),
  HAUT_UND_GESCHLECHTSKRANKHEITEN(
      "HAUT", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Haut- und Geschlechtskrankheiten"),
  HUMANGENETIK("HUMA", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Humangenetik"),
  HYGIENE_UND_UMWELTMEDIZIN(
      "HYGI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Hygiene und Umweltmedizin"),
  INNERE_MEDIZIN("INNE", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Innere Medizin"),
  INNERE_MEDIZIN_ANGIOLOGIE("ANGI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Angiologie"),
  INNERE_MEDIZIN_ENDOKRINOLOGIE_DIABETOLOGIE(
      "ENDO", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Endokrinologie und Diabetologie"),
  INNERE_MEDIZIN_GASTROENTEROLOGIE(
      "GAST", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Gastroenterologie"),
  INNERE_MEDIZIN_HAEMATOLOGIE_ONKOLOGIE(
      "HAEM", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Hämatologie und internistische Onkologie"),
  INNERE_MEDIZIN_KARDIOLOGIE("KARD", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kardiologie"),
  INNERE_MEDIZIN_NEPHROLOGIE("NEPH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Nephrologie"),
  INNERE_MEDIZIN_PNEUMOLOGIE("PNEU", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Pneumologie"),
  INNERE_MEDIZIN_RHEUMATOLOGIE("RHEU", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Rheumatologie"),
  INTENSIVMEDIZIN("INTM", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Intensivmedizin"),
  INTERDISZIPLINAERE_ONKOLOGIE(
      "INTO", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Interdisziplinäre Onkologie"),
  INTERDISZIPLINAERE_SCHMERZMEDIZIN(
      "INTS", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Interdisziplinäre Schmerzmedizin"),
  KINDER_JUGEND_MEDIZIN(
      "KIJU", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kinder- und Jugendmedizin"),
  KINDER_HAEMATOLOGIE_ONKOLOGIE(
      "KONK", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kinder-Hämatologie und -Onkologie"),
  KINDER_KARDIOLOGIE("KKAR", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kinder-Kardiologie"),
  NEONATOLOGIE("NNAT", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neonatologie"),
  NEUROPAEDIATRIE("NPAE", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neuropädiatrie"),
  KINDER_JUGEND_PSYCHIATRIE_PSYCHOTHERAPIE(
      "KPSY",
      Fachrichtung.AERZTLICHE_FACHRICHTUNGEN,
      "Kinder- und Jugendpsychiatrie und -psychotherapie"),
  LABORATORIUMSMEDIZIN("LABO", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Laboratoriumsmedizin"),
  MIKROBIOLOGIE_VIROLOGIE_INFEKTIONSEPIDEMIOLOGIE(
      "MIKR",
      Fachrichtung.AERZTLICHE_FACHRICHTUNGEN,
      "Mikrobiologie, Virologie und Infektionsepidemiologie"),
  MUND_KIEFER_GESICHTSCHIRURGIE(
      "MKGC", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Mund-Kiefer-Gesichtschirurgie"),
  NATURHEILVERFAHREN(
      "NATU",
      Fachrichtung.AERZTLICHE_FACHRICHTUNGEN,
      "Naturheilverfahren und alternative Heilmethoden"),
  NOTFALLMEDIZIN("NOTF", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Notfallmedizin"),
  NEUROCHIRURGIE("NRCH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neurochirurgie"),
  NEUROLOGIE("NEUR", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neurologie"),
  NUKLEARMEDIZIN("NUKL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Nuklearmedizin"),
  OEFFENTLICHES_GESUNDHEITSWESEN(
      "GESU", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Öffentliches Gesundheitswesen"),
  PALLIATIVMEDIZIN("PALL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Palliativmedizin"),
  PATHOLOGIE("PATH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Pathologie"),
  NEUROPATHOLOGIE("NPAT", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neuropathologie"),
  PHARMAKOLOGIE("PHAR", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Pharmakologie"),
  TOXIKOLOGIE("TOXI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Toxikologie"),
  PHYSIKALISCHE_REHABILITATIVE_MEDIZIN(
      "REHA", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Physikalische und Rehabilitative Medizin"),
  PSYCHIATRIE_PSYCHOTHERAPIE(
      "PSYC", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Psychiatrie und Psychotherapie"),
  FORENSISCHE_PSYCHIATRIE(
      "FPSY", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Forensische Psychiatrie"),
  PSYCHOSOMATISCHE_MEDIZIN_PSYCHOTHERAPIE(
      "PSYM",
      Fachrichtung.AERZTLICHE_FACHRICHTUNGEN,
      "Psychosomatische Medizin und Psychotherapie"),
  RADIOLOGIE("RADI", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Radiologie"),
  KINDERRADIOLOGIE("KRAD", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kinderradiologie"),
  NEURORADIOLOGIE("NRAD", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Neuroradiologie"),
  RECHTSMEDIZIN("RECH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Rechtsmedizin"),
  SCHLAFMEDIZIN("SCHL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Schlafmedizin"),
  SPORT_UND_BEWEGUNGSMEDIZIN(
      "SPOR", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Sport- und Bewegungsmedizin"),
  STRAHLENTHERAPIE("STRA", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Strahlentherapie"),
  TRANSFUSIONSMEDIZIN("TRAN", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Transfusionsmedizin"),
  TROPEN_REISEMEDIZIN("TROP", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Tropen-/Reisemedizin"),
  UROLOGIE("UROL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Urologie"),
  ZAHNMEDIZIN("MZKH", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Zahnmedizin"),
  ORALCHIRURGIE("ORAL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Oralchirurgie"),
  KIEFERORTHOPAEDIE("KIEF", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Kieferorthopädie"),
  TRANSPLANTATIONSMEDIZIN(
      "TRPL", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Transplantationsmedizin"),
  ERGOTHERAPIE("ERG", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Ergotherapie"),
  ERNAEHRUNG_DIAETETIK(
      "ERN", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Ernährung und Diätetik"),
  FORSCHUNG("FOR", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Forschung"),
  PFLEGE_BETREUUNG("PFL", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Pflege und Betreuung"),
  ALTENPFLEGE("ALT", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Altenpflege"),
  KINDERPFLEGE("KIN", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Kinderpflege"),
  PATIENT_AUSSERHALB_BETREUUNG(
      "PAT", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Patient außerhalb der Betreuung"),
  PHARMAZEUTIK("PHZ", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Pharmazeutik"),
  PODOLOGIE("POD", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Podologie"),
  PRAEVENTION("PRV", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Prävention"),
  SOZIALWESEN("SOZ", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Sozialwesen"),
  SPRACHTHERAPIE("SPR", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Sprachtherapie"),
  VERSORGUNGSKOORDINATION(
      "VKO", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Versorgungskoordination"),
  VERWALTUNG("VER", Fachrichtung.NICHT_AERZTLICHE_FACHRICHTUNGEN, "Verwaltung"),
  PARODONTOLOGIE("PARO", Fachrichtung.AERZTLICHE_FACHRICHTUNGEN, "Parodontologie"),
  ALLGEMEINE_ZAHNHEILKUNDE(
      "MZAH", Fachrichtung.ZAHNAERZTLICHE_FACHRICHTUNGEN, "Allgemeine Zahnheilkunde"),
  FZA_OEFFENTLICHES_GESUNDHEITSWESEN(
      "ZGES", Fachrichtung.ZAHNAERZTLICHE_FACHRICHTUNGEN, "FZA Öffentliches Gesundheitswesen");

  private final String value;
  private final String codingScheme;
  private final String name;

  public static PracticeSettingCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, PracticeSettingCode.class);
  }

  private static class Fachrichtung {
    public static final String AERZTLICHE_FACHRICHTUNGEN = "1.3.6.1.4.1.19376.3.276.1.5.4";
    public static final String NICHT_AERZTLICHE_FACHRICHTUNGEN = "1.3.6.1.4.1.19376.3.276.1.5.5";
    public static final String ZAHNAERZTLICHE_FACHRICHTUNGEN = "1.2.276.0.76.5.494";
  }
}
