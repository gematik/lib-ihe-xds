/*-
 * #%L
 * lib-ihe-xds
 * %%
 * Copyright (C) 2023 - 2026 gematik GmbH
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
package de.gematik.epa.conversion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.gematik.epa.ihe.model.request.RetrieveDocumentsRequest;
import de.gematik.epa.unit.util.ResourceLoader;
import ihe.iti.xds_b._2007.RetrieveDocumentSetRequestType;
import org.junit.jupiter.api.Test;

class RetrieveDocumentsUtilsTest {

  @Test
  void toRetrieveDocumentSetRequestTest() {
    RetrieveDocumentsRequest libRequest =
        ResourceLoader.retrieveDocumentsRequest(ResourceLoader.RETRIEVE_DOCUMENTS_REQUEST_PATH);

    var iheRequest =
        assertDoesNotThrow(() -> RetrieveDocumentsUtils.toRetrieveDocumentSetRequest(libRequest));

    assertNotNull(iheRequest);

    assertTrue(
        iheRequest.getDocumentRequest().stream()
            .map(RetrieveDocumentSetRequestType.DocumentRequest::getRepositoryUniqueId)
            .allMatch(ruid -> ruid.equals(libRequest.repositoryUniqueId())));
    assertArrayEquals(
        libRequest.documentUniqueIds().toArray(),
        iheRequest.getDocumentRequest().stream()
            .map(RetrieveDocumentSetRequestType.DocumentRequest::getDocumentUniqueId)
            .toArray());
  }
}
