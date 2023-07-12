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
 * <p>Java class for AuditableEventQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditableEventQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AffectedObjectQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EventTypeQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}ClassificationNodeQueryType" minOccurs="0"/&gt;
 *         &lt;element name="UserQuery" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}UserQueryType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditableEventQueryType", propOrder = {
    "affectedObjectQuery",
    "eventTypeQuery",
    "userQuery"
})
public class AuditableEventQueryType
    extends RegistryObjectQueryType
{

    @XmlElement(name = "AffectedObjectQuery")
    protected List<RegistryObjectQueryType> affectedObjectQuery;
    @XmlElement(name = "EventTypeQuery")
    protected ClassificationNodeQueryType eventTypeQuery;
    @XmlElement(name = "UserQuery")
    protected UserQueryType userQuery;

    /**
     * Gets the value of the affectedObjectQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the affectedObjectQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAffectedObjectQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegistryObjectQueryType }
     * 
     * 
     */
    public List<RegistryObjectQueryType> getAffectedObjectQuery() {
        if (affectedObjectQuery == null) {
            affectedObjectQuery = new ArrayList<RegistryObjectQueryType>();
        }
        return this.affectedObjectQuery;
    }

    /**
     * Gets the value of the eventTypeQuery property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationNodeQueryType }
     *     
     */
    public ClassificationNodeQueryType getEventTypeQuery() {
        return eventTypeQuery;
    }

    /**
     * Sets the value of the eventTypeQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationNodeQueryType }
     *     
     */
    public void setEventTypeQuery(ClassificationNodeQueryType value) {
        this.eventTypeQuery = value;
    }

    /**
     * Gets the value of the userQuery property.
     * 
     * @return
     *     possible object is
     *     {@link UserQueryType }
     *     
     */
    public UserQueryType getUserQuery() {
        return userQuery;
    }

    /**
     * Sets the value of the userQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserQueryType }
     *     
     */
    public void setUserQuery(UserQueryType value) {
        this.userQuery = value;
    }

    public AuditableEventQueryType withAffectedObjectQuery(RegistryObjectQueryType... values) {
        if (values!= null) {
            for (RegistryObjectQueryType value: values) {
                getAffectedObjectQuery().add(value);
            }
        }
        return this;
    }

    public AuditableEventQueryType withAffectedObjectQuery(Collection<RegistryObjectQueryType> values) {
        if (values!= null) {
            getAffectedObjectQuery().addAll(values);
        }
        return this;
    }

    public AuditableEventQueryType withEventTypeQuery(ClassificationNodeQueryType value) {
        setEventTypeQuery(value);
        return this;
    }

    public AuditableEventQueryType withUserQuery(UserQueryType value) {
        setUserQuery(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withSlotBranch(SlotBranchType... values) {
        if (values!= null) {
            for (SlotBranchType value: values) {
                getSlotBranch().add(value);
            }
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withSlotBranch(Collection<SlotBranchType> values) {
        if (values!= null) {
            getSlotBranch().addAll(values);
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withNameBranch(InternationalStringBranchType value) {
        setNameBranch(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withDescriptionBranch(InternationalStringBranchType value) {
        setDescriptionBranch(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withVersionInfoFilter(FilterType value) {
        setVersionInfoFilter(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withClassificationQuery(ClassificationQueryType... values) {
        if (values!= null) {
            for (ClassificationQueryType value: values) {
                getClassificationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withClassificationQuery(Collection<ClassificationQueryType> values) {
        if (values!= null) {
            getClassificationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withExternalIdentifierQuery(ExternalIdentifierQueryType... values) {
        if (values!= null) {
            for (ExternalIdentifierQueryType value: values) {
                getExternalIdentifierQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withExternalIdentifierQuery(Collection<ExternalIdentifierQueryType> values) {
        if (values!= null) {
            getExternalIdentifierQuery().addAll(values);
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withObjectTypeQuery(ClassificationNodeQueryType value) {
        setObjectTypeQuery(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withStatusQuery(ClassificationNodeQueryType value) {
        setStatusQuery(value);
        return this;
    }

    @Override
    public AuditableEventQueryType withSourceAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getSourceAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withSourceAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getSourceAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withTargetAssociationQuery(AssociationQueryType... values) {
        if (values!= null) {
            for (AssociationQueryType value: values) {
                getTargetAssociationQuery().add(value);
            }
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withTargetAssociationQuery(Collection<AssociationQueryType> values) {
        if (values!= null) {
            getTargetAssociationQuery().addAll(values);
        }
        return this;
    }

    @Override
    public AuditableEventQueryType withPrimaryFilter(FilterType value) {
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
        final AuditableEventQueryType that = ((AuditableEventQueryType) object);
        {
            List<RegistryObjectQueryType> leftAffectedObjectQuery;
            leftAffectedObjectQuery = (((this.affectedObjectQuery!= null)&&(!this.affectedObjectQuery.isEmpty()))?this.getAffectedObjectQuery():null);
            List<RegistryObjectQueryType> rightAffectedObjectQuery;
            rightAffectedObjectQuery = (((that.affectedObjectQuery!= null)&&(!that.affectedObjectQuery.isEmpty()))?that.getAffectedObjectQuery():null);
            if ((this.affectedObjectQuery!= null)&&(!this.affectedObjectQuery.isEmpty())) {
                if ((that.affectedObjectQuery!= null)&&(!that.affectedObjectQuery.isEmpty())) {
                    if (!leftAffectedObjectQuery.equals(rightAffectedObjectQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.affectedObjectQuery!= null)&&(!that.affectedObjectQuery.isEmpty())) {
                    return false;
                }
            }
        }
        {
            ClassificationNodeQueryType leftEventTypeQuery;
            leftEventTypeQuery = this.getEventTypeQuery();
            ClassificationNodeQueryType rightEventTypeQuery;
            rightEventTypeQuery = that.getEventTypeQuery();
            if (this.eventTypeQuery!= null) {
                if (that.eventTypeQuery!= null) {
                    if (!leftEventTypeQuery.equals(rightEventTypeQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.eventTypeQuery!= null) {
                    return false;
                }
            }
        }
        {
            UserQueryType leftUserQuery;
            leftUserQuery = this.getUserQuery();
            UserQueryType rightUserQuery;
            rightUserQuery = that.getUserQuery();
            if (this.userQuery!= null) {
                if (that.userQuery!= null) {
                    if (!leftUserQuery.equals(rightUserQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.userQuery!= null) {
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
            List<RegistryObjectQueryType> theAffectedObjectQuery;
            theAffectedObjectQuery = (((this.affectedObjectQuery!= null)&&(!this.affectedObjectQuery.isEmpty()))?this.getAffectedObjectQuery():null);
            if ((this.affectedObjectQuery!= null)&&(!this.affectedObjectQuery.isEmpty())) {
                currentHashCode += theAffectedObjectQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            ClassificationNodeQueryType theEventTypeQuery;
            theEventTypeQuery = this.getEventTypeQuery();
            if (this.eventTypeQuery!= null) {
                currentHashCode += theEventTypeQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            UserQueryType theUserQuery;
            theUserQuery = this.getUserQuery();
            if (this.userQuery!= null) {
                currentHashCode += theUserQuery.hashCode();
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
