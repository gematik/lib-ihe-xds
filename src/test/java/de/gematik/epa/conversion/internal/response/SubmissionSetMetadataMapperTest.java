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

package de.gematik.epa.conversion.internal.response;

import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.availabilityStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import java.time.LocalDateTime;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;
import org.junit.jupiter.api.Test;

class SubmissionSetMetadataMapperTest extends RegistryObjectListUtils {

  @Test
  void testAvailabiltyStatus() {
    ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();
    final String expectedStatus = "Approved";
    extrinsicObjectType.setStatus(expectedStatus);

    final String availabilityStatus = availabilityStatus(extrinsicObjectType);
    assertEquals(expectedStatus, availabilityStatus);
  }

  @Test
  void testToSubmissionTime() {
    var registryObjectType = new RegistryPackageType();
    createSlot(registryObjectType, SlotName.SUBMISSION_TIME, "20230309084331");

    final LocalDateTime submissionTime =
        SubmissionSetMetadataMapper.submissionTime(registryObjectType);
    final LocalDateTime expectedSubmissionTime = LocalDateTime.of(2023, 3, 9, 8, 43, 31);
    assertEquals(expectedSubmissionTime, submissionTime);
  }

  @Test
  void testUniqueId() {
    var registryPackageType = new RegistryPackageType();
    String expectedUniqueId = "1.3.6.1.4.1.21367.2023.3.168640940.8";
    createExternalIdentifier(
        registryPackageType, ExternalIdentifierScheme.SUBMISSION_SET_UNIQUE, expectedUniqueId);

    final String uniqueId = SubmissionSetMetadataMapper.uniqueId(registryPackageType);

    assertEquals(expectedUniqueId, uniqueId);
  }

  @Test
  void testContentTypeCode() {
    var registryPackageType = new RegistryPackageType();
    createClassification(
        registryPackageType, ClassificationScheme.SUBMISSION_SET_CONTENT_TYPE, "8");

    final String classCode = SubmissionSetMetadataMapper.contentTypeCode(registryPackageType);
    assertEquals("8", classCode);
  }
}
