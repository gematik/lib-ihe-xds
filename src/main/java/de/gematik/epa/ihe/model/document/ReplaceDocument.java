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

import de.gematik.epa.ihe.model.simple.ByteArray;

public record ReplaceDocument(
    ByteArray documentData, DocumentMetadata documentMetadata, String entryUUIDOfDocumentToReplace)
    implements DocumentInterface {

  public ReplaceDocument(
      byte[] documentData, DocumentMetadata documentMetadata, String entryUUIDOfDocumentToReplace) {
    this(ByteArray.of(documentData), documentMetadata, entryUUIDOfDocumentToReplace);
  }
}
