package vn.easycredit.request;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.easycredit.constant.CommonError;
import vn.easycredit.constant.HttpStatusCode;
import vn.easycredit.response.RedirectResponse;
import vn.easycredit.utilities.ValidateUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

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
		if (StringUtils.isEmpty(this.identity) || StringUtils.isEmpty(this.contractNumber) || StringUtils.isEmpty(this.partnerCode)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INPUT_EMPTY.getValue(), RedirectPage.LOGIN.getCode());
		} else if (!ValidateUtils.checkIntegerMatch(this.identity)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INVALID_IDENTITY.getValue(), RedirectPage.LOGIN.getCode());
		} else if (this.identity.length() != 9 && this.identity.length() != 12) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INVALID_LENGTH_INDENTITY.getValue(), RedirectPage.LOGIN.getCode());
		} else if (!ValidateUtils.checkIntegerMatch(identity)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INVALID_CONTRACT_NUMBER.getValue(), RedirectPage.LOGIN.getCode());
		} else if (this.contractNumber.length() != 10) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INVALID_LENGTH_CONTRACT_NUMBER.getValue(), RedirectPage.LOGIN.getCode());
		}
		return null;
	}
}
