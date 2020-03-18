package vn.easycredit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RedirectResponse extends ResultResponse {
	
	@JsonProperty("redirect_page")
	@SerializedName("redirect_page")
	private String redirectPage;

	public RedirectResponse(String resposeCode, String resposeMessage, String errorMessage, String redirectPage) {
		super(resposeCode, resposeMessage, errorMessage);
		this.redirectPage = redirectPage;
	}
}
