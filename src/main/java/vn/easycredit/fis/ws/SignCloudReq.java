
package vn.easycredit.fis.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signCloudReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signCloudReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agreementDetails" type="{http://api.esigncloud.mobileid.vn/}agreementDetails" minOccurs="0"/>
 *         &lt;element name="agreementUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizeMethod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="billCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="credentialData" type="{http://api.esigncloud.mobileid.vn/}credentialData" minOccurs="0"/>
 *         &lt;element name="csrRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="currentPasscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadingFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="encryption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hardwareInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keepCertificateSerialNumberEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="keepOldKeysEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ltvEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="messagingMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobileNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="multipleSigningFileData" type="{http://api.esigncloud.mobileid.vn/}multipleSigningFileData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="newPasscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noPadding" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="notificationSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notificationTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p2pEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="postbackEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="relyingParty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relyingPartyBillCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revokeOldCertificateEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sharedAgreementUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sharedMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sharedRelyingParty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signCloudMetaData" type="{http://api.esigncloud.mobileid.vn/}signCloudMetaData" minOccurs="0"/>
 *         &lt;element name="signerInfoConstraintEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="signingFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signingFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signingFileUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestampEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="uploadingFileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="xmlDocument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xslTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xslTemplateUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signCloudReq", propOrder = {
    "agreementDetails",
    "agreementUUID",
    "authMode",
    "authorizeCode",
    "authorizeMethod",
    "billCode",
    "certificate",
    "certificateProfile",
    "certificateRequired",
    "credentialData",
    "csrRequired",
    "currentPasscode",
    "downloadingFileUUID",
    "email",
    "encryption",
    "hardwareInfo",
    "hash",
    "hashAlgorithm",
    "keepCertificateSerialNumberEnabled",
    "keepOldKeysEnabled",
    "language",
    "ltvEnabled",
    "messagingMode",
    "mimeType",
    "mobileNo",
    "multipleSigningFileData",
    "newPasscode",
    "noPadding",
    "notificationSubject",
    "notificationTemplate",
    "p2PEnabled",
    "postbackEnabled",
    "relyingParty",
    "relyingPartyBillCode",
    "revokeOldCertificateEnabled",
    "sharedAgreementUUID",
    "sharedMode",
    "sharedRelyingParty",
    "signCloudMetaData",
    "signerInfoConstraintEnabled",
    "signingFileData",
    "signingFileName",
    "signingFileUUID",
    "timestampEnabled",
    "uploadingFileData",
    "xmlDocument",
    "xslTemplate",
    "xslTemplateUUID"
})
public class SignCloudReq {

    protected AgreementDetails agreementDetails;
    protected String agreementUUID;
    protected String authMode;
    protected String authorizeCode;
    protected int authorizeMethod;
    protected String billCode;
    protected String certificate;
    protected String certificateProfile;
    protected boolean certificateRequired;
    protected CredentialData credentialData;
    protected boolean csrRequired;
    protected String currentPasscode;
    protected String downloadingFileUUID;
    protected String email;
    protected String encryption;
    protected String hardwareInfo;
    protected String hash;
    protected String hashAlgorithm;
    protected boolean keepCertificateSerialNumberEnabled;
    protected boolean keepOldKeysEnabled;
    protected String language;
    protected boolean ltvEnabled;
    protected int messagingMode;
    protected String mimeType;
    protected String mobileNo;
    @XmlElement(nillable = true)
    protected List<MultipleSigningFileData> multipleSigningFileData;
    protected String newPasscode;
    protected boolean noPadding;
    protected String notificationSubject;
    protected String notificationTemplate;
    @XmlElement(name = "p2pEnabled")
    protected boolean p2PEnabled;
    protected boolean postbackEnabled;
    protected String relyingParty;
    protected String relyingPartyBillCode;
    protected boolean revokeOldCertificateEnabled;
    protected String sharedAgreementUUID;
    protected int sharedMode;
    protected String sharedRelyingParty;
    protected SignCloudMetaData signCloudMetaData;
    protected boolean signerInfoConstraintEnabled;
    protected byte[] signingFileData;
    protected String signingFileName;
    protected String signingFileUUID;
    protected boolean timestampEnabled;
    protected byte[] uploadingFileData;
    protected String xmlDocument;
    protected String xslTemplate;
    protected String xslTemplateUUID;

    /**
     * Gets the value of the agreementDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AgreementDetails }
     *     
     */
    public AgreementDetails getAgreementDetails() {
        return agreementDetails;
    }

