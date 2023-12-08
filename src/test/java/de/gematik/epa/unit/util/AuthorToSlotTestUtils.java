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

package de.gematik.epa.unit.util;

import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getClassificationList;
import static de.gematik.epa.unit.util.GetXDSAttributesUtil.getSlotFromAuthorClassification;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.gematik.epa.conversion.internal.AuthorUtils;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.Author;
import java.util.ArrayList;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.RegistryObjectType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;

public class AuthorToSlotTestUtils {

  public static void assertAuthor(
      RegistryObjectType objectType, Author author, String urn, int expectedNumberOfAuthors) {
    final List<ClassificationType> authorClassification = getClassificationList(objectType, urn);
    assertEquals(expectedNumberOfAuthors, authorClassification.size());
    assertAuthorPerson(objectType, author, urn);
    assertAuthorRole(objectType, author, urn);
    assertAuthorInstitution(objectType, author, urn);
    assertAuthorSpeciality(objectType, author, urn);
    assertAuthorTelecommunication(objectType, author, urn);
  }

  private static void assertAuthorPerson(
      RegistryObjectType objectType, Author author, String classificationUrn) {
    SlotType1 slotAuthorPerson =
        getSlotFromAuthorClassification(
            objectType, SlotName.AUTHOR_PERSON.getName(), classificationUrn);
    assertNotNull(slotAuthorPerson);
    // added two authors in json
    String authorPerson = slotAuthorPerson.getValueList().getValue().get(0);
    String expectedPerson = author.formatted();
    assertEquals(expectedPerson, authorPerson);
  }

  private static void assertAuthorInstitution(
      RegistryObjectType extrinsicObjectType, Author author, String classificationUrn) {
    SlotType1 slotAuthorInstitution =
        getSlotFromAuthorClassification(
            extrinsicObjectType, SlotName.AUTHOR_INSTITUTION.getName(), classificationUrn);
    assertNotNull(slotAuthorInstitution);

    List<String> actualAuthorInstitution = slotAuthorInstitution.getValueList().getValue();
    String authorInstitutionName = author.authorInstitution().get(0).name();
    String authorInstitutionIdentifier = author.authorInstitution().get(0).identifier();
    String authInstitution =
        authorInstitutionName + AuthorUtils.DEFAULT_INSTITUTION_CODE + authorInstitutionIdentifier;

    List<String> expectedAuthorInstitution = new ArrayList<>(List.of(authInstitution));

    assertTrue(
        expectedAuthorInstitution.containsAll(actualAuthorInstitution)
            && actualAuthorInstitution.containsAll(expectedAuthorInstitution));
  }

  private static void assertAuthorRole(
      RegistryObjectType objectType, Author author, String classificationUrn) {
    SlotType1 slotAuthorRole =
        getSlotFromAuthorClassification(
            objectType, SlotName.AUTHOR_ROLE.getName(), classificationUrn);
    assertNotNull(slotAuthorRole);

    List<String> authorRoleList = slotAuthorRole.getValueList().getValue();
    List<String> expectedRoleList = author.authorRole();
    assertTrue(
        expectedRoleList.containsAll(authorRoleList)
            && authorRoleList.containsAll(expectedRoleList));
  }

  private static void assertAuthorSpeciality(
      RegistryObjectType objectType, Author author, String classificationUrn) {
    SlotType1 slotAuthorSpeciality =
        getSlotFromAuthorClassification(
            objectType, SlotName.AUTHOR_SPECIALTY.getName(), classificationUrn);
    if (slotAuthorSpeciality != null) {
      List<String> authorSpecialityList = slotAuthorSpeciality.getValueList().getValue();
      List<String> expectedSpecialityList = author.authorSpecialty();
      assertTrue(
          expectedSpecialityList.containsAll(authorSpecialityList)
              && authorSpecialityList.containsAll(expectedSpecialityList));
    }
  }

  private static void assertAuthorTelecommunication(
      RegistryObjectType objectType, Author author, String classificationUrn) {
    SlotType1 slotAuthorTelecommunication =
        getSlotFromAuthorClassification(
            objectType, SlotName.AUTHOR_TELECOMMUNICATION.getName(), classificationUrn);
    if (slotAuthorTelecommunication != null) {
      List<String> authorTelecommunicationList =
          slotAuthorTelecommunication.getValueList().getValue();
      List<String> expectedTelecommunicationList = author.authorTelecommunication();
      assertTrue(
          expectedTelecommunicationList.containsAll(authorTelecommunicationList)
              && authorTelecommunicationList.containsAll(expectedTelecommunicationList));
    }
  }
}
