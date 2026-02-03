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
package de.gematik.epa.conversion.internal.requests;

import de.gematik.epa.ihe.model.document.AppendDocument;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.document.ReplaceDocument;
import de.gematik.epa.ihe.model.document.RestrictedUpdateDocument;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.ihe.model.simple.InsurantId;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;

/**
 * Generator class to generate objects from the document data of a request (e.g., {@link
 * de.gematik.epa.ihe.model.document.Document}, {@link
 * de.gematik.epa.ihe.model.document.ReplaceDocument}, or {@link
 * de.gematik.epa.ihe.model.document.AppendDocument}).<br>
 * The generated objects are {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType} and
 * {@link ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType.Document}.
 */
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "generator")
@ToString(callSuper = true)
public class DocumentGenerator {

  public static final String UUID_PREFIX = "urn:uuid:";

  public static DocumentGeneratorList generators(
      List<? extends DocumentInterface> documents, InsurantId insurantId) {
    return new DocumentGeneratorList(
        documents.stream().map(doc -> generator(doc, insurantId)).toList());
  }

  @NonNull private final DocumentInterface document;
  @NonNull private final InsurantId insurantId;

  /**
   * Get the id, which is used for the id attribute of the ExtrinsicObject and the Document. Has the
   * value of {@link de.gematik.epa.ihe.model.document.DocumentMetadata#entryUUID()} if it is not
   * null, otherwise a new id will be generated.
   */
  @Getter(lazy = true)
  private final String id =
      Optional.ofNullable(document.documentMetadata())
          .map(DocumentMetadata::entryUUID)
          .orElseGet(() -> UUID_PREFIX + UUID.randomUUID());

  /**
   * Get the {@link ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType.Document} generated
   * from the provided {@link de.gematik.epa.ihe.model.document.DocumentInterface} implementation.
   */
  @Getter(lazy = true)
  private final Document iheDocument = toIheDocument(document, id());

  /**
   * Get the {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType} generated from the
   * provided {@link de.gematik.epa.ihe.model.document.DocumentInterface} implementation.
   */
  @Getter(lazy = true)
  private final ExtrinsicObjectType extrinsicObject =
      ExtrinsicObjectGenerator.createExtrinsicObject(document, id(), insurantId);

  /**
   * Get the {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType} generated from the
   * provided {@link de.gematik.epa.ihe.model.document.DocumentInterface} implementation for RMU.
   */
  @Getter(lazy = true)
  private final ExtrinsicObjectType extrinsicObjectRMU =
      ExtrinsicObjectGenerator.createExtrinsicObjectRMU(
          document, idOfDocumentToUpdate(), insurantId);

  /**
   * Get the {@link de.gematik.epa.ihe.model.simple.FolderMetadata} from the provided document.<br>
   * This will only return a value, if the provided document is of type {@link
   * de.gematik.epa.ihe.model.document.Document} otherwise null will be returned.
   */
  @Getter(lazy = true)
  private final FolderMetadata folderMetadata =
      Optional.of(document)
          .filter(doc -> doc instanceof de.gematik.epa.ihe.model.document.Document)
          .map(doc -> (de.gematik.epa.ihe.model.document.Document) doc)
          .map(de.gematik.epa.ihe.model.document.Document::folderMetadata)
          .orElse(null);

  /**
   * Get the id of the document, which is to be replaced by the provided document.<br>
   * This will only return a value, if the provided document is of type {@link
   * de.gematik.epa.ihe.model.document.ReplaceDocument} otherwise null will be returned.
   */
  @Getter(lazy = true)
  private final String idOfDocumentToReplace =
      Optional.of(document)
          .filter(ReplaceDocument.class::isInstance)
          .map(ReplaceDocument.class::cast)
          .map(ReplaceDocument::entryUUIDOfDocumentToReplace)
          .orElse(null);

  /**
   * Gets the ID of the document to which the provided document is to be appended.<br>
   * This will only return a value if the provided document is of type {@link
   * de.gematik.epa.ihe.model.document.AppendDocument}; otherwise, null will be returned.
   */
  @Getter(lazy = true)
  private final String idOfDocumentToAppend =
      Optional.of(document)
          .filter(AppendDocument.class::isInstance)
          .map(AppendDocument.class::cast)
          .map(AppendDocument::entryUUIDOfDocumentToAppend)
          .orElse(null);

  /**
   * Get the id of the document, which is to be updated by the provided document.<br>
   * This will only return a value, if the provided document is of type {@link
   * de.gematik.epa.ihe.model.document.RestrictedUpdateDocument} otherwise null will be returned.
   */
  @Getter(lazy = true)
  private final String idOfDocumentToUpdate =
      Optional.of(document)
          .filter(RestrictedUpdateDocument.class::isInstance)
          .map(RestrictedUpdateDocument.class::cast)
          .map(RestrictedUpdateDocument::entryUUIDOfDocumentToUpdate)
          .orElse(null);

  private static Document toIheDocument(DocumentInterface document, String id) {
    var iheDocument = new Document();
    iheDocument.setValue(document.documentData().value());
    iheDocument.setId(id);
    return iheDocument;
  }

  public static class DocumentGeneratorList extends ArrayList<DocumentGenerator> {

    private DocumentGeneratorList(List<DocumentGenerator> list) {
      super(list);
    }

    public List<Document> iheDocuments() {
      return stream().map(DocumentGenerator::iheDocument).toList();
    }

    public List<ExtrinsicObjectType> extrinsicObjects() {
      return stream().map(DocumentGenerator::extrinsicObject).toList();
    }

    public List<ExtrinsicObjectType> extrinsicObjectsRMU() {
      return stream().map(DocumentGenerator::extrinsicObjectRMU).toList();
    }
  }
}
