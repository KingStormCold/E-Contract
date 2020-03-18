package vn.easycredit.internalapi.request;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import vn.easycredit.domain.Utilities;

@Setter
@Getter
public class MessageInfoRequest {

	@JsonProperty("sms_id")
	@SerializedName("sms_id")
	private String smsId;

	@JsonProperty("campaign_id")
	@SerializedName("campaign_id")
	private String campaignId;

	@JsonProperty("campaign_name")
	@SerializedName("campaign_name")
	private String campaignName;

	@JsonProperty("phone_number")
	@SerializedName("phone_number")
	private String phoneNumber;

	@JsonProperty("content")
	@SerializedName("content")
	private String content;

	@JsonProperty("verification_code")
	@SerializedName("verification_code")
	private String verificationCode;

	@SerializedName("type")
	@JsonProperty("type")
	private String type;

	@JsonProperty("schedule")
	@SerializedName("schedule")
	@DateTimeFormat(pattern = Utilities.REGEX_DATEHOUR)
	private String schedule;

	public MessageInfoRequest() {
		super();
	}

	public MessageInfoRequest(String smsId, String phoneNumber, String content, String type) {
		super();
		this.smsId = smsId;
		this.phoneNumber = phoneNumber;
		this.content = content;
		this.type = type;
	}

}
