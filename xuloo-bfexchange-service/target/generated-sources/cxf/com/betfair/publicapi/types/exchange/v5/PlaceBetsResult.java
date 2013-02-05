
package com.betfair.publicapi.types.exchange.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceBetsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaceBetsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="averagePriceMatched" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="betId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="resultCode" type="{http://www.betfair.com/publicapi/types/exchange/v5/}PlaceBetsResultEnum"/>
 *         &lt;element name="sizeMatched" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceBetsResult", propOrder = {
    "averagePriceMatched",
    "betId",
    "resultCode",
    "sizeMatched",
    "success"
})
public class PlaceBetsResult {

    protected double averagePriceMatched;
    protected long betId;
    @XmlElement(required = true)
    protected PlaceBetsResultEnum resultCode;
    protected double sizeMatched;
    protected boolean success;

    /**
     * Gets the value of the averagePriceMatched property.
     * 
     */
    public double getAveragePriceMatched() {
        return averagePriceMatched;
    }

    /**
     * Sets the value of the averagePriceMatched property.
     * 
     */
    public void setAveragePriceMatched(double value) {
        this.averagePriceMatched = value;
    }

    /**
     * Gets the value of the betId property.
     * 
     */
    public long getBetId() {
        return betId;
    }

    /**
     * Sets the value of the betId property.
     * 
     */
    public void setBetId(long value) {
        this.betId = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceBetsResultEnum }
     *     
     */
    public PlaceBetsResultEnum getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceBetsResultEnum }
     *     
     */
    public void setResultCode(PlaceBetsResultEnum value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the sizeMatched property.
     * 
     */
    public double getSizeMatched() {
        return sizeMatched;
    }

    /**
     * Sets the value of the sizeMatched property.
     * 
     */
    public void setSizeMatched(double value) {
        this.sizeMatched = value;
    }

    /**
     * Gets the value of the success property.
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

}
