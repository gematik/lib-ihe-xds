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
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A Subscription for specified Events in an ebXML V3+ registry.
 * 
 * <p>Java class for SubscriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Action" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="selector" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}referenceURI" /&gt;
 *       &lt;attribute name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="notificationInterval" type="{http://www.w3.org/2001/XMLSchema}duration" default="P1D" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionType", propOrder = {
    "action"
})
public class SubscriptionType
    extends RegistryObjectType
{

    @XmlElementRef(name = "Action", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends ActionType>> action;
    @XmlAttribute(name = "selector", required = true)
    protected String selector;
    @XmlAttribute(name = "startTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlAttribute(name = "endTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlAttribute(name = "notificationInterval")
    protected Duration notificationInterval;

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link jakarta.xml.bind.JAXBElement }{@code <}{@link ActionType }{@code >}
     * {@link jakarta.xml.bind.JAXBElement }{@code <}{@link NotifyActionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends ActionType>> getAction() {
        if (action == null) {
            action = new ArrayList<JAXBElement<? extends ActionType>>();
        }
        return this.action;
    }

    /**
     * Gets the value of the selector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelector() {
        return selector;
    }

    /**
     * Sets the value of the selector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelector(String value) {
        this.selector = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the notificationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.Duration }
     *     
     */
    public Duration getNotificationInterval() {
        return notificationInterval;
    }

    /**
     * Sets the value of the notificationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.Duration }
     *     
     */
    public void setNotificationInterval(Duration value) {
        this.notificationInterval = value;
    }

    public SubscriptionType withAction(JAXBElement<? extends ActionType> ... values) {
        if (values!= null) {
            for (JAXBElement<? extends ActionType> value: values) {
                getAction().add(value);
            }
        }
        return this;
    }

    public SubscriptionType withAction(Collection<JAXBElement<? extends ActionType>> values) {
        if (values!= null) {
            getAction().addAll(values);
        }
        return this;
    }

    public SubscriptionType withSelector(String value) {
        setSelector(value);
        return this;
    }

    public SubscriptionType withStartTime(XMLGregorianCalendar value) {
        setStartTime(value);
        return this;
    }

    public SubscriptionType withEndTime(XMLGregorianCalendar value) {
        setEndTime(value);
        return this;
    }

    public SubscriptionType withNotificationInterval(Duration value) {
        setNotificationInterval(value);
        return this;
    }

    @Override
    public SubscriptionType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public SubscriptionType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public SubscriptionType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public SubscriptionType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public SubscriptionType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public SubscriptionType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public SubscriptionType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public SubscriptionType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public SubscriptionType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public SubscriptionType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public SubscriptionType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public SubscriptionType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public SubscriptionType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public SubscriptionType withHome(String value) {
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
        final SubscriptionType that = ((SubscriptionType) object);
        {
            List<JAXBElement<? extends ActionType>> leftAction;
            leftAction = (((this.action!= null)&&(!this.action.isEmpty()))?this.getAction():null);
            List<JAXBElement<? extends ActionType>> rightAction;
            rightAction = (((that.action!= null)&&(!that.action.isEmpty()))?that.getAction():null);
            if ((this.action!= null)&&(!this.action.isEmpty())) {
                if ((that.action!= null)&&(!that.action.isEmpty())) {
                    if (!leftAction.equals(rightAction)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if ((that.action!= null)&&(!that.action.isEmpty())) {
                    return false;
                }
            }
        }
        {
            String leftSelector;
            leftSelector = this.getSelector();
            String rightSelector;
            rightSelector = that.getSelector();
            if (this.selector!= null) {
                if (that.selector!= null) {
                    if (!leftSelector.equals(rightSelector)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.selector!= null) {
                    return false;
                }
            }
        }
        {
            XMLGregorianCalendar leftStartTime;
            leftStartTime = this.getStartTime();
            XMLGregorianCalendar rightStartTime;
            rightStartTime = that.getStartTime();
            if (this.startTime!= null) {
                if (that.startTime!= null) {
                    if (!leftStartTime.equals(rightStartTime)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.startTime!= null) {
                    return false;
                }
            }
        }
        {
            XMLGregorianCalendar leftEndTime;
            leftEndTime = this.getEndTime();
            XMLGregorianCalendar rightEndTime;
            rightEndTime = that.getEndTime();
            if (this.endTime!= null) {
                if (that.endTime!= null) {
                    if (!leftEndTime.equals(rightEndTime)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.endTime!= null) {
                    return false;
                }
            }
        }
        {
            Duration leftNotificationInterval;
            leftNotificationInterval = this.getNotificationInterval();
            Duration rightNotificationInterval;
            rightNotificationInterval = that.getNotificationInterval();
            if (this.notificationInterval!= null) {
                if (that.notificationInterval!= null) {
                    if (!leftNotificationInterval.equals(rightNotificationInterval)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (that.notificationInterval!= null) {
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
            List<JAXBElement<? extends ActionType>> theAction;
            theAction = (((this.action!= null)&&(!this.action.isEmpty()))?this.getAction():null);
            if ((this.action!= null)&&(!this.action.isEmpty())) {
                currentHashCode += theAction.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            String theSelector;
            theSelector = this.getSelector();
            if (this.selector!= null) {
                currentHashCode += theSelector.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            XMLGregorianCalendar theStartTime;
            theStartTime = this.getStartTime();
            if (this.startTime!= null) {
                currentHashCode += theStartTime.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            XMLGregorianCalendar theEndTime;
            theEndTime = this.getEndTime();
            if (this.endTime!= null) {
                currentHashCode += theEndTime.hashCode();
            }
        }
        {
            currentHashCode = (currentHashCode* 31);
            Duration theNotificationInterval;
            theNotificationInterval = this.getNotificationInterval();
            if (this.notificationInterval!= null) {
                currentHashCode += theNotificationInterval.hashCode();
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
