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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServiceBindingQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceBindingQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}ServiceQuery" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}SpecificationLinkQuery" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TargetBindingQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}ServiceBindingQueryType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceBindingQueryType", propOrder = {
    "serviceQuery",
    "specificationLinkQuery",
    "targetBindingQuery"
})
public class ServiceBindingQueryType
    extends RegistryObjectQueryType
{

    @XmlElement(name = "ServiceQuery")
    protected ServiceQueryType serviceQuery;
    @XmlElement(name = "SpecificationLinkQuery")
    protected List<SpecificationLinkQueryType> specificationLinkQuery;
    @XmlElement(name = "TargetBindingQuery")
    protected ServiceBindingQueryType targetBindingQuery;

    /**
     * Gets the value of the serviceQuery property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryType }
     *     
     */
    public ServiceQueryType getServiceQuery() {
        return serviceQuery;
    }

    /**
     * Sets the value of the serviceQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryType }
     *     
     */
    public void setServiceQuery(ServiceQueryType value) {
        this.serviceQuery = value;
    }

    /**
     * Gets the value of the specificationLinkQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the specificationLinkQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationLinkQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.query._3.SpecificationLinkQueryType }
     * 
     * 
     */
    public List<SpecificationLinkQueryType> getSpecificationLinkQuery() {
        if (specificationLinkQuery == null) {
            specificationLinkQuery = new ArrayList<SpecificationLinkQueryType>();
        }
        return this.specificationLinkQuery;
    }

    /**
     * Gets the value of the targetBindingQuery property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceBindingQueryType }
     *     
     */
    public ServiceBindingQueryType getTargetBindingQuery() {
        return targetBindingQuery;
    }

    /**
     * Sets the value of the targetBindingQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceBindingQueryType }
     *     
     */
    public void setTargetBindingQuery(ServiceBindingQueryType value) {
        this.targetBindingQuery = value;
    }

    public ServiceBindingQueryType withServiceQuery(ServiceQueryType value) {
        setServiceQuery(value);
        return this;
    }

    public ServiceBindingQueryType withSpecificationLinkQuery(SpecificationLinkQueryType... values) {
        if (values!= null) {
            for (SpecificationLinkQueryType value: values) {
                getSpecificationLinkQuery().add(value);
            }
        }
        return this;
    }

    public ServiceBindingQueryType withSpecificationLinkQuery(Collection<SpecificationLinkQueryType> values) {
        if (values!= null) {
            getSpecificationLinkQuery().addAll(values);
        }
        return this;
    }

    public ServiceBindingQueryType withTargetBindingQuery(ServiceBindingQueryType value) {
        setTargetBindingQuery(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withSlotBranch(SlotBranchType... values) {
        if (values!= null) {
            for (SlotBranchType value: values) {
                getSlotBranch().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withSlotBranch(Collection<SlotBranchType> values) {
        if (values!= null) {
            getSlotBranch().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withNameBranch(InternationalStringBranchType value) {
        setNameBranch(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withDescriptionBranch(InternationalStringBranchType value) {
        setDescriptionBranch(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withVersionInfoFilter(FilterType value) {
        setVersionInfoFilter(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withClassificationQuery(ClassificationQueryType... values) {
        if (values!= null) {
            for (ClassificationQueryType value: values) {
                getClassificationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withClassificationQuery(Collection<ClassificationQueryType> values) {
        if (values!= null) {
            getClassificationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withExternalIdentifierQuery(ExternalIdentifierQueryType... values) {
        if (values!= null) {
            for (ExternalIdentifierQueryType value: values) {
                getExternalIdentifierQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withExternalIdentifierQuery(Collection<ExternalIdentifierQueryType> values) {
        if (values!= null) {
            getExternalIdentifierQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withObjectTypeQuery(ClassificationNodeQueryType value) {
        setObjectTypeQuery(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withStatusQuery(ClassificationNodeQueryType value) {
        setStatusQuery(value);
        return this;
    }

    @Override
    public ServiceBindingQueryType withSourceAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getSourceAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withSourceAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getSourceAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withTargetAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getTargetAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withTargetAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getTargetAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingQueryType withPrimaryFilter(FilterType value) {
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
        final ServiceBindingQueryType that = ((ServiceBindingQueryType) object);
        {
            ServiceQueryType leftServiceQuery;
            leftServiceQuery = this.getServiceQuery();
            ServiceQueryType rightServiceQuery;
            rightServiceQuery = that.getServiceQuery();
            if (this.serviceQuery!= null) {
                if (that.serviceQuery!= null) {
                    if (!leftServiceQuery.equals(rightServiceQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.serviceQuery!= null) {
                    return false;
                }
            }
        }
        {
            List<SpecificationLinkQueryType> leftSpecificationLinkQuery;
            leftSpecificationLinkQuery = (((this.specificationLinkQuery!= null)&&(!this.specificationLinkQuery.isEmpty()))?this.getSpecificationLinkQuery():null);
            List<SpecificationLinkQueryType> rightSpecificationLinkQuery;
            rightSpecificationLinkQuery = (((that.specificationLinkQuery!= null)&&(!that.specificationLinkQuery.isEmpty()))?that.getSpecificationLinkQuery():null);
            if ((this.specificationLinkQuery!= null)&&(!this.specificationLinkQuery.isEmpty())) {
                if ((that.specificationLinkQuery!= null)&&(!that.specificationLinkQuery.isEmpty())) {
                    if (!leftSpecificationLinkQuery.equals(rightSpecificationLinkQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.specificationLinkQuery!= null)&&(!that.specificationLinkQuery.isEmpty())) {
                    return false;
                }
            }
        }
        {
            ServiceBindingQueryType leftTargetBindingQuery;
            leftTargetBindingQuery = this.getTargetBindingQuery();
            ServiceBindingQueryType rightTargetBindingQuery;
            rightTargetBindingQuery = that.getTargetBindingQuery();
            if (this.targetBindingQuery!= null) {
                if (that.targetBindingQuery!= null) {
                    if (!leftTargetBindingQuery.equals(rightTargetBindingQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.targetBindingQuery!= null) {
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
            ServiceQueryType theServiceQuery;
            theServiceQuery = this.getServiceQuery();
            if (this.serviceQuery!= null) {
                currentHashCode += theServiceQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<SpecificationLinkQueryType> theSpecificationLinkQuery;
            theSpecificationLinkQuery = (((this.specificationLinkQuery!= null)&&(!this.specificationLinkQuery.isEmpty()))?this.getSpecificationLinkQuery():null);
            if ((this.specificationLinkQuery!= null)&&(!this.specificationLinkQuery.isEmpty())) {
                currentHashCode += theSpecificationLinkQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            ServiceBindingQueryType theTargetBindingQuery;
            theTargetBindingQuery = this.getTargetBindingQuery();
            if (this.targetBindingQuery!= null) {
                currentHashCode += theTargetBindingQuery.hashCode();
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
