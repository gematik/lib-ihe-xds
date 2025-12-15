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
package de.gematik.epa.unit.util;

import de.gematik.epa.conversion.internal.requests.factories.UniqueIdFactory;
import de.gematik.epa.ihe.model.Author;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.simple.InsurantId;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

@UtilityClass
public class MessageUtils {

  public static final String RESPONSE_STATUS_SUCCESS =
      "urn:oasis:names:tc:ebxml-regrep:ResponseStatusType:Success";

  public static final String REPOSITORY_UNIQUE_ID = "1.2.276.0.76.3.1.315.3.2.1.1";

  public static RetrieveDocumentSetResponseType createRetrieveDocumentSetResponse() {
    var retrieveDocumentSetResponse = new RetrieveDocumentSetResponseType();
    retrieveDocumentSetResponse.setRegistryResponse(createRegistryResponseSuccess());

    retrieveDocumentSetResponse
        .getDocumentResponse()
        .add(createRetrieveDocumentSetDocumentResponse());
    retrieveDocumentSetResponse
        .getDocumentResponse()
        .add(createRetrieveDocumentSetDocumentResponse());

    return retrieveDocumentSetResponse;
  }

  public static RegistryResponseType createRegistryResponseSuccess() {
    var registryResponse = new RegistryResponseType();
    registryResponse.setStatus(RESPONSE_STATUS_SUCCESS);

    return registryResponse;
  }

  public static RetrieveDocumentSetResponseType.DocumentResponse
      createRetrieveDocumentSetDocumentResponse() {
    var docResponse = new RetrieveDocumentSetResponseType.DocumentResponse();

    docResponse.setRepositoryUniqueId(REPOSITORY_UNIQUE_ID);
    docResponse.setMimeType("application/xml");
    docResponse.setDocumentUniqueId(UniqueIdFactory.createOID());
    docResponse.setDocument("<el><subel name=\"subel\"/></el>".getBytes(StandardCharsets.UTF_8));

    return docResponse;
  }

  public static InsurantId createInsurantId(String extension, String root) {
    return new InsurantId() {
      @Override
      public String getRoot() {
        return root;
      }

      @Override
      public String getExtension() {
        return extension;
      }
    };
  }

  public static InsurantId createInsurantId() {
    return createInsurantId("X110454647", "1.2.276.0.76.4.8");
  }

  public static DocumentMetadata getDocumentMetadata() {
    List<Author> authors = getAuthors();
    String availabilityStatus = "Approved";
    List<String> confidentialityCode = List.of("V");

    return new DocumentMetadata(
        authors,
        availabilityStatus,
        confidentialityCode,
        "classCode",
        "comments",
        LocalDateTime.now(),
        "uuid",
        Arrays.asList("eventCode1", "eventCode2"),
        "formatCode",
        "hash",
        "healthcareFacilityTypeCodeValue",
        "DE-de",
        "legalAuthenticator",
        "mimeType",
        "practiceSettingCode",
        Arrays.asList("referenceId1", "referenceId2"),
        LocalDateTime.now(),
        LocalDateTime.now().plusHours(1),
        1024,
        "Mediplan",
        "typeCode",
        "7.8.9.4.5.6",
        "uri",
        "1.2.3.45.6",
        "hci",
        "X123456",
        "j98789");
  }

  private static List<Author> getAuthors() {
    Author nullAuthor = new Author("1", null, null, null, null, null, null, null, null, null, null);
    return List.of(nullAuthor);
  }

  private static SubmissionSetMetadata getSubmissionSetMetadata() {
    List<Author> authors = getAuthors();
    return new SubmissionSetMetadata(
        authors, "title", LocalDateTime.now(), "Approved", "1.2.3", "uuid");
  }
}
