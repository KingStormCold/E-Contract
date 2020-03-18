package vn.easycredit.exception;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.easycredit.domain.Utilities.ApiError;

/**
 * 
 * @author HienNT
 *
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
public class InvalidException2 extends Exception {
	private ApiError errorCode;
	private String message;
	private Object request;

	public InvalidException2(ApiError code, String message) {
		super(code.asErrorCode());
		this.message = message;
		this.errorCode = code;
	}

	public InvalidException2(ApiError code, String message, Object request) {
		super(code.asErrorCode());
		this.message = message;
		this.errorCode = code;
		this.request = request;
	}

	public ApiError getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Object getRequest() {
		return request;
	}
}
