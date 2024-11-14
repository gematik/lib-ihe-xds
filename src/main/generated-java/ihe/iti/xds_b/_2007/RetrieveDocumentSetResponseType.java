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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RetrieveDocumentSetResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveDocumentSetResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0}RegistryResponse"/&gt;
 *         &lt;sequence minOccurs="0"&gt;
 *           &lt;element name="DocumentResponse" maxOccurs="unbounded"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="HomeCommunityId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
 *                     &lt;element name="RepositoryUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
 *                     &lt;element name="DocumentUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
 *                     &lt;element name="NewRepositoryUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
 *                     &lt;element name="NewDocumentUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
 *                     &lt;element name="mimeType" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
 *                     &lt;element name="Document" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveDocumentSetResponseType", propOrder = {
    "registryResponse",
    "documentResponse"
})
public class RetrieveDocumentSetResponseType {

    @XmlElement(name = "RegistryResponse", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0", required = true)
    protected RegistryResponseType registryResponse;
    @XmlElement(name = "DocumentResponse")
    protected List<DocumentResponse> documentResponse;

    /**
     * Gets the value of the registryResponse property.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType }
     *     
     */
    public RegistryResponseType getRegistryResponse() {
        return registryResponse;
    }

    /**
     * Sets the value of the registryResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType }
     *     
     */
    public void setRegistryResponse(RegistryResponseType value) {
        this.registryResponse = value;
    }

    /**
     * Gets the value of the documentResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ihe.iti.xds_b._2007.RetrieveDocumentSetResponseType.DocumentResponse }
     * 
     * 
     */
    public List<DocumentResponse> getDocumentResponse() {
        if (documentResponse == null) {
            documentResponse = new ArrayList<DocumentResponse>();
        }
        return this.documentResponse;
    }

    public RetrieveDocumentSetResponseType withRegistryResponse(RegistryResponseType value) {
        setRegistryResponse(value);
        return this;
    }

    public RetrieveDocumentSetResponseType withDocumentResponse(DocumentResponse... values) {
        if (values!= null) {
            for (DocumentResponse value: values) {
                getDocumentResponse().add(value);
            }
        }
        return this;
    }

    public RetrieveDocumentSetResponseType withDocumentResponse(Collection<DocumentResponse> values) {
        if (values!= null) {
            getDocumentResponse().addAll(values);
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
        final RetrieveDocumentSetResponseType that = ((RetrieveDocumentSetResponseType) object);
        {
            RegistryResponseType leftRegistryResponse;
            leftRegistryResponse = this.getRegistryResponse();
            RegistryResponseType rightRegistryResponse;
            rightRegistryResponse = that.getRegistryResponse();
            if (this.registryResponse!= null) {
                if (that.registryResponse!= null) {
                    if (!leftRegistryResponse.equals(rightRegistryResponse)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.registryResponse!= null) {
                    return false;
                }
            }
        }
        {
            List<DocumentResponse> leftDocumentResponse;
            leftDocumentResponse = (((this.documentResponse!= null)&&(!this.documentResponse.isEmpty()))?this.getDocumentResponse():null);
            List<DocumentResponse> rightDocumentResponse;
            rightDocumentResponse = (((that.documentResponse!= null)&&(!that.documentResponse.isEmpty()))?that.getDocumentResponse():null);
            if ((this.documentResponse!= null)&&(!this.documentResponse.isEmpty())) {
                if ((that.documentResponse!= null)&&(!that.documentResponse.isEmpty())) {
                    if (!leftDocumentResponse.equals(rightDocumentResponse)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.documentResponse!= null)&&(!that.documentResponse.isEmpty())) {
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
            RegistryResponseType theRegistryResponse;
            theRegistryResponse = this.getRegistryResponse();
            if (this.registryResponse!= null) {
                currentHashCode += theRegistryResponse.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            List<DocumentResponse> theDocumentResponse;
            theDocumentResponse = (((this.documentResponse!= null)&&(!this.documentResponse.isEmpty()))?this.getDocumentResponse():null);
            if ((this.documentResponse!= null)&&(!this.documentResponse.isEmpty())) {
                currentHashCode += theDocumentResponse.hashCode();
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
     *         &lt;element name="NewRepositoryUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
     *         &lt;element name="NewDocumentUniqueId" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName" minOccurs="0"/&gt;
     *         &lt;element name="mimeType" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}LongName"/&gt;
     *         &lt;element name="Document" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
        "documentUniqueId",
        "newRepositoryUniqueId",
        "newDocumentUniqueId",
        "mimeType",
        "document"
    })
    public static class DocumentResponse {

        @XmlElement(name = "HomeCommunityId")
        protected String homeCommunityId;
        @XmlElement(name = "RepositoryUniqueId", required = true)
        protected String repositoryUniqueId;
        @XmlElement(name = "DocumentUniqueId", required = true)
        protected String documentUniqueId;
        @XmlElement(name = "NewRepositoryUniqueId")
        protected String newRepositoryUniqueId;
        @XmlElement(name = "NewDocumentUniqueId")
        protected String newDocumentUniqueId;
        @XmlElement(required = true)
        protected String mimeType;
        @XmlElement(name = "Document", required = true)
        protected byte[] document;

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

        /**
         * Gets the value of the newRepositoryUniqueId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNewRepositoryUniqueId() {
            return newRepositoryUniqueId;
        }

        /**
         * Sets the value of the newRepositoryUniqueId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNewRepositoryUniqueId(String value) {
            this.newRepositoryUniqueId = value;
        }

        /**
         * Gets the value of the newDocumentUniqueId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNewDocumentUniqueId() {
            return newDocumentUniqueId;
        }

        /**
         * Sets the value of the newDocumentUniqueId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNewDocumentUniqueId(String value) {
            this.newDocumentUniqueId = value;
        }

        /**
         * Gets the value of the mimeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMimeType() {
            return mimeType;
        }

        /**
         * Sets the value of the mimeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMimeType(String value) {
            this.mimeType = value;
        }

        /**
         * Gets the value of the document property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getDocument() {
            return document;
        }

        /**
         * Sets the value of the document property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setDocument(byte[] value) {
            this.document = value;
        }

        public DocumentResponse withHomeCommunityId(String value) {
            setHomeCommunityId(value);
            return this;
        }

        public DocumentResponse withRepositoryUniqueId(String value) {
            setRepositoryUniqueId(value);
            return this;
        }

        public DocumentResponse withDocumentUniqueId(String value) {
            setDocumentUniqueId(value);
            return this;
        }

        public DocumentResponse withNewRepositoryUniqueId(String value) {
            setNewRepositoryUniqueId(value);
            return this;
        }

        public DocumentResponse withNewDocumentUniqueId(String value) {
            setNewDocumentUniqueId(value);
            return this;
        }

        public DocumentResponse withMimeType(String value) {
            setMimeType(value);
            return this;
        }

        public DocumentResponse withDocument(byte[] value) {
            setDocument(value);
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
            final DocumentResponse that = ((DocumentResponse) object);
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
            {
                String leftNewRepositoryUniqueId;
                leftNewRepositoryUniqueId = this.getNewRepositoryUniqueId();
                String rightNewRepositoryUniqueId;
                rightNewRepositoryUniqueId = that.getNewRepositoryUniqueId();
                if (this.newRepositoryUniqueId!= null) {
                    if (that.newRepositoryUniqueId!= null) {
                        if (!leftNewRepositoryUniqueId.equals(rightNewRepositoryUniqueId)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.newRepositoryUniqueId!= null) {
                        return false;
                    }
                }
            }
            {
                String leftNewDocumentUniqueId;
                leftNewDocumentUniqueId = this.getNewDocumentUniqueId();
                String rightNewDocumentUniqueId;
                rightNewDocumentUniqueId = that.getNewDocumentUniqueId();
                if (this.newDocumentUniqueId!= null) {
                    if (that.newDocumentUniqueId!= null) {
                        if (!leftNewDocumentUniqueId.equals(rightNewDocumentUniqueId)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.newDocumentUniqueId!= null) {
                        return false;
                    }
                }
            }
            {
                String leftMimeType;
                leftMimeType = this.getMimeType();
                String rightMimeType;
                rightMimeType = that.getMimeType();
                if (this.mimeType!= null) {
                    if (that.mimeType!= null) {
                        if (!leftMimeType.equals(rightMimeType)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.mimeType!= null) {
                        return false;
                    }
                }
            }
            {
                byte[] leftDocument;
                leftDocument = this.getDocument();
                byte[] rightDocument;
                rightDocument = that.getDocument();
                if (this.document!= null) {
                    if (that.document!= null) {
                        if (!Arrays.equals(leftDocument, rightDocument)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (that.document!= null) {
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
            {
                currentHashCode = (currentHashCode* 31);
                String theNewRepositoryUniqueId;
                theNewRepositoryUniqueId = this.getNewRepositoryUniqueId();
                if (this.newRepositoryUniqueId!= null) {
                    currentHashCode += theNewRepositoryUniqueId.hashCode();
                }
            }
            {
                currentHashCode = (currentHashCode* 31);
                String theNewDocumentUniqueId;
                theNewDocumentUniqueId = this.getNewDocumentUniqueId();
                if (this.newDocumentUniqueId!= null) {
                    currentHashCode += theNewDocumentUniqueId.hashCode();
                }
            }
            {
                currentHashCode = (currentHashCode* 31);
                String theMimeType;
                theMimeType = this.getMimeType();
                if (this.mimeType!= null) {
                    currentHashCode += theMimeType.hashCode();
                }
            }
            {
                currentHashCode = (currentHashCode* 31);
                byte[] theDocument;
                theDocument = this.getDocument();
                currentHashCode += Arrays.hashCode(theDocument);
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
