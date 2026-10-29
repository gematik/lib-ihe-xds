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
package de.gematik.epa.conversion.internal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

public class DateUtil {

  private DateUtil() {}

  private static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

  public static String now() {
    return LocalDateTime.now().format(FORMATTER);
  }

  public static String format(LocalDateTime localDateTime) {
    return localDateTime != null ? localDateTime.format(FORMATTER) : null;
  }

  // HL7 DTM: YYYY[MM[DD[hh[mm[ss]]]]], missing parts default to the start of the period
  private static final DateTimeFormatter DTM_PARSER =
      new DateTimeFormatterBuilder()
          .appendValue(ChronoField.YEAR, 4)
          .optionalStart()
          .appendValue(ChronoField.MONTH_OF_YEAR, 2)
          .optionalStart()
          .appendValue(ChronoField.DAY_OF_MONTH, 2)
          .optionalStart()
          .appendValue(ChronoField.HOUR_OF_DAY, 2)
          .optionalStart()
          .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
          .optionalStart()
          .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
          .optionalEnd()
          .optionalEnd()
          .optionalEnd()
          .optionalEnd()
          .optionalEnd()
          .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
          .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
          .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
          .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
          .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
          .toFormatter()
          .withResolverStyle(ResolverStyle.STRICT);

  public static LocalDateTime format(String dateString) {
    return LocalDateTime.parse(dateString, DTM_PARSER);
  }
}
