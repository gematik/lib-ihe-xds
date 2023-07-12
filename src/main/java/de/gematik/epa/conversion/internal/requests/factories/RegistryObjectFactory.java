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

package de.gematik.epa.conversion.internal.requests.factories;

import de.gematik.epa.conversion.internal.requests.factories.slot.InternationalStringGenerator;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;

@UtilityClass
public class RegistryObjectFactory {

  public static void setName(RegistryObjectType registryObject, String value) {
    Optional.ofNullable(value)
        .ifPresent(
            name ->
                registryObject.setName(
                    InternationalStringGenerator.generateInternationalString(name)));
  }

  public static void setDescription(RegistryObjectType registryObject, String value) {
    Optional.ofNullable(value)
        .ifPresent(
            description ->
                registryObject.setDescription(
                    InternationalStringGenerator.generateInternationalString(description)));
  }
}
