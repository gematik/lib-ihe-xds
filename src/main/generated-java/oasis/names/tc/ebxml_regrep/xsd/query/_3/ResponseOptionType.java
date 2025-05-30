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


package oasis.names.tc.ebxml_regrep.xsd.query._3;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ResponseOptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseOptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="returnType" default="RegistryObject"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName"&gt;
 *             &lt;enumeration value="ObjectRef"/&gt;
 *             &lt;enumeration value="RegistryObject"/&gt;
 *             &lt;enumeration value="LeafClass"/&gt;
 *             &lt;enumeration value="LeafClassWithRepositoryItem"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="returnComposedObjects" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseOptionType")
public class ResponseOptionType {

    @XmlAttribute(name = "returnType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String returnType;
    @XmlAttribute(name = "returnComposedObjects")
    protected Boolean returnComposedObjects;

    /**
     * Gets the value of the returnType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnType() {
        if (returnType == null) {
            return "RegistryObject";
        } else {
            return returnType;
        }
    }

    /**
     * Sets the value of the returnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnType(String value) {
        this.returnType = value;
    }

    /**
     * Gets the value of the returnComposedObjects property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnComposedObjects() {
        if (returnComposedObjects == null) {
            return false;
        } else {
            return returnComposedObjects;
        }
    }

    /**
     * Sets the value of the returnComposedObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnComposedObjects(Boolean value) {
        this.returnComposedObjects = value;
    }

    public ResponseOptionType withReturnType(String value) {
        setReturnType(value);
        return this;
    }

    public ResponseOptionType withReturnComposedObjects(Boolean value) {
        setReturnComposedObjects(value);
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
        final ResponseOptionType that = ((ResponseOptionType) object);
        {
            String leftReturnType;
            leftReturnType = this.getReturnType();
            String rightReturnType;
            rightReturnType = that.getReturnType();
            if (this.returnType!= null) {
                if (that.returnType!= null) {
                    if (!leftReturnType.equals(rightReturnType)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.returnType!= null) {
                    return false;
                }
            }
        }
        {
            boolean leftReturnComposedObjects;
            leftReturnComposedObjects = ((this.returnComposedObjects!= null)?this.isReturnComposedObjects():false);
            boolean rightReturnComposedObjects;
            rightReturnComposedObjects = ((that.returnComposedObjects!= null)?that.isReturnComposedObjects():false);
            if (this.returnComposedObjects!= null) {
                if (that.returnComposedObjects!= null) {
                    if (leftReturnComposedObjects!= rightReturnComposedObjects) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.returnComposedObjects!= null) {
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
            String theReturnType;
            theReturnType = this.getReturnType();
            if (this.returnType!= null) {
                currentHashCode += theReturnType.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            boolean theReturnComposedObjects;
            theReturnComposedObjects = ((this.returnComposedObjects!= null)?this.isReturnComposedObjects():false);
            if (this.returnComposedObjects!= null) {
                currentHashCode += (theReturnComposedObjects? 1231 : 1237);
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
