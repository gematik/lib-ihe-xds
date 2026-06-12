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
package de.gematik.epa.ihe.model.response;

import java.util.List;

/**
 * Response from the XDS Document Service.
 *
 * @param success indicates if the operation was successful
 * @param statusMessage the status message from the response
 * @param reusedDocumentMappings list of document mappings when EnableDocumentReuse was used and
 *     duplicates were detected (as per A_27700-02)
 */
public record ProxyResponse(
    Boolean success, String statusMessage, List<ReusedDocumentMapping> reusedDocumentMappings) {

  /**
   * Constructor for backward compatibility without reusedDocumentMappings.
   *
   * @param success indicates if the operation was successful
   * @param statusMessage the status message from the response
   */
  public ProxyResponse(Boolean success, String statusMessage) {
    this(success, statusMessage, null);
  }
}
