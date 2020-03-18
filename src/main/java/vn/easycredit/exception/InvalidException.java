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
public class InvalidException extends Exception {
	private String message;
	private String errCode;

	public InvalidException(String code, String message) {
		this.message = message;
		this.errCode = code;
	}

	public InvalidException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
