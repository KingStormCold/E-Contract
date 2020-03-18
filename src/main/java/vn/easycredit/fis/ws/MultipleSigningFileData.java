
package vn.easycredit.fis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for multipleSigningFileData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multipleSigningFileData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signCloudMetaData" type="{http://api.esigncloud.mobileid.vn/}signCloudMetaData" minOccurs="0"/>
 *         &lt;element name="signingFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signingFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmlDocument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xslTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multipleSigningFileData", propOrder = {
    "hash",
    "mimeType",
    "signCloudMetaData",
    "signingFileData",
    "signingFileName",
    "xmlDocument",
    "xslTemplate"
})
public class MultipleSigningFileData {

    protected String hash;
    protected String mimeType;
    protected SignCloudMetaData signCloudMetaData;
    protected byte[] signingFileData;
    protected String signingFileName;
    protected String xmlDocument;
    protected String xslTemplate;

    /**
     * Gets the value of the hash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHash() {
        return hash;
    }

    /**
     * Sets the value of the hash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHash(String value) {
        this.hash = value;
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
     * Gets the value of the signCloudMetaData property.
     * 
     * @return
     *     possible object is
     *     {@link SignCloudMetaData }
     *     
     */
    public SignCloudMetaData getSignCloudMetaData() {
        return signCloudMetaData;
    }

    /**
     * Sets the value of the signCloudMetaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignCloudMetaData }
     *     
     */
    public void setSignCloudMetaData(SignCloudMetaData value) {
        this.signCloudMetaData = value;
    }

    /**
     * Gets the value of the signingFileData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSigningFileData() {
        return signingFileData;
    }

    /**
     * Sets the value of the signingFileData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSigningFileData(byte[] value) {
        this.signingFileData = value;
    }

    /**
     * Gets the value of the signingFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigningFileName() {
        return signingFileName;
    }

    /**
     * Sets the value of the signingFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigningFileName(String value) {
        this.signingFileName = value;
    }

    /**
     * Gets the value of the xmlDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlDocument() {
        return xmlDocument;
    }

    /**
     * Sets the value of the xmlDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlDocument(String value) {
        this.xmlDocument = value;
    }

    /**
     * Gets the value of the xslTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXslTemplate() {
        return xslTemplate;
    }

    /**
     * Sets the value of the xslTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXslTemplate(String value) {
        this.xslTemplate = value;
    }

}
