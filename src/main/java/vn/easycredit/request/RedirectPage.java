package vn.easycredit.request;

import lombok.Getter;

@Getter
public enum RedirectPage {

	LOGIN("00", "Login page."),
	SHOW_CONTRACT("02", "Show contract."),
	QUESTION_LIST("01", "Question list."),
	OTP("03", "OTP."),
	SEND_MAIL("04", "Send mail.");
	
	private String code;
	
	private String value;

	private RedirectPage(String code, String value) {
		this.code = code;
		this.value = value;
	}
}
