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

package de.gematik.epa.conversion.internal.response;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExternalIdentifierType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.LocalizedStringType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;

public abstract class RegistryObjectListUtils {

  protected InternationalStringType getInternationalStringType(String description) {
    var internationalStringType = new InternationalStringType();
    var localizedStringType = new LocalizedStringType();
    localizedStringType.setCharset("UTF-8");
    localizedStringType.setValue(description);
    localizedStringType.setLang("de-DE");
    internationalStringType.getLocalizedString().add(localizedStringType);
    return internationalStringType;
  }

  protected void createSlot(
      RegistryObjectType registryObjectType, SlotName slotName, String value) {
    SlotType1 slotType1 = new SlotType1();
    slotType1.setName(slotName.getName());
    var list = new ValueListType();
    list.getValue().add(value);
    slotType1.setValueList(list);
    registryObjectType.getSlot().add(slotType1);
  }

  protected void createExternalIdentifier(
      RegistryObjectType registryObjectType,
      ExternalIdentifierScheme externalIdentifierScheme,
      String value) {
    var externalIdentifier = new ExternalIdentifierType();
    InternationalStringType internationalStringType =
        getInternationalStringType(externalIdentifierScheme.getName());
    externalIdentifier.setName(internationalStringType);
    externalIdentifier.setIdentificationScheme(externalIdentifierScheme.getId());
    externalIdentifier.setValue(value);
    registryObjectType.getExternalIdentifier().add(externalIdentifier);
  }

  protected void createClassification(
      RegistryObjectType registryObjectType,
      ClassificationScheme classificationScheme,
      String value) {
    ClassificationType classification = new ClassificationType();
    classification.setClassificationScheme(classificationScheme.getUrn());
    classification.setNodeRepresentation(value);
    registryObjectType.getClassification().add(classification);
  }
}
