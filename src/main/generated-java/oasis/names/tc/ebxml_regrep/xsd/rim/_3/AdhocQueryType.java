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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *       A registry query.
 *       A QueryExpression child element is not required when invoking a stored query.
 *       
 * 
 * <p>Java class for AdhocQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdhocQueryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}QueryExpression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdhocQueryType", propOrder = {
    "queryExpression"
})
public class AdhocQueryType
    extends RegistryObjectType
{

    @XmlElement(name = "QueryExpression")
    protected QueryExpressionType queryExpression;

    /**
     * Gets the value of the queryExpression property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.QueryExpressionType }
     *     
     */
    public QueryExpressionType getQueryExpression() {
        return queryExpression;
    }

    /**
     * Sets the value of the queryExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rim._3.QueryExpressionType }
     *     
     */
    public void setQueryExpression(QueryExpressionType value) {
        this.queryExpression = value;
    }

    public AdhocQueryType withQueryExpression(QueryExpressionType value) {
        setQueryExpression(value);
        return this;
    }

    @Override
    public AdhocQueryType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public AdhocQueryType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public AdhocQueryType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public AdhocQueryType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public AdhocQueryType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public AdhocQueryType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public AdhocQueryType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public AdhocQueryType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public AdhocQueryType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public AdhocQueryType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public AdhocQueryType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public AdhocQueryType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public AdhocQueryType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public AdhocQueryType withHome(String value) {
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
        final AdhocQueryType that = ((AdhocQueryType) object);
        {
            QueryExpressionType leftQueryExpression;
            leftQueryExpression = this.getQueryExpression();
            QueryExpressionType rightQueryExpression;
            rightQueryExpression = that.getQueryExpression();
            if (this.queryExpression!= null) {
                if (that.queryExpression!= null) {
                    if (!leftQueryExpression.equals(rightQueryExpression)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.queryExpression!= null) {
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
            QueryExpressionType theQueryExpression;
            theQueryExpression = this.getQueryExpression();
            if (this.queryExpression!= null) {
                currentHashCode += theQueryExpression.hashCode();
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
