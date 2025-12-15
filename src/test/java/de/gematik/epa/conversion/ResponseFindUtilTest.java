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
package de.gematik.epa.conversion;

import static de.gematik.epa.conversion.ResponseUtils.SUCCESS;
import static de.gematik.epa.conversion.internal.requests.factories.classification.RegistryPackageTypeClassificationFactory.createFolderIdClassification;
import static de.gematik.epa.conversion.internal.requests.factories.classification.RegistryPackageTypeClassificationFactory.createSubmissionSetIdClassification;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.conversion.internal.AssociationGenerator;
import de.gematik.epa.conversion.internal.enumerated.ClassCode;
import de.gematik.epa.conversion.internal.enumerated.TypeCode;
import de.gematik.epa.conversion.internal.requests.ExtrinsicObjectGenerator;
import de.gematik.epa.conversion.internal.requests.RegistryPackageGenerator;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.conversion.internal.response.RegistryObjectListUtils;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.response.ProxyFindResponse;
import de.gematik.epa.ihe.model.simple.Association;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotListType;
import org.junit.jupiter.api.Test;

class ResponseFindUtilTest extends RegistryObjectListUtils {

  private final String title = "Musterkind, Max 03.03.2017";
  private final String comments = "Beispiel eines Dokument von PS geschickt";
  private final List<String> codeList = List.of("childsrecord^^1.2.276.0.76.5.512");
  private final List<String> referenceIdList =
      List.of("1.2.3.12.78.23^^^&1.2.3.4&ISO^urn:ihe:iti:xds:2013:uniqueId");
  private final String uniqueId = "2.25.193805246743443392003";
  private final String entryUUID = "urn:uuid:b5b5a11b-56ff-4b9f-82ca-13ff85fe5197";
  private final String availabilityStatus = "urn:oasis:names:tc:ebxml-regrep:StatusType:Approved";
  private final String patientId = "X110417159^^^&amp;1.2.276.0.76.4.8&amp;ISO";
  private final String contentTypeCode = "8";
  private final String mimeType = "application/pdf";
  private final String languageCode = "de-DE";
  private final String uri = "Medikationsplan.xml";
  private final String associationType =
      "urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember";
  private final String sourceObject = "urn:uuid:125a34ff-fdff-4abf-8d8e-386a73e16dbd";
  private final String targetObject = "urn:uuid:275011e5-77ee-49f6-9c45-13b8cffdc726";
  private final String associationId = "urn:uuid:12407dd6-b219-46a0-9051-3b3c6c926a47";

  @Test
  void testSuccessResponse() {
    var registryResponseType = new AdhocQueryResponse();
    registryResponseType.setStatus(SUCCESS);
    registryResponseType.setResponseSlotList(new SlotListType());

    final ProxyFindResponse proxyResponse = ResponseUtils.toProxyFindResponse(registryResponseType);

    assertEquals(true, proxyResponse.success());
    assertEquals(SUCCESS, proxyResponse.statusMessage());
  }

  @Test
  void toProxyFindResponse() {

    var registryResponseType = new AdhocQueryResponse();
    registryResponseType.setStatus(SUCCESS);
    registryResponseType.setTotalResultCount(BigInteger.ONE);
    RegistryObjectListType registryObjectListType = new RegistryObjectListType();
    List<RegistryPackageType> registryPackages = new ArrayList<>();

    createFolder(registryPackages);
    createSubmissionSet(registryPackages);
    var documents = createDocuments();
    var associations = createAssociations();

    var jaxbElements = RegistryPackageGenerator.toRegistryPackageJaxbElements(registryPackages);
    var jaxbDocuments = ExtrinsicObjectGenerator.toJaxbElements(documents);
    var jaxbAssociations = AssociationGenerator.toAssociationJaxbElements(associations);
    registryObjectListType.getIdentifiable().addAll(jaxbElements);
    registryObjectListType.getIdentifiable().addAll(jaxbDocuments);
    registryObjectListType.getIdentifiable().addAll(jaxbAssociations);
    registryResponseType.setRegistryObjectList(registryObjectListType);

    final ProxyFindResponse proxyResponse =
        assertDoesNotThrow(() -> ResponseUtils.toProxyFindResponse(registryResponseType));
    assertProxyResponse(proxyResponse);
  }

  private void assertProxyResponse(ProxyFindResponse proxyResponse) {
    assertNotNull(proxyResponse);
    assertNotNull(proxyResponse.registryObjectLists());
    assertFolderMetadataList(proxyResponse);
    assertSubmissionSetList(proxyResponse);
    assertDocuments(proxyResponse);
    assertAssociationsList(proxyResponse);
  }

  private void assertAssociationsList(ProxyFindResponse proxyResponse) {
    final List<Association> associations = proxyResponse.registryObjectLists().associations();
    assertNotNull(associations);
    assertEquals(1, associations.size());

    final Association association = associations.get(0);
    assertEquals(associationId, association.id());
    assertEquals(associationType, association.associationType());
    assertEquals(sourceObject, association.sourceObject());
    assertEquals(targetObject, association.targetObject());
  }

