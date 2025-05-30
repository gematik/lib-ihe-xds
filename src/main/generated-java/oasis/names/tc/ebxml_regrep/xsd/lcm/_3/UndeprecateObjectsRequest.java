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


package oasis.names.tc.ebxml_regrep.xsd.lcm._3;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AdhocQueryType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectRefListType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotListType;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryRequestType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0}RegistryRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}AdhocQuery" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}ObjectRefList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "adhocQuery",
    "objectRefList"
})
@XmlRootElement(name = "UndeprecateObjectsRequest")
public class UndeprecateObjectsRequest
    extends RegistryRequestType
{

    @XmlElement(name = "AdhocQuery", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0")
    protected AdhocQueryType adhocQuery;
    @XmlElement(name = "ObjectRefList", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0")
    protected ObjectRefListType objectRefList;

    /**
     * Gets the value of the adhocQuery property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.AdhocQueryType }
     *     
     */
    public AdhocQueryType getAdhocQuery() {
        return adhocQuery;
    }

    /**
     * Sets the value of the adhocQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.AdhocQueryType }
     *     
     */
    public void setAdhocQuery(AdhocQueryType value) {
        this.adhocQuery = value;
    }

    /**
     * Gets the value of the objectRefList property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectRefListType }
     *     
     */
    public ObjectRefListType getObjectRefList() {
        return objectRefList;
    }

    /**
     * Sets the value of the objectRefList property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.ObjectRefListType }
     *     
     */
    public void setObjectRefList(ObjectRefListType value) {
        this.objectRefList = value;
    }

    public UndeprecateObjectsRequest withAdhocQuery(AdhocQueryType value) {
        setAdhocQuery(value);
        return this;
    }

    public UndeprecateObjectsRequest withObjectRefList(ObjectRefListType value) {
        setObjectRefList(value);
        return this;
    }

    @Override
    public UndeprecateObjectsRequest withRequestSlotList(SlotListType value) {
        setRequestSlotList(value);
        return this;
    }

    @Override
    public UndeprecateObjectsRequest withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public UndeprecateObjectsRequest withComment(String value) {
        setComment(value);
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
        final UndeprecateObjectsRequest that = ((UndeprecateObjectsRequest) object);
        {
            AdhocQueryType leftAdhocQuery;
            leftAdhocQuery = this.getAdhocQuery();
            AdhocQueryType rightAdhocQuery;
            rightAdhocQuery = that.getAdhocQuery();
            if (this.adhocQuery!= null) {
                if (that.adhocQuery!= null) {
                    if (!leftAdhocQuery.equals(rightAdhocQuery)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.adhocQuery!= null) {
                    return false;
                }
            }
        }
        {
            ObjectRefListType leftObjectRefList;
            leftObjectRefList = this.getObjectRefList();
            ObjectRefListType rightObjectRefList;
            rightObjectRefList = that.getObjectRefList();
            if (this.objectRefList!= null) {
                if (that.objectRefList!= null) {
                    if (!leftObjectRefList.equals(rightObjectRefList)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.objectRefList!= null) {
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
            AdhocQueryType theAdhocQuery;
            theAdhocQuery = this.getAdhocQuery();
            if (this.adhocQuery!= null) {
                currentHashCode += theAdhocQuery.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            ObjectRefListType theObjectRefList;
            theObjectRefList = this.getObjectRefList();
            if (this.objectRefList!= null) {
                currentHashCode += theObjectRefList.hashCode();
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
