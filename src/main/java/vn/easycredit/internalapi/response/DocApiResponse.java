package vn.easycredit.internalapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocApiResponse {

	@JsonProperty("partner_code")
	@SerializedName("partner_code")	
	private String partnerCode;
	
	@JsonProperty("response_code")
	@SerializedName("response_code")	
	private String responseCode;
	
	@JsonProperty("response_message")
	@SerializedName("response_message")	
	private String responseMessage;
	
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("list_data")
	@SerializedName("list_data")
	private List<ListDataResponse> listData;
}
