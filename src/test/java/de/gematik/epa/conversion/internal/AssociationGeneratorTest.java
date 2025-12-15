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
package de.gematik.epa.conversion.internal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.unit.util.ResourceLoader;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssociationGeneratorTest {
  private static final String ASSOCIATION_TYPE_HAS_MEMBER =
      "urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember";

  @Test
  void createDocumentReplaceAssociationsTest() {
    var request = ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);
    var docGenerators = DocumentGenerator.generators(request.documents(), request.insurantId());

    var associations =
        Assertions.assertDoesNotThrow(
            () -> AssociationGenerator.createDocumentReplaceAssociations(docGenerators));

    assertNotNull(associations);
    assertEquals(docGenerators.size(), associations.size());
    assertArrayEquals(
        docGenerators.stream().map(DocumentGenerator::idOfDocumentToReplace).toArray(),
        associations.stream().map(AssociationType1::getTargetObject).toArray());
  }

  @Test
  void createRMUAssociationTest() {
    String targetId = "targetId";
    var association =
        Assertions.assertDoesNotThrow(
            () -> AssociationGenerator.createNewMemberUpdateDocumentAssociation(targetId));

    assertNotNull(association);
    assertEquals(ASSOCIATION_TYPE_HAS_MEMBER, association.getAssociationType());
    assertFalse(association.getSlot().isEmpty());
    assertEquals(3, association.getSlot().size());
    assertEquals(targetId, association.getTargetObject());
  }
}
