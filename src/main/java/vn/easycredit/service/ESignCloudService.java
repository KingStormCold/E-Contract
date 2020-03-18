package vn.easycredit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.config.setting.EcontractConfigSetting;
import vn.easycredit.entity.esign.ESignAgreementUuidHistoryEntity;
import vn.easycredit.entity.esign.ESignPrepareCertificateEntity;
import vn.easycredit.entity.esign.ESignPrepareFileEntity;
import vn.easycredit.enums.PartnerCodeEnum;
import vn.easycredit.fis.esigncloud.ESignCloudConstant;
import vn.easycredit.fis.esigncloud.SSLUtilities;
import vn.easycredit.fis.esigncloud.Utils;
import vn.easycredit.fis.esigncloud.request.CustomerInfo;
import vn.easycredit.fis.ws.AgreementDetails;
import vn.easycredit.fis.ws.CredentialData;
import vn.easycredit.fis.ws.Services;
import vn.easycredit.fis.ws.Services_Service;
import vn.easycredit.fis.ws.SignCloudMetaData;
import vn.easycredit.fis.ws.SignCloudReq;
import vn.easycredit.fis.ws.SignCloudResp;
import vn.easycredit.repository.esign.ESignPrepareCertificateRepository;
import vn.easycredit.repository.esign.ESignPrepareFileRepository;
import vn.easycredit.utilities.SftpServerConnection;

@Slf4j
@Service
@Transactional
public class ESignCloudService {
//	public static final String URL = "https://52.3.52.247/eSignCloud/Services?wsdl";
//	public static final String relyingParty = "EC";
//	public static final String relyingPartyUser = "e_credit";
//	public static final String relyingPartyPassword = "w28h6737";
//	public static final String relyingPartySignature = "M6tvfxwsnKTkxNxH/9vmKrdOZRiYNipn4Q3nlj8bTvmJsJuldpj89ZZS1T8/ZVhm7DD71VqcDiITea9eQHxjPoMGxNynP+NjwVIlLr+S448iMmtYOK+saZonebrGB8o/gtky5ggP28R9PVSo6xICJWqIbW/QW86IJQYGPjpMDRFkEbC2L7UrLVjys6TnHCr/QE4HlHgUvb7fvuiisIXnIUjZYGH0Wewt2SzafEsGJ9aZGm++ILuZfe69ytEup4emDdFnzgzeaY21UCKzXGeau+VBtpqzgrxlHWlawYKZibvfSYKDazV4KGkblzd0zTNEcl1XBXRV4ryIiesReUX83A==";
//	public static final String relyingPartyKeyStore = "E:/Project/doc_api/external doc/FPT/E-Sign/FPTeSignEasyCredit.20200219/FPTeSignEasyCredit/file/ec.p12";
//	public static final String relyingPartyKeyStorePassword = "hkB6R3F8";
	public static final String agreementUUID = "202002191341"; // AWS
//	final public static String passCode = "12345678";
//	public static final String certificateProfile = "PERS.1D";

//	public static final String FILE_DIRECTORY = "file\\";
//	public static final String FILE_PDF_01 = "E:/Project/doc_api/external doc/FPT/E-Sign/FPTeSignEasyCredit.20200219/FPTeSignEasyCredit/file/ec_contract.pdf";
	
	@Autowired
	private EcontractConfigSetting econtractConfigSetting;
	
	@Autowired
	private ESignPrepareCertificateRepository eSignPrepareCertificateRepository;
	
	@Autowired
	private ESignPrepareFileRepository eSignPrepareFileRepository;
    
