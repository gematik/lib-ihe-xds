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


package oasis.names.tc.ebxml_regrep.xsd.rim._3;

import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Mapping of the same named interface in ebRIM.
 * 
 * <p>Java class for UserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}PersonType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType")
public class UserType
    extends PersonType
{


    @Override
    public UserType withAddress(PostalAddressType... values) {
        if (values!= null) {
            for (PostalAddressType value: values) {
                getAddress().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withAddress(Collection<PostalAddressType> values) {
        if (values!= null) {
            getAddress().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withPersonName(PersonNameType value) {
        setPersonName(value);
        return this;
    }

    @Override
    public UserType withTelephoneNumber(TelephoneNumberType... values) {
        if (values!= null) {
            for (TelephoneNumberType value: values) {
                getTelephoneNumber().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withTelephoneNumber(Collection<TelephoneNumberType> values) {
        if (values!= null) {
            getTelephoneNumber().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withEmailAddress(EmailAddressType... values) {
        if (values!= null) {
            for (EmailAddressType value: values) {
                getEmailAddress().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withEmailAddress(Collection<EmailAddressType> values) {
        if (values!= null) {
            getEmailAddress().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withName(InternationalStringType value) {
        setName(value);
        return this;
    }

    @Override
    public UserType withDescription(InternationalStringType value) {
        setDescription(value);
        return this;
    }

    @Override
    public UserType withVersionInfo(VersionInfoType value) {
        setVersionInfo(value);
        return this;
    }

    @Override
    public UserType withClassification(ClassificationType... values) {
        if (values!= null) {
            for (ClassificationType value: values) {
                getClassification().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withClassification(Collection<ClassificationType> values) {
        if (values!= null) {
            getClassification().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withExternalIdentifier(ExternalIdentifierType... values) {
        if (values!= null) {
            for (ExternalIdentifierType value: values) {
                getExternalIdentifier().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withExternalIdentifier(Collection<ExternalIdentifierType> values) {
        if (values!= null) {
            getExternalIdentifier().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withLid(String value) {
        setLid(value);
        return this;
    }

    @Override
    public UserType withObjectType(String value) {
        setObjectType(value);
        return this;
    }

    @Override
    public UserType withStatus(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public UserType withSlot(SlotType1 ... values) {
        if (values!= null) {
            for (SlotType1 value: values) {
                getSlot().add(value);
            }
        }
        return this;
    }

    @Override
    public UserType withSlot(Collection<SlotType1> values) {
        if (values!= null) {
            getSlot().addAll(values);
        }
        return this;
    }

    @Override
    public UserType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public UserType withHome(String value) {
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
        return true;
    }

    @Override
    public int hashCode() {
        int currentHashCode = 1;
        currentHashCode = ((currentHashCode* 31)+ super.hashCode());
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