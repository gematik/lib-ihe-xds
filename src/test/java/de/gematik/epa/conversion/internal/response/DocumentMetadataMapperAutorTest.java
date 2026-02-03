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

import static de.gematik.epa.conversion.internal.requests.factories.slot.SlotName.AUTHOR_INSTITUTION;
import static de.gematik.epa.conversion.internal.requests.factories.slot.SlotName.AUTHOR_PERSON;
import static de.gematik.epa.conversion.internal.requests.factories.slot.SlotName.AUTHOR_ROLE;
import static de.gematik.epa.conversion.internal.requests.factories.slot.SlotName.AUTHOR_SPECIALTY;
import static de.gematik.epa.conversion.internal.response.RegistryObjectListMapper.toAuthor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.gematik.epa.conversion.internal.AuthorUtils;
import de.gematik.epa.conversion.internal.requests.factories.classification.ClassificationScheme;
import de.gematik.epa.ihe.model.Author;
import java.util.List;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;
import org.junit.jupiter.api.Test;

class DocumentMetadataMapperAutorTest extends RegistryObjectListUtils {

  private static final String INSTITUTION =
      "arztpraxis^^^^^&1.2.276.0.76.4.188&ISO^^^^1-SMC-B-Testkarte-883110000141436";
  private static final String NAME_1 =
      "165746304^Blankenburg^Sigrid^^^Dr.^^^&amp;1.2.276.0.76.4.16&amp;ISO";
  private static final String NAME_2 =
      "585476783^Rosenthal^Thomas^^^Dr.^^^&amp;1.2.276.0.76.4.16&amp;ISO";
  private static final String ROLE = "8^^^&amp;1.3.6.1.4.1.19376.3.276.1.5.13&amp;ISO";
  private static final String SPECIALTY_1 = "3^^^&1.2.276.0.76.5.492&ISO";
  private static final String SPECIALTY_2 = "130^^^&1.2.276.0.76.5.114&ISO";

  @Test
  void toAuthorTest() {
    final ExtrinsicObjectType extrinsicObjectType = createAuthors();

    final List<Author> authors =
        toAuthor(extrinsicObjectType, ClassificationScheme.DOCUMENT_ENTRY_AUTHOR);
    assertEquals(2, authors.size());
    Author authorOne = authors.get(0);
    assertEquals("Blankenburg", authorOne.familyName());
    assertEquals("", authorOne.otherName());
    assertEquals("Dr.", authorOne.title());
    assertEquals("", authorOne.nameAffix());
    assertEquals("165746304", authorOne.identifier());
    assertEquals("Sigrid", authorOne.givenName());
    assertEquals(1, authorOne.authorInstitution().size());
    assertEquals(
        "1-SMC-B-Testkarte-883110000141436", authorOne.authorInstitution().get(0).identifier());
    assertEquals("arztpraxis", authorOne.authorInstitution().get(0).name());
    assertEquals(1, authorOne.authorRole().size());
    assertEquals(ROLE, authorOne.authorRole().get(0));
    assertEquals(2, authorOne.authorSpecialty().size());
    assertEquals(SPECIALTY_1, authorOne.authorSpecialty().get(0));
    assertEquals(SPECIALTY_2, authorOne.authorSpecialty().get(1));
    assertEquals(0, authorOne.authorTelecommunication().size());
  }

  private ExtrinsicObjectType createAuthors() {
    final ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();

    final ClassificationType authorOne = createOneAuthor(NAME_1);
    final ClassificationType authorTwo = createOneAuthor(NAME_2);

    extrinsicObjectType.getClassification().add(authorOne);
    extrinsicObjectType.getClassification().add(authorTwo);
    return extrinsicObjectType;
  }

  private ClassificationType createOneAuthor(String name) {
    final ClassificationType classificationType = new ClassificationType();
    classificationType.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_AUTHOR.getUrn());
    createSlot(classificationType, AUTHOR_PERSON, name);
    createSlot(classificationType, AUTHOR_INSTITUTION, INSTITUTION);
    createSlot(classificationType, AUTHOR_ROLE, ROLE);
    createSlot(classificationType, AUTHOR_SPECIALTY, SPECIALTY_1);
    classificationType.getSlot().get(3).getValueList().getValue().add(SPECIALTY_2);

