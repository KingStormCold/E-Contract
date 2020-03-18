package vn.easycredit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {

	@JsonProperty("respose_code")
	@SerializedName("respose_code")
	private String resposeCode;
	
	@JsonProperty("respose_message")
	@SerializedName("respose_message")
	private String resposeMessage;
	
	@JsonProperty("error_message")
	@SerializedName("error_message")
	private String errorMessage;
	
}
