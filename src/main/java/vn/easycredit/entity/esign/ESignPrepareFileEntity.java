package vn.easycredit.entity.esign;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import vn.easycredit.entity.BaseInfoEntity;
import vn.easycredit.fis.ws.SignCloudResp;

@Setter
@Getter
@Entity
@Table(name = "econtract_prepare_file_for_sign_cloud")
public class ESignPrepareFileEntity extends BaseInfoEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Size(min = 1, max = 45)
	@Column(name = "id")
	private String id;
	
	@Column(name = "contract_number")
	private String contractNumber;
	
	@Column(name = "agreement_uuid")
	private String agreementUUID;
	
	@Column(name = "file_location")
	private String fileLocation;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "response_code")
	private Integer responseCode;

	@Column(name = "response_message")
	private String responseMessage;
	
	@Column(name = "bill_code")
	private String billCode;

	@Column(name = "authorize_code")
	private String authorizeCode;

	public ESignPrepareFileEntity() {
		super();
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	public ESignPrepareFileEntity(String contractNumber, String agreementUUID, String fileLocation, String fileName) {
		super();
		this.contractNumber = contractNumber;
		this.agreementUUID = agreementUUID;
		this.fileLocation = fileLocation;
		this.fileName = fileName;
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}
	
	public void initResponseInfo(SignCloudResp prepareFileResp){
		this.responseCode = prepareFileResp.getResponseCode();
		this.responseMessage = prepareFileResp.getResponseMessage();
		this.billCode = prepareFileResp.getBillCode();
		this.authorizeCode = prepareFileResp.getAuthorizeCredential();
	}
}
