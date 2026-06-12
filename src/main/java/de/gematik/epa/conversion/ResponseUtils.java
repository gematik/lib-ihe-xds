/*-
 * #%L
 * lib-ihe-xds
 * %%
 * Copyright (C) 2023 - 2026 gematik GmbH
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

import static de.gematik.epa.conversion.internal.response.AssociationsMapper.mapAssociations;
import static de.gematik.epa.conversion.internal.response.DocumentMetadataMapper.mapDocumentMetadata;
import static de.gematik.epa.conversion.internal.response.FolderListMapper.mapFolders;
import static de.gematik.epa.conversion.internal.response.SubmissionSetMetadataMapper.mapSubmissionSetMetadata;

import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.response.ProxyFindResponse;
import de.gematik.epa.ihe.model.response.ProxyResponse;
import de.gematik.epa.ihe.model.response.RegistryObjectLists;
import de.gematik.epa.ihe.model.response.RetrieveDocumentElement;
import de.gematik.epa.ihe.model.response.RetrieveDocumentsResponse;
import de.gematik.epa.ihe.model.response.ReusedDocumentMapping;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType;
import java.util.List;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryError;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

@UtilityClass
public class ResponseUtils {

  private static final String NN = "nn";
  public static final String SUCCESS = "Success";
  private static final String FAILURE = "Failure";

  /** Standard response */
  public static ProxyResponse toProxyResponse(RegistryResponseType registryResponse) {
    Boolean success = isSuccess(registryResponse);
    String statusMessage = createStatusMessage(registryResponse);
    return new ProxyResponse(success, statusMessage);
  }

  /** Response with reusedDocumentMappings */
  public static ProxyResponse toProxyResponseWithReusedMappings(
      RegistryResponseType registryResponse) {
    Boolean success = isSuccess(registryResponse);
    String statusMessage = createStatusMessage(registryResponse);
    List<ReusedDocumentMapping> reusedDocumentMappings =
        extractReusedDocumentMappings(registryResponse);
    return new ProxyResponse(success, statusMessage, reusedDocumentMappings);
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
                if (isRegistryErrorEmpty(registryError)) {
                  return; // Skip empty RegistryError
                }
                statusMessageBuilder.append("\n");
                appendWithKey(statusMessageBuilder, "Severity", registryError.getSeverity());
                appendWithKey(statusMessageBuilder, "ErrorCode", registryError.getErrorCode());
                appendWithKey(statusMessageBuilder, "CodeContext", registryError.getCodeContext());
                if (Objects.nonNull(registryError.getLocation())) {
                  appendWithKey(statusMessageBuilder, "Location", registryError.getLocation());
                }
                statusMessageBuilder.deleteCharAt(statusMessageBuilder.lastIndexOf("\t"));
              });
    }
    return statusMessageBuilder.toString();
  }

  private static boolean isRegistryErrorEmpty(RegistryError registryError) {
    return (registryError.getSeverity() == null
            || registryError
                .getSeverity()
                .equals("urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error"))
        && (registryError.getErrorCode() == null || registryError.getErrorCode().equals(NN))
        && (registryError.getCodeContext() == null || registryError.getCodeContext().equals(NN));
  }

  private static void appendWithKey(StringBuilder builder, String key, String value) {
    builder.append(key).append(": ").append(Objects.toString(value, ResponseUtils.NN)).append("\t");
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

  /**
   * Extracts ReusedDocumentMapping entries from the ResponseSlotList of a RegistryResponse.
   * According to A_27700-02, each slot with name "urn:gematik:iti:xds:ReusedDocumentMapping"
   * contains a value in the format "$uniqueId_neu|$uniqueId_alt".
   *
   * @param registryResponse the registry response to extract mappings from
   * @return list of ReusedDocumentMapping entries, or empty list if none found
   */
  private static List<ReusedDocumentMapping> extractReusedDocumentMappings(
      RegistryResponseType registryResponse) {
    if (registryResponse.getResponseSlotList() == null
        || registryResponse.getResponseSlotList().getSlot() == null) {
      return List.of();
    }

    return registryResponse.getResponseSlotList().getSlot().stream()
        .filter(
            slot ->
                SlotName.REUSED_DOCUMENT_MAPPING.getName().equals(slot.getName())
                    && slot.getValueList() != null
                    && slot.getValueList().getValue() != null)
        .flatMap(slot -> slot.getValueList().getValue().stream())
        .map(ReusedDocumentMapping::fromSlotValue)
        .filter(Objects::nonNull)
        .toList();
  }

  private static RetrieveDocumentElement createRetrieveDocumentElement(
      RetrieveDocumentSetResponseType.DocumentResponse iheDocResponse) {
    return new RetrieveDocumentElement(
        iheDocResponse.getRepositoryUniqueId(),
        iheDocResponse.getDocumentUniqueId(),
        iheDocResponse.getMimeType(),
        iheDocResponse.getDocument());
  }
}