    public void customerRegisterEsigning(){
    	try {
    		CustomerInfo customerInfo = new CustomerInfo();
    		customerInfo.setContractNumber(agreementUUID);
    		customerInfo.setPersonalId("104430191");
    		customerInfo.setPersonalName("NGUYỄN VĂN A");
    		customerInfo.setLocation("Quận 1");
    		customerInfo.setStateProvince("TP Hồ Chí Minh");
    		customerInfo.setCountry("VN");
    		customerInfo.setMobileNo("0378932888");
    		PartnerCodeEnum partnerCodeEnum = PartnerCodeEnum.findCode("ZAL");
    		customerInfo.setPartnerCode(partnerCodeEnum.getCode());
    		customerInfo.generateAgreementUUID();
    		
    		ESignPrepareCertificateEntity eSignPrepareCertificateEntity = new ESignPrepareCertificateEntity();
    		eSignPrepareCertificateEntity.initInfo(customerInfo);
//    		String[] result = null;
    		SignCloudResp prepareCertificateResp = prepareCertificateForSignCloud(customerInfo);
    		
    		eSignPrepareCertificateEntity.setResponseCode(prepareCertificateResp.getResponseCode());
    		eSignPrepareCertificateEntity.setResponseMessage(prepareCertificateResp.getResponseMessage());
    		
    		ESignAgreementUuidHistoryEntity eSignAgreementUuidHistoryEntity = new ESignAgreementUuidHistoryEntity(customerInfo.getAgreementUUID(), prepareCertificateResp.getResponseCode(), prepareCertificateResp.getResponseMessage(), eSignPrepareCertificateEntity);
    		eSignPrepareCertificateEntity.getListESignAgreementUuidHistory().add(eSignAgreementUuidHistoryEntity);
    		
    		eSignPrepareCertificateRepository.save(eSignPrepareCertificateEntity);
    		
    		SignCloudResp prepareFileResp = null;
			if(prepareCertificateResp.getResponseCode() == 0){
				String fileName = "20190724_1907230003.pdf";
	        	String fileLocation = econtractConfigSetting.getSftpServer().getWorkingDir() + "Viettel2/uploads/easycredit/";
				SftpServerConnection sftpServerConnection = new SftpServerConnection(econtractConfigSetting.getSftpServer());
		        boolean isConnected = sftpServerConnection.connect();
		        byte[] fileData = null;
		        if(isConnected){
		        	
		        	String fullFilePath = fileLocation + fileName;
		        	fileData = IOUtils.toByteArray(sftpServerConnection.getFile(fullFilePath));
		        	sftpServerConnection.disconnect();
		        }
		        ESignPrepareFileEntity eSignPrepareFileEntity = new ESignPrepareFileEntity(customerInfo.getContractNumber(), customerInfo.getAgreementUUID(), fileLocation, fileName);
		        
		        prepareFileResp = prepareFileForSignCloud(customerInfo.getAgreementUUID(), fileData);
		        
		        eSignPrepareFileEntity.initResponseInfo(prepareFileResp);
		        eSignPrepareFileRepository.save(eSignPrepareFileEntity);
		        
			}
			if (prepareFileResp !=null && prepareFileResp.getResponseCode() == 1007) {
            	SignCloudResp signCloudResp = authorizeCounterSigningForSignCloud(customerInfo.getAgreementUUID(), prepareFileResp.getAuthorizeCredential(), prepareFileResp.getBillCode());
//            	String passCode = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getPassCode();
//                prepareFileForEasyCreditSignCloud(econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getAgreementUuid(), passCode);
            	// just for testing
                if (signCloudResp.getResponseCode() == 0) {
                    if (signCloudResp.getSignedFileData() != null) {
                    	String passCode = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getPassCode();
                        prepareFileForEasyCreditSignCloud(econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getAgreementUuid(), passCode, signCloudResp.getSignedFileData());
                    	
//                        File file = new File("E:/TEST/esign/" + "signed_" + "20190724_1907230003.pdf");
                    	File file = new File("E:/TEST/esign/" + "20190724_1907230003.pdf");
                        log.info("Saved in " + file);
                        log.info("MimeType: " + signCloudResp.getMimeType());
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        IOUtils.write(signCloudResp.getSignedFileData(), fileOutputStream);
                        fileOutputStream.close();
                        SftpServerConnection sftpServerConnection = new SftpServerConnection(econtractConfigSetting.getSftpServer());
                        boolean isConnected = sftpServerConnection.connect();
                        if(isConnected){
                        	String desDir = econtractConfigSetting.getSftpServer().getWorkingDir() + "Viettel2/uploads/easycredit/";
                        	sftpServerConnection.uploadFile(file, desDir);
                        	sftpServerConnection.disconnect();
                        }
                    }
                }
            }
		} catch (Exception e) {
			log.info(e.toString(), e);
		}
    }
    
