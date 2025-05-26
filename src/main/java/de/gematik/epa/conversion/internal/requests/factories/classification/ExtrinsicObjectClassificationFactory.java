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
package de.gematik.epa.conversion.internal.requests.factories.classification;

import de.gematik.epa.conversion.internal.enumerated.ClassCode;
import de.gematik.epa.conversion.internal.enumerated.CodeInterface;
import de.gematik.epa.conversion.internal.enumerated.ConfidentialityCode;
import de.gematik.epa.conversion.internal.enumerated.EventCode;
import de.gematik.epa.conversion.internal.enumerated.FormatCode;
import de.gematik.epa.conversion.internal.enumerated.HealthcareFacilityCode;
import de.gematik.epa.conversion.internal.enumerated.PracticeSettingCode;
import de.gematik.epa.conversion.internal.enumerated.TypeCode;
import de.gematik.epa.conversion.internal.requests.factories.OasisObjectType;
import de.gematik.epa.conversion.internal.requests.factories.slot.InternationalStringGenerator;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.ihe.model.Author;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;

public class ExtrinsicObjectClassificationFactory {

  private ExtrinsicObjectClassificationFactory() {}

  public static void createClassifications(
      ExtrinsicObjectType extrinsicObject, DocumentInterface originalDocument) {
    var documentMetadata = originalDocument.documentMetadata();
    createClassCodeClassification(documentMetadata, extrinsicObject);
    createConfidentialityCodeClassification(documentMetadata, extrinsicObject);
    createEventCodeClassification(documentMetadata, extrinsicObject);
    createFormatCodeClassification(documentMetadata, extrinsicObject);
    createHealthcareFacilityCodeClassification(documentMetadata, extrinsicObject);
    createPracticeSettingCodeClassification(documentMetadata, extrinsicObject);
    createTypeCodeClassification(documentMetadata, extrinsicObject);
    createAuthorsClassification(extrinsicObject, documentMetadata);
  }

  private static void createAuthorsClassification(
      ExtrinsicObjectType extrinsicObject, DocumentMetadata documentMetadata) {
    if (documentMetadata.author() != null) {
      documentMetadata
          .author()
          .forEach(author -> createAuthorClassification(author, extrinsicObject));
    }
  }

  private static void createAuthorClassification(
      Author author, ExtrinsicObjectType extrinsicObject) {
    SharedClassificationFactory.createAuthorClassification(
        author, extrinsicObject, ClassificationScheme.DOCUMENT_ENTRY_AUTHOR);
  }

  private static void createClassCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.classCode())
        .ifPresent(
            classCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_CLASS,
                            ClassCode.fromValue(classCode))));
  }

  private static void createTypeCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.typeCode())
        .ifPresent(
            typeCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_TYPE,
                            TypeCode.fromValue(typeCode))));
  }

  private static void createPracticeSettingCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.practiceSettingCode())
        .ifPresent(
            practiceSettingCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_PRACTICE_SETTING,
                            PracticeSettingCode.fromValue(practiceSettingCode))));
  }

  private static void createHealthcareFacilityCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.healthcareFacilityTypeCode())
        .ifPresent(
            healthcareFacilityCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_HEALTHCARE_FACILITY,
                            HealthcareFacilityCode.fromValue(healthcareFacilityCode))));
  }

  private static void createFormatCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.formatCode())
        .ifPresent(
            formatCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_FORMAT,
                            FormatCode.fromValue(formatCode))));
  }

  private static void createConfidentialityCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.confidentialityCode()).stream()
        .flatMap(Collection::stream)
        .forEach(
            confidentialityCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_CONFIDENTIALITY,
                            ConfidentialityCode.fromValue(confidentialityCode))));
  }

  private static void createEventCodeClassification(
      DocumentMetadata documentMetadata, ExtrinsicObjectType extrinsicObject) {
    Optional.ofNullable(documentMetadata.eventCodeList()).stream()
        .flatMap(Collection::stream)
        .forEach(
            eventCode ->
                extrinsicObject
                    .getClassification()
                    .add(
                        createExtrinsicObjectCodeClassification(
                            extrinsicObject,
                            ClassificationScheme.DOCUMENT_ENTRY_EVENT,
                            EventCode.fromValue(eventCode))));
  }

  private static ClassificationType createExtrinsicObjectCodeClassification(
      ExtrinsicObjectType extrinsicObject,
      ClassificationScheme classificationScheme,
      CodeInterface code) {
    var classification = new ClassificationType();
    classification.setId(UUID.randomUUID().toString());

    classification.setObjectType(OasisObjectType.CLASSIFICATION.getValue());
    classification.setClassifiedObject(extrinsicObject.getId());

    classification.setClassificationScheme(classificationScheme.getUrn());
    classification.setNodeRepresentation(code.getValue());

    classification.getSlot().add(SlotFactory.slot("codingScheme", code.getCodingScheme()));
    classification.setName(
        InternationalStringGenerator.generateInternationalString(code.getName()));

    return classification;
  }
}
