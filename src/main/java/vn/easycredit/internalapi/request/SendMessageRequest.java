package vn.easycredit.internalapi.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendMessageRequest {

	@JsonProperty("partner_code")
	@SerializedName("partner_code")
	private String partnerCode;

	@JsonProperty("message")
	@SerializedName("message")
	private List<MessageInfoRequest> message;

	public SendMessageRequest() {
		super();
		this.message = new ArrayList<>();
	}

	public SendMessageRequest(String partnerCode, List<MessageInfoRequest> message) {
		super();
		this.partnerCode = partnerCode;
		this.message = message;
	}
	
	public SendMessageRequest(String partnerCode) {
		super();
		this.partnerCode = partnerCode;
		this.message = new ArrayList<>();
	}
}