    return classificationType;
  }

  @Test
  void testSeparateAuthorNameWithNullAuthorName() {
    ClassificationType classificationType = new ClassificationType();
    String[] result = AuthorUtils.seperateAuthorName(classificationType);
    assertEquals(0, result.length, "Expected an empty array when author name is null");
  }

  // A_21209-02
  @Test
  void testVerifyAuthor() {
    final ExtrinsicObjectType extrinsicObjectType = createAuthorsTest();

    final List<Author> authors =
        toAuthor(extrinsicObjectType, ClassificationScheme.DOCUMENT_ENTRY_AUTHOR);
    assertEquals(3, authors.size());
    // Author 1
    Author authorOne = authors.get(0);
    assertEquals("Mustermann", authorOne.familyName());
    assertEquals("", authorOne.otherName());
    assertEquals("", authorOne.title());
    assertEquals("", authorOne.nameAffix());
    assertEquals("X110552837", authorOne.identifier());
    assertEquals("Erika Sophie", authorOne.givenName());

    assertEquals(1, authorOne.authorRole().size());
    assertEquals(
        "102^^^&amp;1.3.6.1.4.1.19376.3.276.1.5.14&amp;ISO", authorOne.authorRole().get(0));

    // Author 2
    Author authorTwo = authors.get(1);
    assertEquals(1, authorTwo.authorSpecialty().size());
    assertEquals("141903^^^&amp;1.2.276.0.76.5.514&amp;ISO", authorTwo.authorSpecialty().get(0));
    assertEquals(1, authorTwo.authorInstitution().size());
    assertEquals("Arztpraxis Dr. Thilo Weber", authorTwo.authorInstitution().get(0).name());
    assertNull(authorTwo.authorInstitution().get(0).identifier());

    // Author 3
    Author authorThree = authors.get(2);
    assertEquals(1, authorThree.authorInstitution().size());
    assertEquals("Arztpraxis Dr. Thilo Weber", authorThree.authorInstitution().get(0).name());
    assertEquals("1-2c47sd-e518", authorThree.authorInstitution().get(0).identifier());
  }

  private ClassificationType createAuthorWithAuthorPersonAndAuthorRole() {
    final ClassificationType classificationType = new ClassificationType();
    classificationType.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_AUTHOR.getUrn());
    createSlot(
        classificationType,
        AUTHOR_PERSON,
        "X110552837^Mustermann^Erika Sophie^^^^^^&amp;1.2.276.0.76.4.8&amp;");
    createSlot(
        classificationType, AUTHOR_ROLE, "102^^^&amp;1.3.6.1.4.1.19376.3.276.1.5.14&amp;ISO");
    return classificationType;
  }

  private ClassificationType createAuthorWithAuthorRoleSpecialityInstitution() {
    final ClassificationType classificationType = new ClassificationType();
    classificationType.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_AUTHOR.getUrn());
    createSlot(classificationType, AUTHOR_INSTITUTION, "Arztpraxis Dr. Thilo Weber");
    createSlot(classificationType, AUTHOR_ROLE, "11^^^&amp;1.3.6.1.4.1.19376.3.276.1.5.13&amp;ISO");
    createSlot(classificationType, AUTHOR_SPECIALTY, "141903^^^&amp;1.2.276.0.76.5.514&amp;ISO");
    return classificationType;
  }

  private ClassificationType createAuthorWithAuthorInstitution() {
    final ClassificationType classificationType = new ClassificationType();
    classificationType.setClassificationScheme(ClassificationScheme.DOCUMENT_ENTRY_AUTHOR.getUrn());
    createSlot(
        classificationType,
        AUTHOR_INSTITUTION,
        "Arztpraxis Dr. Thilo Weber^^^^^&1.2.276.0.76.4.188&ISO^^^^1-2c47sd-e518");
    createSlot(classificationType, AUTHOR_ROLE, "11^^^&amp;1.3.6.1.4.1.19376.3.276.1.5.13&amp;ISO");
    createSlot(classificationType, AUTHOR_SPECIALTY, "141903^^^&amp;1.2.276.0.76.5.514&amp;ISO");
    return classificationType;
  }

  private ExtrinsicObjectType createAuthorsTest() {
    final ExtrinsicObjectType extrinsicObjectType = new ExtrinsicObjectType();

    final ClassificationType authorOne = createAuthorWithAuthorPersonAndAuthorRole();
    final ClassificationType authorTwo = createAuthorWithAuthorRoleSpecialityInstitution();
    final ClassificationType authorThree = createAuthorWithAuthorInstitution();

    extrinsicObjectType.getClassification().add(authorOne);
    extrinsicObjectType.getClassification().add(authorTwo);
    extrinsicObjectType.getClassification().add(authorThree);
    return extrinsicObjectType;
  }
}
