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

import de.gematik.epa.ihe.model.request.FindRequest;
import java.math.BigInteger;
import java.util.List;
import lombok.NonNull;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.ResponseOptionType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AdhocQueryType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;

@SuppressWarnings("unused")
public class AdhocQueryUtils {

  private AdhocQueryUtils() {}

  public static AdhocQueryRequest generateFindRequestBody(FindRequest request) {
    var result = new AdhocQueryRequest();
    result.setFederated(false);
    result.setStartIndex(BigInteger.ZERO);
    result.setMaxResults(BigInteger.valueOf(-1));
    result.setResponseOption(addResponseOptions(request));
    var adhocQuery = createAdhocQuery(request);
    result.setAdhocQuery(adhocQuery);
    request
        .queryMetadata()
        .forEach(
            (key, value) -> {
              var slot = new SlotType1();
              var valueListType = new ValueListType();
              slot.setName(key.getKeyword());
              valueListType.getValue().addAll(getFormattedValues(value));
              slot.setValueList(valueListType);
              adhocQuery.getSlot().add(slot);
            });
    adhocQuery.getSlot().addAll(request.query().fillPatientIdSlot(request));
    return result;
  }

  public static List<String> getFormattedValues(List<String> value) {
    return value.stream().map(AdhocQueryUtils::formatIfUnformattedListElement).toList();
  }

  private static ResponseOptionType addResponseOptions(FindRequest request) {
    var responseOption = new ResponseOptionType();
    responseOption.setReturnType(request.returnType().getKeyword());
    responseOption.setReturnComposedObjects(true);
    return responseOption;
  }

  private static AdhocQueryType createAdhocQuery(FindRequest request) {
    var adhocQuery = new AdhocQueryType();
    adhocQuery.setId(request.query().getUrn());
    adhocQuery.setHome(request.recordIdentifier().getHomeCommunityId());
    return adhocQuery;
  }

  private static String formatAsList(@NonNull String value) {
    return String.format("('%s')", value);
  }

  public static String formatIfUnformattedListElement(@NonNull String value) {
    return isFormattedAsList(value) ? value : formatAsList(value);
  }

  public static boolean isFormattedAsList(@NonNull String value) {
    var trimmedValue = value.trim();
    if (trimmedValue.startsWith("(") || trimmedValue.endsWith(")")) {
      if ((trimmedValue.startsWith("('") && trimmedValue.endsWith("')"))) {
        return true;
      } else {
        throw new IllegalArgumentException(
            String.format(
                "The parameter value is ill formatted. It either is bracketed like \"('value')\" or it is not bracketed like \"value\"! But the received parameter value is \"%s\"",
                value));
      }
    } else {
      return false;
    }
  }
}
