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

import static org.junit.jupiter.api.Assertions.*;

import de.gematik.epa.ihe.model.response.ProxyResponse;
import de.gematik.epa.ihe.model.response.RetrieveDocumentElement;
import de.gematik.epa.unit.util.MessageUtils;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType.DocumentResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotListType;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryError;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryErrorList;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;
import org.junit.jupiter.api.Test;

class ResponseUtilsTest {

  private static final String SUCCESS =
      "urn:oasis:names:tc:ebxml-regrep:ResponseStatusType:Success";
  private static final String FAILURE =
      "urn:oasis:names:tc:ebxml-regrep:ResponseStatusType:Failure";

  private static final String WITH_VALUES =
      "Severity: Error\t" + "ErrorCode: 123\t" + "CodeContext: Invalid input";

  @Test
  void testSuccessResponse() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(SUCCESS);
    registryResponseType.setResponseSlotList(new SlotListType());

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    assertEquals(true, proxyResponse.success());
    assertEquals(SUCCESS, proxyResponse.statusMessage());
  }

  @Test
  void testFailedResponse() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(FAILURE);
    registryResponseType.setRegistryErrorList(createRegistryErrorList());

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    assertEquals(false, proxyResponse.success());
    assertEquals(getStatusMessageWithValues(), proxyResponse.statusMessage());
  }

  @Test
  void testFailedResponseWithAllAttributes() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(FAILURE);

    var registryError = new RegistryError();
    registryError.setSeverity("Error");
    registryError.setErrorCode("123");
    registryError.setCodeContext("Invalid input");
    registryError.setLocation("TestLocation");

    var registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(registryError);
    registryResponseType.setRegistryErrorList(registryErrorList);

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    String expectedMessage =
        FAILURE
            + "\n"
            + "Severity: Error\t"
            + "ErrorCode: 123\t"
            + "CodeContext: Invalid input\t"
            + "Location: TestLocation";

    assertEquals(false, proxyResponse.success());
    assertEquals(expectedMessage, proxyResponse.statusMessage());
  }

  @Test
  void testFailedResponseWithCompletelyEmptyRegistryError() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(FAILURE);

    var emptyError = new RegistryError();
    var registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(emptyError);
    registryResponseType.setRegistryErrorList(registryErrorList);

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    assertEquals(false, proxyResponse.success());
    assertEquals(FAILURE, proxyResponse.statusMessage());
  }

  @Test
  void testFailedResponseWithPartiallyEmptyRegistryError() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(FAILURE);

    var emptyError = new RegistryError();
    emptyError.setSeverity("urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error");
    emptyError.setErrorCode("nn");
    emptyError.setCodeContext("nn");
    var registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(emptyError);
    registryResponseType.setRegistryErrorList(registryErrorList);

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    assertEquals(false, proxyResponse.success());
    assertEquals(FAILURE, proxyResponse.statusMessage());
  }

  @Test
  void testDeleteLastTabCharacter() {
    StringBuilder statusMessageBuilder = new StringBuilder("Test message\t");
    statusMessageBuilder.deleteCharAt(statusMessageBuilder.lastIndexOf("\t"));

    assertEquals("Test message", statusMessageBuilder.toString());
  }

  @Test
  void testResponseWithException() {
    var registryResponseType = new RegistryResponseType();
    var emptyError = new RegistryError();
    var registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(emptyError);
    registryResponseType.setRegistryErrorList(registryErrorList);

    assertThrows(
        IllegalArgumentException.class, () -> ResponseUtils.toProxyResponse(registryResponseType));
  }

  @Test
  void toRetrieveDocumentResponseTest() {
    var iheResponse = MessageUtils.createRetrieveDocumentSetResponse();

    var result = assertDoesNotThrow(() -> ResponseUtils.toRetrieveDocumentResponse(iheResponse));

    assertNotNull(result);
    assertTrue(result.success());
    assertEquals(MessageUtils.RESPONSE_STATUS_SUCCESS, result.statusMessage());

    assertArrayEquals(
        iheResponse.getDocumentResponse().stream()
            .map(DocumentResponse::getDocumentUniqueId)
            .toArray(),
        result.documents().stream().map(RetrieveDocumentElement::documentUniqueId).toArray());

    assertEquals(
        iheResponse.getDocumentResponse().stream()
            .map(DocumentResponse::getRepositoryUniqueId)
            .findFirst()
            .orElse(null),
        result.documents().stream()
            .map(RetrieveDocumentElement::repositoryUniqueId)
            .findFirst()
            .orElse(null));
    assertArrayEquals(
        iheResponse.getDocumentResponse().stream().map(DocumentResponse::getDocument).toArray(),
        result.documents().stream()
            .map(retrieveDocumentElement -> retrieveDocumentElement.document().value())
            .toArray());
  }

  private RegistryErrorList createRegistryErrorList() {
    var registryErrorList = new RegistryErrorList();
    var registryError = new RegistryError();
    registryError.setSeverity("Error");
    registryError.setErrorCode("123");
    registryError.setCodeContext("Invalid input");
    registryErrorList.getRegistryError().add(registryError);
    return registryErrorList;
  }

  private String getStatusMessageWithValues() {
    return FAILURE + "\n" + WITH_VALUES;
  }
}
