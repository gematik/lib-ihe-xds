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

package de.gematik.epa.conversion.internal;

import static de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory.getListFromSlot;

import de.gematik.epa.conversion.internal.requests.factories.slot.SlotFactory;
import de.gematik.epa.conversion.internal.requests.factories.slot.SlotName;
import de.gematik.epa.ihe.model.Author;
import de.gematik.epa.ihe.model.simple.AuthorInstitution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ClassificationType;
import org.apache.commons.text.StringEscapeUtils;

public class AuthorUtils {

  private AuthorUtils() {}

  public static final String DEFAULT_INSTITUTION_CODE = "^^^^^&1.2.276.0.76.4.188&ISO^^^^";
  public static final String DEFAULT_LEI_CODE = "^^&1.2.276.0.76.4.16&ISO";

  public static String formatAuthorName(final Author author) {
    // Build Author Person IHE String if Information are given
    // Moved to new method in class TdToIheUtils
    return (Objects.nonNull(author.identifier()) ? author.identifier() + "^" : "^")
        + (Objects.nonNull(author.familyName()) ? author.familyName() + "^" : "^")
        + (Objects.nonNull(author.givenName()) ? author.givenName() + "^" : "^")
        + (Objects.nonNull(author.otherName()) ? author.otherName() + "^" : "^")
        + (Objects.nonNull(author.nameAffix()) ? author.nameAffix() + "^" : "^")
        + (Objects.nonNull(author.title()) ? author.title() + "^" : "^")
        + (Objects.nonNull(author.identifier()) ? DEFAULT_LEI_CODE : "");
  }

  public static List<String> formatAuthorRole(final Author author) {
    return Optional.ofNullable(author.authorRole()).stream()
        .flatMap(Collection::stream)
        .map(StringEscapeUtils::unescapeXml)
        .toList();
  }

  public static List<String> formatAuthorInstitutions(final Author author) {
    return Optional.ofNullable(author.authorInstitution()).stream()
        .flatMap(Collection::stream)
        .map(AuthorUtils::formatAuthorInstitution)
        .toList();
  }

  public static List<AuthorInstitution> toAuthorInstitution(
      ClassificationType authorClassification) {
    var institutions = getListFromSlot(authorClassification, SlotName.AUTHOR_INSTITUTION);
    var authorInstitutionList = new ArrayList<AuthorInstitution>();

    if (!institutions.isEmpty()) {
      for (String institutionValue : institutions) {
        String identifier = null;
        String name = null;
        final String[] codeArray = institutionValue.split(Pattern.quote(DEFAULT_INSTITUTION_CODE));
        if (codeArray.length >= 2) {
          identifier = codeArray[codeArray.length - 1];
          name = codeArray[0];
        }
        AuthorInstitution institution = new AuthorInstitution(name, identifier);
        authorInstitutionList.add(institution);
      }
    }
    return authorInstitutionList;
  }

  public static List<String> toAuthorRole(ClassificationType author) {
    return getListFromSlot(author, SlotName.AUTHOR_ROLE);
  }

  public static List<String> toAuthorSpecialty(ClassificationType author) {
    return getListFromSlot(author, SlotName.AUTHOR_SPECIALTY);
  }

  public static List<String> toAuthorTelecommunication(ClassificationType author) {
    return getListFromSlot(author, SlotName.AUTHOR_TELECOMMUNICATION);
  }

  public static String[] seperateAuthorName(ClassificationType author) {
    // Es gibt immer ein Namen (ein Name-Slot mit einem ValueList Eintrag)
    var authorName = SlotFactory.getValueFromSlot(author.getSlot(), SlotName.AUTHOR_PERSON);

    return authorName.split("\\^");
  }

  private static String formatAuthorInstitution(AuthorInstitution authorInstitution) {
    String authorInstitutionString = Objects.requireNonNullElse(authorInstitution.name(), "");
    // gemSpec_DM A_21209 - Author Institution must be completed with ISO Code only if the
    // Telematik ID is present
    if (Objects.nonNull(authorInstitution.identifier())
        && !authorInstitution.identifier().isBlank()) {
      authorInstitutionString += DEFAULT_INSTITUTION_CODE + authorInstitution.identifier();
    }
    return authorInstitutionString;
  }
}
