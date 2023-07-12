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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CompoundFilterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompoundFilterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}FilterType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LeftFilter" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}FilterType"/&gt;
 *         &lt;element name="RightFilter" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}FilterType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="logicalOperator" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName"&gt;
 *             &lt;enumeration value="AND"/&gt;
 *             &lt;enumeration value="OR"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompoundFilterType", propOrder = {
    "leftFilter",
    "rightFilter"
})
public class CompoundFilterType
    extends FilterType
{

    @XmlElement(name = "LeftFilter", required = true)
    protected FilterType leftFilter;
    @XmlElement(name = "RightFilter", required = true)
    protected FilterType rightFilter;
    @XmlAttribute(name = "logicalOperator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String logicalOperator;

    /**
     * Gets the value of the leftFilter property.
     * 
     * @return
     *     possible object is
     *     {@link FilterType }
     *     
     */
    public FilterType getLeftFilter() {
        return leftFilter;
    }

    /**
     * Sets the value of the leftFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterType }
     *     
     */
    public void setLeftFilter(FilterType value) {
        this.leftFilter = value;
    }

    /**
     * Gets the value of the rightFilter property.
     * 
     * @return
     *     possible object is
     *     {@link FilterType }
     *     
     */
    public FilterType getRightFilter() {
        return rightFilter;
    }

    /**
     * Sets the value of the rightFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterType }
     *     
     */
    public void setRightFilter(FilterType value) {
        this.rightFilter = value;
    }

    /**
     * Gets the value of the logicalOperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicalOperator() {
        return logicalOperator;
    }

    /**
     * Sets the value of the logicalOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicalOperator(String value) {
        this.logicalOperator = value;
    }

    public CompoundFilterType withLeftFilter(FilterType value) {
        setLeftFilter(value);
        return this;
    }

    public CompoundFilterType withRightFilter(FilterType value) {
        setRightFilter(value);
        return this;
    }

    public CompoundFilterType withLogicalOperator(String value) {
        setLogicalOperator(value);
        return this;
    }

    @Override
    public CompoundFilterType withNegate(Boolean value) {
        setNegate(value);
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
        final CompoundFilterType that = ((CompoundFilterType) object);
        {
            FilterType leftLeftFilter;
            leftLeftFilter = this.getLeftFilter();
            FilterType rightLeftFilter;
            rightLeftFilter = that.getLeftFilter();
            if (this.leftFilter!= null) {
                if (that.leftFilter!= null) {
                    if (!leftLeftFilter.equals(rightLeftFilter)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.leftFilter!= null) {
                    return false;
                }
            }
        }
        {
            FilterType leftRightFilter;
            leftRightFilter = this.getRightFilter();
            FilterType rightRightFilter;
            rightRightFilter = that.getRightFilter();
            if (this.rightFilter!= null) {
                if (that.rightFilter!= null) {
                    if (!leftRightFilter.equals(rightRightFilter)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.rightFilter!= null) {
                    return false;
                }
            }
        }
        {
            String leftLogicalOperator;
            leftLogicalOperator = this.getLogicalOperator();
            String rightLogicalOperator;
            rightLogicalOperator = that.getLogicalOperator();
            if (this.logicalOperator!= null) {
                if (that.logicalOperator!= null) {
                    if (!leftLogicalOperator.equals(rightLogicalOperator)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.logicalOperator!= null) {
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
            FilterType theLeftFilter;
            theLeftFilter = this.getLeftFilter();
            if (this.leftFilter!= null) {
                currentHashCode += theLeftFilter.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            FilterType theRightFilter;
            theRightFilter = this.getRightFilter();
            if (this.rightFilter!= null) {
                currentHashCode += theRightFilter.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theLogicalOperator;
            theLogicalOperator = this.getLogicalOperator();
            if (this.logicalOperator!= null) {
                currentHashCode += theLogicalOperator.hashCode();
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