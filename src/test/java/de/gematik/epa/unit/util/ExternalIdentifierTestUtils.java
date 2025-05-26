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
package de.gematik.epa.unit.util;

import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getExternalIdentifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.gematik.epa.conversion.internal.requests.factories.UniqueIdFactory;
import de.gematik.epa.ihe.model.request.SubmissionRequestInterface;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;

public class ExternalIdentifierTestUtils {

  // Number of external identifiers in given test data
  private static final int EXTERNAL_IDENTIFIER_COUNT = 2;

  public static void assertExternalIdentifiers(
      RegistryObjectType objectType,
      SubmissionRequestInterface<?> submissionRequest,
      String patientIdScheme,
      String uniqueIdScheme) {
    assertEquals(EXTERNAL_IDENTIFIER_COUNT, objectType.getExternalIdentifier().size());

    assertExternalIdentifierPatientId(objectType, submissionRequest, patientIdScheme);
    assertExternalIdentifierUniqueId(objectType, uniqueIdScheme);
  }

  public static void assertExternalIdentifierUniqueId(
      RegistryObjectType registryObjectType, String externalIdentifierScheme) {
    String uniqueId = getExternalIdentifier(registryObjectType, externalIdentifierScheme);
    assertNotNull(uniqueId);
    assertTrue(uniqueId.matches(UniqueIdFactory.OID_PREFIX + "([.]\\d+)+"));
  }

  public static void assertExternalIdentifierPatientId(
      RegistryObjectType registryObjectType,
      SubmissionRequestInterface<?> submissionRequest,
      String externalIdentifierScheme) {
    var insurantId = submissionRequest.insurantId();
    String patientId = getExternalIdentifier(registryObjectType, externalIdentifierScheme);
    String expectedPatientId = insurantId.getExtension() + "^^^&" + insurantId.getRoot() + "&ISO";
    assertEquals(expectedPatientId, patientId);
  }
}
