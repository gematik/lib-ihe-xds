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

import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.document.Document;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import de.gematik.epa.unit.util.MessageUtils;
import de.gematik.epa.unit.util.ResourceLoader;
import java.util.List;
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

  @Test
  void toProvideAndRegisterDocumentSetRequestWithEnableDocumentReuseTest() {
    // Create a document with enableDocumentReuse = true
    var documentMetadata =
        new DocumentMetadata(
            null, // author
            null, // availabilityStatus
            null, // confidentialityCode
            null, // classCode
            null, // comments
            null, // creationTime
            null, // entryUUID
            null, // eventCodeList
            null, // formatCode
            null, // hash
            null, // healthcareFacilityTypeCode
            "de-DE", // languageCode
            null, // legalAuthenticator
            "application/pdf", // mimeType
            null, // practiceSettingCode
            null, // referenceIdList
            null, // serviceStartTime
            null, // serviceStopTime
            null, // size
            "Test Document", // title
            null, // typeCode
            "2.25.12345", // uniqueId
            null, // uri
            null, // repositoryUniqueId
            null, // homeCommunityId
            null, // patientId
            null); // sourcePatientId

    var document = new Document(new byte[] {0x01, 0x02}, documentMetadata, null);

    var submissionSetMetadata =
        new SubmissionSetMetadata(
            List.of(), null, // contentTypeCode
            null, // title
            null, // comments
            null, // intendedRecipient
            null); // uniqueId

    var insurantId = MessageUtils.createInsurantId();

    var request =
        new DocumentSubmissionRequest(insurantId, List.of(document), submissionSetMetadata, true);

    var testResult = ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(request);

    assertNotNull(testResult);
    assertNotNull(testResult.getSubmitObjectsRequest());
    assertNotNull(testResult.getSubmitObjectsRequest().getRequestSlotList());

    var requestSlotList = testResult.getSubmitObjectsRequest().getRequestSlotList();
    assertEquals(1, requestSlotList.getSlot().size());

    var enableDocumentReuseSlot = requestSlotList.getSlot().getFirst();
    assertEquals(SlotName.ENABLE_DOCUMENT_REUSE.getName(), enableDocumentReuseSlot.getName());
    assertEquals("true", enableDocumentReuseSlot.getValueList().getValue().getFirst());
  }

  @Test
  void toProvideAndRegisterDocumentSetRequestWithoutEnableDocumentReuseTest() {
    var testdata =
        ResourceLoader.documentSubmissionRequest(
            ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    var testResult = ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(testdata);

    assertNotNull(testResult);
    assertNull(
        testResult.getSubmitObjectsRequest().getRequestSlotList(),
        "RequestSlotList should be null when no document has enableDocumentReuse=true");
  }
}