    private CredentialData createCredentialData() throws Exception{
		String relyingPartyUser = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingPartyUser();
		String relyingPartyPassword = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingPartyPassword();
		String relyingPartySignature = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingPartySignature();
		String relyingPartyKeyStore = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingPartyKeyStore();
		String relyingPartyKeyStorePassword = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingPartyKeyStorePassword();
		
		String timestamp = String.valueOf(System.currentTimeMillis());
		String data2sign = relyingPartyUser + relyingPartyPassword + relyingPartySignature + timestamp;
        String pkcs1Signature = Utils.getPKCS1Signature(data2sign, relyingPartyKeyStore, relyingPartyKeyStorePassword);
        
        CredentialData credentialData = new CredentialData();
        credentialData.setUsername(relyingPartyUser);
        credentialData.setPassword(relyingPartyPassword);
        credentialData.setTimestamp(timestamp);
        credentialData.setSignature(relyingPartySignature);
        credentialData.setPkcs1Signature(pkcs1Signature);
        
        return credentialData;
    }
    
    public SignCloudResp prepareCertificateForSignCloud(CustomerInfo customerInfo) throws Exception {
    	
    	String servicesUrl = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getServicesUrl();
    	String relyingParty = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingParty();

        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
        Services_Service services = new Services_Service(new URL(servicesUrl), new QName("http://api.esigncloud.mobileid.vn/", "Services"));

        Services ws = services.getServicesPort();

        SignCloudReq signCloudReq = new SignCloudReq();
        signCloudReq.setRelyingParty(relyingParty);
        signCloudReq.setAgreementUUID(customerInfo.getAgreementUUID());
        signCloudReq.setMobileNo(customerInfo.getMobileNo());

        AgreementDetails agreementDetails = new AgreementDetails();
        agreementDetails.setPersonalName(customerInfo.getPersonalName());
        agreementDetails.setOrganizationUnit(customerInfo.getContractNumber());
        agreementDetails.setPersonalID(customerInfo.getPersonalId());
        agreementDetails.setLocation(customerInfo.getLocation());
        agreementDetails.setStateOrProvince(customerInfo.getStateProvince());
        agreementDetails.setCountry("VN");

        signCloudReq.setAgreementDetails(agreementDetails);
        
        CredentialData credentialData = createCredentialData();

        signCloudReq.setCredentialData(credentialData);

        SignCloudResp signCloudResp = ws.prepareCertificateForSignCloud(signCloudReq);
        log.info("Code: " + signCloudResp.getResponseCode());
        log.info("Message: " + signCloudResp.getResponseMessage());
        return signCloudResp;
    }
    
