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
package de.gematik.epa.conversion.internal.factories;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.conversion.internal.requests.factories.UniqueIdFactory;
import org.junit.jupiter.api.Test;

class UniqueIdFactoryTest {

  @Test
  void createUUIDWithoutPrefix() {
    String result1 = UniqueIdFactory.createUUIDWithoutPrefix();
    String result2 = UniqueIdFactory.createUUIDWithoutPrefix();
    assertNotEquals(result1, result2);
  }

  @Test
  void createOID() {
    String result = UniqueIdFactory.createOID();
    assertFalse(result.isBlank());
    assertTrue(result.matches(UniqueIdFactory.OID_PREFIX + "([.]\\d+)+"));
  }
}
