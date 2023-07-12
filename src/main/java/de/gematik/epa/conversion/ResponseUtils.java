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

import static de.gematik.epa.conversion.internal.response.AssociationsMapper.mapAssociations;
import static de.gematik.epa.conversion.internal.response.DocumentMetadataMapper.mapDocumentMetadata;
import static de.gematik.epa.conversion.internal.response.FolderListMapper.mapFolders;
import static de.gematik.epa.conversion.internal.response.SubmissionSetMetadataMapper.mapSubmissionSetMetadata;

import de.gematik.epa.ihe.model.response.ProxyFindResponse;
import de.gematik.epa.ihe.model.response.ProxyResponse;
import de.gematik.epa.ihe.model.response.RegistryObjectLists;
import de.gematik.epa.ihe.model.response.RetrieveDocumentElement;
import de.gematik.epa.ihe.model.response.RetrieveDocumentsResponse;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

@UtilityClass
public class ResponseUtils {

  private static final String NN = "nn";
  private static final String UNKNOWN_ERROR = "unknown error";
  public static final String SUCCESS = "Success";
  private static final String FAILURE = "Failure";

  public static ProxyResponse toProxyResponse(RegistryResponseType registryResponse) {
    Boolean success = isSuccess(registryResponse);
    String statusMessage = createStatusMessage(registryResponse);
    return new ProxyResponse(success, statusMessage);
  }

  public static ProxyFindResponse toProxyFindResponse(AdhocQueryResponse adhocQueryResponse) {
    Boolean success = isSuccess(adhocQueryResponse);
    String statusMessage = createStatusMessage(adhocQueryResponse);
    var registryObjectLists = createObjectsMetadataList(adhocQueryResponse);
    return new ProxyFindResponse(success, statusMessage, registryObjectLists);
  }

  public static RetrieveDocumentsResponse toRetrieveDocumentResponse(
      RetrieveDocumentSetResponseType iheResponse) {
    var baseResponse = toProxyResponse(iheResponse.getRegistryResponse());
    return new RetrieveDocumentsResponse(
        baseResponse,
        iheResponse.getDocumentResponse().stream()
            .map(ResponseUtils::createRetrieveDocumentElement)
            .toList());
  }

  private static RegistryObjectLists createObjectsMetadataList(
      AdhocQueryResponse adhocQueryResponse) {
    var documents = mapDocumentMetadata(adhocQueryResponse);
    var submissionSets = mapSubmissionSetMetadata(adhocQueryResponse);
    var folders = mapFolders(adhocQueryResponse);
    var associations = mapAssociations(adhocQueryResponse);
    return new RegistryObjectLists(submissionSets, documents, folders, associations);
  }

  private static String createStatusMessage(RegistryResponseType registryResponse) {
    var statusMessageBuilder = new StringBuilder();
    statusMessageBuilder.append(registryResponse.getStatus());

    if (Objects.nonNull(registryResponse.getRegistryErrorList())) {
      registryResponse
          .getRegistryErrorList()
          .getRegistryError()
          .forEach(
              registryError -> {
                statusMessageBuilder.append("\n");
                append(statusMessageBuilder, registryError.getLocation(), NN);
                append(statusMessageBuilder, registryError.getSeverity(), NN);
                append(statusMessageBuilder, registryError.getErrorCode(), NN);
                append(statusMessageBuilder, registryError.getCodeContext(), NN);
                append(statusMessageBuilder, registryError.getValue(), UNKNOWN_ERROR);
                statusMessageBuilder.deleteCharAt(statusMessageBuilder.lastIndexOf("\t"));
              });
    }
    return statusMessageBuilder.toString();
  }

  private static void append(StringBuilder builder, String value, String nullDefault) {
    builder.append(Objects.toString(value, nullDefault)).append("\t");
  }

  private static boolean isSuccess(RegistryResponseType registryResponse) {
    final String statusValue = registryResponse.getStatus();
    if (neitherSuccessNorFailure(statusValue)) {
      throw new IllegalArgumentException(
          "There is no response status defined for the value " + statusValue);
    }
    return statusValue.contains(SUCCESS);
  }

  private static boolean neitherSuccessNorFailure(String statusValue) {
    return statusValue == null
        || (!statusValue.contains(SUCCESS) && !statusValue.contains(FAILURE));
  }

  private static RetrieveDocumentElement createRetrieveDocumentElement(
      RetrieveDocumentSetResponseType.DocumentResponse iheDocResponse) {
    return new RetrieveDocumentElement(
        iheDocResponse.getDocumentUniqueId(),
        iheDocResponse.getMimeType(),
        iheDocResponse.getDocument());
  }
}
