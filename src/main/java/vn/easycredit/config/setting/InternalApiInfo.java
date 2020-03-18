package vn.easycredit.config.setting;

import lombok.Data;

@Data
public class InternalApiInfo {
	
	private SmsApiInfo smsApiInfo;
	
	private DocApiInfo docApiInfo;

}
