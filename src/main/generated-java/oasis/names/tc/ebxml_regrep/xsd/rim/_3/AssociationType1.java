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


import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         Association is the mapping of the same named interface in ebRIM.
 *         It extends RegistryObject.
 *         An Association specifies references to two previously submitted
 *         registry entrys.
 *         The sourceObject is id of the sourceObject in association
 *         The targetObject is id of the targetObject in association
 *       
 * 
 * <p>Java class for AssociationType1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociationType1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;attribute name="associationType" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="sourceObject" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="targetObject" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociationType1")
public class AssociationType1
    extends RegistryObjectType
{

    @XmlAttribute(name = "associationType", required = true)
    protected String associationType;
    @XmlAttribute(name = "sourceObject", required = true)
    protected String sourceObject;
    @XmlAttribute(name = "targetObject", required = true)
    protected String targetObject;

    /**
     * Gets the value of the associationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssociationType() {
        return associationType;
    }

    /**
     * Sets the value of the associationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssociationType(String value) {
        this.associationType = value;
    }

    /**
     * Gets the value of the sourceObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceObject() {
        return sourceObject;
    }

    /**
     * Sets the value of the sourceObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceObject(String value) {
        this.sourceObject = value;
    }

    /**
     * Gets the value of the targetObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetObject() {
        return targetObject;
    }

    /**
     * Sets the value of the targetObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetObject(String value) {
        this.targetObject = value;
    }

    public AssociationType1 withAssociationType(String value) {
        setAssociationType(value);
        return this;
    }

    public AssociationType1 withSourceObject(String value) {
        setSourceObject(value);
        return this;
    }

    public AssociationType1 withTargetObject(String value) {
        setTargetObject(value);
        return this;
    }

    @Override
    public AssociationType1 withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public AssociationType1 withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public AssociationType1 withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public AssociationType1 withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public AssociationType1 withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public AssociationType1 withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public AssociationType1 withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public AssociationType1 withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public AssociationType1 withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public AssociationType1 withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public AssociationType1 withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public AssociationType1 withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public AssociationType1 withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public AssociationType1 withHome(String value) {
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
        final AssociationType1 that = ((AssociationType1) object);
        {
            String leftAssociationType;
            leftAssociationType = this.getAssociationType();
            String rightAssociationType;
            rightAssociationType = that.getAssociationType();
            if (this.associationType!= null) {
                if (that.associationType!= null) {
                    if (!leftAssociationType.equals(rightAssociationType)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.associationType!= null) {
                    return false;
                }
            }
        }
        {
            String leftSourceObject;
            leftSourceObject = this.getSourceObject();
            String rightSourceObject;
            rightSourceObject = that.getSourceObject();
            if (this.sourceObject!= null) {
                if (that.sourceObject!= null) {
                    if (!leftSourceObject.equals(rightSourceObject)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.sourceObject!= null) {
                    return false;
                }
            }
        }
        {
            String leftTargetObject;
            leftTargetObject = this.getTargetObject();
            String rightTargetObject;
            rightTargetObject = that.getTargetObject();
            if (this.targetObject!= null) {
                if (that.targetObject!= null) {
                    if (!leftTargetObject.equals(rightTargetObject)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.targetObject!= null) {
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
            String theAssociationType;
            theAssociationType = this.getAssociationType();
            if (this.associationType!= null) {
                currentHashCode += theAssociationType.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theSourceObject;
            theSourceObject = this.getSourceObject();
            if (this.sourceObject!= null) {
                currentHashCode += theSourceObject.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theTargetObject;
            theTargetObject = this.getTargetObject();
            if (this.targetObject!= null) {
                currentHashCode += theTargetObject.hashCode();
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
