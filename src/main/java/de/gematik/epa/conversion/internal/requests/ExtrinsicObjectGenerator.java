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
package de.gematik.epa.conversion.internal.requests;

import de.gematik.epa.conversion.internal.requests.factories.RegistryObjectFactory;
import de.gematik.epa.conversion.internal.requests.factories.classification.ExtrinsicObjectClassificationFactory;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.ExtrinsicObjectSlotFactory;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.document.ObjectType;
import de.gematik.epa.ihe.model.simple.InsurantId;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;

public class ExtrinsicObjectGenerator {

  private ExtrinsicObjectGenerator() {}

  public static void fillCommonExtrinsicObject(
      ExtrinsicObjectType extrinsicObject, DocumentInterface document) {
    extrinsicObject.setMimeType(document.documentMetadata().mimeType());
    extrinsicObject.setIsOpaque(false);
    extrinsicObject.setObjectType(ObjectType.DOCUMENT_ENTRY.getId());

    RegistryObjectFactory.setName(extrinsicObject, document.documentMetadata().title());
    RegistryObjectFactory.setDescription(extrinsicObject, document.documentMetadata().comments());

    ExtrinsicObjectSlotFactory.createSlotTypes(extrinsicObject, document);
    ExtrinsicObjectClassificationFactory.createClassifications(extrinsicObject, document);
  }

  public static void fillExtrinsicObject(
      ExtrinsicObjectType extrinsicObject, DocumentInterface document, InsurantId insurantId) {
    fillCommonExtrinsicObject(extrinsicObject, document);
    ExternalIdentifierFactory.forDocumentEntry(extrinsicObject, document, insurantId);
  }

  public static ExtrinsicObjectType createExtrinsicObject(
      DocumentInterface document, String documentId, InsurantId insurantId) {
    var extrinsicObject = toExtrinsicObject(documentId);
    fillExtrinsicObject(extrinsicObject, document, insurantId);
    return extrinsicObject;
  }

  public static ExtrinsicObjectType createExtrinsicObjectRMU(
      DocumentInterface document, String documentId, InsurantId insurantId) {
    var extrinsicObject = toExtrinsicObject(documentId);
    fillExtrinsicObjectRMU(extrinsicObject, document, insurantId);
    return extrinsicObject;
  }

  public static void fillExtrinsicObjectRMU(
      ExtrinsicObjectType extrinsicObject, DocumentInterface document, InsurantId insurantId) {
    fillCommonExtrinsicObject(extrinsicObject, document);
    ExternalIdentifierFactory.forDocumentEntryRMU(extrinsicObject, document, insurantId);
  }

  public static ExtrinsicObjectType toExtrinsicObject(String documentId) {
    var extrinsicObject = new ExtrinsicObjectType();
    extrinsicObject.setId(documentId);
    return extrinsicObject;
  }

  public static List<JAXBElement<ExtrinsicObjectType>> toJaxbElements(
      List<ExtrinsicObjectType> extrinsicObjects) {
    var objectFactory = new oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectFactory();
    return extrinsicObjects.stream().map(objectFactory::createExtrinsicObject).toList();
  }
}