    /**
     * Sets the value of the agreementDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgreementDetails }
     *     
     */
    public void setAgreementDetails(AgreementDetails value) {
        this.agreementDetails = value;
    }

    /**
     * Gets the value of the agreementUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementUUID() {
        return agreementUUID;
    }

    /**
     * Sets the value of the agreementUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementUUID(String value) {
        this.agreementUUID = value;
    }

    /**
     * Gets the value of the authMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthMode() {
        return authMode;
    }

    /**
     * Sets the value of the authMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthMode(String value) {
        this.authMode = value;
    }

    /**
     * Gets the value of the authorizeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizeCode() {
        return authorizeCode;
    }

    /**
     * Sets the value of the authorizeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizeCode(String value) {
        this.authorizeCode = value;
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
     * Gets the value of the certificateProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateProfile() {
        return certificateProfile;
    }

    /**
     * Sets the value of the certificateProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateProfile(String value) {
        this.certificateProfile = value;
    }

    /**
     * Gets the value of the certificateRequired property.
     * 
     */
    public boolean isCertificateRequired() {
        return certificateRequired;
    }

    /**
     * Sets the value of the certificateRequired property.
     * 
     */
    public void setCertificateRequired(boolean value) {
        this.certificateRequired = value;
    }

    /**
     * Gets the value of the credentialData property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialData }
     *     
     */
    public CredentialData getCredentialData() {
        return credentialData;
    }

    /**
     * Sets the value of the credentialData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialData }
     *     
     */
    public void setCredentialData(CredentialData value) {
        this.credentialData = value;
    }

    /**
     * Gets the value of the csrRequired property.
     * 
     */
    public boolean isCsrRequired() {
        return csrRequired;
    }

    /**
     * Sets the value of the csrRequired property.
     * 
     */
    public void setCsrRequired(boolean value) {
        this.csrRequired = value;
    }

    /**
     * Gets the value of the currentPasscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentPasscode() {
        return currentPasscode;
    }

    /**
     * Sets the value of the currentPasscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentPasscode(String value) {
        this.currentPasscode = value;
    }

    /**
     * Gets the value of the downloadingFileUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadingFileUUID() {
        return downloadingFileUUID;
    }

    /**
     * Sets the value of the downloadingFileUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadingFileUUID(String value) {
        this.downloadingFileUUID = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the encryption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryption() {
        return encryption;
    }

    /**
     * Sets the value of the encryption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryption(String value) {
        this.encryption = value;
    }

    /**
     * Gets the value of the hardwareInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardwareInfo() {
        return hardwareInfo;
    }

    /**
     * Sets the value of the hardwareInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardwareInfo(String value) {
        this.hardwareInfo = value;
    }

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
     * Gets the value of the hashAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Sets the value of the hashAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashAlgorithm(String value) {
        this.hashAlgorithm = value;
    }

    /**
     * Gets the value of the keepCertificateSerialNumberEnabled property.
     * 
     */
    public boolean isKeepCertificateSerialNumberEnabled() {
        return keepCertificateSerialNumberEnabled;
    }

    /**
     * Sets the value of the keepCertificateSerialNumberEnabled property.
     * 
     */
    public void setKeepCertificateSerialNumberEnabled(boolean value) {
        this.keepCertificateSerialNumberEnabled = value;
    }

    /**
     * Gets the value of the keepOldKeysEnabled property.
     * 
     */
    public boolean isKeepOldKeysEnabled() {
        return keepOldKeysEnabled;
    }

