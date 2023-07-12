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

package de.gematik.epa.conversion.internal.requests;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.ihe.model.document.Document;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.ihe.model.simple.ByteArray;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.unit.util.ResourceLoader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DocumentGeneratorTest {

  DocumentSubmissionRequest request =
      ResourceLoader.documentSubmissionRequest(
          ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

  @Test
  void generatorsTest() {
    var documents = documents();
    var recordIdentifier = request.recordIdentifier();
    var result =
        assertDoesNotThrow(() -> DocumentGenerator.generators(documents, recordIdentifier));

    assertNotNull(result);
    assertEquals(documents.size(), result.size());
  }

  @Test
  void generatorTest() {
    var document = request.documents().get(0);
    var result =
        assertDoesNotThrow(() -> DocumentGenerator.generator(document, request.recordIdentifier()));

    assertNotNull(result);
    assertEquals(document, result.document());
    assertEquals(request.recordIdentifier(), result.recordIdentifier());
  }

  @Test
  void idTest() {
    var replaceRequest =
        ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);
    DocumentGenerator docGenerator =
        DocumentGenerator.generator(
            replaceRequest.documents().get(0), replaceRequest.recordIdentifier());

    String id = assertDoesNotThrow(docGenerator::id);

    assertEquals(replaceRequest.documents().get(0).documentMetadata().entryUUID(), id);
    assertId(docGenerator);

    docGenerator =
        DocumentGenerator.generator(request.documents().get(0), request.recordIdentifier());
    id = assertDoesNotThrow(docGenerator::id);

    assertNotNull(id);
    assertId(docGenerator);
  }

  @Test
  void iheDocumentTest() {
    var docGenerator =
        DocumentGenerator.generator(request.documents().get(0), request.recordIdentifier());

    var result = assertDoesNotThrow(docGenerator::iheDocument);

    assertNotNull(result);
    assertArrayEquals(docGenerator.document().documentData().value(), result.getValue());
  }

  @Test
  void extrinsicObjectTest() {
    var docGenerator =
        DocumentGenerator.generator(request.documents().get(0), request.recordIdentifier());

    var result = assertDoesNotThrow(docGenerator::extrinsicObject);

    assertNotNull(result);
  }

  @Test
  void folderMetadataTest() {
    var replaceRequest =
        ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);

    var minimalRequest =
        new DocumentSubmissionRequest(
            request.recordIdentifier(), new ArrayList<>(), request.submissionSetMetadata());
    minimalRequest
        .documents()
        .add(
            new Document(
                ByteArray.of("blubs".getBytes()),
                replaceRequest.documents().get(0).documentMetadata(),
                null));

    DocumentGenerator docGenerator =
        DocumentGenerator.generator(request.documents().get(0), request.recordIdentifier());

    FolderMetadata folderMetadata = assertDoesNotThrow(docGenerator::folderMetadata);
    assertNotNull(folderMetadata);

    docGenerator =
        DocumentGenerator.generator(
            replaceRequest.documents().get(0), replaceRequest.recordIdentifier());

    folderMetadata = assertDoesNotThrow(docGenerator::folderMetadata);
    assertNull(folderMetadata);

    docGenerator =
        DocumentGenerator.generator(
            minimalRequest.documents().get(0), minimalRequest.recordIdentifier());

    folderMetadata = assertDoesNotThrow(docGenerator::folderMetadata);
    assertNull(folderMetadata);
  }

  @Test
  void idOfDocumentToReplaceTest() {
    var replaceRequest =
        ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);

    DocumentGenerator docGenerator =
        DocumentGenerator.generator(request.documents().get(0), request.recordIdentifier());

    String idToReplace = assertDoesNotThrow(docGenerator::idOfDocumentToReplace);
    assertNull(idToReplace);

    docGenerator =
        DocumentGenerator.generator(
            replaceRequest.documents().get(0), replaceRequest.recordIdentifier());

    idToReplace = assertDoesNotThrow(docGenerator::idOfDocumentToReplace);
    assertNotNull(idToReplace);
  }

  @Test
  void documentGeneratorListTest() {
    var documents = documents();
    var recordIdentifier = request.recordIdentifier();
    var docGeneratorList = DocumentGenerator.generators(documents, recordIdentifier);

    var iheDocuments = assertDoesNotThrow(docGeneratorList::iheDocuments);

    assertNotNull(iheDocuments);
    assertEquals(documents.size(), iheDocuments.size());

    var extrinsicObjects = assertDoesNotThrow(docGeneratorList::extrinsicObjects);

    assertNotNull(extrinsicObjects);
    assertEquals(documents.size(), extrinsicObjects.size());
  }

  private List<DocumentInterface> documents() {
    var req2 =
        ResourceLoader.documentSubmissionRequest(
            ResourceLoader.PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST);

    var result = new ArrayList<DocumentInterface>();
    result.addAll(request.documents());
    result.addAll(req2.documents());
    return result;
  }

  private void assertId(DocumentGenerator docGenerator) {
    assertEquals(docGenerator.id(), docGenerator.iheDocument().getId());
    assertEquals(docGenerator.id(), docGenerator.extrinsicObject().getId());
  }
}
