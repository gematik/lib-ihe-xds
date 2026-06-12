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

import java.util.regex.Pattern;

/**
 * Represents a mapping between a new document uniqueId and an existing (reused) document uniqueId.
 * This is used in the response when document reuse is enabled (EnableDocumentReuse=true) and a
 * duplicate document was detected.
 *
 * <p>According to A_27700-02, the format is: $uniqueId_neu|$uniqueId_alt
 *
 * @param newUniqueId the DocumentEntry.uniqueId of the document from the SubmissionRequest
 * @param oldUniqueId the DocumentEntry.uniqueId of the existing document
 */
public record ReusedDocumentMapping(String newUniqueId, String oldUniqueId) {

  /** Separator used in the slot value format. */
  public static final String SEPARATOR = "|";

  /**
   * Parses a slot value in the format "$uniqueId_neu|$uniqueId_alt" into a ReusedDocumentMapping.
   *
   * @param slotValue the slot value to parse
   * @return the ReusedDocumentMapping or null if the format is invalid
   */
  public static ReusedDocumentMapping fromSlotValue(String slotValue) {
    if (slotValue == null || !slotValue.contains(SEPARATOR)) {
      return null;
    }
    String[] parts = slotValue.split(Pattern.quote(SEPARATOR), 2);
    if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
      return null;
    }
    return new ReusedDocumentMapping(parts[0], parts[1]);
  }

  /**
   * Converts this mapping to the slot value format "$uniqueId_neu|$uniqueId_alt".
   *
   * @return the slot value string
   */
  public String toSlotValue() {
    return newUniqueId + SEPARATOR + oldUniqueId;
  }
}
