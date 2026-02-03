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
package de.gematik.epa.conversion.internal.requests.factories.classification;

import static de.gematik.epa.conversion.internal.AuthorUtils.formatAuthorInstitutions;
import static de.gematik.epa.conversion.internal.AuthorUtils.formatAuthorRole;

import de.gematik.epa.conversion.internal.enumerated.CodeInterface;
import de.gematik.epa.conversion.internal.requests.factories.OasisObjectType;
import de.gematik.epa.conversion.internal.requests.factories.slot.InternationalStringGenerator;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.Author;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;

public class SharedClassificationFactory {

  private SharedClassificationFactory() {}

  public static ClassificationType createCodeClassification(
      RegistryObjectType classifiedObject,
      ClassificationScheme classificationScheme,
      CodeInterface code) {
    var classification = createNewClassification(classifiedObject);

    classification.setClassificationScheme(classificationScheme.getUrn());
    classification.setNodeRepresentation(code.getValue());

    classification.getSlot().add(SlotFactory.slot("codingScheme", code.getCodingScheme()));
    classification.setName(
        InternationalStringGenerator.generateInternationalString(code.getName()));

    return classification;
  }

  public static ClassificationType createNewClassification(RegistryObjectType classifiedObject) {
    var classification = new ClassificationType();
    classification.setId(UUID.randomUUID().toString());
    classification.setObjectType(OasisObjectType.CLASSIFICATION.getValue());
    classification.setClassifiedObject(classifiedObject.getId());

    return classification;
  }

  static void createAuthorClassification(
      Author author, RegistryObjectType registryObject, ClassificationScheme scheme) {
    var classification = createNewClassification(registryObject);
    classification.setClassificationScheme(scheme.getUrn());

    var slots =
        new java.util.ArrayList<>(
            List.of(
                SlotFactory.slotIf(SlotName.AUTHOR_PERSON, Objects::nonNull, author.formatted()),
                SlotFactory.slotIf(
                    SlotName.AUTHOR_ROLE, strings -> !strings.isEmpty(), formatAuthorRole(author)),
                SlotFactory.slotIf(
                    SlotName.AUTHOR_INSTITUTION,
                    strings -> !strings.isEmpty(),
                    formatAuthorInstitutions(author)),
                SlotFactory.slotIf(
                    SlotName.AUTHOR_SPECIALTY,
                    strings -> !strings.isEmpty(),
                    author.authorSpecialty()),
                SlotFactory.slotIf(
                    SlotName.AUTHOR_TELECOMMUNICATION,
                    strings -> !strings.isEmpty(),
                    author.authorTelecommunication())));
    slots.removeIf(slotType1 -> slotType1.equals(SlotFactory.REMOVE_ME));
    classification.getSlot().addAll(slots);
    registryObject.getClassification().add(classification);
  }
}
