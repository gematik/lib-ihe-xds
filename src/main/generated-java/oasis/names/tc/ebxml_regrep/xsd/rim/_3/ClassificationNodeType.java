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
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         ClassificationNode is the mapping of the same named interface in ebRIM.
 *         It extends RegistryObject.
 *         ClassificationNode is used to submit a Classification tree to the Registry.
 *         The parent attribute is the id to the parent node. code is an optional code value for a ClassificationNode
 *         often defined by an external taxonomy (e.g. NAICS)
 *       
 * 
 * <p>Java class for ClassificationNodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationNodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}ClassificationNode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="parent" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="code" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" /&gt;
 *       &lt;attribute name="path" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationNodeType", propOrder = {
    "classificationNode"
})
public class ClassificationNodeType
    extends RegistryObjectType
{

    @XmlElement(name = "ClassificationNode")
    protected List<ClassificationNodeType> classificationNode;
    @XmlAttribute(name = "parent")
    protected String parent;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "path")
    protected String path;

    /**
     * Gets the value of the classificationNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the classificationNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassificationNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassificationNodeType }
     * 
     * 
     */
    public List<ClassificationNodeType> getClassificationNode() {
        if (classificationNode == null) {
            classificationNode = new ArrayList<ClassificationNodeType>();
        }
        return this.classificationNode;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParent(String value) {
        this.parent = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    public ClassificationNodeType withClassificationNode(ClassificationNodeType... values) {
        if (values!= null) {
            for (ClassificationNodeType value: values) {
                getClassificationNode().add(value);
            }
        }
        return this;
    }

    public ClassificationNodeType withClassificationNode(Collection<ClassificationNodeType> values) {
        if (values!= null) {
            getClassificationNode().addAll(values);
        }
        return this;
    }

    public ClassificationNodeType withParent(String value) {
        setParent(value);
        return this;
    }

    public ClassificationNodeType withCode(String value) {
        setCode(value);
        return this;
    }

    public ClassificationNodeType withPath(String value) {
        setPath(value);
        return this;
    }

    @Override
    public ClassificationNodeType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public ClassificationNodeType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public ClassificationNodeType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public ClassificationNodeType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public ClassificationNodeType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public ClassificationNodeType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ClassificationNodeType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public ClassificationNodeType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public ClassificationNodeType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ClassificationNodeType withHome(String value) {
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
        final ClassificationNodeType that = ((ClassificationNodeType) object);
        {
            List<ClassificationNodeType> leftClassificationNode;
            leftClassificationNode = (((this.classificationNode!= null)&&(!this.classificationNode.isEmpty()))?this.getClassificationNode():null);
            List<ClassificationNodeType> rightClassificationNode;
            rightClassificationNode = (((that.classificationNode!= null)&&(!that.classificationNode.isEmpty()))?that.getClassificationNode():null);
            if ((this.classificationNode!= null)&&(!this.classificationNode.isEmpty())) {
                if ((that.classificationNode!= null)&&(!that.classificationNode.isEmpty())) {
                    if (!leftClassificationNode.equals(rightClassificationNode)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.classificationNode!= null)&&(!that.classificationNode.isEmpty())) {
                    return false;
                }
            }
        }
        {
            String leftParent;
            leftParent = this.getParent();
            String rightParent;
            rightParent = that.getParent();
            if (this.parent!= null) {
                if (that.parent!= null) {
                    if (!leftParent.equals(rightParent)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.parent!= null) {
                    return false;
                }
            }
        }
        {
            String leftCode;
            leftCode = this.getCode();
            String rightCode;
            rightCode = that.getCode();
            if (this.code!= null) {
                if (that.code!= null) {
                    if (!leftCode.equals(rightCode)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.code!= null) {
                    return false;
                }
            }
        }
        {
            String leftPath;
            leftPath = this.getPath();
            String rightPath;
            rightPath = that.getPath();
            if (this.path!= null) {
                if (that.path!= null) {
                    if (!leftPath.equals(rightPath)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.path!= null) {
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
            List<ClassificationNodeType> theClassificationNode;
            theClassificationNode = (((this.classificationNode!= null)&&(!this.classificationNode.isEmpty()))?this.getClassificationNode():null);
            if ((this.classificationNode!= null)&&(!this.classificationNode.isEmpty())) {
                currentHashCode += theClassificationNode.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theParent;
            theParent = this.getParent();
            if (this.parent!= null) {
                currentHashCode += theParent.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theCode;
            theCode = this.getCode();
            if (this.code!= null) {
                currentHashCode += theCode.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String thePath;
            thePath = this.getPath();
            if (this.path!= null) {
                currentHashCode += thePath.hashCode();
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
