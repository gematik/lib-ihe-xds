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

@AllArgsConstructor
@Getter
public enum EventCode implements CodeInterface {
  WORKFLOW_OFFEN(
      "urn:ihe:iti:xdw:2011:eventCode:open", CodeSystem.IHE_FORMAT_CODES, "Workflow offen"),
  WORKFLOW_ABGESCHLOSSEN(
      "urn:ihe:iti:xdw:2011:eventCode:closed",
      CodeSystem.IHE_FORMAT_CODES,
      "Workflow abgeschlossen"),
  PATIENTEN_MITGEBRACHT("H1", CodeSystem.DOKUMENTEN_WARNHINWEISE, "vom Patienten mitgebracht"),
  PATIENT_UNBESPROCHEN(
      "H2", CodeSystem.DOKUMENTEN_WARNHINWEISE, "noch nicht mit Patient besprochen"),
  EVENTUELL_VERALTETE_DATEN("H3", CodeSystem.DOKUMENTEN_WARNHINWEISE, "eventuell veraltete Daten"),
  VORLAEUFIGES_DOKUMENT("H4", CodeSystem.DOKUMENTEN_WARNHINWEISE, "vorläufiges Dokument"),
  AMBULANTER_KONTAKT("E100", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "ambulanter Kontakt"),
  AMBULANTE_OP("E110", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "ambulante OP"),
  STATIONAERER_AUFENTHALT(
      "E200", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "stationärer Aufenthalt"),
  STATIONAERE_AUFNAHME("E210", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "stationäre Aufnahme"),
  AUFNAHME_VOLLSTATIONAER(
      "E211", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Aufnahme vollstationär"),
  AUFNAHME_WIEDERAUFNAHME_TEILSTATIONAER(
      "E212", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Aufnahme/Wiederaufnahme teilstationär"),
  AUFNAHME_ENTBINDUNG_STATIONAER(
      "E213", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Aufnahme Entbindung stationär"),
  AUFNAHME_NEUGEBORENE(
      "E214", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Aufnahme eines Neugeborenen"),
  AUFNAHME_SPENDER_ORGANENTNAHME(
      "E215",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "Aufnahme des Spenders zur Organentnahme"),
  STATIONAERE_ENTLASSUNG(
      "E230", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "stationäre Entlassung"),
  STATIONAERE_ENTLASSUNG_NACH_HAUSE(
      "E231", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "stationäre Entlassung nach Hause"),
  STATIONAERE_ENTLASSUNG_NACH_REHA(
      "E232",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "stationäre Entlassung in eine Rehabilitationseinrichtung"),
  STATIONAERE_ENTLASSUNG_NACH_PFLEGE_HOSPIZ(
      "E233",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "stationäre Entlassung in eine Pflegeeinrichtung/Hospiz"),
  ENTLASSUNG_ZUR_NACHSTATIONAEREN_BEHANDLUNG(
      "E234",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "Entlassung zur nachstationären Behandlung"),
  PATIENT_STATIONAEREM_AUFENTHALT_VERSTORBEN(
      "E235",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "Patient während stationärem Aufenthalt verstorben"),
  STATIONAERE_VERLEGUNG(
      "E250", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "stationäre Verlegung"),
  VERLEGUNG_INNERHALB_KRANKENHAUS(
      "E251",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "Verlegung innerhalb eines Krankenhauses"),
  VERLEGUNG_ANDERES_KRANKENHAUS(
      "E252", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Verlegung in ein anderes Krankenhaus"),
  EXTERNE_VERLEGUNG_PSYCHIATRIE(
      "E253", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "externe Verlegung in Psychiatrie"),
  KURZZEITIGE_UNTERBRECHUNG_STATIONAERE_BEHANDLUNG(
      "E270",
      CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG,
      "kurzzeitige Unterbrechung einer stationären Behandlung"),
  KONSIL("E280", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Konsil"),
  BEHANDLUNG_HAEUSLICH(
      "E300", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Behandlung im häuslichen Umfeld"),
  VIRTUAL_ENCOUNTER("E400", CodeSystem.FALLKONTEXT_DOKUMENTENERSTELLUNG, "Virtual Encounter");

  private final String value;
  private final String codingScheme;
  private final String name;

  public static EventCode fromValue(@NonNull String value) {
    return CodeInterface.fromValue(value, EventCode.class);
  }

  private static class CodeSystem {
    public static final String DOKUMENTEN_WARNHINWEISE = "1.3.6.1.4.1.19376.3.276.1.5.15";
    public static final String FALLKONTEXT_DOKUMENTENERSTELLUNG = "1.3.6.1.4.1.19376.3.276.1.5.16";
    public static final String IHE_FORMAT_CODES = "1.3.6.1.4.1.19376.1.2.3";
  }
}
