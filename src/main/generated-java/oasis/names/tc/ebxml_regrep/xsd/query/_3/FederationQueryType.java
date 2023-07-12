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

//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.11 at 06:21:54 PM CEST 
//


package oasis.names.tc.ebxml_regrep.xsd.query._3;

import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FederationQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FederationQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FederationQueryType")
public class FederationQueryType
    extends RegistryObjectQueryType
{


    @Override
    public FederationQueryType withSlotBranch(SlotBranchType... values) {
        if (values!= null) {
            for (SlotBranchType value: values) {
                getSlotBranch().add(value);
            }
        }
        return this;
    }

    @Override
    public FederationQueryType withSlotBranch(Collection<SlotBranchType> values) {
        if (values!= null) {
            getSlotBranch().addAll(values);
        }
        return this;
    }

    @Override
    public FederationQueryType withNameBranch(InternationalStringBranchType value) {
        setNameBranch(value);
        return this;
    }

    @Override
    public FederationQueryType withDescriptionBranch(InternationalStringBranchType value) {
        setDescriptionBranch(value);
        return this;
    }

    @Override
    public FederationQueryType withVersionInfoFilter(FilterType value) {
        setVersionInfoFilter(value);
        return this;
    }

    @Override
    public FederationQueryType withClassificationQuery(ClassificationQueryType... values) {
        if (values!= null) {
            for (ClassificationQueryType value: values) {
                getClassificationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public FederationQueryType withClassificationQuery(Collection<ClassificationQueryType> values) {
        if (values!= null) {
            getClassificationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public FederationQueryType withExternalIdentifierQuery(ExternalIdentifierQueryType... values) {
        if (values!= null) {
            for (ExternalIdentifierQueryType value: values) {
                getExternalIdentifierQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public FederationQueryType withExternalIdentifierQuery(Collection<ExternalIdentifierQueryType> values) {
        if (values!= null) {
            getExternalIdentifierQuery().addAll(values);
        }
        return this;
    }

    @Override
    public FederationQueryType withObjectTypeQuery(ClassificationNodeQueryType value) {
        setObjectTypeQuery(value);
        return this;
    }

    @Override
    public FederationQueryType withStatusQuery(ClassificationNodeQueryType value) {
        setStatusQuery(value);
        return this;
    }

    @Override
    public FederationQueryType withSourceAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getSourceAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public FederationQueryType withSourceAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getSourceAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public FederationQueryType withTargetAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getTargetAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public FederationQueryType withTargetAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getTargetAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public FederationQueryType withPrimaryFilter(FilterType value) {
        setPrimaryFilter(value);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int currentHashCode = 1;
        currentHashCode = ((currentHashCode* 31)+ super.hashCode());
        return currentHashCode;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
