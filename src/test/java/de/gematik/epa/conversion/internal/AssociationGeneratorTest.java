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

package de.gematik.epa.conversion.internal;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.unit.util.ResourceLoader;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import org.junit.jupiter.api.Test;

class AssociationGeneratorTest {

  @Test
  void createDocumentReplaceAssociationsTest() {
    var request = ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);
    var docGenerators =
        DocumentGenerator.generators(request.documents(), request.recordIdentifier());

    var associations =
        assertDoesNotThrow(
            () -> AssociationGenerator.createDocumentReplaceAssociations(docGenerators));

    assertNotNull(associations);
    assertEquals(docGenerators.size(), associations.size());
    assertArrayEquals(
        docGenerators.stream().map(DocumentGenerator::idOfDocumentToReplace).toArray(),
        associations.stream().map(AssociationType1::getTargetObject).toArray());
  }
}
