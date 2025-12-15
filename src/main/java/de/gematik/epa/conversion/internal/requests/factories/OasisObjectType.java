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
package de.gematik.epa.conversion.internal.requests.factories;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OasisObjectType {
  CLASSIFICATION("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:Classification"),
  EXTERNAL_IDENTIFIER(
      "urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExternalIdentifier"),
  EXTRINSIC_OBJECT("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"),
  REGISTRY_PACKAGE("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:RegistryPackage");

  private final String value;
}
