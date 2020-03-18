package vn.easycredit.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.easycredit.response.RedirectResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmOtpRequest {

	@JsonProperty("code_otp")
	@SerializedName("code_otp")
	private String codeOtp;
	
	@JsonProperty("identity")
	@SerializedName("identity")
	private String identity;
	
	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;
	
	@JsonProperty("partner_code")
	@SerializedName("partner_code")
	private String partnerCode;
	
	public RedirectResponse validate() {
		return null;
	}
}
