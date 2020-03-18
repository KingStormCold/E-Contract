package vn.easycredit.internalapi.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseImx {
	@JsonProperty("Response_code")
	@SerializedName("Response_code")
	private String responseCode;

	@JsonProperty("Response_message")
	@SerializedName("Response_message")
	private String responseMessage;

	@JsonProperty("Body")
	@SerializedName("Body")
	private List<ImxContractInfo> listContractInfo;
}
