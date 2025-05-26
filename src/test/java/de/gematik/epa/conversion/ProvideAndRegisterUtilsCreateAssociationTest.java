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
 * For additional notes and disclaimer from gematik and in case of changes by gematik find details in the "Readme" file.
 * #L%
 */
package de.gematik.epa.conversion;

import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.xml.bind.JAXBElement;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import org.junit.jupiter.api.Test;

class ProvideAndRegisterUtilsCreateAssociationTest extends AbstractRegistryObjectTest {

  private static final String ASSOCIATION = "Association";
  private static final String FOLDER = "RegistryPackage";
  private static final String ASSOCIATION_TYPE_HAS_MEMBER =
      "urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember";

  private List<JAXBElement<? extends RegistryObjectType>> folder;
  private List<JAXBElement<? extends RegistryObjectType>> associations;

  @Test
  // Test basiert auf xml Datei mit vollständigen Daten
  void createAssociationsObjectsWithAllAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    // In this case there is only the association for folder - document
    // Other associations are created in another method
    createAssossiationsAndFolder();

    associations.forEach(f -> assertAssociationType((AssociationType1) f.getValue()));
    associations.forEach(
        f -> assertSourceObject((AssociationType1) f.getValue(), folder.get(0).getValue().getId()));
    associations.forEach(f -> assertTargetObject((AssociationType1) f.getValue()));
  }

  private void assertSourceObject(AssociationType1 value, String folderId) {
    assertEquals(value.getSourceObject(), folderId);
  }

  private void assertTargetObject(AssociationType1 value) {
    assertEquals(documentGenerators.get(0).id(), value.getTargetObject());
  }

  private void assertAssociationType(AssociationType1 value) {
    assertEquals(ASSOCIATION_TYPE_HAS_MEMBER, value.getAssociationType());
  }

  @Test
  // Test basiert auf xml Datei von Iryna - Folder/Document are empty but existent, so associations
  // are created
  void createFolderWithoutAttributes() {
    createSubmissionRequest(PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST);
    createAssossiationsAndFolder();

    assertEquals(1, associations.size());
    associations.forEach(f -> assertAssociationType((AssociationType1) f.getValue()));
    associations.forEach(
        f -> assertSourceObject((AssociationType1) f.getValue(), folder.get(0).getValue().getId()));
    associations.forEach(f -> assertTargetObject((AssociationType1) f.getValue()));
  }

  private void createAssossiationsAndFolder() {
    final List<JAXBElement<? extends RegistryObjectType>> folderAndAssociations =
        ProvideAndRegisterUtils.createFolderRegistryPackagesAndAssociations(
            documentSubmissionRequest, documentGenerators);

    associations = filter(folderAndAssociations, ASSOCIATION);
    folder = filter(folderAndAssociations, FOLDER);
  }
}
