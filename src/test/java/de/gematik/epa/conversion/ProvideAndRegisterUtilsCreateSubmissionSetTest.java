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

import static de.gematik.epa.unit.util.AuthorToSlotTestUtils.assertAuthor;
import static de.gematik.epa.unit.util.ExternalIdentifierTestUtils.assertExternalIdentifiers;
import static de.gematik.epa.unit.util.ResourceLoader.PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST;
import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.conversion.internal.AssociationGenerator;
import de.gematik.epa.conversion.internal.requests.factories.OasisObjectType;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.document.ReplaceDocument;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import de.gematik.epa.unit.util.ResourceLoader;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType.Document;
import jakarta.xml.bind.JAXBElement;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;
import org.junit.jupiter.api.Test;

class ProvideAndRegisterUtilsCreateSubmissionSetTest {

  DocumentSubmissionRequest documentSubmissionRequest;

  @Test
  // Test basiert auf xml Datei von Iryna
  void createSubmissionSetWithAllAttributes() {
    documentSubmissionRequest =
        ResourceLoader.documentSubmissionRequest(PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST);

    final RegistryPackageType submissionSet =
        ProvideAndRegisterUtils.createSubmissionSetRegistryPackage(documentSubmissionRequest);

    assertEquals(submissionSet.getObjectType(), OasisObjectType.REGISTRY_PACKAGE.getValue());
    assertEquals(1, submissionSet.getSlot().size());
    assertEquals(submissionSet.getSlot().get(0).getName(), SlotName.SUBMISSION_TIME.getName());
    // in beispiel xml befinden sich derzeit 3, aber die Classification
    // mit representationNode wird jetzt nicht mehr benötigt, daher nicht gesetzt
    assertEquals(2, submissionSet.getClassification().size());
    assertEquals(2, submissionSet.getExternalIdentifier().size());

    final SubmissionSetMetadata submissionSetMetadata =
        documentSubmissionRequest.submissionSetMetadata();

    int expectedNumberOfAuthors = 1;
    assertAuthor(
        submissionSet,
        submissionSetMetadata.authors().get(0),
        ClassificationScheme.SUBMISSION_SET_AUTHOR.getUrn(),
        expectedNumberOfAuthors);
    assertExternalIdentifiers(
        submissionSet,
        documentSubmissionRequest,
        ExternalIdentifierScheme.SUBMISSION_SET_PATIENT.getName(),
        ExternalIdentifierScheme.SUBMISSION_SET_UNIQUE.getName());
  }

  @Test
  void createSubmissionSetWithDocumentReplaceTest() {
    var request = ResourceLoader.documentsReplaceRequest(ResourceLoader.REPLACE_DOCUMENTS_REQUEST);

    var result =
        assertDoesNotThrow(
            () -> ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(request));

    assertNotNull(result);
    assertEquals(request.documents().size(), result.getDocument().size());

    assertNotNull(result.getSubmitObjectsRequest());

    var replaceAssociations =
        result.getSubmitObjectsRequest().getRegistryObjectList().getIdentifiable().stream()
            .filter(jei -> AssociationType1.class.equals(jei.getDeclaredType()))
            .map(JAXBElement::getValue)
            .map(identifiable -> (AssociationType1) identifiable)
            .filter(
                asso ->
                    AssociationGenerator.ASSOCIATION_TYPE_REPLACE.equals(asso.getAssociationType()))
            .toList();

    assertEquals(request.documents().size(), replaceAssociations.size());
    assertArrayEquals(
        request.documents().stream().map(ReplaceDocument::entryUUIDOfDocumentToReplace).toArray(),
        replaceAssociations.stream().map(AssociationType1::getTargetObject).toArray());
    assertArrayEquals(
        result.getDocument().stream().map(Document::getId).toArray(),
        replaceAssociations.stream().map(AssociationType1::getSourceObject).toArray());
  }
}
