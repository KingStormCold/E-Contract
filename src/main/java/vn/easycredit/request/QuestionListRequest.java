package vn.easycredit.request;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.easycredit.constant.CommonError;
import vn.easycredit.constant.Constant;
import vn.easycredit.constant.HttpStatusCode;
import vn.easycredit.response.RedirectResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionListRequest {

	@JsonProperty("term_two_dot_four")
	@SerializedName("term_two_dot_four")
	private String termTwoDotFour;
	
	@JsonProperty("term_three")
	@SerializedName("term_three")
	private String termThree;
	
	@JsonProperty("term_four")
	@SerializedName("term_four")
	private String termFour;
	
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
		if (StringUtils.isEmpty(this.identity) || StringUtils.isEmpty(this.contractNumber)
				|| StringUtils.isEmpty(this.termTwoDotFour) || StringUtils.isEmpty(this.termThree)
				|| StringUtils.isEmpty(this.termFour)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INPUT_EMPTY.getValue(), RedirectPage.QUESTION_LIST.getCode());
		} else if (!Constant.TERM_TRUE.equals(this.termThree) || !Constant.TERM_TRUE.equals(this.termFour)) {
			return new RedirectResponse(HttpStatusCode._400.getCode(), HttpStatusCode._400.getValue(), CommonError.INVALID_TERM.getValue(), RedirectPage.QUESTION_LIST.getCode());
		}
		return null;
	}
}
