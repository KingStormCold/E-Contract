
package vn.easycredit.fis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authorizeSingletonSigningForSignCloud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authorizeSingletonSigningForSignCloud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signCloudReq" type="{http://api.esigncloud.mobileid.vn/}signCloudReq" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authorizeSingletonSigningForSignCloud", propOrder = {
    "signCloudReq"
})
public class AuthorizeSingletonSigningForSignCloud {

    protected SignCloudReq signCloudReq;

    /**
     * Gets the value of the signCloudReq property.
     * 
     * @return
     *     possible object is
     *     {@link SignCloudReq }
     *     
     */
    public SignCloudReq getSignCloudReq() {
        return signCloudReq;
    }

    /**
     * Sets the value of the signCloudReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignCloudReq }
     *     
     */
    public void setSignCloudReq(SignCloudReq value) {
        this.signCloudReq = value;
    }

}
