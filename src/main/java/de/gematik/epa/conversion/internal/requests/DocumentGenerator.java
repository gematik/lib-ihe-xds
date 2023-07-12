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

package de.gematik.epa.conversion.internal.requests;

import de.gematik.epa.ihe.model.document.DocumentInterface;
import de.gematik.epa.ihe.model.document.DocumentMetadata;
import de.gematik.epa.ihe.model.document.ReplaceDocument;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.ihe.model.simple.RecordIdentifier;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
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
 * Generator class to generate the objects, which are created from the document data ({@link
 * de.gematik.epa.ihe.model.document.Document} or {@link ReplaceDocument}) of a request.<br>
 * These are {@link ExtrinsicObjectType} and {@link Document}.
 */
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "generator")
@ToString(callSuper = true)
public class DocumentGenerator {

  public static final String UUID_PREFIX = "urn:uuid:";

  public static DocumentGeneratorList generators(
      List<? extends DocumentInterface> documents, RecordIdentifier recordIdentifier) {
    return new DocumentGeneratorList(
        documents.stream().map(doc -> generator(doc, recordIdentifier)).toList());
  }

  @NonNull private final DocumentInterface document;

  @NonNull private final RecordIdentifier recordIdentifier;

  /**
   * Get the id, which is used for the id attribute of the ExtrinsicObject and the Document. Has the
   * value of {@link DocumentMetadata#entryUUID()} if it is not null, otherwise a new id will be
   * generated.
   */
  @Getter(lazy = true)
  private final String id =
      Optional.ofNullable(document.documentMetadata())
          .map(DocumentMetadata::entryUUID)
          .orElseGet(() -> UUID_PREFIX + UUID.randomUUID());

  /**
   * Get the {@link Document} generated from the provided {@link DocumentInterface} implementation.
   */
  @Getter(lazy = true)
  private final ProvideAndRegisterDocumentSetRequestType.Document iheDocument =
      toIheDocument(document, id());

  /**
   * Get the {@link ExtrinsicObjectType} generated from the provided {@link DocumentInterface}
   * implementation.
   */
  @Getter(lazy = true)
  private final ExtrinsicObjectType extrinsicObject =
      ExtrinsicObjectGenerator.createExtrinsicObject(document, recordIdentifier, id());

  /**
   * Get the {@link FolderMetadata} from the provided document.<br>
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
   * This will only return a value, if the provided document is of type {@link ReplaceDocument}
   * otherwise null will be returned.
   */
  @Getter(lazy = true)
  private final String idOfDocumentToReplace =
      Optional.of(document)
          .filter(ReplaceDocument.class::isInstance)
          .map(ReplaceDocument.class::cast)
          .map(ReplaceDocument::entryUUIDOfDocumentToReplace)
          .orElse(null);

  private static ProvideAndRegisterDocumentSetRequestType.Document toIheDocument(
      DocumentInterface document, String id) {
    var iheDocument = new ProvideAndRegisterDocumentSetRequestType.Document();
    iheDocument.setValue(document.documentData().value());
    iheDocument.setId(id);
    return iheDocument;
  }

  public static class DocumentGeneratorList extends ArrayList<DocumentGenerator> {

    private DocumentGeneratorList(List<DocumentGenerator> list) {
      super(list);
    }

    public List<ProvideAndRegisterDocumentSetRequestType.Document> iheDocuments() {
      return stream().map(DocumentGenerator::iheDocument).toList();
    }

    public List<ExtrinsicObjectType> extrinsicObjects() {
      return stream().map(DocumentGenerator::extrinsicObject).toList();
    }
  }
}