    public SignCloudResp prepareFileForSignCloud(String agreementUUID, byte[] fileData) throws Exception {
    	
    	String servicesUrl = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getServicesUrl();
    	String relyingParty = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingParty();

        String notificationTemplate = "EC: Your Authorize Code: {AuthorizeCode}. It will be expired within 5 minutes";
        String notificationSubject = "EC - Authorization Code";
//        byte[] fileData = IOUtils.toByteArray(new FileInputStream("E:/Project/doc_api/external doc/FPT/E-Sign/FPTeSignEasyCredit.20200219/FPTeSignEasyCredit/file/20190724_1907230003.pdf"));
        String mimeType = ESignCloudConstant.MIMETYPE_PDF;

        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
        Services_Service services = new Services_Service(new URL(servicesUrl), new QName("http://api.esigncloud.mobileid.vn/", "Services"));

        Services ws = services.getServicesPort();

        String timestamp = String.valueOf(System.currentTimeMillis());

        SignCloudReq signCloudReq = new SignCloudReq();
        signCloudReq.setRelyingParty(relyingParty);
        signCloudReq.setAgreementUUID(agreementUUID);
        signCloudReq.setAuthorizeMethod(ESignCloudConstant.AUTHORISATION_METHOD_SMS);
        signCloudReq.setSigningFileData(fileData);
        signCloudReq.setMimeType(mimeType);

        signCloudReq.setSigningFileName("HDDT-" + timestamp + ".pdf");

        signCloudReq.setNotificationTemplate(notificationTemplate);
        signCloudReq.setNotificationSubject(notificationSubject);

        CredentialData credentialData = createCredentialData();
        signCloudReq.setCredentialData(credentialData);

        SignCloudMetaData signCloudMetaData = new SignCloudMetaData();

        // -- SingletonSigning (Signature properties for customer)
        SignCloudMetaData.SingletonSigning singletonSigning = new SignCloudMetaData.SingletonSigning();

        SignCloudMetaData.SingletonSigning.Entry counterSignEnabled = new SignCloudMetaData.SingletonSigning.Entry();
        counterSignEnabled.setKey("COUNTERSIGNENABLED");
        counterSignEnabled.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry pageNo = new SignCloudMetaData.SingletonSigning.Entry();
        pageNo.setKey("PAGENO");
        pageNo.setValue("Last");

        SignCloudMetaData.SingletonSigning.Entry positionIdentifider = new SignCloudMetaData.SingletonSigning.Entry();
        positionIdentifider.setKey("POSITIONIDENTIFIER");
        positionIdentifider.setValue("BÊN VAY");

        SignCloudMetaData.SingletonSigning.Entry rectangleOffset = new SignCloudMetaData.SingletonSigning.Entry();
        rectangleOffset.setKey("RECTANGLEOFFSET");
        rectangleOffset.setValue("-30,-100");

        SignCloudMetaData.SingletonSigning.Entry rectangleSize = new SignCloudMetaData.SingletonSigning.Entry();
        rectangleSize.setKey("RECTANGLESIZE");
        rectangleSize.setValue("170,90");

        SignCloudMetaData.SingletonSigning.Entry visibleSignature = new SignCloudMetaData.SingletonSigning.Entry();
        visibleSignature.setKey("VISIBLESIGNATURE");
        visibleSignature.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry showSignerInfo = new SignCloudMetaData.SingletonSigning.Entry();
        showSignerInfo.setKey("SHOWSIGNERINFO");
        showSignerInfo.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry signerInfoPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        signerInfoPrefix.setKey("SIGNERINFOPREFIX");
        signerInfoPrefix.setValue("Ký bởi:");

        SignCloudMetaData.SingletonSigning.Entry showDateTime = new SignCloudMetaData.SingletonSigning.Entry();
        showDateTime.setKey("SHOWDATETIME");
        showDateTime.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry dateTimePrefix = new SignCloudMetaData.SingletonSigning.Entry();
        dateTimePrefix.setKey("DATETIMEPREFIX");
        dateTimePrefix.setValue("Ký ngày:");

        SignCloudMetaData.SingletonSigning.Entry showReason = new SignCloudMetaData.SingletonSigning.Entry();
        showReason.setKey("SHOWREASON");
        showReason.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry signReasonPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        signReasonPrefix.setKey("SIGNREASONPREFIX");
        signReasonPrefix.setValue("Lý do:");

        SignCloudMetaData.SingletonSigning.Entry signReason = new SignCloudMetaData.SingletonSigning.Entry();
        signReason.setKey("SIGNREASON");
        signReason.setValue("Đồng ý");

        SignCloudMetaData.SingletonSigning.Entry showLocation = new SignCloudMetaData.SingletonSigning.Entry();
        showLocation.setKey("SHOWLOCATION");
        showLocation.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry location = new SignCloudMetaData.SingletonSigning.Entry();
        location.setKey("LOCATION");
        location.setValue("TP Hồ Chí Minh");

        SignCloudMetaData.SingletonSigning.Entry locationPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        locationPrefix.setKey("LOCATIONPREFIX");
        locationPrefix.setValue("Ký tại:");

        SignCloudMetaData.SingletonSigning.Entry textColor = new SignCloudMetaData.SingletonSigning.Entry();
        textColor.setKey("TEXTCOLOR");
        textColor.setValue("black");

        SignCloudMetaData.SingletonSigning.Entry lockAfterSigning = new SignCloudMetaData.SingletonSigning.Entry();
        lockAfterSigning.setKey("LOCKAFTERSIGNING");
        lockAfterSigning.setValue("False");

        singletonSigning.getEntry().add(counterSignEnabled);
        singletonSigning.getEntry().add(pageNo);
        singletonSigning.getEntry().add(positionIdentifider);
        singletonSigning.getEntry().add(rectangleOffset);
        singletonSigning.getEntry().add(rectangleSize);
        singletonSigning.getEntry().add(visibleSignature);
        singletonSigning.getEntry().add(showSignerInfo);
        singletonSigning.getEntry().add(signerInfoPrefix);
        singletonSigning.getEntry().add(showDateTime);
        singletonSigning.getEntry().add(dateTimePrefix);
        singletonSigning.getEntry().add(showReason);
        singletonSigning.getEntry().add(signReasonPrefix);
        singletonSigning.getEntry().add(signReason);
        singletonSigning.getEntry().add(showLocation);
        singletonSigning.getEntry().add(location);
        singletonSigning.getEntry().add(locationPrefix);
        singletonSigning.getEntry().add(textColor);
        singletonSigning.getEntry().add(lockAfterSigning);

        signCloudMetaData.setSingletonSigning(singletonSigning);

        signCloudReq.setSignCloudMetaData(signCloudMetaData);

        SignCloudResp signCloudResp = ws.prepareFileForSignCloud(signCloudReq);
        log.info("Code: " + signCloudResp.getResponseCode());
        log.info("Message: " + signCloudResp.getResponseMessage());
        log.info("BillCode: " + signCloudResp.getBillCode());
        log.info("NotificationMessage: " + signCloudResp.getNotificationMessage());
        log.info("NotificationSubject: " + signCloudResp.getNotificationSubject());
        log.info("RemainingCounter: " + signCloudResp.getRemainingCounter());

//        String[] result = null;
//        if (signCloudResp.getResponseCode() == 1007) {
//            result = new String[2];
//            result[0] = signCloudResp.getBillCode();
//            result[1] = signCloudResp.getAuthorizeCredential();
//        }
        return signCloudResp;
    }
    
