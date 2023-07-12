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

package de.gematik.epa.unit.util;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExternalIdentifierType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;

public class GetXDSAttributesUtil {

  public static String getValueFromSlot(RegistryObjectType objectType, String slotName) {
    SlotType1 slot = getSlotFromRegistryObject(objectType, slotName);
    return Optional.ofNullable(slot)
        .map(currentSlot -> currentSlot.getValueList().getValue().get(0))
        .orElse(null);
  }

  public static SlotType1 getSlotFromRegistryObject(
      RegistryObjectType objectType, String slotName) {
    return objectType.getSlot().stream()
        .filter(s -> s.getName().equals(slotName))
        .findFirst()
        .orElse(null);
  }

  public static SlotType1 getSlotFromAuthorClassification(
      RegistryObjectType objectType, String slotName, String classificationSchemeUrn) {
    ClassificationType authorClassification =
        getFirstClassification(objectType, classificationSchemeUrn);
    return authorClassification.getSlot().stream()
        .filter(s -> s.getName().equals(slotName))
        .findFirst()
        .orElse(null);
  }

  public static String getSlotTimeValue(RegistryObjectType objectType, String slotName) {
    return getSlotFromRegistryObject(objectType, slotName).getValueList().getValue().stream()
        .findFirst()
        .orElse(null);
  }

  public static ClassificationType getFirstClassification(
      RegistryObjectType objectType, String scheme) {
    return Optional.ofNullable(objectType.getClassification()).stream()
        .flatMap(List::stream)
        .filter(current -> current.getClassificationScheme().equals(scheme))
        .findFirst()
        .orElse(null);
  }

  public static List<ClassificationType> getClassificationList(
      RegistryObjectType objectType, String scheme) {
    return Optional.ofNullable(objectType.getClassification()).stream()
        .flatMap(List::stream)
        .filter(c -> c != null && scheme.equals(c.getClassificationScheme()))
        .toList();
  }

  public static String getNodeRepresentationValue(
      RegistryObjectType objectType, String classificationValue) {
    return Optional.ofNullable(getFirstClassification(objectType, classificationValue))
        .map(ClassificationType::getNodeRepresentation)
        .orElse(null);
  }

  public static List<String> getNodeRepresentationValueList(
      RegistryObjectType objectType, String classificationSchemeValue) {
    return Optional.ofNullable(getClassificationList(objectType, classificationSchemeValue))
        .stream()
        .flatMap(Collection::stream)
        .map(ClassificationType::getNodeRepresentation)
        .collect(Collectors.toList());
  }

  public static String getExternalIdentifier(RegistryObjectType objectType, String type) {
    ExternalIdentifierType externalIdentifierType =
        objectType.getExternalIdentifier().stream()
            .filter(name -> name.getName().getLocalizedString().get(0).getValue().equals(type))
            .findFirst()
            .orElse(null);
    return Objects.requireNonNull(externalIdentifierType).getValue();
  }
}
