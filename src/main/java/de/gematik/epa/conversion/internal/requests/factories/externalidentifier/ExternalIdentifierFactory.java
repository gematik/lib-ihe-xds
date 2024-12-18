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

package de.gematik.epa.conversion.internal.requests.factories.externalidentifier;

import de.gematik.epa.conversion.internal.requests.factories.OasisObjectType;
import de.gematik.epa.conversion.internal.requests.factories.UniqueIdFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.InternationalStringGenerator;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.ihe.model.simple.InsurantId;
import java.util.Optional;
import java.util.UUID;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExternalIdentifierType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

public class ExternalIdentifierFactory {
  private ExternalIdentifierFactory() {}

  public static void forDocumentEntry(
      ExtrinsicObjectType extrinsicObject,
      DocumentInterface originalDocument,
      InsurantId insurantId) {
    createPatientId(extrinsicObject, insurantId, ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT);
    createUniqueId(
        extrinsicObject,
        originalDocument.documentMetadata().uniqueId(),
        ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE);
  }

  public static void forDocumentEntryRMU(
      ExtrinsicObjectType extrinsicObject,
      DocumentInterface originalDocument,
      InsurantId insurantId) {
    if (originalDocument.documentMetadata().patientId() != null) {
      createPatientId(extrinsicObject, insurantId, ExternalIdentifierScheme.DOCUMENT_ENTRY_PATIENT);
    }
    if (originalDocument.documentMetadata().uniqueId() != null) {
      createUniqueId(
          extrinsicObject,
          originalDocument.documentMetadata().uniqueId(),
          ExternalIdentifierScheme.DOCUMENT_ENTRY_UNIQUE);
    }
  }

  public static void forSubmissionSet(RegistryPackageType registryPackage, InsurantId insurantId) {
    createPatientId(registryPackage, insurantId, ExternalIdentifierScheme.SUBMISSION_SET_PATIENT);
    createUniqueId(
        registryPackage,
        UniqueIdFactory.createOID(),
        ExternalIdentifierScheme.SUBMISSION_SET_UNIQUE);
  }

  public static void forFolder(
      RegistryPackageType registryPackage, FolderMetadata folderMetadata, InsurantId insurantId) {
    createPatientId(registryPackage, insurantId, ExternalIdentifierScheme.FOLDER_PATIENT);
    createUniqueId(
        registryPackage, folderMetadata.uniqueId(), ExternalIdentifierScheme.FOLDER_UNIQUE);
  }

  // region private

  private static void createPatientId(
      RegistryObjectType registryObject, InsurantId insurantId, ExternalIdentifierScheme scheme) {
    ExternalIdentifierType externalIdentifierType = create(registryObject, scheme);
    externalIdentifierType.setValue(insurantId.getPatientIdValue());
  }

  private static void createUniqueId(
      RegistryObjectType registryObject, String uniqueId, ExternalIdentifierScheme scheme) {
    var externalIdentifier = create(registryObject, scheme);
    externalIdentifier.setValue(Optional.ofNullable(uniqueId).orElse(UniqueIdFactory.createOID()));
  }

  private static ExternalIdentifierType create(
      RegistryObjectType registryObject, ExternalIdentifierScheme scheme) {
    var externalIdentifier = new ExternalIdentifierType();
    externalIdentifier.setRegistryObject(registryObject.getId());
    externalIdentifier.setObjectType(OasisObjectType.EXTERNAL_IDENTIFIER.getValue());
    externalIdentifier.setId(UUID.randomUUID().toString());
    externalIdentifier.setIdentificationScheme(scheme.getId());
    externalIdentifier.setName(
        InternationalStringGenerator.generateInternationalString(scheme.getName()));
    registryObject.getExternalIdentifier().add(externalIdentifier);
    return externalIdentifier;
  }

  // endregion private
}
