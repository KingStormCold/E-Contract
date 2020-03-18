package vn.easycredit.config.setting;

import lombok.Data;

@Data
public class DocApiInfo {

	private String accessTokenUrl;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private String docApiUrl;
	private String timeOut;
}
