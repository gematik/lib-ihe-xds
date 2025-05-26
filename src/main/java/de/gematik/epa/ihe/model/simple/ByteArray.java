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
package de.gematik.epa.ihe.model.simple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;
import lombok.NonNull;

/**
 * Only purpose of this class is to avoid the Sonar bug, about the need to override {@code
 * hashCode()}, {@code equals()} and {@code toString()}, if a record contains a {@code byte[]}.<br>
 * So the idea is, whenever a record shall contain a {@code byte[]}, use this class instead.
 */
public final class ByteArray {

  private final byte[] value;

  private ByteArray(@NonNull byte[] input) {
    value = Arrays.copyOf(input, input.length);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (Objects.isNull(obj)) return false;
    if (obj instanceof ByteArray objByteArray) {
      return Arrays.equals(value, objByteArray.value());
    }
    return false;
  }

  @Override
  public String toString() {
    return Arrays.toString(value);
  }

  @JsonValue
  public byte[] value() {
    return Arrays.copyOf(value, value.length);
  }

  @JsonCreator
  public static ByteArray of(byte[] value) {
    return new ByteArray(value);
  }
}
