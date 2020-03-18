package vn.easycredit.config.setting;

import lombok.Data;

@Data
public class SmsApiInfo {

	private String accessTokenUrl;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private String sendSmsUrl;
	private String contentSms;
	private String timeOut;
}