  private void assertDocuments(ProxyFindResponse proxyResponse) {
    final List<DocumentMetadata> documentMetadataList =
        proxyResponse.registryObjectLists().documentsMetadata();
    assertEquals(1, documentMetadataList.size());

    final DocumentMetadata documentMetadata = documentMetadataList.get(0);
    assertEquals(mimeType, documentMetadata.mimeType());
    assertEquals(availabilityStatus, documentMetadata.availabilityStatus());
    assertEquals(entryUUID, documentMetadata.entryUUID());
    assertEquals(comments, documentMetadata.comments());
    assertEquals(title, documentMetadata.title());
    assertEquals(0, documentMetadata.author().size());
    assertEquals(0, documentMetadata.confidentialityCode().size());
    assertEquals(ClassCode.MEDIZINISCHER_AUSWEIS.getValue(), documentMetadata.classCode());
    assertEquals(TypeCode.AERZTLICHE_BESCHEINIGUNGEN.getValue(), documentMetadata.typeCode());
    assertNull(documentMetadata.practiceSettingCode());
    assertEquals(languageCode, documentMetadata.languageCode());
    assertEquals(uri, documentMetadata.uri());
    assertEquals(1, documentMetadata.referenceIdList().size());
    assertEquals(referenceIdList, documentMetadata.referenceIdList());
  }

  private void assertSubmissionSetList(ProxyFindResponse proxyResponse) {
    final List<SubmissionSetMetadata> submissionSetMetadataList =
        proxyResponse.registryObjectLists().submissionSetsMetadata();
    assertNotNull(submissionSetMetadataList);
    assertEquals(1, submissionSetMetadataList.size());

    final SubmissionSetMetadata submissionSetMetadata = submissionSetMetadataList.get(0);
    assertEquals(0, submissionSetMetadata.authors().size());
    assertEquals(contentTypeCode, submissionSetMetadata.contentTypeCode());
    assertNotNull(submissionSetMetadata.submissionTime());
    assertEquals(uniqueId, submissionSetMetadata.uniqueId());
    assertEquals(entryUUID, submissionSetMetadata.entryUUID());
    assertEquals(availabilityStatus, submissionSetMetadata.availabilityStatus());
  }

  private void assertFolderMetadataList(ProxyFindResponse proxyResponse) {
    final List<FolderMetadata> folderMetadataList =
        proxyResponse.registryObjectLists().foldersMetadata();
    assertNotNull(folderMetadataList);
    assertEquals(1, folderMetadataList.size());

    final FolderMetadata folderMetadata = folderMetadataList.get(0);
    assertEquals(comments, folderMetadata.comments());
    assertEquals(title, folderMetadata.title());
    assertEquals(1, folderMetadata.codeList().size());
    assertEquals(codeList, folderMetadata.codeList());
    assertEquals(uniqueId, folderMetadata.uniqueId());
    assertEquals(entryUUID, folderMetadata.entryUUID());
    assertEquals(availabilityStatus, folderMetadata.availabilityStatus());
  }

  private void createFolder(List<RegistryPackageType> registryPackages) {
    RegistryPackageType folderRegistryPackage = new RegistryPackageType();
    folderRegistryPackage.setStatus(availabilityStatus);
    folderRegistryPackage.setName(getInternationalStringType(title));
    folderRegistryPackage.setDescription(getInternationalStringType(comments));
    folderRegistryPackage.setId(entryUUID);
    createSlot(folderRegistryPackage, SlotName.LAST_UPDATE_TIME, "20230409084331");
    createClassification(folderRegistryPackage, ClassificationScheme.FOLDER_LIST, codeList.get(0));
    createFolderIdClassification(folderRegistryPackage);
    createExternalIdentifier(
        folderRegistryPackage, ExternalIdentifierScheme.FOLDER_UNIQUE, uniqueId);
    createExternalIdentifier(
        folderRegistryPackage, ExternalIdentifierScheme.FOLDER_PATIENT, patientId);

    registryPackages.add(folderRegistryPackage);
  }

  private void createSubmissionSet(List<RegistryPackageType> registryPackages) {
    RegistryPackageType submissionSet = new RegistryPackageType();
    submissionSet.setStatus(availabilityStatus);
    submissionSet.setId(entryUUID);
    createSlot(submissionSet, SlotName.SUBMISSION_TIME, "20230409084331");
    createClassification(
        submissionSet, ClassificationScheme.SUBMISSION_SET_CONTENT_TYPE, contentTypeCode);
    createSubmissionSetIdClassification(submissionSet);
    createExternalIdentifier(
        submissionSet, ExternalIdentifierScheme.SUBMISSION_SET_UNIQUE, uniqueId);
    createExternalIdentifier(
        submissionSet, ExternalIdentifierScheme.SUBMISSION_SET_PATIENT, patientId);

    registryPackages.add(submissionSet);
  }

  private List<AssociationType1> createAssociations() {
    List<AssociationType1> associations = new ArrayList<>();
    AssociationType1 associationType1 = new AssociationType1();
    associationType1.setId(associationId);
    associationType1.setAssociationType(associationType);
    associationType1.setSourceObject(sourceObject);
    associationType1.setTargetObject(targetObject);
    associations.add(associationType1);

    return associations;
  }

  private List<ExtrinsicObjectType> createDocuments() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    extrinsicObjectType.setMimeType(mimeType);
    extrinsicObjectType.setStatus(availabilityStatus);
    extrinsicObjectType.setId(entryUUID);
    extrinsicObjectType.setDescription(getInternationalStringType(comments));
    extrinsicObjectType.setName(getInternationalStringType(title));

    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_CLASS,
        ClassCode.MEDIZINISCHER_AUSWEIS.getValue());

    createClassification(
        extrinsicObjectType,
        ClassificationScheme.DOCUMENT_ENTRY_TYPE,
        TypeCode.AERZTLICHE_BESCHEINIGUNGEN.getValue());

    createSlot(extrinsicObjectType, SlotName.LANGUAGE_CODE, languageCode);
    createSlot(extrinsicObjectType, SlotName.URI, uri);
    createSlot(extrinsicObjectType, SlotName.REFERENCE_ID_LIST, referenceIdList.get(0));

    return List.of(extrinsicObjectType);
  }
}
