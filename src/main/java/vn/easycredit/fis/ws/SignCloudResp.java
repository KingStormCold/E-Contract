
package vn.easycredit.fis.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for signCloudResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signCloudResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authModeSupported" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorizationMethodsEnabled" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorizeCredential" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizeMethod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="billCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateStateID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="certificateThumbprint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credentialExpireIn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="csr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dmsMetaData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadedFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="downloadedFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="issuerDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logInstance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="multipleSignedFileData" type="{http://api.esigncloud.mobileid.vn/}multipleSignedFileData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="notificationMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notificationSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receipt" type="{http://api.esigncloud.mobileid.vn/}receipt" minOccurs="0"/>
 *         &lt;element name="remainingCounter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="responseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signatureValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signedFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signedFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signedFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signerInfo" type="{http://api.esigncloud.mobileid.vn/}signerInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="uploadedFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signCloudResp", propOrder = {
    "authModeSupported",
    "authorizationMethodsEnabled",
    "authorizeCredential",
    "authorizeMethod",
    "billCode",
    "certificate",
    "certificateDN",
    "certificateSerialNumber",
    "certificateStateID",
    "certificateThumbprint",
    "credentialExpireIn",
    "csr",
    "dmsMetaData",
    "downloadedFileData",
    "downloadedFileUUID",
    "issuerDN",
    "logInstance",
    "mimeType",
    "multipleSignedFileData",
    "notificationMessage",
    "notificationSubject",
    "receipt",
    "remainingCounter",
    "responseCode",
    "responseMessage",
    "signatureValue",
    "signedFileData",
    "signedFileName",
    "signedFileUUID",
    "signerInfo",
    "timestamp",
    "uploadedFileUUID",
    "validFrom",
    "validTo"
})
public class SignCloudResp {

    @XmlElement(nillable = true)
    protected List<String> authModeSupported;
    @XmlElement(nillable = true)
    protected List<Integer> authorizationMethodsEnabled;
    protected String authorizeCredential;
    protected int authorizeMethod;
    protected String billCode;
    protected String certificate;
    protected String certificateDN;
    protected String certificateSerialNumber;
    protected int certificateStateID;
    protected String certificateThumbprint;
    protected int credentialExpireIn;
    protected String csr;
    protected String dmsMetaData;
    protected byte[] downloadedFileData;
    protected String downloadedFileUUID;
    protected String issuerDN;
    protected int logInstance;
    protected String mimeType;
    @XmlElement(nillable = true)
    protected List<MultipleSignedFileData> multipleSignedFileData;
    protected String notificationMessage;
    protected String notificationSubject;
    protected Receipt receipt;
    protected int remainingCounter;
    protected int responseCode;
    protected String responseMessage;
    protected String signatureValue;
    protected byte[] signedFileData;
    protected String signedFileName;
    protected String signedFileUUID;
    @XmlElement(nillable = true)
    protected List<SignerInfo> signerInfo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    protected String uploadedFileUUID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validTo;

    /**
     * Gets the value of the authModeSupported property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authModeSupported property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthModeSupported().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAuthModeSupported() {
        if (authModeSupported == null) {
            authModeSupported = new ArrayList<String>();
        }
        return this.authModeSupported;
    }

    /**
     * Gets the value of the authorizationMethodsEnabled property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizationMethodsEnabled property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizationMethodsEnabled().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAuthorizationMethodsEnabled() {
        if (authorizationMethodsEnabled == null) {
            authorizationMethodsEnabled = new ArrayList<Integer>();
        }
        return this.authorizationMethodsEnabled;
    }

    /**
     * Gets the value of the authorizeCredential property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizeCredential() {
        return authorizeCredential;
    }

    /**
     * Sets the value of the authorizeCredential property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizeCredential(String value) {
        this.authorizeCredential = value;
    }

    /**
     * Gets the value of the authorizeMethod property.
     * 
     */
    public int getAuthorizeMethod() {
        return authorizeMethod;
    }

    /**
     * Sets the value of the authorizeMethod property.
     * 
     */
    public void setAuthorizeMethod(int value) {
        this.authorizeMethod = value;
    }

