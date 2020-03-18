package vn.easycredit.entity.esign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;
import vn.easycredit.entity.BaseInfoEntity;
import vn.easycredit.fis.esigncloud.request.CustomerInfo;

@Setter
@Getter
@Entity
@Table(name = "econtract_prepare_certificate_for_sign_cloud")
public class ESignPrepareCertificateEntity extends BaseInfoEntity {

	@Id
	@Column(name = "contract_number")
	private String contractNumber;
	
	@Column(name = "partner_code")
	private String partnerCode;
	
	@Column(name = "personal_name")
	private String personalName;

	@Column(name = "personal_id")
	private String personalId;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "location")
	private String location;

	@Column(name = "state_province")
	private String stateProvince;

	@Column(name = "country")
	private String country;
	
	@Column(name = "current_agreement_uuid")
	private String currentAgreementUUID;
	
	@Column(name = "response_code")
	private Integer responseCode;

	@Column(name = "response_message")
	private String responseMessage;
	
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "prepareCertificateEntity")
	private List<ESignAgreementUuidHistoryEntity> listESignAgreementUuidHistory;
	
	public ESignPrepareCertificateEntity() {
		super();
		this.createdDate = new Date();
		this.updatedDate = new Date();
		this.listESignAgreementUuidHistory = new ArrayList<>();
	}
	
	public void initInfo(CustomerInfo customerInfo){
		this.contractNumber = customerInfo.getContractNumber();
		this.personalId = customerInfo.getPersonalId();
		this.personalName = customerInfo.getPersonalName();
		this.location = customerInfo.getLocation();
		this.stateProvince = customerInfo.getStateProvince();
		this.country = customerInfo.getCountry();
		this.mobileNo = customerInfo.getMobileNo();
		this.currentAgreementUUID = customerInfo.getAgreementUUID();
		this.partnerCode = customerInfo.getPartnerCode();
	}
}
