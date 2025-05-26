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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.conversion.internal.requests.DocumentGenerator;
import de.gematik.epa.ihe.model.request.DocumentSubmissionRequest;
import de.gematik.epa.unit.util.ResourceLoader;
import jakarta.xml.bind.JAXBElement;
import java.util.List;
import java.util.Objects;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;

public abstract class AbstractRegistryObjectTest {

  DocumentSubmissionRequest documentSubmissionRequest;
  DocumentGenerator.DocumentGeneratorList documentGenerators;

  public void createSubmissionRequest(String template) {
    documentSubmissionRequest = ResourceLoader.documentSubmissionRequest(template);
    documentGenerators =
        DocumentGenerator.generators(
            documentSubmissionRequest.documents(), documentSubmissionRequest.insurantId());
  }

  public List<JAXBElement<? extends RegistryObjectType>> filter(
      List<JAXBElement<? extends RegistryObjectType>> folderAndAssociations, String type) {
    return folderAndAssociations.stream()
        .filter(fa -> Objects.equals(fa.getName().getLocalPart(), type))
        .toList();
  }

  public void assertHomeCommunityIdIsNull(RegistryObjectType registryObjectType) {
    assertNull(registryObjectType.getHome());
  }

  public void assertName(RegistryObjectType registryObjectType, String expectedName) {
    InternationalStringType name = registryObjectType.getName();
    assertNotNull(name);
    assertEquals(expectedName, name.getLocalizedString().get(0).getValue());
  }

  public void assertDescription(RegistryObjectType registryObjectType, String expectedDescription) {
    InternationalStringType name = registryObjectType.getDescription();
    assertNotNull(name);
    assertEquals(expectedDescription, name.getLocalizedString().get(0).getValue());
  }
}
