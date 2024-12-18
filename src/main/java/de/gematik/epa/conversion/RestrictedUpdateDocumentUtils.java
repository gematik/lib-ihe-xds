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

package de.gematik.epa.conversion;

import static de.gematik.epa.conversion.ProvideAndRegisterUtils.createExtrinsicObjectsRMU;
import static de.gematik.epa.conversion.ProvideAndRegisterUtils.createSubmissionSetRegistryPackage;

import de.gematik.epa.conversion.internal.AssociationGenerator;
import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.ihe.model.document.RestrictedUpdateDocument;
import de.gematik.epa.ihe.model.request.SubmissionRequestInterface;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import lombok.experimental.UtilityClass;
import oasis.names.tc.ebxml_regrep.xsd.lcm._3.SubmitObjectsRequest;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryPackageType;

@UtilityClass
public class RestrictedUpdateDocumentUtils {

  public static SubmitObjectsRequest toUpdateDocumentSetRequest(
      SubmissionRequestInterface<RestrictedUpdateDocument> submissionRequest) {
    var docGenerators =
        DocumentGenerator.generators(submissionRequest.documents(), submissionRequest.insurantId());

    return createSubmitObjectsRequest(submissionRequest, docGenerators);
  }

  private static SubmitObjectsRequest createSubmitObjectsRequest(
      SubmissionRequestInterface<RestrictedUpdateDocument> submissionRequest,
      DocumentGenerator.DocumentGeneratorList docGenerators) {

    var submitObjectRequest = new SubmitObjectsRequest();
    var registryObjectList = new RegistryObjectListType();
    submitObjectRequest.setRegistryObjectList(registryObjectList);
    registryObjectList.getIdentifiable().addAll(createExtrinsicObjectsRMU(docGenerators));

    var submissionSetRegistryPackage = createSubmissionSetRegistryPackage(submissionRequest);
    registryObjectList
        .getIdentifiable()
        .addAll(
            createSubmissionSetUpdateDocumentAssociations(
                submissionSetRegistryPackage, registryObjectList));
    registryObjectList
        .getIdentifiable()
        .add(
            0,
            de.gematik.epa.conversion.internal.requests.RegistryPackageGenerator
                .toRegistryPackageJaxbElement(submissionSetRegistryPackage));
    return submitObjectRequest;
  }

  public static List<JAXBElement<AssociationType1>> createSubmissionSetUpdateDocumentAssociations(
      RegistryPackageType submissionSet, RegistryObjectListType registryObjectList) {
    return registryObjectList.getIdentifiable().stream()
        .map(JAXBElement::getValue)
        .map(
            identifiable -> {
              var association =
                  AssociationGenerator.createNewMemberUpdateDocumentAssociation(
                      identifiable.getId());
              association.setSourceObject(submissionSet.getId());
              return association;
            })
        .map(AssociationGenerator::toAssociationJaxbElement)
        .toList();
  }
}
