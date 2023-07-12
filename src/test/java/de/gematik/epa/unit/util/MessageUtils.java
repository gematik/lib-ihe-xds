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

package de.gematik.epa.unit.util;

import de.gematik.epa.conversion.internal.requests.factories.UniqueIdFactory;
import de.gematik.epa.ihe.model.simple.InsurantId;
import de.gematik.epa.ihe.model.simple.RecordIdentifier;
import ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType;
import java.nio.charset.StandardCharsets;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

@UtilityClass
public class MessageUtils {

  public static final String RESPONSE_STATUS_SUCCESS =
      "urn:oasis:names:tc:ebxml-regrep:ResponseStatusType:Success";

  public static final String HOME_COMMUNITY_ID = "1.2.276.0.76.3.1.315.3.2.1.1";

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

    docResponse.setHomeCommunityId(HOME_COMMUNITY_ID);
    docResponse.setRepositoryUniqueId(HOME_COMMUNITY_ID);
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

  public static RecordIdentifier createRecordIdentifier(InsurantId insurantId, String hcid) {
    return new RecordIdentifier() {
      @Override
      public InsurantId getInsurantId() {
        return insurantId;
      }

      @Override
      public String getHomeCommunityId() {
        return hcid;
      }
    };
  }

  public static RecordIdentifier createRecordIdentifier() {
    return createRecordIdentifier(createInsurantId(), HOME_COMMUNITY_ID);
  }
}
