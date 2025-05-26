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
package de.gematik.epa.conversion;

import de.gematik.epa.ihe.model.request.DeleteObjectsRequest;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.lcm._3.RemoveObjectsRequest;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectRefListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectRefType;

@UtilityClass
public class DeleteObjectsUtils {

  /**
   * Convert a {@link DeleteObjectsRequest} as defined by this lib into an IHE {@link
   * RemoveObjectsRequest}.<br>
   * Only the ObjectRefList will be filled with the provided UUIDs, no slotList or adhoc query will
   * be provided.
   *
   * @param deleteObjectsRequest the input data
   * @return {@link RemoveObjectsRequest}
   */
  public static RemoveObjectsRequest toRemoveObjectsRequest(
      DeleteObjectsRequest deleteObjectsRequest) {

    var objRefList = new ObjectRefListType();

    var objRefs =
        deleteObjectsRequest.entryUUIDs().stream().map(DeleteObjectsUtils::toObjectRef).toList();

    objRefList.withObjectRef(objRefs);

    var removeObjectsRequest = new RemoveObjectsRequest();
    removeObjectsRequest.setObjectRefList(objRefList);
    return removeObjectsRequest;
  }

  private static ObjectRefType toObjectRef(String id) {
    return new ObjectRefType().withId(id);
  }
}
