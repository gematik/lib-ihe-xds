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
package de.gematik.epa.conversion.internal.requests.factories.slot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectFactory;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;

/** Provides convenience methods to create new instances of {@link SlotType1}. */
public final class SlotFactory {

  public static final SlotType1 REMOVE_ME = new SlotType1();

  private SlotFactory() {}

  /** Returns a new SlotType1 based on the passed slotName name and value if test passes */
  public static SlotType1 slotIf(
      final SlotName slotName, Predicate<String> test, final String value) {
    return test.test(value) ? slot(slotName.getName(), value) : REMOVE_ME;
  }

  /** Returns a new SlotType1 based on the passed slotName name and values if test passes */
  public static SlotType1 slotIf(
      final SlotName slotName, Predicate<List<String>> test, final List<String> values) {
    return values != null && test.test(values) ? slot(slotName.getName(), values) : REMOVE_ME;
  }

  /** Returns a new SlotType1 based on the passed name and values */
  public static SlotType1 slot(final String name, final String... values) {
    final var slot = new ObjectFactory().createSlotType1();
    slot.setName(name);
    slot.setValueList(valueList(values));
    return slot;
  }

  /** Returns a new SlotType1 based on the passed name and values */
  public static SlotType1 slot(final String name, final List<String> values) {
    final var slot = new ObjectFactory().createSlotType1();
    slot.setName(name);
    slot.setValueList(valueList(values));
    return slot;
  }

  /**
   * Filters within the classification for a certain slottype. There is just one SlotName. Then
   * returns the values
   */
  public static List<String> getListFromSlot(
      ClassificationType classificationType, SlotName slotName) {
    List<String> values =
        classificationType.getSlot().stream()
            .filter(a -> a.getName().equals(slotName.getName()))
            .flatMap(a -> a.getValueList().getValue().stream())
            .toList();

    return new ArrayList<>(values);
  }

  /**
   * Filters within the extrinsicObjectType for a certain slottype. There is just one SlotName and
   * within that one value
   */
  public static String getValueFromSlot(List<SlotType1> slots, SlotName slotName) {
    return slots.stream()
        .filter(a -> a.getName().equals(slotName.getName()))
        .flatMap(a -> a.getValueList().getValue().stream())
        .findFirst()
        .orElse(null);
  }

  /** Returns a new ValueListType based on the passed values */
  private static ValueListType valueList(final String... values) {
    return new ObjectFactory().createValueListType().withValue(values);
  }

  /** Returns a new ValueListType based on the passed values */
  private static ValueListType valueList(final List<String> values) {
    return new ObjectFactory().createValueListType().withValue(values);
  }
}
