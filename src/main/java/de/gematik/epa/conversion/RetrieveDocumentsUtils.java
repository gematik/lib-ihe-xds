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

import de.gematik.epa.ihe.model.request.RetrieveDocumentsRequest;
import ihe.iti.xds_b._2007.RetrieveDocumentSetRequestType;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RetrieveDocumentsUtils {

  public static RetrieveDocumentSetRequestType toRetrieveDocumentSetRequest(
      @NonNull RetrieveDocumentsRequest retrieveDocumentsRequest) {

    return new RetrieveDocumentSetRequestType()
        .withDocumentRequest(
            retrieveDocumentsRequest.documentUniqueIds().stream()
                .map(
                    docUniqueId ->
                        new RetrieveDocumentSetRequestType.DocumentRequest()
                            .withDocumentUniqueId(docUniqueId)
                            .withHomeCommunityId(retrieveDocumentsRequest.homeCommunityId())
                            .withRepositoryUniqueId(retrieveDocumentsRequest.homeCommunityId()))
                .toList());
  }
}
