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
package de.gematik.epa.conversion.internal.response;

import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.availabilityStatus;
import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.entryUUID;
import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.getCodeFromClassification;
import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.getLocalDateTime;
import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.toAuthor;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationNode;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import jakarta.xml.bind.JAXBElement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.IdentifiableType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

public class SubmissionSetMetadataMapper {

  private SubmissionSetMetadataMapper() {}

  public static List<SubmissionSetMetadata> mapSubmissionSetMetadata(
      AdhocQueryResponse adhocQueryResponse) {
    var registryObjectList = adhocQueryResponse.getRegistryObjectList();
    var submissionSetMetadata = new ArrayList<SubmissionSetMetadata>();

    if (registryObjectList != null) {
      fillSubmissionSetMetadataList(registryObjectList.getIdentifiable(), submissionSetMetadata);
    }
    return submissionSetMetadata.isEmpty() ? null : submissionSetMetadata;
  }

  private static void fillSubmissionSetMetadataList(
      List<JAXBElement<? extends IdentifiableType>> identifiable,
      List<SubmissionSetMetadata> submissionSetMetadataList) {
    var submissionSets =
        RegistryObjectListMapper.getRegistryPackageByClassification(
            identifiable, ClassificationNode.SUBMISSION_SET_ID_CLASSIFICATION);
    for (JAXBElement<? extends IdentifiableType> jaxbElement : submissionSets) {
      var registryPackage = (RegistryPackageType) jaxbElement.getValue();
      SubmissionSetMetadata submissionSetMetadata =
          new SubmissionSetMetadata(
              toAuthor(registryPackage, ClassificationScheme.SUBMISSION_SET_AUTHOR),
              contentTypeCode(registryPackage),
              submissionTime(registryPackage),
              availabilityStatus(registryPackage),
              uniqueId(registryPackage),
              entryUUID(registryPackage));
      submissionSetMetadataList.add(submissionSetMetadata);
    }
  }

  static String uniqueId(RegistryPackageType registryPackage) {
    return RegistryObjectListMapper.externalIdentifierValue(
        registryPackage, ExternalIdentifierScheme.SUBMISSION_SET_UNIQUE);
  }

  static LocalDateTime submissionTime(RegistryPackageType registryPackage) {
    return getLocalDateTime(registryPackage, SlotName.SUBMISSION_TIME);
  }

  static String contentTypeCode(RegistryPackageType registryPackage) {
    return getCodeFromClassification(
        registryPackage, ClassificationScheme.SUBMISSION_SET_CONTENT_TYPE);
  }
}
