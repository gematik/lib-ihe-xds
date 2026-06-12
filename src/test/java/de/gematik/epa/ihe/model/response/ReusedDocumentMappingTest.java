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
package de.gematik.epa.ihe.model.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ReusedDocumentMappingTest {

  @Test
  void testConstructorWithNullValues() {
    ReusedDocumentMapping mapping = new ReusedDocumentMapping(null, null);
    assertEquals("null|null", mapping.toSlotValue());
  }

  @ParameterizedTest
  @CsvSource({
    "newUniqueId|oldUniqueId, newUniqueId, oldUniqueId",
    "1.2.3.4.5.6|1.2.3.4.5.7, 1.2.3.4.5.6, 1.2.3.4.5.7"
  })
  void testFromSlotValueWithValidInput(String slotValue, String expectedNew, String expectedOld) {
    ReusedDocumentMapping mapping = ReusedDocumentMapping.fromSlotValue(slotValue);

    assertNotNull(mapping);
    assertEquals(expectedNew, mapping.newUniqueId());
    assertEquals(expectedOld, mapping.oldUniqueId());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"noSeparatorHere", "|", "newId|", "|oldId"})
  void testFromSlotValueWithInvalidInput(String slotValue) {
    ReusedDocumentMapping mapping = ReusedDocumentMapping.fromSlotValue(slotValue);
    assertNull(mapping);
  }

  @Test
  void testFromSlotValueWithMultipleSeparators() {
    // Should only split on first separator
    String slotValue = "part1|part2|part3";

    ReusedDocumentMapping mapping = ReusedDocumentMapping.fromSlotValue(slotValue);

    assertNotNull(mapping);
    assertEquals("part1", mapping.newUniqueId());
    assertEquals("part2|part3", mapping.oldUniqueId());
  }

  @Test
  void testToSlotValue() {
    ReusedDocumentMapping mapping = new ReusedDocumentMapping("newId", "existingId");

    String slotValue = mapping.toSlotValue();

    assertEquals("newId|existingId", slotValue);
  }

  @Test
  void testRoundTrip() {
    String originalSlotValue = "newUniqueId|oldUniqueId";

    ReusedDocumentMapping mapping = ReusedDocumentMapping.fromSlotValue(originalSlotValue);
    assertNotNull(mapping);

    String reconstructedSlotValue = mapping.toSlotValue();

    assertEquals(originalSlotValue, reconstructedSlotValue);
  }

  @Test
  void testSeparatorConstant() {
    assertEquals("|", ReusedDocumentMapping.SEPARATOR);
  }
}
