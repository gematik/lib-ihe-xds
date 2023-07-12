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


package oasis.names.tc.ebxml_regrep.xsd.rs._3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="codeContext" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="errorCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="severity" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" default="urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error" /&gt;
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "RegistryError")
public class RegistryError {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "codeContext", required = true)
    protected String codeContext;
    @XmlAttribute(name = "errorCode", required = true)
    protected String errorCode;
    @XmlAttribute(name = "severity")
    protected String severity;
    @XmlAttribute(name = "location")
    protected String location;

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

    /**
     * Gets the value of the codeContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeContext() {
        return codeContext;
    }

    /**
     * Sets the value of the codeContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeContext(String value) {
        this.codeContext = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        if (severity == null) {
            return "urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error";
        } else {
            return severity;
        }
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    public RegistryError withValue(String value) {
        setValue(value);
        return this;
    }

    public RegistryError withCodeContext(String value) {
        setCodeContext(value);
        return this;
    }

    public RegistryError withErrorCode(String value) {
        setErrorCode(value);
        return this;
    }

    public RegistryError withSeverity(String value) {
        setSeverity(value);
        return this;
    }

    public RegistryError withLocation(String value) {
        setLocation(value);
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
        final RegistryError that = ((RegistryError) object);
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
        {
            String leftCodeContext;
            leftCodeContext = this.getCodeContext();
            String rightCodeContext;
            rightCodeContext = that.getCodeContext();
            if (this.codeContext!= null) {
                if (that.codeContext!= null) {
                    if (!leftCodeContext.equals(rightCodeContext)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.codeContext!= null) {
                    return false;
                }
            }
        }
        {
            String leftErrorCode;
            leftErrorCode = this.getErrorCode();
            String rightErrorCode;
            rightErrorCode = that.getErrorCode();
            if (this.errorCode!= null) {
                if (that.errorCode!= null) {
                    if (!leftErrorCode.equals(rightErrorCode)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.errorCode!= null) {
                    return false;
                }
            }
        }
        {
            String leftSeverity;
            leftSeverity = this.getSeverity();
            String rightSeverity;
            rightSeverity = that.getSeverity();
            if (this.severity!= null) {
                if (that.severity!= null) {
                    if (!leftSeverity.equals(rightSeverity)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.severity!= null) {
                    return false;
                }
            }
        }
        {
            String leftLocation;
            leftLocation = this.getLocation();
            String rightLocation;
            rightLocation = that.getLocation();
            if (this.location!= null) {
                if (that.location!= null) {
                    if (!leftLocation.equals(rightLocation)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.location!= null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int currentHashCode = 1;
        {
            currentHashCode = (currentHashCode* 31);
            String theValue;
            theValue = this.getValue();
            if (this.value!= null) {
                currentHashCode += theValue.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theCodeContext;
            theCodeContext = this.getCodeContext();
            if (this.codeContext!= null) {
                currentHashCode += theCodeContext.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theErrorCode;
            theErrorCode = this.getErrorCode();
            if (this.errorCode!= null) {
                currentHashCode += theErrorCode.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theSeverity;
            theSeverity = this.getSeverity();
            if (this.severity!= null) {
                currentHashCode += theSeverity.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theLocation;
            theLocation = this.getLocation();
            if (this.location!= null) {
                currentHashCode += theLocation.hashCode();
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