    public SignCloudResp authorizeCounterSigningForSignCloud(String agreementUUID, String authorizeCode, String billCode) throws Exception {
    	String servicesUrl = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getServicesUrl();
    	String relyingParty = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingParty();
    	
    	SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
        Services_Service services = new Services_Service(new URL(servicesUrl), new QName("http://api.esigncloud.mobileid.vn/", "Services"));

        Services ws = services.getServicesPort();

        SignCloudReq signCloudReq = new SignCloudReq();
        signCloudReq.setRelyingParty(relyingParty);
        signCloudReq.setAgreementUUID(agreementUUID);
        signCloudReq.setMessagingMode(ESignCloudConstant.SYNCHRONOUS);
        signCloudReq.setBillCode(billCode);
        signCloudReq.setAuthorizeCode(authorizeCode);

        signCloudReq.setLtvEnabled(false);

        CredentialData credentialData = createCredentialData();
        signCloudReq.setCredentialData(credentialData);

        SignCloudResp signCloudResp = ws.authorizeCounterSigningForSignCloud(signCloudReq);
        log.info("Code: " + signCloudResp.getResponseCode());
        log.info("Message: " + signCloudResp.getResponseMessage());
        log.info("BillCode: " + signCloudResp.getBillCode());
        log.info("NotificationMessage: " + signCloudResp.getNotificationMessage());
        log.info("NotificationSubject: " + signCloudResp.getNotificationSubject());
        log.info("RemainingCounter: " + signCloudResp.getRemainingCounter());
        
        return signCloudResp;
    }
    
