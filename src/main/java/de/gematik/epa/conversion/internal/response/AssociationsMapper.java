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

import de.gematik.epa.ihe.model.simple.Association;
import jakarta.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AssociationType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.IdentifiableType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectListType;

public class AssociationsMapper {

  private AssociationsMapper() {}

  public static List<Association> mapAssociations(AdhocQueryResponse adhocQueryResponse) {
    final RegistryObjectListType registryObjectList = adhocQueryResponse.getRegistryObjectList();
    var associationList = new ArrayList<Association>();
    if (registryObjectList != null) {
      fillAssociations(registryObjectList.getIdentifiable(), associationList);
    }

    return associationList.isEmpty() ? null : associationList;
  }

  private static void fillAssociations(
      List<JAXBElement<? extends IdentifiableType>> identifiable,
      List<Association> associationList) {
    final List<JAXBElement<? extends IdentifiableType>> associationObjectList =
        identifiable.stream()
            .filter(d -> d.getValue().getClass().equals(AssociationType1.class))
            .toList();
    for (JAXBElement<? extends IdentifiableType> jaxbElement : associationObjectList) {
      final AssociationType1 value = (AssociationType1) jaxbElement.getValue();
      Association association =
          new Association(
              associationId(value),
              associationType(value),
              sourceObject(value),
              targetObject(value));
      associationList.add(association);
    }
  }

  static String associationId(AssociationType1 value) {
    return value.getId();
  }

  static String associationType(AssociationType1 value) {
    return value.getAssociationType();
  }

  static String sourceObject(AssociationType1 value) {
    return value.getSourceObject();
  }

  static String targetObject(AssociationType1 value) {
    return value.getTargetObject();
  }
}
