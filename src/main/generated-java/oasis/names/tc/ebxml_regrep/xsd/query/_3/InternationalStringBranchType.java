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


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for InternationalStringBranchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InternationalStringBranchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}BranchType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalizedStringFilter" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}FilterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalStringBranchType", propOrder = {
    "localizedStringFilter"
})
public class InternationalStringBranchType
    extends BranchType
{

    @XmlElement(name = "LocalizedStringFilter")
    protected List<FilterType> localizedStringFilter;

    /**
     * Gets the value of the localizedStringFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the localizedStringFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizedStringFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilterType }
     * 
     * 
     */
    public List<FilterType> getLocalizedStringFilter() {
        if (localizedStringFilter == null) {
            localizedStringFilter = new ArrayList<FilterType>();
        }
        return this.localizedStringFilter;
    }

    public InternationalStringBranchType withLocalizedStringFilter(FilterType... values) {
        if (values!= null) {
            for (FilterType value: values) {
                getLocalizedStringFilter().add(value);
            }
        }
        return this;
    }

    public InternationalStringBranchType withLocalizedStringFilter(Collection<FilterType> values) {
        if (values!= null) {
            getLocalizedStringFilter().addAll(values);
        }
        return this;
    }

    @Override
    public InternationalStringBranchType withPrimaryFilter(FilterType value) {
        setPrimaryFilter(value);
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
        final InternationalStringBranchType that = ((InternationalStringBranchType) object);
        {
            List<FilterType> leftLocalizedStringFilter;
            leftLocalizedStringFilter = (((this.localizedStringFilter!= null)&&(!this.localizedStringFilter.isEmpty()))?this.getLocalizedStringFilter():null);
            List<FilterType> rightLocalizedStringFilter;
            rightLocalizedStringFilter = (((that.localizedStringFilter!= null)&&(!that.localizedStringFilter.isEmpty()))?that.getLocalizedStringFilter():null);
            if ((this.localizedStringFilter!= null)&&(!this.localizedStringFilter.isEmpty())) {
                if ((that.localizedStringFilter!= null)&&(!that.localizedStringFilter.isEmpty())) {
                    if (!leftLocalizedStringFilter.equals(rightLocalizedStringFilter)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.localizedStringFilter!= null)&&(!that.localizedStringFilter.isEmpty())) {
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
            List<FilterType> theLocalizedStringFilter;
            theLocalizedStringFilter = (((this.localizedStringFilter!= null)&&(!this.localizedStringFilter.isEmpty()))?this.getLocalizedStringFilter():null);
            if ((this.localizedStringFilter!= null)&&(!this.localizedStringFilter.isEmpty())) {
                currentHashCode += theLocalizedStringFilter.hashCode();
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
