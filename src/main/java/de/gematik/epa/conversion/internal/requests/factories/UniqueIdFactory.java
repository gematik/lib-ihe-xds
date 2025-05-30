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
package de.gematik.epa.conversion.internal.requests.factories;

import java.math.BigInteger;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UniqueIdFactory {

  public static final String OID_PREFIX = "2.25";

  public static String createUUIDWithoutPrefix() {
    return UUID.randomUUID().toString();
  }

  public static String createOID() {
    var hexString = createUUIDWithoutPrefix().replace("-", "");
    BigInteger decimalValue = new BigInteger(hexString.substring(15), 16);
    return OID_PREFIX + "." + decimalValue;
  }
}
