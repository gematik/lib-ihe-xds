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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Mapping of the same named interface in ebRIM.
 * 
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Address" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}PersonName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}TelephoneNumber" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}EmailAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "address",
    "personName",
    "telephoneNumber",
    "emailAddress"
})
@XmlSeeAlso({
    UserType.class
})
public class PersonType
    extends RegistryObjectType
{

    @XmlElement(name = "Address")
    protected List<PostalAddressType> address;
    @XmlElement(name = "PersonName")
    protected PersonNameType personName;
    @XmlElement(name = "TelephoneNumber")
    protected List<TelephoneNumberType> telephoneNumber;
    @XmlElement(name = "EmailAddress")
    protected List<EmailAddressType> emailAddress;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.PostalAddressType }
     * 
     * 
     */
    public List<PostalAddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<PostalAddressType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.PersonNameType }
     *     
     */
    public PersonNameType getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.PersonNameType }
     *     
     */
    public void setPersonName(PersonNameType value) {
        this.personName = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the telephoneNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelephoneNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.TelephoneNumberType }
     * 
     * 
     */
    public List<TelephoneNumberType> getTelephoneNumber() {
        if (telephoneNumber == null) {
            telephoneNumber = new ArrayList<TelephoneNumberType>();
        }
        return this.telephoneNumber;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the emailAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.EmailAddressType }
     * 
     * 
     */
    public List<EmailAddressType> getEmailAddress() {
        if (emailAddress == null) {
            emailAddress = new ArrayList<EmailAddressType>();
        }
        return this.emailAddress;
    }

    public PersonType withAddress(PostalAddressType... values) {
        if (values!= null) {
            for (PostalAddressType value: values) {
                getAddress().add(value);
            }
        }
        return this;
    }

    public PersonType withAddress(Collection<PostalAddressType> values) {
        if (values!= null) {
            getAddress().addAll(values);
        }
        return this;
    }

    public PersonType withPersonName(PersonNameType value) {
        setPersonName(value);
        return this;
    }

    public PersonType withTelephoneNumber(TelephoneNumberType... values) {
        if (values!= null) {
            for (TelephoneNumberType value: values) {
                getTelephoneNumber().add(value);
            }
        }
        return this;
    }

    public PersonType withTelephoneNumber(Collection<TelephoneNumberType> values) {
        if (values!= null) {
            getTelephoneNumber().addAll(values);
        }
        return this;
    }

    public PersonType withEmailAddress(EmailAddressType... values) {
        if (values!= null) {
            for (EmailAddressType value: values) {
                getEmailAddress().add(value);
            }
        }
        return this;
    }

    public PersonType withEmailAddress(Collection<EmailAddressType> values) {
        if (values!= null) {
            getEmailAddress().addAll(values);
        }
        return this;
    }

    @Override
    public PersonType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public PersonType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public PersonType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public PersonType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public PersonType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public PersonType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public PersonType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public PersonType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public PersonType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public PersonType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public PersonType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public PersonType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public PersonType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public PersonType withHome(String value) {
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
        final PersonType that = ((PersonType) object);
        {
            List<PostalAddressType> leftAddress;
            leftAddress = (((this.address!= null)&&(!this.address.isEmpty()))?this.getAddress():null);
            List<PostalAddressType> rightAddress;
            rightAddress = (((that.address!= null)&&(!that.address.isEmpty()))?that.getAddress():null);
            if ((this.address!= null)&&(!this.address.isEmpty())) {
                if ((that.address!= null)&&(!that.address.isEmpty())) {
                    if (!leftAddress.equals(rightAddress)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.address!= null)&&(!that.address.isEmpty())) {
                    return false;
                }
            }
        }
        {
            PersonNameType leftPersonName;
            leftPersonName = this.getPersonName();
            PersonNameType rightPersonName;
            rightPersonName = that.getPersonName();
            if (this.personName!= null) {
                if (that.personName!= null) {
                    if (!leftPersonName.equals(rightPersonName)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.personName!= null) {
                    return false;
                }
            }
        }
        {
            List<TelephoneNumberType> leftTelephoneNumber;
            leftTelephoneNumber = (((this.telephoneNumber!= null)&&(!this.telephoneNumber.isEmpty()))?this.getTelephoneNumber():null);
            List<TelephoneNumberType> rightTelephoneNumber;
            rightTelephoneNumber = (((that.telephoneNumber!= null)&&(!that.telephoneNumber.isEmpty()))?that.getTelephoneNumber():null);
            if ((this.telephoneNumber!= null)&&(!this.telephoneNumber.isEmpty())) {
                if ((that.telephoneNumber!= null)&&(!that.telephoneNumber.isEmpty())) {
                    if (!leftTelephoneNumber.equals(rightTelephoneNumber)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.telephoneNumber!= null)&&(!that.telephoneNumber.isEmpty())) {
                    return false;
                }
            }
        }
        {
            List<EmailAddressType> leftEmailAddress;
            leftEmailAddress = (((this.emailAddress!= null)&&(!this.emailAddress.isEmpty()))?this.getEmailAddress():null);
            List<EmailAddressType> rightEmailAddress;
            rightEmailAddress = (((that.emailAddress!= null)&&(!that.emailAddress.isEmpty()))?that.getEmailAddress():null);
            if ((this.emailAddress!= null)&&(!this.emailAddress.isEmpty())) {
                if ((that.emailAddress!= null)&&(!that.emailAddress.isEmpty())) {
                    if (!leftEmailAddress.equals(rightEmailAddress)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.emailAddress!= null)&&(!that.emailAddress.isEmpty())) {
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
            List<PostalAddressType> theAddress;
            theAddress = (((this.address!= null)&&(!this.address.isEmpty()))?this.getAddress():null);
            if ((this.address!= null)&&(!this.address.isEmpty())) {
                currentHashCode += theAddress.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            PersonNameType thePersonName;
            thePersonName = this.getPersonName();
            if (this.personName!= null) {
                currentHashCode += thePersonName.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<TelephoneNumberType> theTelephoneNumber;
            theTelephoneNumber = (((this.telephoneNumber!= null)&&(!this.telephoneNumber.isEmpty()))?this.getTelephoneNumber():null);
            if ((this.telephoneNumber!= null)&&(!this.telephoneNumber.isEmpty())) {
                currentHashCode += theTelephoneNumber.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<EmailAddressType> theEmailAddress;
            theEmailAddress = (((this.emailAddress!= null)&&(!this.emailAddress.isEmpty()))?this.getEmailAddress():null);
            if ((this.emailAddress!= null)&&(!this.emailAddress.isEmpty())) {
                currentHashCode += theEmailAddress.hashCode();
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
