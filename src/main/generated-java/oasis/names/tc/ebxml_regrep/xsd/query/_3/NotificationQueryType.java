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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for NotificationQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQuery" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationQueryType", propOrder = {
    "registryObjectQuery"
})
public class NotificationQueryType
    extends RegistryObjectQueryType
{

    @XmlElement(name = "RegistryObjectQuery")
    protected RegistryObjectQueryType registryObjectQuery;

    /**
     * Gets the value of the registryObjectQuery property.
     * 
     * @return
     *     possible object is
     *     {@link RegistryObjectQueryType }
     *     
     */
    public RegistryObjectQueryType getRegistryObjectQuery() {
        return registryObjectQuery;
    }

    /**
     * Sets the value of the registryObjectQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistryObjectQueryType }
     *     
     */
    public void setRegistryObjectQuery(RegistryObjectQueryType value) {
        this.registryObjectQuery = value;
    }

    public NotificationQueryType withRegistryObjectQuery(RegistryObjectQueryType value) {
        setRegistryObjectQuery(value);
        return this;
    }

    @Override
    public NotificationQueryType withSlotBranch(SlotBranchType... values) {
        if (values!= null) {
            for (SlotBranchType value: values) {
                getSlotBranch().add(value);
            }
        }
        return this;
    }

    @Override
    public NotificationQueryType withSlotBranch(Collection<SlotBranchType> values) {
        if (values!= null) {
            getSlotBranch().addAll(values);
        }
        return this;
    }

    @Override
    public NotificationQueryType withNameBranch(InternationalStringBranchType value) {
        setNameBranch(value);
        return this;
    }

    @Override
    public NotificationQueryType withDescriptionBranch(InternationalStringBranchType value) {
        setDescriptionBranch(value);
        return this;
    }

    @Override
    public NotificationQueryType withVersionInfoFilter(FilterType value) {
        setVersionInfoFilter(value);
        return this;
    }

    @Override
    public NotificationQueryType withClassificationQuery(ClassificationQueryType... values) {
        if (values!= null) {
            for (ClassificationQueryType value: values) {
                getClassificationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public NotificationQueryType withClassificationQuery(Collection<ClassificationQueryType> values) {
        if (values!= null) {
            getClassificationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public NotificationQueryType withExternalIdentifierQuery(ExternalIdentifierQueryType... values) {
        if (values!= null) {
            for (ExternalIdentifierQueryType value: values) {
                getExternalIdentifierQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public NotificationQueryType withExternalIdentifierQuery(Collection<ExternalIdentifierQueryType> values) {
        if (values!= null) {
            getExternalIdentifierQuery().addAll(values);
        }
        return this;
    }

    @Override
    public NotificationQueryType withObjectTypeQuery(ClassificationNodeQueryType value) {
        setObjectTypeQuery(value);
        return this;
    }

    @Override
    public NotificationQueryType withStatusQuery(ClassificationNodeQueryType value) {
        setStatusQuery(value);
        return this;
    }

    @Override
    public NotificationQueryType withSourceAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getSourceAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public NotificationQueryType withSourceAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getSourceAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public NotificationQueryType withTargetAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getTargetAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public NotificationQueryType withTargetAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getTargetAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public NotificationQueryType withPrimaryFilter(FilterType value) {
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
        final NotificationQueryType that = ((NotificationQueryType) object);
        {
            RegistryObjectQueryType leftRegistryObjectQuery;
            leftRegistryObjectQuery = this.getRegistryObjectQuery();
            RegistryObjectQueryType rightRegistryObjectQuery;
            rightRegistryObjectQuery = that.getRegistryObjectQuery();
            if (this.registryObjectQuery!= null) {
                if (that.registryObjectQuery!= null) {
                    if (!leftRegistryObjectQuery.equals(rightRegistryObjectQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.registryObjectQuery!= null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int currentHashCode = 1;
        currentHashCode = ((currentHashCode* 31)+ super.hashCode());
        {
            currentHashCode = (currentHashCode* 31);
            RegistryObjectQueryType theRegistryObjectQuery;
            theRegistryObjectQuery = this.getRegistryObjectQuery();
            if (this.registryObjectQuery!= null) {
                currentHashCode += theRegistryObjectQuery.hashCode();
            }
        }
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
