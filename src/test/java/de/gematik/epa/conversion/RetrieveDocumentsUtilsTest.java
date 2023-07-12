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

package de.gematik.epa.conversion;

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.unit.util.ResourceLoader;
import ihe.iti.xds_b._2007.RetrieveDocumentSetRequestType.DocumentRequest;
import org.junit.jupiter.api.Test;

class RetrieveDocumentsUtilsTest {

  @Test
  void toRetrieveDocumentSetRequestTest() {
    var libRequest =
        ResourceLoader.retrieveDocumentsRequest(ResourceLoader.RETRIEVE_DOCUMENTS_REQUEST_PATH);

    var iheRequest =
        assertDoesNotThrow(() -> RetrieveDocumentsUtils.toRetrieveDocumentSetRequest(libRequest));

    assertNotNull(iheRequest);
    assertTrue(
        iheRequest.getDocumentRequest().stream()
            .map(DocumentRequest::getHomeCommunityId)
            .allMatch(hcid -> hcid.equals(libRequest.homeCommunityId())));
    assertTrue(
        iheRequest.getDocumentRequest().stream()
            .map(DocumentRequest::getRepositoryUniqueId)
            .allMatch(ruid -> ruid.equals(libRequest.homeCommunityId())));
    assertArrayEquals(
        libRequest.documentUniqueIds().toArray(),
        iheRequest.getDocumentRequest().stream()
            .map(DocumentRequest::getDocumentUniqueId)
            .toArray());
  }
}
