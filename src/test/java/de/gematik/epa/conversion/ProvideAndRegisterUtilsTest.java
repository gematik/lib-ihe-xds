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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.ihe.model.document.Document;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.unit.util.ResourceLoader;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class ProvideAndRegisterUtilsTest {
  @Test
  void toProvideAndRegisterDocumentSetRequestTest() {
    var testdata =
        ResourceLoader.documentSubmissionRequest(
            ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    var testResult = ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(testdata);

    assertNotNull(testResult);
    assertEquals(testdata.documents().size(), testResult.getDocument().size());
    assertNotNull(testResult.getSubmitObjectsRequest());
    assertNotNull(testResult.getSubmitObjectsRequest().getRegistryObjectList());

    assertNull(testResult.getSubmitObjectsRequest().getRequestSlotList());

    var registryObjectList = testResult.getSubmitObjectsRequest().getRegistryObjectList();
    // +1 for the SubmissionSet RegistryPackage
    //   this will need further modification, once folder and associations are added to the request
    assertEquals(
        calculateNumberOfRegistryObjects(testdata), registryObjectList.getIdentifiable().size());
  }

  private long calculateNumberOfRegistryObjects(DocumentSubmissionRequest testdata) {
    long result = 0;

    // Number of ExtrinsicObjects
    result += testdata.documents().size();

    var folder =
        testdata.documents().stream()
            .map(Document::folderMetadata)
            .filter(Objects::nonNull)
            .toList();

    // Number of Folder RegistryPackages
    result +=
        folder.stream()
            .filter(folderMetadata -> Objects.isNull(folderMetadata.entryUUID()))
            .count();

    // Number of Document to Folder Associations
    result += folder.size();

    // Number of any RegistryObject to SubmissionSet Associations
    result *= 2;

    // One SubmissionSet RegistryPackage
    result += 1;

    return result;
  }
}