    /**
     * Gets the value of the billCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillCode() {
        return billCode;
    }

    /**
     * Sets the value of the billCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillCode(String value) {
        this.billCode = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificate(String value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the certificateDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateDN() {
        return certificateDN;
    }

    /**
     * Sets the value of the certificateDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateDN(String value) {
        this.certificateDN = value;
    }

    /**
     * Gets the value of the certificateSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateSerialNumber() {
        return certificateSerialNumber;
    }

    /**
     * Sets the value of the certificateSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateSerialNumber(String value) {
        this.certificateSerialNumber = value;
    }

    /**
     * Gets the value of the certificateStateID property.
     * 
     */
    public int getCertificateStateID() {
        return certificateStateID;
    }

    /**
     * Sets the value of the certificateStateID property.
     * 
     */
    public void setCertificateStateID(int value) {
        this.certificateStateID = value;
    }

    /**
     * Gets the value of the certificateThumbprint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateThumbprint() {
        return certificateThumbprint;
    }

    /**
     * Sets the value of the certificateThumbprint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateThumbprint(String value) {
        this.certificateThumbprint = value;
    }

    /**
     * Gets the value of the credentialExpireIn property.
     * 
     */
    public int getCredentialExpireIn() {
        return credentialExpireIn;
    }

    /**
     * Sets the value of the credentialExpireIn property.
     * 
     */
    public void setCredentialExpireIn(int value) {
        this.credentialExpireIn = value;
    }

    /**
     * Gets the value of the csr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsr() {
        return csr;
    }

    /**
     * Sets the value of the csr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsr(String value) {
        this.csr = value;
    }

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
     * Gets the value of the downloadedFileData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDownloadedFileData() {
        return downloadedFileData;
    }

    /**
     * Sets the value of the downloadedFileData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDownloadedFileData(byte[] value) {
        this.downloadedFileData = value;
    }

    /**
     * Gets the value of the downloadedFileUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadedFileUUID() {
        return downloadedFileUUID;
    }

    /**
     * Sets the value of the downloadedFileUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadedFileUUID(String value) {
        this.downloadedFileUUID = value;
    }

    /**
     * Gets the value of the issuerDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerDN() {
        return issuerDN;
    }

    /**
     * Sets the value of the issuerDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerDN(String value) {
        this.issuerDN = value;
    }

    /**
     * Gets the value of the logInstance property.
     * 
     */
    public int getLogInstance() {
        return logInstance;
    }

    /**
     * Sets the value of the logInstance property.
     * 
     */
    public void setLogInstance(int value) {
        this.logInstance = value;
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
     * Gets the value of the multipleSignedFileData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multipleSignedFileData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultipleSignedFileData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultipleSignedFileData }
     * 
     * 
     */
    public List<MultipleSignedFileData> getMultipleSignedFileData() {
        if (multipleSignedFileData == null) {
            multipleSignedFileData = new ArrayList<MultipleSignedFileData>();
        }
        return this.multipleSignedFileData;
    }

    /**
     * Gets the value of the notificationMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationMessage() {
        return notificationMessage;
    }

    /**
     * Sets the value of the notificationMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationMessage(String value) {
        this.notificationMessage = value;
    }

    /**
     * Gets the value of the notificationSubject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationSubject() {
        return notificationSubject;
    }

    /**
     * Sets the value of the notificationSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationSubject(String value) {
        this.notificationSubject = value;
    }

    /**
     * Gets the value of the receipt property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt }
     *     
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * Sets the value of the receipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt }
     *     
     */
    public void setReceipt(Receipt value) {
        this.receipt = value;
    }

    /**
     * Gets the value of the remainingCounter property.
     * 
     */
    public int getRemainingCounter() {
        return remainingCounter;
    }

    /**
     * Sets the value of the remainingCounter property.
     * 
     */
    public void setRemainingCounter(int value) {
        this.remainingCounter = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     */
    public void setResponseCode(int value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the value of the responseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
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

    /**
     * Gets the value of the signerInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signerInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignerInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignerInfo }
     * 
     * 
     */
    public List<SignerInfo> getSignerInfo() {
        if (signerInfo == null) {
            signerInfo = new ArrayList<SignerInfo>();
        }
        return this.signerInfo;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the uploadedFileUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadedFileUUID() {
        return uploadedFileUUID;
    }

    /**
     * Sets the value of the uploadedFileUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadedFileUUID(String value) {
        this.uploadedFileUUID = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

}
