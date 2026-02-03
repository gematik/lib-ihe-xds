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
package de.gematik.epa.conversion.internal.requests.factories.slot;

import de.gematik.epa.conversion.internal.DateUtil;
import de.gematik.epa.ihe.model.document.DocumentInterface;
import java.util.List;
import java.util.Objects;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ExtrinsicObjectType;

public final class ExtrinsicObjectSlotFactory {

  private ExtrinsicObjectSlotFactory() {}

  public static void createSlotTypes(
      ExtrinsicObjectType extrinsicObject, DocumentInterface originalDocument) {

    var documentMetadata = originalDocument.documentMetadata();
    var creationTime = DateUtil.format(documentMetadata.creationTime());
    var serviceStartTime = DateUtil.format(documentMetadata.serviceStartTime());
    var serviceStopTime = DateUtil.format(documentMetadata.serviceStopTime());
    var slots =
        new java.util.ArrayList<>(
            List.of(
                SlotFactory.slotIf(SlotName.CREATION_TIME, Objects::nonNull, creationTime),
                SlotFactory.slotIf(
                    SlotName.LANGUAGE_CODE, Objects::nonNull, documentMetadata.languageCode()),
                SlotFactory.slotIf(SlotName.URI, Objects::nonNull, documentMetadata.uri()),
                SlotFactory.slotIf(
                    SlotName.REFERENCE_ID_LIST,
                    Objects::nonNull,
                    documentMetadata.referenceIdList()),
                SlotFactory.slotIf(SlotName.SERVICE_START_TIME, Objects::nonNull, serviceStartTime),
                SlotFactory.slotIf(SlotName.SERVICE_STOP_TIME, Objects::nonNull, serviceStopTime),
                SlotFactory.slotIf(
                    SlotName.SOURCE_PATIENT_ID,
                    Objects::nonNull,
                    documentMetadata.sourcePatientId())));
    slots.removeIf(slotType1 -> slotType1.equals(SlotFactory.REMOVE_ME));
    extrinsicObject.getSlot().addAll(slots);
  }
}
