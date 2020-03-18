
package vn.easycredit.fis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for multipleSignedFileData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multipleSignedFileData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dmsMetaData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signatureValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signedFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signedFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signedFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multipleSignedFileData", propOrder = {
    "dmsMetaData",
    "mimeType",
    "signatureValue",
    "signedFileData",
    "signedFileName",
    "signedFileUUID"
})
public class MultipleSignedFileData {

    protected String dmsMetaData;
    protected String mimeType;
    protected String signatureValue;
    protected byte[] signedFileData;
    protected String signedFileName;
    protected String signedFileUUID;

    /**
     * Gets the value of the dmsMetaData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDmsMetaData() {
        return dmsMetaData;
    }

    /**
     * Sets the value of the dmsMetaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDmsMetaData(String value) {
        this.dmsMetaData = value;
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
     * Gets the value of the signatureValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureValue() {
        return signatureValue;
    }

    /**
     * Sets the value of the signatureValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureValue(String value) {
        this.signatureValue = value;
    }

    /**
     * Gets the value of the signedFileData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSignedFileData() {
        return signedFileData;
    }

    /**
     * Sets the value of the signedFileData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSignedFileData(byte[] value) {
        this.signedFileData = value;
    }

    /**
     * Gets the value of the signedFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignedFileName() {
        return signedFileName;
    }

    /**
     * Sets the value of the signedFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignedFileName(String value) {
        this.signedFileName = value;
    }

    /**
     * Gets the value of the signedFileUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignedFileUUID() {
        return signedFileUUID;
    }

    /**
     * Sets the value of the signedFileUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignedFileUUID(String value) {
        this.signedFileUUID = value;
    }

}
