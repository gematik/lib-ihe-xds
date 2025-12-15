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
package de.gematik.epa.ihe.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.document.RestrictedUpdateDocument;
import de.gematik.epa.ihe.model.simple.InsurantId;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import de.gematik.epa.unit.util.MessageUtils;
import de.gematik.epa.unit.util.MetadataTestUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

class RestrictedUpdateDocumentRequestTest extends MetadataTestUtils {

  @Test
  void testConstructorRestrictedUpdateDocumentRequest() {
    DocumentMetadata documentMetadata = getDocumentMetadata();

    String entryUUIDOfDocumentToUpdate = "exampleEntryUUID";

    SubmissionSetMetadata submissionSetMetadata = getSubmissionSetMetadata();
    RestrictedUpdateDocument restrictedUpdateDocument =
        new RestrictedUpdateDocument(documentMetadata, entryUUIDOfDocumentToUpdate);
    List<RestrictedUpdateDocument> documents = List.of(restrictedUpdateDocument);
    InsurantId patientId = MessageUtils.createInsurantId();

    RestrictedUpdateDocumentRequest request =
        new RestrictedUpdateDocumentRequest(patientId, documents, submissionSetMetadata);

    assertNotNull(request);
    assertEquals(patientId, request.insurantId());
    assertEquals(documents, request.documents());
    assertEquals(submissionSetMetadata, request.submissionSetMetadata());
  }

  @Test
  void testDefaultConstructorAndGetters() {
    RestrictedUpdateDocumentRequest request = new RestrictedUpdateDocumentRequest();

    assertNull(request.documents());
    assertNull(request.insurantId());
    assertNull(request.submissionSetMetadata());
  }
}
