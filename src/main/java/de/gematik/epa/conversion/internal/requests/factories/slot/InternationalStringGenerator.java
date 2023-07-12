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

package de.gematik.epa.conversion.internal.requests.factories.slot;

import lombok.NonNull;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.LocalizedStringType;

public class InternationalStringGenerator {

  public static final String UTF8_CHARSET = "UTF-8";

  public static final String DE_LANGUAGE = "de-DE";

  private InternationalStringGenerator() {}

  public static InternationalStringType generateInternationalString(@NonNull String value) {
    var localizedString = generateLocalizedString(value, UTF8_CHARSET, DE_LANGUAGE);

    return new InternationalStringType().withLocalizedString(localizedString);
  }

  public static LocalizedStringType generateLocalizedString(
      @NonNull String value, @NonNull String charset, @NonNull String language) {
    var localizedString = new LocalizedStringType();
    localizedString.setValue(value);
    localizedString.setCharset(charset);
    localizedString.setLang(language);
    return localizedString;
  }
}
