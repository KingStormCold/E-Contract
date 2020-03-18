package vn.easycredit.fis.esigncloud.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerInfo {
	
	@JsonProperty("partner_code")
	@SerializedName("partner_code")
	private String partnerCode;

	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;
	
	@JsonProperty("personal_name")
	@SerializedName("personal_name")
	private String personalName;

	@JsonProperty("personal_id")
	@SerializedName("personal_id")
	private String personalId;

	@JsonProperty("mobile_no")
	@SerializedName("mobile_no")
	private String mobileNo;

	@JsonProperty("location")
	@SerializedName("location")
	private String location;

	@JsonProperty("state_province")
	@SerializedName("state_province")
	private String stateProvince;

	@JsonProperty("country")
	@SerializedName("country")
	private String country;
	
	@JsonProperty("agreement_uuid")
	@SerializedName("agreement_uuid")
	private String agreementUUID;

	public CustomerInfo() {
		super();
		this.country = "VN";
	}

	public String generateAgreementUUID(){
		Date currentDate = new Date();
		this.agreementUUID = this.contractNumber + "_" +currentDate.getTime();
		return this.agreementUUID;
	}
}
