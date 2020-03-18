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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReSendOtpRequest {

	@JsonProperty("identity")
	@SerializedName("identity")
	private String identity;
	
	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;
	
	public RedirectResponse validate() {
		if (StringUtils.isEmpty(this.identity) || StringUtils.isEmpty(this.contractNumber)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INPUT_EMPTY.getValue(), RedirectPage.QUESTION_LIST.getCode());
		}
		return null;
	}
}
