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
package de.gematik.epa.conversion.internal.factories.slot;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlotFactoryTest {

  private SlotType1 excpextedSlot;
  private String value;
  private SlotName slotName;

  @BeforeEach
  public void setUp() {
    value = "Something";
    slotName = SlotName.CREATION_TIME;
    excpextedSlot = new SlotType1();
    excpextedSlot.setName(slotName.getName());
    ValueListType valueListType = new ValueListType();
    valueListType.getValue().add(value);
    excpextedSlot.setValueList(valueListType);
  }

  @Test
  void testSlotIfValue() {
    final SlotType1 actualSlot = SlotFactory.slotIf(slotName, strings -> !strings.isEmpty(), value);
    assertEquals(excpextedSlot.getSlotType(), actualSlot.getSlotType());
    assertEquals(excpextedSlot.getName(), actualSlot.getName());
    assertEquals(
        excpextedSlot.getValueList().getValue().get(0),
        actualSlot.getValueList().getValue().get(0));
  }

  @Test
  void testSlotIfNotValue() {
    value = "";
    final SlotType1 actualSlot = SlotFactory.slotIf(slotName, strings -> !strings.isEmpty(), value);
    assertNull(actualSlot.getSlotType());
    assertNull(actualSlot.getName());
    assertNull(actualSlot.getValueList());
  }

  @Test
  void testSlotIfList() {
    final SlotType1 actualSlot =
        SlotFactory.slotIf(slotName, strings -> !strings.isEmpty(), List.of(value));
    assertEquals(excpextedSlot.getSlotType(), actualSlot.getSlotType());
    assertEquals(excpextedSlot.getName(), actualSlot.getName());
    assertEquals(
        excpextedSlot.getValueList().getValue().get(0),
        actualSlot.getValueList().getValue().get(0));
  }

  @Test
  void testSlotArray() {
    final SlotType1 actualSlot = SlotFactory.slot(slotName.getName(), value);
    assertEquals(excpextedSlot.getSlotType(), actualSlot.getSlotType());
    assertEquals(excpextedSlot.getName(), actualSlot.getName());
    assertEquals(
        excpextedSlot.getValueList().getValue().get(0),
        actualSlot.getValueList().getValue().get(0));
  }

  @Test
  void testSlotList() {
    final SlotType1 actualSlot = SlotFactory.slot(slotName.getName(), List.of(value));
    assertEquals(excpextedSlot.getSlotType(), actualSlot.getSlotType());
    assertEquals(excpextedSlot.getName(), actualSlot.getName());
    assertEquals(
        excpextedSlot.getValueList().getValue().get(0),
        actualSlot.getValueList().getValue().get(0));
  }
}