    /**
     * Sets the value of the keepOldKeysEnabled property.
     * 
     */
    public void setKeepOldKeysEnabled(boolean value) {
        this.keepOldKeysEnabled = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the ltvEnabled property.
     * 
     */
    public boolean isLtvEnabled() {
        return ltvEnabled;
    }

    /**
     * Sets the value of the ltvEnabled property.
     * 
     */
    public void setLtvEnabled(boolean value) {
        this.ltvEnabled = value;
    }

    /**
     * Gets the value of the messagingMode property.
     * 
     */
    public int getMessagingMode() {
        return messagingMode;
    }

    /**
     * Sets the value of the messagingMode property.
     * 
     */
    public void setMessagingMode(int value) {
        this.messagingMode = value;
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
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNo(String value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the multipleSigningFileData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multipleSigningFileData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultipleSigningFileData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultipleSigningFileData }
     * 
     * 
     */
    public List<MultipleSigningFileData> getMultipleSigningFileData() {
        if (multipleSigningFileData == null) {
            multipleSigningFileData = new ArrayList<MultipleSigningFileData>();
        }
        return this.multipleSigningFileData;
    }

    /**
     * Gets the value of the newPasscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPasscode() {
        return newPasscode;
    }

    /**
     * Sets the value of the newPasscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPasscode(String value) {
        this.newPasscode = value;
    }

    /**
     * Gets the value of the noPadding property.
     * 
     */
    public boolean isNoPadding() {
        return noPadding;
    }

    /**
     * Sets the value of the noPadding property.
     * 
     */
    public void setNoPadding(boolean value) {
        this.noPadding = value;
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
     * Gets the value of the notificationTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationTemplate() {
        return notificationTemplate;
    }

    /**
     * Sets the value of the notificationTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationTemplate(String value) {
        this.notificationTemplate = value;
    }

    /**
     * Gets the value of the p2PEnabled property.
     * 
     */
    public boolean isP2PEnabled() {
        return p2PEnabled;
    }

    /**
     * Sets the value of the p2PEnabled property.
     * 
     */
    public void setP2PEnabled(boolean value) {
        this.p2PEnabled = value;
    }

    /**
     * Gets the value of the postbackEnabled property.
     * 
     */
    public boolean isPostbackEnabled() {
        return postbackEnabled;
    }

    /**
     * Sets the value of the postbackEnabled property.
     * 
     */
    public void setPostbackEnabled(boolean value) {
        this.postbackEnabled = value;
    }

    /**
     * Gets the value of the relyingParty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelyingParty() {
        return relyingParty;
    }

    /**
     * Sets the value of the relyingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelyingParty(String value) {
        this.relyingParty = value;
    }

    /**
     * Gets the value of the relyingPartyBillCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelyingPartyBillCode() {
        return relyingPartyBillCode;
    }

    /**
     * Sets the value of the relyingPartyBillCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelyingPartyBillCode(String value) {
        this.relyingPartyBillCode = value;
    }

    /**
     * Gets the value of the revokeOldCertificateEnabled property.
     * 
     */
    public boolean isRevokeOldCertificateEnabled() {
        return revokeOldCertificateEnabled;
    }

    /**
     * Sets the value of the revokeOldCertificateEnabled property.
     * 
     */
    public void setRevokeOldCertificateEnabled(boolean value) {
        this.revokeOldCertificateEnabled = value;
    }

    /**
     * Gets the value of the sharedAgreementUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedAgreementUUID() {
        return sharedAgreementUUID;
    }

    /**
     * Sets the value of the sharedAgreementUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedAgreementUUID(String value) {
        this.sharedAgreementUUID = value;
    }

    /**
     * Gets the value of the sharedMode property.
     * 
     */
    public int getSharedMode() {
        return sharedMode;
    }

    /**
     * Sets the value of the sharedMode property.
     * 
     */
    public void setSharedMode(int value) {
        this.sharedMode = value;
    }

    /**
     * Gets the value of the sharedRelyingParty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedRelyingParty() {
        return sharedRelyingParty;
    }

    /**
     * Sets the value of the sharedRelyingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedRelyingParty(String value) {
        this.sharedRelyingParty = value;
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
     * Gets the value of the signerInfoConstraintEnabled property.
     * 
     */
    public boolean isSignerInfoConstraintEnabled() {
        return signerInfoConstraintEnabled;
    }

    /**
     * Sets the value of the signerInfoConstraintEnabled property.
     * 
     */
    public void setSignerInfoConstraintEnabled(boolean value) {
        this.signerInfoConstraintEnabled = value;
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
     * Gets the value of the signingFileUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigningFileUUID() {
        return signingFileUUID;
    }

    /**
     * Sets the value of the signingFileUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigningFileUUID(String value) {
        this.signingFileUUID = value;
    }

    /**
     * Gets the value of the timestampEnabled property.
     * 
     */
    public boolean isTimestampEnabled() {
        return timestampEnabled;
    }

    /**
     * Sets the value of the timestampEnabled property.
     * 
     */
    public void setTimestampEnabled(boolean value) {
        this.timestampEnabled = value;
    }

    /**
     * Gets the value of the uploadingFileData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getUploadingFileData() {
        return uploadingFileData;
    }

    /**
     * Sets the value of the uploadingFileData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setUploadingFileData(byte[] value) {
        this.uploadingFileData = value;
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

    /**
     * Gets the value of the xslTemplateUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXslTemplateUUID() {
        return xslTemplateUUID;
    }

    /**
     * Sets the value of the xslTemplateUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXslTemplateUUID(String value) {
        this.xslTemplateUUID = value;
    }

}
