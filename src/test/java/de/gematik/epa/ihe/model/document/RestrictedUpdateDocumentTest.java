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

package de.gematik.epa.ihe.model.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.ihe.model.simple.ByteArray;
import de.gematik.epa.unit.util.MetadataTestUtils;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class RestrictedUpdateDocumentTest extends MetadataTestUtils {

  @Test
  void testConstructorWithNullDocumentData() {
    DocumentMetadata documentMetadata = getDocumentMetadata();

    String entryUUIDOfDocumentToUpdate = "exampleEntryUUID";

    RestrictedUpdateDocument restrictedUpdateDocument =
        new RestrictedUpdateDocument(documentMetadata, entryUUIDOfDocumentToUpdate);

    assertNull(restrictedUpdateDocument.documentData());
    assertNotNull(restrictedUpdateDocument.documentMetadata());
    assertEquals(documentMetadata, restrictedUpdateDocument.documentMetadata());
    assertNotNull(restrictedUpdateDocument.entryUUIDOfDocumentToUpdate());
    assertEquals(
        entryUUIDOfDocumentToUpdate, restrictedUpdateDocument.entryUUIDOfDocumentToUpdate());
  }

  @Test
  void testConstructorWithNonNullDocumentData() {
    byte[] value = "My test byte array".getBytes(StandardCharsets.UTF_8);
    var documentData = ByteArray.of(value);

    DocumentMetadata documentMetadata = getDocumentMetadata();
    String entryUUIDOfDocumentToUpdate = "exampleEntryUUID";

    RestrictedUpdateDocument restrictedUpdateDocument =
        new RestrictedUpdateDocument(documentData, documentMetadata, entryUUIDOfDocumentToUpdate);

    assertNotNull(restrictedUpdateDocument.documentData());
    assertEquals(documentData, restrictedUpdateDocument.documentData());
    assertEquals(documentMetadata, restrictedUpdateDocument.documentMetadata());
    assertEquals(
        entryUUIDOfDocumentToUpdate, restrictedUpdateDocument.entryUUIDOfDocumentToUpdate());
  }
}
