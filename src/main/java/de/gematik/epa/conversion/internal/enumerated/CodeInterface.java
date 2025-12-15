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

import java.util.Arrays;
import java.util.Objects;
import lombok.NonNull;

public interface CodeInterface {

  String getValue();

  String getCodingScheme();

  String getName();

  static <T extends CodeInterface> T fromValue(String value, @NonNull Class<T> enumClass) {
    var enumValue = enumClass.getEnumConstants();
    return Arrays.stream(enumValue)
        .filter(code -> code.getValue().equals(value))
        .findFirst()
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "Unknown value for "
                        + enumClass.getSimpleName()
                        + " "
                        + Objects.requireNonNullElse(value, "null")));
  }
}
