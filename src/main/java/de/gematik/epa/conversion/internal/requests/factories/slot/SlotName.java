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
package de.gematik.epa.conversion.internal.requests.factories.slot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** A SlotName might have multiple attributes and behavior. At the moment is just has a name. */
@Getter
@AllArgsConstructor
public enum SlotName {
  AUTHOR_ROLE("authorRole"),
  AUTHOR_PERSON("authorPerson"),
  AUTHOR_INSTITUTION("authorInstitution"),
  AUTHOR_SPECIALTY("authorSpecialty"),
  AUTHOR_TELECOMMUNICATION("authorTelecommunication"),
  CODING_SCHEME("codingScheme"),
  CREATION_TIME("creationTime"),
  HASH("hash"),
  LANGUAGE_CODE("languageCode"),
  LAST_UPDATE_TIME("lastUpdateTime"),
  LEGAL_AUTHENTICATOR("legalAuthenticator"),
  REFERENCE_ID_LIST("urn:ihe:iti:xds:2013:referenceIdList"),
  REPOSITORY_UNIQUE_ID("repositoryUniqueId"),
  SERVICE_START_TIME("serviceStartTime"),
  SERVICE_STOP_TIME("serviceStopTime"),
  SIZE("size"),
  SOURCE_PATIENT_ID("sourcePatientId"),
  SOURCE_PATIENT_INFO("sourcePatientInfo"),
  SUBMISSION_TIME("submissionTime"),
  URI("URI"),
  HOME_COMMUNITY_ID("homeCommunityId"),
  PREVIOUS_VERSION("PreviousVersion"),
  ASSOCIATION_PROPAGATION("associationPropagation"),
  SUBMISSION_SET_STATUS("SubmissionSetStatus");

  private final String name;
}
