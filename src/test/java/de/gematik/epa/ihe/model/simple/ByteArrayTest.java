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

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ByteArrayTest {

  @Test
  void byteArrayTest() {
    byte[] value = "My test byte array".getBytes(StandardCharsets.UTF_8);

    var result = assertDoesNotThrow(() -> ByteArray.of(value));

    assertNotNull(result);

    assertArrayEquals(value, result.value());
    assertEquals(Arrays.hashCode(value), result.hashCode());
    assertEquals(Arrays.toString(value), result.toString());
    assertEquals(result, ByteArray.of(value));
  }
}