    public void prepareFileForEasyCreditSignCloud(String agreementUUID, String passCode, byte[] fileData) throws Exception {
    	
    	String servicesUrl = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getServicesUrl();
    	String relyingParty = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingParty();

        String mimeType = ESignCloudConstant.MIMETYPE_PDF;

        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
        Services_Service services = new Services_Service(new URL(servicesUrl), new QName("http://api.esigncloud.mobileid.vn/", "Services"));

        Services ws = services.getServicesPort();

        String timestamp = String.valueOf(System.currentTimeMillis());

        SignCloudReq signCloudReq = new SignCloudReq();
        signCloudReq.setRelyingParty(relyingParty);
        signCloudReq.setAgreementUUID(agreementUUID);
        signCloudReq.setAuthorizeMethod(ESignCloudConstant.AUTHORISATION_METHOD_PASSCODE);
        signCloudReq.setAuthorizeCode(passCode);
        signCloudReq.setSigningFileData(fileData);
        signCloudReq.setMimeType(mimeType);

        signCloudReq.setSigningFileName("HDDT-" + timestamp + ".pdf");

        CredentialData credentialData = createCredentialData();
        signCloudReq.setCredentialData(credentialData);

        SignCloudMetaData signCloudMetaData = new SignCloudMetaData();

        // -- SingletonSigning (Signature properties for EC)
        SignCloudMetaData.SingletonSigning singletonSigning = new SignCloudMetaData.SingletonSigning();
        
        SignCloudMetaData.SingletonSigning.Entry singletonSigningPageNo = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningPageNo.setKey("PAGENO");
        singletonSigningPageNo.setValue("Last");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningPositionIdentifider = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningPositionIdentifider.setKey("POSITIONIDENTIFIER");
        singletonSigningPositionIdentifider.setValue("BÊN CHO VAY");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningRectangleOffset = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningRectangleOffset.setKey("RECTANGLEOFFSET");
        singletonSigningRectangleOffset.setValue("-30,-100");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningRectangleSize = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningRectangleSize.setKey("RECTANGLESIZE");
        singletonSigningRectangleSize.setValue("170,50");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningVisibleSignature = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningVisibleSignature.setKey("VISIBLESIGNATURE");
        singletonSigningVisibleSignature.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningShowSignerInfo = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningShowSignerInfo.setKey("SHOWSIGNERINFO");
        singletonSigningShowSignerInfo.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningSignerInfoPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningSignerInfoPrefix.setKey("SIGNERINFOPREFIX");
        singletonSigningSignerInfoPrefix.setValue("Ký bởi:");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningShowDateTime = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningShowDateTime.setKey("SHOWDATETIME");
        singletonSigningShowDateTime.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningDateTimePrefix = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningDateTimePrefix.setKey("DATETIMEPREFIX");
        singletonSigningDateTimePrefix.setValue("Ký ngày:");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningShowReason = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningShowReason.setKey("SHOWREASON");
        singletonSigningShowReason.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningSignReasonPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningSignReasonPrefix.setKey("SIGNREASONPREFIX");
        singletonSigningSignReasonPrefix.setValue("Lý do:");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningSignReason = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningSignReason.setKey("SIGNREASON");
        singletonSigningSignReason.setValue("Đồng ý");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningShowLocation = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningShowLocation.setKey("SHOWLOCATION");
        singletonSigningShowLocation.setValue("True");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningLocation = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningLocation.setKey("LOCATION");
        singletonSigningLocation.setValue("TP Hồ Chí Minh");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningLocationPrefix = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningLocationPrefix.setKey("LOCATIONPREFIX");
        singletonSigningLocationPrefix.setValue("Ký tại:");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningTextColor = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningTextColor.setKey("TEXTCOLOR");
        singletonSigningTextColor.setValue("black");

        SignCloudMetaData.SingletonSigning.Entry singletonSigningLockAfterSigning = new SignCloudMetaData.SingletonSigning.Entry();
        singletonSigningLockAfterSigning.setKey("LOCKAFTERSIGNING");
        singletonSigningLockAfterSigning.setValue("False");

        singletonSigning.getEntry().add(singletonSigningPageNo);
        singletonSigning.getEntry().add(singletonSigningPositionIdentifider);
        singletonSigning.getEntry().add(singletonSigningRectangleOffset);
        singletonSigning.getEntry().add(singletonSigningRectangleSize);
        singletonSigning.getEntry().add(singletonSigningVisibleSignature);
        singletonSigning.getEntry().add(singletonSigningShowSignerInfo);
        singletonSigning.getEntry().add(singletonSigningSignerInfoPrefix);
        singletonSigning.getEntry().add(singletonSigningShowDateTime);
        singletonSigning.getEntry().add(singletonSigningDateTimePrefix);
        singletonSigning.getEntry().add(singletonSigningShowReason);
        singletonSigning.getEntry().add(singletonSigningSignReasonPrefix);
        singletonSigning.getEntry().add(singletonSigningSignReason);
        singletonSigning.getEntry().add(singletonSigningShowLocation);
        singletonSigning.getEntry().add(singletonSigningLocation);
        singletonSigning.getEntry().add(singletonSigningLocationPrefix);
        singletonSigning.getEntry().add(singletonSigningTextColor);
        singletonSigning.getEntry().add(singletonSigningLockAfterSigning);

        signCloudMetaData.setSingletonSigning(singletonSigning);

        signCloudReq.setSignCloudMetaData(signCloudMetaData);

        SignCloudResp signCloudResp = ws.prepareFileForSignCloud(signCloudReq);
        log.info("Code: " + signCloudResp.getResponseCode());
        log.info("Message: " + signCloudResp.getResponseMessage());
        log.info("BillCode: " + signCloudResp.getBillCode());
        log.info("NotificationMessage: " + signCloudResp.getNotificationMessage());
        log.info("NotificationSubject: " + signCloudResp.getNotificationSubject());
        log.info("RemainingCounter: " + signCloudResp.getRemainingCounter());

     // just for testing
        if (signCloudResp.getResponseCode() == 0 || signCloudResp.getResponseCode() == 1018) {
            if (signCloudResp.getSignedFileData() != null) {
                String file = "E:/TEST/esign/" + "signed_final_" + "ec_contract.pdf";
                log.info("Saved in " + file);
                log.info("MimeType: " + signCloudResp.getMimeType());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                IOUtils.write(signCloudResp.getSignedFileData(), fileOutputStream);
                fileOutputStream.close();
            }
        }
    }
    
