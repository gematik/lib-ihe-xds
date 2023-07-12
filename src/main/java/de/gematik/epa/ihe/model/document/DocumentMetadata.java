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

package de.gematik.epa.ihe.model.document;

import de.gematik.epa.ihe.model.Author;
import java.time.LocalDateTime;
import java.util.List;

public record DocumentMetadata(
    List<Author> author,
    String availabilityStatus,
    List<String> confidentialityCode,
    String classCode,
    String comments,
    LocalDateTime creationTime,
    String entryUUID,
    List<String> eventCodeList,
    String formatCode,
    String hash,
    String healthcareFacilityTypeCode,
    String languageCode,
    String legalAuthenticator,
    String mimeType,
    String practiceSettingCode,
    List<String> referenceIdList,
    LocalDateTime serviceStartTime,
    LocalDateTime serviceStopTime,
    Integer size,
    String title,
    String typeCode,
    String uniqueId,
    String uri,
    String repositoryUniqueId,
    String home,
    String patientId) {}
