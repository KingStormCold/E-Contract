package vn.easycredit.constant;

import lombok.Getter;

@Getter
public enum HttpStatusCode {
	_400("400", "Bad request"),
	_200("200", "OK"),
	_500("500", "Error Internal Server"),
	_404("404", "Not found");
	
	private String code;
	
	private String value;

	private HttpStatusCode(String code, String value) {
		this.code = code;
		this.value = value;
	}
}
