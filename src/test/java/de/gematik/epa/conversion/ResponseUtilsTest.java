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
  private static final String WITHOUT_VALUES =
      "nn\turn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error\tnn\tnn\tunknown error";
  private static final String WITH_VALUES =
      "FM\t"
          + "urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error\t"
          + "7400\t"
          + "Fehler - Die Operation konnte nicht durchgeführt werden.\t"
          + "titusMandant is marked non-null but is null\n"
          + "PHRService\t"
          + "urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error\t"
          + "XDSRegistryError\t"
          + "java.lang.NullPointerException\t"
          + "titusMandant is marked non-null but is null";

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
  void testFailedResponseWithEmptyError() {
    var registryResponseType = new RegistryResponseType();
    registryResponseType.setStatus(FAILURE);
    var emptyError = new RegistryError();
    var registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(emptyError);
    registryResponseType.setRegistryErrorList(registryErrorList);

    final ProxyResponse proxyResponse = ResponseUtils.toProxyResponse(registryResponseType);

    assertEquals(false, proxyResponse.success());
    assertEquals(proxyResponse.statusMessage(), getStatusMessageWithoutValues());
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
    RegistryError error = new RegistryError();
    error.setLocation("FM");
    error.setSeverity("urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error");
    error.setErrorCode("7400");
    error.setCodeContext("Fehler - Die Operation konnte nicht durchgeführt werden.");
    error.setValue("titusMandant is marked non-null but is null");
    RegistryErrorList registryErrorList = new RegistryErrorList();
    registryErrorList.getRegistryError().add(error);

    RegistryError error2 = new RegistryError();
    error2.setLocation("PHRService");
    error2.setSeverity("urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error");
    error2.setErrorCode("XDSRegistryError");
    error2.setCodeContext("java.lang.NullPointerException");
    error2.setValue("titusMandant is marked non-null but is null");
    registryErrorList.getRegistryError().add(error2);
    return registryErrorList;
  }

  private String getStatusMessageWithoutValues() {
    return FAILURE + "\n" + WITHOUT_VALUES;
  }

  private String getStatusMessageWithValues() {
    return FAILURE + "\n" + WITH_VALUES;
  }
}
