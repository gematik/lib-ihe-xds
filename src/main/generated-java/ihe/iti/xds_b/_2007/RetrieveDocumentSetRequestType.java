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


package ihe.iti.xds_b._2007;

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
 * <p>Java class for RetrieveDocumentSetRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveDocumentSetRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocumentRequest" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="HomeCommunityId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
 *                   &lt;element name="RepositoryUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
 *                   &lt;element name="DocumentUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveDocumentSetRequestType", propOrder = {
    "documentRequest"
})
public class RetrieveDocumentSetRequestType {

    @XmlElement(name = "DocumentRequest", required = true)
    protected List<RetrieveDocumentSetRequestType.DocumentRequest> documentRequest;

    /**
     * Gets the value of the documentRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveDocumentSetRequestType.DocumentRequest }
     * 
     * 
     */
    public List<RetrieveDocumentSetRequestType.DocumentRequest> getDocumentRequest() {
        if (documentRequest == null) {
            documentRequest = new ArrayList<RetrieveDocumentSetRequestType.DocumentRequest>();
        }
        return this.documentRequest;
    }

    public RetrieveDocumentSetRequestType withDocumentRequest(RetrieveDocumentSetRequestType.DocumentRequest... values) {
        if (values!= null) {
            for (RetrieveDocumentSetRequestType.DocumentRequest value: values) {
                getDocumentRequest().add(value);
            }
        }
        return this;
    }

    public RetrieveDocumentSetRequestType withDocumentRequest(Collection<RetrieveDocumentSetRequestType.DocumentRequest> values) {
        if (values!= null) {
            getDocumentRequest().addAll(values);
        }
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
        final RetrieveDocumentSetRequestType that = ((RetrieveDocumentSetRequestType) object);
        {
            List<RetrieveDocumentSetRequestType.DocumentRequest> leftDocumentRequest;
            leftDocumentRequest = (((this.documentRequest!= null)&&(!this.documentRequest.isEmpty()))?this.getDocumentRequest():null);
            List<RetrieveDocumentSetRequestType.DocumentRequest> rightDocumentRequest;
            rightDocumentRequest = (((that.documentRequest!= null)&&(!that.documentRequest.isEmpty()))?that.getDocumentRequest():null);
            if ((this.documentRequest!= null)&&(!this.documentRequest.isEmpty())) {
                if ((that.documentRequest!= null)&&(!that.documentRequest.isEmpty())) {
                    if (!leftDocumentRequest.equals(rightDocumentRequest)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.documentRequest!= null)&&(!that.documentRequest.isEmpty())) {
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
            List<RetrieveDocumentSetRequestType.DocumentRequest> theDocumentRequest;
            theDocumentRequest = (((this.documentRequest!= null)&&(!this.documentRequest.isEmpty()))?this.getDocumentRequest():null);
            if ((this.documentRequest!= null)&&(!this.documentRequest.isEmpty())) {
                currentHashCode += theDocumentRequest.hashCode();
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="HomeCommunityId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
     *         &lt;element name="RepositoryUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
     *         &lt;element name="DocumentUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "homeCommunityId",
        "repositoryUniqueId",
        "documentUniqueId"
    })
    public static class DocumentRequest {

        @XmlElement(name = "HomeCommunityId")
        protected String homeCommunityId;
        @XmlElement(name = "RepositoryUniqueId", required = true)
        protected String repositoryUniqueId;
        @XmlElement(name = "DocumentUniqueId", required = true)
        protected String documentUniqueId;

        /**
         * Gets the value of the homeCommunityId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHomeCommunityId() {
            return homeCommunityId;
        }

        /**
         * Sets the value of the homeCommunityId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHomeCommunityId(String value) {
            this.homeCommunityId = value;
        }

        /**
         * Gets the value of the repositoryUniqueId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRepositoryUniqueId() {
            return repositoryUniqueId;
        }

        /**
         * Sets the value of the repositoryUniqueId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRepositoryUniqueId(String value) {
            this.repositoryUniqueId = value;
        }

        /**
         * Gets the value of the documentUniqueId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentUniqueId() {
            return documentUniqueId;
        }

        /**
         * Sets the value of the documentUniqueId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentUniqueId(String value) {
            this.documentUniqueId = value;
        }

        public RetrieveDocumentSetRequestType.DocumentRequest withHomeCommunityId(String value) {
            setHomeCommunityId(value);
            return this;
        }

        public RetrieveDocumentSetRequestType.DocumentRequest withRepositoryUniqueId(String value) {
            setRepositoryUniqueId(value);
            return this;
        }

        public RetrieveDocumentSetRequestType.DocumentRequest withDocumentUniqueId(String value) {
            setDocumentUniqueId(value);
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
            final RetrieveDocumentSetRequestType.DocumentRequest that = ((RetrieveDocumentSetRequestType.DocumentRequest) object);
            {
                String leftHomeCommunityId;
                leftHomeCommunityId = this.getHomeCommunityId();
                String rightHomeCommunityId;
                rightHomeCommunityId = that.getHomeCommunityId();
                if (this.homeCommunityId!= null) {
                    if (that.homeCommunityId!= null) {
                        if (!leftHomeCommunityId.equals(rightHomeCommunityId)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.homeCommunityId!= null) {
                        return false;
                    }
                }
            }
            {
                String leftRepositoryUniqueId;
                leftRepositoryUniqueId = this.getRepositoryUniqueId();
                String rightRepositoryUniqueId;
                rightRepositoryUniqueId = that.getRepositoryUniqueId();
                if (this.repositoryUniqueId!= null) {
                    if (that.repositoryUniqueId!= null) {
                        if (!leftRepositoryUniqueId.equals(rightRepositoryUniqueId)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.repositoryUniqueId!= null) {
                        return false;
                    }
                }
            }
            {
                String leftDocumentUniqueId;
                leftDocumentUniqueId = this.getDocumentUniqueId();
                String rightDocumentUniqueId;
                rightDocumentUniqueId = that.getDocumentUniqueId();
                if (this.documentUniqueId!= null) {
                    if (that.documentUniqueId!= null) {
                        if (!leftDocumentUniqueId.equals(rightDocumentUniqueId)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.documentUniqueId!= null) {
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
                String theHomeCommunityId;
                theHomeCommunityId = this.getHomeCommunityId();
                if (this.homeCommunityId!= null) {
                    currentHashCode += theHomeCommunityId.hashCode();
                }
            }
            {
                currentHashCode = (currentHashCode* 31);
                String theRepositoryUniqueId;
                theRepositoryUniqueId = this.getRepositoryUniqueId();
                if (this.repositoryUniqueId!= null) {
                    currentHashCode += theRepositoryUniqueId.hashCode();
                }
            }
            {
                currentHashCode = (currentHashCode* 31);
                String theDocumentUniqueId;
                theDocumentUniqueId = this.getDocumentUniqueId();
                if (this.documentUniqueId!= null) {
                    currentHashCode += theDocumentUniqueId.hashCode();
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

}