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
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServiceBindingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceBindingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}SpecificationLink" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="service" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="accessURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="targetBinding" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceBindingType", propOrder = {
    "specificationLink"
})
public class ServiceBindingType
    extends RegistryObjectType
{

    @XmlElement(name = "SpecificationLink")
    protected List<SpecificationLinkType> specificationLink;
    @XmlAttribute(name = "service", required = true)
    protected String service;
    @XmlAttribute(name = "accessURI")
    @XmlSchemaType(name = "anyURI")
    protected String accessURI;
    @XmlAttribute(name = "targetBinding")
    protected String targetBinding;

    /**
     * Gets the value of the specificationLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the specificationLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.SpecificationLinkType }
     * 
     * 
     */
    public List<SpecificationLinkType> getSpecificationLink() {
        if (specificationLink == null) {
            specificationLink = new ArrayList<SpecificationLinkType>();
        }
        return this.specificationLink;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Gets the value of the accessURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessURI() {
        return accessURI;
    }

    /**
     * Sets the value of the accessURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessURI(String value) {
        this.accessURI = value;
    }

    /**
     * Gets the value of the targetBinding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetBinding() {
        return targetBinding;
    }

    /**
     * Sets the value of the targetBinding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetBinding(String value) {
        this.targetBinding = value;
    }

    public ServiceBindingType withSpecificationLink(SpecificationLinkType... values) {
        if (values!= null) {
            for (SpecificationLinkType value: values) {
                getSpecificationLink().add(value);
            }
        }
        return this;
    }

    public ServiceBindingType withSpecificationLink(Collection<SpecificationLinkType> values) {
        if (values!= null) {
            getSpecificationLink().addAll(values);
        }
        return this;
    }

    public ServiceBindingType withService(String value) {
        setService(value);
        return this;
    }

    public ServiceBindingType withAccessURI(String value) {
        setAccessURI(value);
        return this;
    }

    public ServiceBindingType withTargetBinding(String value) {
        setTargetBinding(value);
        return this;
    }

    @Override
    public ServiceBindingType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public ServiceBindingType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public ServiceBindingType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public ServiceBindingType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public ServiceBindingType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public ServiceBindingType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ServiceBindingType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public ServiceBindingType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public ServiceBindingType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ServiceBindingType withHome(String value) {
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
        final ServiceBindingType that = ((ServiceBindingType) object);
        {
            List<SpecificationLinkType> leftSpecificationLink;
            leftSpecificationLink = (((this.specificationLink!= null)&&(!this.specificationLink.isEmpty()))?this.getSpecificationLink():null);
            List<SpecificationLinkType> rightSpecificationLink;
            rightSpecificationLink = (((that.specificationLink!= null)&&(!that.specificationLink.isEmpty()))?that.getSpecificationLink():null);
            if ((this.specificationLink!= null)&&(!this.specificationLink.isEmpty())) {
                if ((that.specificationLink!= null)&&(!that.specificationLink.isEmpty())) {
                    if (!leftSpecificationLink.equals(rightSpecificationLink)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.specificationLink!= null)&&(!that.specificationLink.isEmpty())) {
                    return false;
                }
            }
        }
        {
            String leftService;
            leftService = this.getService();
            String rightService;
            rightService = that.getService();
            if (this.service!= null) {
                if (that.service!= null) {
                    if (!leftService.equals(rightService)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.service!= null) {
                    return false;
                }
            }
        }
        {
            String leftAccessURI;
            leftAccessURI = this.getAccessURI();
            String rightAccessURI;
            rightAccessURI = that.getAccessURI();
            if (this.accessURI!= null) {
                if (that.accessURI!= null) {
                    if (!leftAccessURI.equals(rightAccessURI)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.accessURI!= null) {
                    return false;
                }
            }
        }
        {
            String leftTargetBinding;
            leftTargetBinding = this.getTargetBinding();
            String rightTargetBinding;
            rightTargetBinding = that.getTargetBinding();
            if (this.targetBinding!= null) {
                if (that.targetBinding!= null) {
                    if (!leftTargetBinding.equals(rightTargetBinding)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.targetBinding!= null) {
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
            List<SpecificationLinkType> theSpecificationLink;
            theSpecificationLink = (((this.specificationLink!= null)&&(!this.specificationLink.isEmpty()))?this.getSpecificationLink():null);
            if ((this.specificationLink!= null)&&(!this.specificationLink.isEmpty())) {
                currentHashCode += theSpecificationLink.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theService;
            theService = this.getService();
            if (this.service!= null) {
                currentHashCode += theService.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theAccessURI;
            theAccessURI = this.getAccessURI();
            if (this.accessURI!= null) {
                currentHashCode += theAccessURI.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theTargetBinding;
            theTargetBinding = this.getTargetBinding();
            if (this.targetBinding!= null) {
                currentHashCode += theTargetBinding.hashCode();
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
