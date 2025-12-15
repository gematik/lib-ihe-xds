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
package de.gematik.epa;

import de.gematik.epa.conversion.DeleteObjectsUtils;
import de.gematik.epa.conversion.ResponseUtils;
import de.gematik.epa.conversion.RestrictedUpdateDocumentUtils;
import de.gematik.epa.ihe.model.request.DeleteObjectsRequest;
import de.gematik.epa.ihe.model.request.RestrictedUpdateDocumentRequest;
import de.gematik.epa.ihe.model.response.ProxyFindResponse;
import de.gematik.epa.ihe.model.response.ProxyResponse;
import de.gematik.epa.ihe.model.response.RetrieveDocumentsResponse;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
import ihe.iti.xds_b._2007.RetrieveDocumentSetRequestType;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.lcm._3.RemoveObjectsRequest;
import oasis.names.tc.ebxml_regrep.xsd.lcm._3.SubmitObjectsRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

/** Utility class serving as entry point for the functionality provided by the lib-ihe-xds. */
@UtilityClass
public class LibIheXdsMain {

  /**
   * Create a {@code urn:ihe:iti:xds-b:2007:ProvideAndRegisterDocumentSetRequestType} from a {@link
   * de.gematik.epa.ihe.model.request.DocumentSubmissionRequest}.<br>
   * The request created can provide and register documents as well as folders.
   *
   * @param documentSubmissionRequest input data
   * @return {@link ProvideAndRegisterDocumentSetRequestType}
   */
  public static ProvideAndRegisterDocumentSetRequestType convertDocumentSubmissionRequest(
      de.gematik.epa.ihe.model.request.DocumentSubmissionRequest documentSubmissionRequest) {
    return de.gematik.epa.conversion.ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(
        documentSubmissionRequest);
  }

  /**
   * Create a {@code urn:ihe:iti:xds-b:2007:ProvideAndRegisterDocumentSetRequestType} from a {@link
   * de.gematik.epa.ihe.model.request.DocumentReplaceRequest}<br>
   * The request created is meant to replace documents already registered with newer versions.
   *
   * @param documentReplaceRequest input data
   * @return {@link ProvideAndRegisterDocumentSetRequestType}
   */
  public static ProvideAndRegisterDocumentSetRequestType convertDocumentReplaceRequest(
      de.gematik.epa.ihe.model.request.DocumentReplaceRequest documentReplaceRequest) {
    return de.gematik.epa.conversion.ProvideAndRegisterUtils.toProvideAndRegisterDocumentSetRequest(
        documentReplaceRequest);
  }

  /**
   * Create a {@code urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0:AdhocQueryRequest} from a {@link
   * de.gematik.epa.ihe.model.request.FindRequest}<br>
   * The created request is meant to query an IHE registry for documents and folders. Supported
   * query types are FindDocuments, FindDocumentsByTitle, FindFolders, GetAll, GetFolderAndContents
   * & GetRelatedApprovedDocuments
   *
   * @param findRequest input data
   * @return {@link AdhocQueryRequest}
   */
  public static AdhocQueryRequest convertFindRequest(
      de.gematik.epa.ihe.model.request.FindRequest findRequest) {
    return de.gematik.epa.conversion.AdhocQueryUtils.generateFindRequestBody(findRequest);
  }

  /**
   * Create a {@code urn:ihe:iti:xds-b:2007:RetrieveDocumentSetRequestType} from a {@link
   * de.gematik.epa.ihe.model.request.RetrieveDocumentsRequest}.<br>
   * The created request is meant to retrieve documents from an IHE repository
   *
   * @param retrieveDocumentsRequest input data
   * @return {@link RetrieveDocumentSetResponseType}
   */
  public static RetrieveDocumentSetRequestType convertRetrieveDocumentsRequest(
      de.gematik.epa.ihe.model.request.RetrieveDocumentsRequest retrieveDocumentsRequest) {
    return de.gematik.epa.conversion.RetrieveDocumentsUtils.toRetrieveDocumentSetRequest(
        retrieveDocumentsRequest);
  }

  /**
   * Create a {@code urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0:RemoveObjectsRequest} from a {@link
   * DeleteObjectsRequest}.<br>
   * The created request is meant to remove documents from an IHE repository
   *
   * @param deleteObjectsRequest input data
   * @return {@link RemoveObjectsRequest}
   */
  public static RemoveObjectsRequest convertDeleteObjectsRequest(
      DeleteObjectsRequest deleteObjectsRequest) {
    return DeleteObjectsUtils.toRemoveObjectsRequest(deleteObjectsRequest);
  }

  /**
   * Create a {@link ProxyResponse} from a {@code
   * urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0:RegistryResponseType}.<br>
   * The RegistryResponseType is a standard response type of IHE registry and used as response for
   * several operations (e.g. provideAndRegister, removeObjects)
   *
   * @param registryResponse the {@link RegistryResponseType} as received from the IHE registry.
   * @return {@link ProxyResponse}
   */
  public static ProxyResponse convertRegistryResponse(RegistryResponseType registryResponse) {
    return ResponseUtils.toProxyResponse(registryResponse);
  }

  /**
   * Create a {@link ProxyFindResponse} from a {@code
   * urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0:AdhocQueryResponse}.<br>
   * The AdhocQueryResponse holds the results of the query submitted in an AdhocQueryRequest.
   *
   * @param adhocQueryResponse the {@link AdhocQueryResponse} from the IHE registry
   * @return {@link ProxyFindResponse}
   */
  public static ProxyFindResponse convertAdhocQueryResponse(AdhocQueryResponse adhocQueryResponse) {
    return ResponseUtils.toProxyFindResponse(adhocQueryResponse);
  }

  /**
   * Create a {@link RetrieveDocumentsResponse} from a {@code
   * urn:ihe:iti:xds-b:2007:RetrieveDocumentSetResponseType}.<br>
   * The RetrieveDocumentSetResponse contains the documents retrieved from an IHE repository,
   * triggered using a RetrieveDocumentSetRequest.
   *
   * @param retrieveDocumentSetResponse {@link RetrieveDocumentSetResponseType} as returned by an
   *     IHE repository
   * @return {@link RetrieveDocumentsResponse}
   */
  public static RetrieveDocumentsResponse convertRetrieveDocumentSetResponse(
      RetrieveDocumentSetResponseType retrieveDocumentSetResponse) {
    return ResponseUtils.toRetrieveDocumentResponse(retrieveDocumentSetResponse);
  }

  /**
   * Create a {@code urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0:SubmitObjectsRequest} from a {@link
   * RestrictedUpdateDocumentRequest}.<br>
   * The request created can update documents metadata
   *
   * @param restrictedUpdateDocumentRequest input data
   * @return {@link SubmitObjectsRequest}
   */
  public static SubmitObjectsRequest convertRestrictedUpdateDocumentSetRequest(
      RestrictedUpdateDocumentRequest restrictedUpdateDocumentRequest) {
    return RestrictedUpdateDocumentUtils.toUpdateDocumentSetRequest(
        restrictedUpdateDocumentRequest);
  }
}
