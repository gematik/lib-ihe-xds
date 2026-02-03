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
package de.gematik.epa.conversion.internal.response;

import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationNode;
import de.gematik.epa.conversion.internal.requests.factories.externalidentifier.ExternalIdentifierScheme;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import jakarta.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.IdentifiableType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

public class FolderListMapper {

  private FolderListMapper() {}

  public static List<FolderMetadata> mapFolders(AdhocQueryResponse adhocQueryResponse) {
    final RegistryObjectListType registryObjectList = adhocQueryResponse.getRegistryObjectList();
    var folderMetadataList = new ArrayList<FolderMetadata>();
    if (registryObjectList != null) {
      fillFolderMetadataList(registryObjectList.getIdentifiable(), folderMetadataList);
    }

    return folderMetadataList.isEmpty() ? null : folderMetadataList;
  }

  private static void fillFolderMetadataList(
      List<JAXBElement<? extends IdentifiableType>> identifiable,
      List<FolderMetadata> folderMetadataList) {

    var registryPackage =
        RegistryObjectListMapper.getRegistryPackageByClassification(
            identifiable, ClassificationNode.FOLDER_ID_CLASSIFICATION);
    for (JAXBElement<? extends IdentifiableType> jaxbElement : registryPackage) {
      final RegistryPackageType value = (RegistryPackageType) jaxbElement.getValue();
      FolderMetadata folderMetadata =
          new FolderMetadata(
              RegistryObjectListMapper.comments(value),
              RegistryObjectListMapper.codeList(value),
              RegistryObjectListMapper.lastUpdateTime(value),
              RegistryObjectListMapper.title(value),
              RegistryObjectListMapper.externalIdentifierValue(
                  value, ExternalIdentifierScheme.FOLDER_UNIQUE),
              RegistryObjectListMapper.entryUUID(value),
              RegistryObjectListMapper.availabilityStatus(value));
      folderMetadataList.add(folderMetadata);
    }
  }
}
