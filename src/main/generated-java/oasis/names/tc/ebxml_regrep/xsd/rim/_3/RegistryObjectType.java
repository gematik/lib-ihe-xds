/*-
 * #%L
 * lib-ihe-xds
 * %%
 * Copyright (C) 2023 - 2025 gematik GmbH
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
 * For additional notes and disclaimer from gematik and in case of changes by gematik find details in the "Readme" file.
 * #L%
 */
//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.11 at 06:21:54 PM CEST 
//


package oasis.names.tc.ebxml_regrep.xsd.rim._3;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RegistryObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistryObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}IdentifiableType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Name" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Description" minOccurs="0"/&gt;
 *         &lt;element name="VersionInfo" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}VersionInfoType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Classification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}ExternalIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="lid" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="objectType" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="status" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistryObjectType", propOrder = {
    "name",
    "description",
    "versionInfo",
    "classification",
    "externalIdentifier"
})
@XmlSeeAlso({
    AssociationType1 .class,
    AuditableEventType.class,
    ClassificationType.class,
    ClassificationNodeType.class,
    ClassificationSchemeType.class,
    ExternalIdentifierType.class,
    ExternalLinkType.class,
    ExtrinsicObjectType.class,
    OrganizationType.class,
    RegistryPackageType.class,
    ServiceType.class,
    ServiceBindingType.class,
    SpecificationLinkType.class,
    PersonType.class,
    RegistryType.class,
    FederationType.class,
    AdhocQueryType.class,
    NotificationType.class,
    SubscriptionType.class
})
public class RegistryObjectType
    extends IdentifiableType
{

    @XmlElement(name = "Name")
    protected InternationalStringType name;
    @XmlElement(name = "Description")
    protected InternationalStringType description;
    @XmlElement(name = "VersionInfo")
    protected VersionInfoType versionInfo;
    @XmlElement(name = "Classification")
    protected List<ClassificationType> classification;
    @XmlElement(name = "ExternalIdentifier")
    protected List<ExternalIdentifierType> externalIdentifier;
    @XmlAttribute(name = "lid")
    @XmlSchemaType(name = "anyURI")
    protected String lid;
    @XmlAttribute(name = "objectType")
    protected String objectType;
    @XmlAttribute(name = "status")
    protected String status;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType }
     *     
     */
    public InternationalStringType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType }
     *     
     */
    public void setName(InternationalStringType value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType }
     *     
     */
    public InternationalStringType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.InternationalStringType }
     *     
     */
    public void setDescription(InternationalStringType value) {
        this.description = value;
    }

    /**
     * Gets the value of the versionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VersionInfoType }
     *     
     */
    public VersionInfoType getVersionInfo() {
        return versionInfo;
    }

    /**
     * Sets the value of the versionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionInfoType }
     *     
     */
    public void setVersionInfo(VersionInfoType value) {
        this.versionInfo = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the classification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassificationType }
     * 
     * 
     */
    public List<ClassificationType> getClassification() {
        if (classification == null) {
            classification = new ArrayList<ClassificationType>();
        }
        return this.classification;
    }

    /**
     * Gets the value of the externalIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the externalIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ExternalIdentifierType }
     * 
     * 
     */
    public List<ExternalIdentifierType> getExternalIdentifier() {
        if (externalIdentifier == null) {
            externalIdentifier = new ArrayList<ExternalIdentifierType>();
        }
        return this.externalIdentifier;
    }

    /**
     * Gets the value of the lid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLid() {
        return lid;
    }

    /**
     * Sets the value of the lid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLid(String value) {
        this.lid = value;
    }

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectType(String value) {
        this.objectType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    public RegistryObjectType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    public RegistryObjectType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    public RegistryObjectType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    public RegistryObjectType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    public RegistryObjectType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    public RegistryObjectType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    public RegistryObjectType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    public RegistryObjectType withLid(String value) {
        setLid(value);
        return this;
    }

    public RegistryObjectType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    public RegistryObjectType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public RegistryObjectType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public RegistryObjectType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public RegistryObjectType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public RegistryObjectType withHome(String value) {
        setHome(value);
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
        final RegistryObjectType that = ((RegistryObjectType) object);
        {
            InternationalStringType leftName;
            leftName = this.getName();
            InternationalStringType rightName;
            rightName = that.getName();
            if (this.name!= null) {
                if (that.name!= null) {
                    if (!leftName.equals(rightName)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.name!= null) {
                    return false;
                }
            }
        }
        {
            InternationalStringType leftDescription;
            leftDescription = this.getDescription();
            InternationalStringType rightDescription;
            rightDescription = that.getDescription();
            if (this.description!= null) {
                if (that.description!= null) {
                    if (!leftDescription.equals(rightDescription)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.description!= null) {
                    return false;
                }
            }
        }
        {
            VersionInfoType leftVersionInfo;
            leftVersionInfo = this.getVersionInfo();
            VersionInfoType rightVersionInfo;
            rightVersionInfo = that.getVersionInfo();
            if (this.versionInfo!= null) {
                if (that.versionInfo!= null) {
                    if (!leftVersionInfo.equals(rightVersionInfo)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.versionInfo!= null) {
                    return false;
                }
            }
        }
        {
            List<ClassificationType> leftClassification;
            leftClassification = (((this.classification!= null)&&(!this.classification.isEmpty()))?this.getClassification():null);
            List<ClassificationType> rightClassification;
            rightClassification = (((that.classification!= null)&&(!that.classification.isEmpty()))?that.getClassification():null);
            if ((this.classification!= null)&&(!this.classification.isEmpty())) {
                if ((that.classification!= null)&&(!that.classification.isEmpty())) {
                    if (!leftClassification.equals(rightClassification)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.classification!= null)&&(!that.classification.isEmpty())) {
                    return false;
                }
            }
        }
        {
            List<ExternalIdentifierType> leftExternalIdentifier;
            leftExternalIdentifier = (((this.externalIdentifier!= null)&&(!this.externalIdentifier.isEmpty()))?this.getExternalIdentifier():null);
            List<ExternalIdentifierType> rightExternalIdentifier;
            rightExternalIdentifier = (((that.externalIdentifier!= null)&&(!that.externalIdentifier.isEmpty()))?that.getExternalIdentifier():null);
            if ((this.externalIdentifier!= null)&&(!this.externalIdentifier.isEmpty())) {
                if ((that.externalIdentifier!= null)&&(!that.externalIdentifier.isEmpty())) {
                    if (!leftExternalIdentifier.equals(rightExternalIdentifier)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.externalIdentifier!= null)&&(!that.externalIdentifier.isEmpty())) {
                    return false;
                }
            }
        }
        {
            String leftLid;
            leftLid = this.getLid();
            String rightLid;
            rightLid = that.getLid();
            if (this.lid!= null) {
                if (that.lid!= null) {
                    if (!leftLid.equals(rightLid)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.lid!= null) {
                    return false;
                }
            }
        }
        {
            String leftObjectType;
            leftObjectType = this.getObjectType();
            String rightObjectType;
            rightObjectType = that.getObjectType();
            if (this.objectType!= null) {
                if (that.objectType!= null) {
                    if (!leftObjectType.equals(rightObjectType)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.objectType!= null) {
                    return false;
                }
            }
        }
        {
            String leftStatus;
            leftStatus = this.getStatus();
            String rightStatus;
            rightStatus = that.getStatus();
            if (this.status!= null) {
                if (that.status!= null) {
                    if (!leftStatus.equals(rightStatus)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.status!= null) {
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
            InternationalStringType theName;
            theName = this.getName();
            if (this.name!= null) {
                currentHashCode += theName.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            InternationalStringType theDescription;
            theDescription = this.getDescription();
            if (this.description!= null) {
                currentHashCode += theDescription.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            VersionInfoType theVersionInfo;
            theVersionInfo = this.getVersionInfo();
            if (this.versionInfo!= null) {
                currentHashCode += theVersionInfo.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<ClassificationType> theClassification;
            theClassification = (((this.classification!= null)&&(!this.classification.isEmpty()))?this.getClassification():null);
            if ((this.classification!= null)&&(!this.classification.isEmpty())) {
                currentHashCode += theClassification.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<ExternalIdentifierType> theExternalIdentifier;
            theExternalIdentifier = (((this.externalIdentifier!= null)&&(!this.externalIdentifier.isEmpty()))?this.getExternalIdentifier():null);
            if ((this.externalIdentifier!= null)&&(!this.externalIdentifier.isEmpty())) {
                currentHashCode += theExternalIdentifier.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theLid;
            theLid = this.getLid();
            if (this.lid!= null) {
                currentHashCode += theLid.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theObjectType;
            theObjectType = this.getObjectType();
            if (this.objectType!= null) {
                currentHashCode += theObjectType.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theStatus;
            theStatus = this.getStatus();
            if (this.status!= null) {
                currentHashCode += theStatus.hashCode();
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
