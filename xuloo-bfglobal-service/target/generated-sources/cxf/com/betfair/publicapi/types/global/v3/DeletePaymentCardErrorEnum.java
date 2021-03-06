
package com.betfair.publicapi.types.global.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeletePaymentCardErrorEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeletePaymentCardErrorEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="INVALID_CARD_DETAILS"/>
 *     &lt;enumeration value="INVALID_PASSWORD"/>
 *     &lt;enumeration value="ACCOUNT_INACTIVE"/>
 *     &lt;enumeration value="UNAUTHORIZED"/>
 *     &lt;enumeration value="CARD_NOT_DELETED"/>
 *     &lt;enumeration value="API_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeletePaymentCardErrorEnum")
@XmlEnum
public enum DeletePaymentCardErrorEnum {

    OK,
    INVALID_CARD_DETAILS,
    INVALID_PASSWORD,
    ACCOUNT_INACTIVE,
    UNAUTHORIZED,
    CARD_NOT_DELETED,
    API_ERROR;

    public String value() {
        return name();
    }

    public static DeletePaymentCardErrorEnum fromValue(String v) {
        return valueOf(v);
    }

}
