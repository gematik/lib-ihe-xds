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

import static de.gematik.epa.unit.util.ExternalIdentifierTestUtils.assertExternalIdentifiers;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getNodeRepresentationValueList;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import org.junit.jupiter.api.Test;

class ProvideAndRegisterUtilsCreateFolderTest extends AbstractRegistryObjectTest {

  private static final String REGISTRY_PACKAGE = "RegistryPackage";

  @Test
  // Test basiert auf xml Datei mit vollständigen Daten
  void createFolderObjectsWithAllAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    var folderMetadata = documentGenerators.get(0).folderMetadata();

    final List<JAXBElement<? extends RegistryObjectType>> folderAndAssociations =
        ProvideAndRegisterUtils.createFolderRegistryPackagesAndAssociations(
            documentSubmissionRequest, documentGenerators);

    final List<JAXBElement<? extends RegistryObjectType>> folders =
        filter(folderAndAssociations, REGISTRY_PACKAGE);

    folders.forEach(f -> assertHomeCommunityId(f.getValue(), documentSubmissionRequest));
    folders.forEach(f -> assertStatus(f.getValue()));
    folders.forEach(f -> assertName(f.getValue(), folderMetadata.title()));
    folders.forEach(f -> assertDescription(f.getValue(), folderMetadata.comments()));
    folders.forEach(f -> assertClassifications(f.getValue()));
    folders.forEach(
        f ->
            assertExternalIdentifiers(
                f.getValue(),
                documentSubmissionRequest,
                ExternalIdentifierScheme.FOLDER_PATIENT.getName(),
                ExternalIdentifierScheme.FOLDER_UNIQUE.getName()));
  }

  @Test
  // Test basiert auf xml Datei von Iryna
  void createFolderWithoutAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST);
    final List<JAXBElement<? extends RegistryObjectType>> folderAndAssociations =
        ProvideAndRegisterUtils.createFolderRegistryPackagesAndAssociations(
            documentSubmissionRequest, documentGenerators);

    final List<JAXBElement<? extends RegistryObjectType>> folders =
        filter(folderAndAssociations, REGISTRY_PACKAGE);

    assertEquals(1, folders.size());
    final RegistryObjectType value = folders.get(0).getValue();

    assertNull(value.getName());
    assertHomeCommunityId(value, documentSubmissionRequest);
    assertNull(value.getStatus());
    // this folder classification is alsways there
    assertEquals(1, value.getClassification().size());
    assertExternalIdentifiers(
        value,
        documentSubmissionRequest,
        ExternalIdentifierScheme.FOLDER_PATIENT.getName(),
        ExternalIdentifierScheme.FOLDER_UNIQUE.getName());
    assertNull(value.getDescription());
  }

  private void assertClassifications(RegistryObjectType registryObjectType) {
    final FolderMetadata folderMetadata = documentGenerators.get(0).folderMetadata();
    final List<String> expectedCodeList = folderMetadata.codeList();
    List<String> actual =
        getNodeRepresentationValueList(
            registryObjectType, ClassificationScheme.FOLDER_LIST.getUrn());
    assertNotNull(actual);
    assertIterableEquals(expectedCodeList, actual);
  }

  private void assertStatus(RegistryObjectType registryObjectType) {
    String status = registryObjectType.getStatus();
    final FolderMetadata folderMetadata = documentGenerators.get(0).folderMetadata();
    assertEquals(folderMetadata.availabilityStatus(), status);
  }
}
