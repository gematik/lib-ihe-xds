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


package oasis.names.tc.ebxml_regrep.xsd.rim._3;

import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         ExternalIdentifier is the mapping of the same named interface in ebRIM.
 *         It extends RegistryObject.
 *       
 * 
 * <p>Java class for ExternalIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalIdentifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;attribute name="registryObject" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="identificationScheme" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="value" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalIdentifierType")
public class ExternalIdentifierType
    extends RegistryObjectType
{

    @XmlAttribute(name = "registryObject", required = true)
    protected String registryObject;
    @XmlAttribute(name = "identificationScheme", required = true)
    protected String identificationScheme;
    @XmlAttribute(name = "value", required = true)
    protected String value;

    /**
     * Gets the value of the registryObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistryObject() {
        return registryObject;
    }

    /**
     * Sets the value of the registryObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistryObject(String value) {
        this.registryObject = value;
    }

    /**
     * Gets the value of the identificationScheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationScheme() {
        return identificationScheme;
    }

    /**
     * Sets the value of the identificationScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationScheme(String value) {
        this.identificationScheme = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    public ExternalIdentifierType withRegistryObject(String value) {
        setRegistryObject(value);
        return this;
    }

    public ExternalIdentifierType withIdentificationScheme(String value) {
        setIdentificationScheme(value);
        return this;
    }

    public ExternalIdentifierType withValue(String value) {
        setValue(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public ExternalIdentifierType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ExternalIdentifierType withHome(String value) {
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
        final ExternalIdentifierType that = ((ExternalIdentifierType) object);
        {
            String leftRegistryObject;
            leftRegistryObject = this.getRegistryObject();
            String rightRegistryObject;
            rightRegistryObject = that.getRegistryObject();
            if (this.registryObject!= null) {
                if (that.registryObject!= null) {
                    if (!leftRegistryObject.equals(rightRegistryObject)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.registryObject!= null) {
                    return false;
                }
            }
        }
        {
            String leftIdentificationScheme;
            leftIdentificationScheme = this.getIdentificationScheme();
            String rightIdentificationScheme;
            rightIdentificationScheme = that.getIdentificationScheme();
            if (this.identificationScheme!= null) {
                if (that.identificationScheme!= null) {
                    if (!leftIdentificationScheme.equals(rightIdentificationScheme)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.identificationScheme!= null) {
                    return false;
                }
            }
        }
        {
            String leftValue;
            leftValue = this.getValue();
            String rightValue;
            rightValue = that.getValue();
            if (this.value!= null) {
                if (that.value!= null) {
                    if (!leftValue.equals(rightValue)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.value!= null) {
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
            String theRegistryObject;
            theRegistryObject = this.getRegistryObject();
            if (this.registryObject!= null) {
                currentHashCode += theRegistryObject.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theIdentificationScheme;
            theIdentificationScheme = this.getIdentificationScheme();
            if (this.identificationScheme!= null) {
                currentHashCode += theIdentificationScheme.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theValue;
            theValue = this.getValue();
            if (this.value!= null) {
                currentHashCode += theValue.hashCode();
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