    public void regenerateAuthorisationCodeForSignCloud(String agreementUUID) throws Exception {
    	
    	String servicesUrl = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getServicesUrl();
    	String relyingParty = econtractConfigSetting.getThirdPartyApiInfo().getFptPartnerInfo().getEsignApiInfo().getRelyingParty();
    	
        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
        Services_Service services = new Services_Service(new URL(servicesUrl), new QName("http://api.esigncloud.mobileid.vn/", "Services"));

        Services ws = services.getServicesPort();

        SignCloudReq signCloudReq = new SignCloudReq();
        signCloudReq.setRelyingParty(relyingParty);
        signCloudReq.setAgreementUUID(agreementUUID);
        signCloudReq.setAuthorizeMethod(ESignCloudConstant.AUTHORISATION_METHOD_SMS);

        String notificationTemplate = "EC: Your Authorize Code: {AuthorizeCode}. It will be expired within 5 minutes";
        String notificationSubject = "EC - Authorization Code";

        signCloudReq.setNotificationTemplate(notificationTemplate);
        signCloudReq.setNotificationSubject(notificationSubject);

        CredentialData credentialData = createCredentialData();
        signCloudReq.setCredentialData(credentialData);

        SignCloudResp signCloudResp = ws.regenerateAuthorisationCodeForSignCloud(signCloudReq);

        log.info("Code: " + signCloudResp.getResponseCode());
        log.info("Message: " + signCloudResp.getResponseMessage());
        log.info("BillCode: " + signCloudResp.getBillCode());
        log.info("NotificationMessage: " + signCloudResp.getNotificationMessage());
        log.info("NotificationSubject: " + signCloudResp.getNotificationSubject());
        log.info("RemainingCounter: " + signCloudResp.getRemainingCounter());
        log.info("AuthorizeCredential: " + signCloudResp.getAuthorizeCredential());
    }
}
