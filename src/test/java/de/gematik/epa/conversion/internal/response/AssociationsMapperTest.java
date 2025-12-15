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
package de.gematik.epa.conversion.internal.response;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssociationsMapperTest {

  private final String expectedUUID = "urn:uuid:125a34ff-fdff-4abf-8d8e-386a73e16dbd";
  private AssociationType1 association;

  @BeforeEach
  void setUp() {
    association = new AssociationType1();
  }

  @Test
  void associationId() {
    association.setId(expectedUUID);
    final String actual = assertDoesNotThrow(() -> AssociationsMapper.associationId(association));
    assertFalse(actual.isEmpty());
    assertEquals(expectedUUID, actual);
  }

  @Test
  void associationType() {
    final String expected = "urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember";
    association.setAssociationType(expected);
    final String actual = assertDoesNotThrow(() -> AssociationsMapper.associationType(association));
    assertFalse(actual.isEmpty());
    assertEquals(expected, actual);
  }

  @Test
  void sourceObject() {
    association.setSourceObject(expectedUUID);
    final String actual = assertDoesNotThrow(() -> AssociationsMapper.sourceObject(association));
    assertFalse(actual.isEmpty());
    assertEquals(expectedUUID, actual);
  }

  @Test
  void targetObject() {
    association.setTargetObject(expectedUUID);
    final String actual = assertDoesNotThrow(() -> AssociationsMapper.targetObject(association));
    assertFalse(actual.isEmpty());
    assertEquals(expectedUUID, actual);
  }
}
