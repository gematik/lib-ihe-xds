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
package de.gematik.epa.conversion.internal.requests.factories.classification;

import de.gematik.epa.conversion.internal.enumerated.DynamicFolderCode;
import de.gematik.epa.ihe.model.simple.FolderMetadata;
import de.gematik.epa.ihe.model.simple.SubmissionSetMetadata;
import java.util.Optional;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

public class RegistryPackageTypeClassificationFactory {

  private RegistryPackageTypeClassificationFactory() {}

  public static void createSubmissionSetClassifications(
      SubmissionSetMetadata metadata, RegistryPackageType registryPackage) {
    metadata
        .authors()
        .forEach(
            author ->
                SharedClassificationFactory.createAuthorClassification(
                    author, registryPackage, ClassificationScheme.SUBMISSION_SET_AUTHOR));
    createSubmissionSetIdClassification(registryPackage);
  }

  public static void createFolderClassifications(
      FolderMetadata metadata, RegistryPackageType registryPackage) {
    createFolderIdClassification(registryPackage);
    createFolderCodeClassifications(metadata, registryPackage);
  }

  public static void createSubmissionSetIdClassification(RegistryPackageType registryPackage) {
    createRegistryTypeClassification(
        registryPackage, ClassificationNode.SUBMISSION_SET_ID_CLASSIFICATION);
  }

  public static void createFolderIdClassification(RegistryPackageType registryPackage) {
    createRegistryTypeClassification(registryPackage, ClassificationNode.FOLDER_ID_CLASSIFICATION);
  }

  // region private

  private static void createRegistryTypeClassification(
      RegistryPackageType registryPackage, ClassificationNode idClassification) {
    var newClassification = SharedClassificationFactory.createNewClassification(registryPackage);
    newClassification.setClassificationNode(idClassification.getUrn());

    registryPackage.getClassification().add(newClassification);
  }

  private static void createFolderCodeClassifications(
      FolderMetadata metadata, RegistryPackageType registryPackage) {
    Optional.ofNullable(metadata.codeList())
        .ifPresent(
            folderCodeList ->
                folderCodeList.forEach(
                    folderCodeValue -> {
                      var classification =
                          SharedClassificationFactory.createCodeClassification(
                              registryPackage,
                              ClassificationScheme.FOLDER_LIST,
                              DynamicFolderCode.fromValue(folderCodeValue));
                      registryPackage.getClassification().add(classification);
                    }));
  }

  // endregion private
}
