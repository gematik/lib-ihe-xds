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
 * <p>Java class for ClassificationNodeQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationNodeQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ParentQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType" minOccurs="0"/&gt;
 *         &lt;element name="ChildrenQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}ClassificationNodeQueryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationNodeQueryType", propOrder = {
    "parentQuery",
    "childrenQuery"
})
public class ClassificationNodeQueryType
    extends RegistryObjectQueryType
{

    @XmlElement(name = "ParentQuery")
    protected RegistryObjectQueryType parentQuery;
    @XmlElement(name = "ChildrenQuery")
    protected List<ClassificationNodeQueryType> childrenQuery;

    /**
     * Gets the value of the parentQuery property.
     * 
     * @return
     *     possible object is
     *     {@link RegistryObjectQueryType }
     *     
     */
    public RegistryObjectQueryType getParentQuery() {
        return parentQuery;
    }

    /**
     * Sets the value of the parentQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistryObjectQueryType }
     *     
     */
    public void setParentQuery(RegistryObjectQueryType value) {
        this.parentQuery = value;
    }

    /**
     * Gets the value of the childrenQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the childrenQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildrenQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassificationNodeQueryType }
     * 
     * 
     */
    public List<ClassificationNodeQueryType> getChildrenQuery() {
        if (childrenQuery == null) {
            childrenQuery = new ArrayList<ClassificationNodeQueryType>();
        }
        return this.childrenQuery;
    }

    public ClassificationNodeQueryType withParentQuery(RegistryObjectQueryType value) {
        setParentQuery(value);
        return this;
    }

    public ClassificationNodeQueryType withChildrenQuery(ClassificationNodeQueryType... values) {
        if (values!= null) {
            for (ClassificationNodeQueryType value: values) {
                getChildrenQuery().add(value);
            }
        }
        return this;
    }

    public ClassificationNodeQueryType withChildrenQuery(Collection<ClassificationNodeQueryType> values) {
        if (values!= null) {
            getChildrenQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withSlotBranch(SlotBranchType... values) {
        if (values!= null) {
            for (SlotBranchType value: values) {
                getSlotBranch().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withSlotBranch(Collection<SlotBranchType> values) {
        if (values!= null) {
            getSlotBranch().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withNameBranch(InternationalStringBranchType value) {
        setNameBranch(value);
        return this;
    }

    @Override
    public ClassificationNodeQueryType withDescriptionBranch(InternationalStringBranchType value) {
        setDescriptionBranch(value);
        return this;
    }

    @Override
    public ClassificationNodeQueryType withVersionInfoFilter(FilterType value) {
        setVersionInfoFilter(value);
        return this;
    }

    @Override
    public ClassificationNodeQueryType withClassificationQuery(ClassificationQueryType... values) {
        if (values!= null) {
            for (ClassificationQueryType value: values) {
                getClassificationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withClassificationQuery(Collection<ClassificationQueryType> values) {
        if (values!= null) {
            getClassificationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withExternalIdentifierQuery(ExternalIdentifierQueryType... values) {
        if (values!= null) {
            for (ExternalIdentifierQueryType value: values) {
                getExternalIdentifierQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withExternalIdentifierQuery(Collection<ExternalIdentifierQueryType> values) {
        if (values!= null) {
            getExternalIdentifierQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withObjectTypeQuery(ClassificationNodeQueryType value) {
        setObjectTypeQuery(value);
        return this;
    }

    @Override
    public ClassificationNodeQueryType withStatusQuery(ClassificationNodeQueryType value) {
        setStatusQuery(value);
        return this;
    }

    @Override
    public ClassificationNodeQueryType withSourceAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getSourceAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withSourceAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getSourceAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withTargetAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getTargetAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withTargetAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getTargetAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeQueryType withPrimaryFilter(FilterType value) {
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
        final ClassificationNodeQueryType that = ((ClassificationNodeQueryType) object);
        {
            RegistryObjectQueryType leftParentQuery;
            leftParentQuery = this.getParentQuery();
            RegistryObjectQueryType rightParentQuery;
            rightParentQuery = that.getParentQuery();
            if (this.parentQuery!= null) {
                if (that.parentQuery!= null) {
                    if (!leftParentQuery.equals(rightParentQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.parentQuery!= null) {
                    return false;
                }
            }
        }
        {
            List<ClassificationNodeQueryType> leftChildrenQuery;
            leftChildrenQuery = (((this.childrenQuery!= null)&&(!this.childrenQuery.isEmpty()))?this.getChildrenQuery():null);
            List<ClassificationNodeQueryType> rightChildrenQuery;
            rightChildrenQuery = (((that.childrenQuery!= null)&&(!that.childrenQuery.isEmpty()))?that.getChildrenQuery():null);
            if ((this.childrenQuery!= null)&&(!this.childrenQuery.isEmpty())) {
                if ((that.childrenQuery!= null)&&(!that.childrenQuery.isEmpty())) {
                    if (!leftChildrenQuery.equals(rightChildrenQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.childrenQuery!= null)&&(!that.childrenQuery.isEmpty())) {
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
            RegistryObjectQueryType theParentQuery;
            theParentQuery = this.getParentQuery();
            if (this.parentQuery!= null) {
                currentHashCode += theParentQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<ClassificationNodeQueryType> theChildrenQuery;
            theChildrenQuery = (((this.childrenQuery!= null)&&(!this.childrenQuery.isEmpty()))?this.getChildrenQuery():null);
            if ((this.childrenQuery!= null)&&(!this.childrenQuery.isEmpty())) {
                currentHashCode += theChildrenQuery.hashCode();
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