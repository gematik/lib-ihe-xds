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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.gematik.epa.ihe.model.request.DocumentReplaceRequest;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.ihe.model.request.RestrictedUpdateDocumentRequest;
import de.gematik.epa.ihe.model.request.RetrieveDocumentsRequest;
import de.gematik.epa.ihe.model.simple.InsurantId;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

public class ResourceLoader {
  public static final String REQUEST_PATH = "src/test/resources/";

  public static final String PUT_DOCUMENTS_WITH_FOLDER_METADATA_REQUEST =
      REQUEST_PATH + "documentSubmissionRequest.json";

  public static final String PUT_DOCUMENTS_RMU_REQUEST =
      REQUEST_PATH + "documentSubmissionRequestRMU.json";
  public static final String PUT_DOCUMENTS_WITHOUT_ATTRIBUTES_REQUEST =
      REQUEST_PATH + "documentSubmissionRequestWithoutAttributes.json";

  public static final String REPLACE_DOCUMENTS_REQUEST =
      REQUEST_PATH + "documentReplaceRequest.json";

  public static final String RETRIEVE_DOCUMENTS_REQUEST_PATH =
      REQUEST_PATH + "retrieveDocumentsRequest.json";

  public static final String RESTRICTED_UPDATE_DOCUMENT_REQUEST =
      REQUEST_PATH + "updateDocumentRequest.json";
  public static final String RESTRICTED_UPDATE_DOCUMENT_DIFFERENCE_REQUEST =
      REQUEST_PATH + "updateDocumentRequestDifference.json";

  public static final String RESTRICTED_UPDATE_DOCUMENT_LIST_REQUEST =
      REQUEST_PATH + "updateDocumentListRequest.json";

  private static ObjectMapper objMapper;

  @SneakyThrows
  public static DocumentSubmissionRequest documentSubmissionRequest(String template) {
    return loadDtoFromJsonFile(DocumentSubmissionRequest.class, template);
  }

  @SneakyThrows
  public static RestrictedUpdateDocumentRequest updateDocumentSetRequest(String template) {
    return loadDtoFromJsonFile(RestrictedUpdateDocumentRequest.class, template);
  }

  @SneakyThrows
  public static RetrieveDocumentsRequest retrieveDocumentsRequest(String template) {
    return loadDtoFromJsonFile(RetrieveDocumentsRequest.class, template);
  }

  @SneakyThrows
  public static DocumentReplaceRequest documentsReplaceRequest(String template) {
    return loadDtoFromJsonFile(DocumentReplaceRequest.class, template);
  }

  public static <T> T loadDtoFromJsonFile(final Class<T> dtoClass, final String path)
      throws IOException {
    final String fileContent = readFileContentFromResource(path);
    return getObjectMapper().readValue(fileContent, dtoClass);
  }

  public static String readFileContentFromResource(final String filePath) throws IOException {
    Objects.requireNonNull(filePath, "The path of the file must not be null!");
    var file = FileUtils.getFile(filePath);
    return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
  }

  public static ObjectMapper getObjectMapper() {
    return Optional.ofNullable(objMapper)
        .orElseGet(
            () -> {
              objMapper =
                  new ObjectMapper()
                      .registerModule(new JavaTimeModule())
                      .registerModule(
                          new SimpleModule()
                              .addDeserializer(
                                  InsurantId.class, new InsurantIdInterfaceDeserializer()));
              return objMapper;
            });
  }

  private static class InsurantIdInterfaceDeserializer extends JsonDeserializer<InsurantId> {
    @Override
    public InsurantId deserialize(
        JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
      JsonNode node = jsonParser.getCodec().readTree(jsonParser);
      String root = node.get("root").asText();
      String extension = node.get("extension").asText();
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
  }
}
