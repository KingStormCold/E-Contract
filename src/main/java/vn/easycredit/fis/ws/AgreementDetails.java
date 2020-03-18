
package vn.easycredit.fis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for agreementDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="agreementDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationForm" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="authorizeLetter" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="budgetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessLicense" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="citizenID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passportID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoActivityDeclaration" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="photoAuthorizeDelegate" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="photoIDCard" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="requestForm" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agreementDetails", propOrder = {
    "applicationForm",
    "authorizeLetter",
    "budgetID",
    "businessLicense",
    "citizenID",
    "country",
    "email",
    "location",
    "organization",
    "organizationUnit",
    "passportID",
    "personalID",
    "personalName",
    "photoActivityDeclaration",
    "photoAuthorizeDelegate",
    "photoIDCard",
    "requestForm",
    "stateOrProvince",
    "taxID",
    "telephoneNumber",
    "title"
})
public class AgreementDetails {

    protected byte[] applicationForm;
    protected byte[] authorizeLetter;
    protected String budgetID;
    protected byte[] businessLicense;
    protected String citizenID;
    protected String country;
    protected String email;
    protected String location;
    protected String organization;
    protected String organizationUnit;
    protected String passportID;
    protected String personalID;
    protected String personalName;
    protected byte[] photoActivityDeclaration;
    protected byte[] photoAuthorizeDelegate;
    protected byte[] photoIDCard;
    protected byte[] requestForm;
    protected String stateOrProvince;
    protected String taxID;
    protected String telephoneNumber;
    protected String title;

    /**
     * Gets the value of the applicationForm property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getApplicationForm() {
        return applicationForm;
    }

    /**
     * Sets the value of the applicationForm property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setApplicationForm(byte[] value) {
        this.applicationForm = value;
    }

    /**
     * Gets the value of the authorizeLetter property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAuthorizeLetter() {
        return authorizeLetter;
    }

    /**
     * Sets the value of the authorizeLetter property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAuthorizeLetter(byte[] value) {
        this.authorizeLetter = value;
    }

    /**
     * Gets the value of the budgetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetID() {
        return budgetID;
    }

    /**
     * Sets the value of the budgetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetID(String value) {
        this.budgetID = value;
    }

    /**
     * Gets the value of the businessLicense property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBusinessLicense() {
        return businessLicense;
    }

    /**
     * Sets the value of the businessLicense property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBusinessLicense(byte[] value) {
        this.businessLicense = value;
    }

    /**
     * Gets the value of the citizenID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenID() {
        return citizenID;
    }

    /**
     * Sets the value of the citizenID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenID(String value) {
        this.citizenID = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
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
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Gets the value of the organizationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationUnit() {
        return organizationUnit;
    }

    /**
     * Sets the value of the organizationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationUnit(String value) {
        this.organizationUnit = value;
    }

    /**
     * Gets the value of the passportID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets the value of the passportID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassportID(String value) {
        this.passportID = value;
    }

    /**
     * Gets the value of the personalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalID() {
        return personalID;
    }

    /**
     * Sets the value of the personalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalID(String value) {
        this.personalID = value;
    }

    /**
     * Gets the value of the personalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalName() {
        return personalName;
    }

    /**
     * Sets the value of the personalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalName(String value) {
        this.personalName = value;
    }

    /**
     * Gets the value of the photoActivityDeclaration property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhotoActivityDeclaration() {
        return photoActivityDeclaration;
    }

    /**
     * Sets the value of the photoActivityDeclaration property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhotoActivityDeclaration(byte[] value) {
        this.photoActivityDeclaration = value;
    }

    /**
     * Gets the value of the photoAuthorizeDelegate property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhotoAuthorizeDelegate() {
        return photoAuthorizeDelegate;
    }

    /**
     * Sets the value of the photoAuthorizeDelegate property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhotoAuthorizeDelegate(byte[] value) {
        this.photoAuthorizeDelegate = value;
    }

    /**
     * Gets the value of the photoIDCard property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhotoIDCard() {
        return photoIDCard;
    }

    /**
     * Sets the value of the photoIDCard property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhotoIDCard(byte[] value) {
        this.photoIDCard = value;
    }

    /**
     * Gets the value of the requestForm property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getRequestForm() {
        return requestForm;
    }

    /**
     * Sets the value of the requestForm property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setRequestForm(byte[] value) {
        this.requestForm = value;
    }

    /**
     * Gets the value of the stateOrProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    /**
     * Sets the value of the stateOrProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvince(String value) {
        this.stateOrProvince = value;
    }

    /**
     * Gets the value of the taxID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * Sets the value of the taxID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxID(String value) {
        this.taxID = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the value of the telephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephoneNumber(String value) {
        this.telephoneNumber = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
