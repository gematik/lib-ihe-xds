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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.unit.util.ResourceLoader;
import org.junit.jupiter.api.Test;

class RestrictedUpdateDocumentUtilsTest {
  @Test
  void toUpdateDocumentRequest() {
    var testdata =
        ResourceLoader.updateDocumentSetRequest(ResourceLoader.RESTRICTED_UPDATE_DOCUMENT_REQUEST);

    var testResult = RestrictedUpdateDocumentUtils.toUpdateDocumentSetRequest(testdata);
    assertNotNull(testResult);
    assertNull(testResult.getRequestSlotList());
    assertEquals(3, testResult.getRegistryObjectList().getIdentifiable().size());
    assertNotNull(testResult.getRegistryObjectList());
  }

  @Test
  void toUpdateDocumentDifferenceRequest() {
    var testdata =
        ResourceLoader.updateDocumentSetRequest(
            ResourceLoader.RESTRICTED_UPDATE_DOCUMENT_DIFFERENCE_REQUEST);

    var testResult = RestrictedUpdateDocumentUtils.toUpdateDocumentSetRequest(testdata);
    assertNotNull(testResult);
    assertNull(testResult.getRequestSlotList());
    assertEquals(3, testResult.getRegistryObjectList().getIdentifiable().size());
    assertNotNull(testResult.getRegistryObjectList());
  }

  @Test
  void toUpdateDocumentListRequest() {
    var testdata =
        ResourceLoader.updateDocumentSetRequest(
            ResourceLoader.RESTRICTED_UPDATE_DOCUMENT_LIST_REQUEST);

    var testResult = RestrictedUpdateDocumentUtils.toUpdateDocumentSetRequest(testdata);
    assertNull(testResult.getRequestSlotList());
    assertNotNull(testResult);
    assertEquals(5, testResult.getRegistryObjectList().getIdentifiable().size());
    assertNotNull(testResult.getRegistryObjectList());
  }
}
