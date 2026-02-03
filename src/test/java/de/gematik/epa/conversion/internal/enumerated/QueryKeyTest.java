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
package de.gematik.epa.conversion.internal.enumerated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.gematik.epa.ihe.model.query.QueryKey;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class QueryKeyTest {

  @Test
  void testXDSDocumentEntryStatusFromValue() {
    assertEquals(QueryKey.XDS_DOCUMENT_ENTRY_STATUS, QueryKey.fromValue("$XDSDocumentEntryStatus"));
    assertEquals(QueryKey.XDS_DOCUMENT_ENTRY_STATUS, QueryKey.fromValue("XDSDocumentEntryStatus"));
    assertThrows(NoSuchElementException.class, () -> QueryKey.fromValue("invalid"));
  }
}
