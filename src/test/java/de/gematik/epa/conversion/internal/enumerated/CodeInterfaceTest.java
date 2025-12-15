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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class CodeInterfaceTest {

  @Test
  @SuppressWarnings("ConstantConditions")
  void testConfidentialityCodeValueNotNull() {
    assertThrows(
        NullPointerException.class,
        () -> ConfidentialityCode.fromValue(null),
        "Expected NullPointerException when value is null");
  }

  @ParameterizedTest
  @EnumSource(ConfidentialityCode.class)
  void testConfidentialityCodeFromValue(ConfidentialityCode input) {
    String value = input.getValue();
    Class<ConfidentialityCode> enumClass = ConfidentialityCode.class;

    ConfidentialityCode expected =
        switch (value) {
          case "N" -> ConfidentialityCode.NORMAL;
          case "R" -> ConfidentialityCode.RESTRICTED;
          case "V" -> ConfidentialityCode.VERY_RESTRICTED;
          case "CON" -> ConfidentialityCode.CON;
          default -> null;
        };
    ConfidentialityCode actual = CodeInterface.fromValue(value, enumClass);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("invalidInputs")
  void testConfidentialityCodeFromValueWithInvalidInput(String input) {
    var exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CodeInterface.fromValue(input, ConfidentialityCode.class));
    String expectedMessage =
        "Unknown value for "
            + ConfidentialityCode.class.getSimpleName()
            + " "
            + Objects.requireNonNullElse(input, "null");
    assertEquals(expectedMessage, exception.getMessage());
  }

  static Collection<String> invalidInputs() {
    return Arrays.asList("H2", null, "");
  }
}
