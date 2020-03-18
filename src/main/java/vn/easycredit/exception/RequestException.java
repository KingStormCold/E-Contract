package vn.easycredit.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import vn.easycredit.domain.Utilities.ApiError;

/**
 * @author HienNT
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class RequestException extends InvalidException{
	private static final long serialVersionUID = 1L;

	/*public RequestException(String message) throws IOException {
        super(ApiError.BAD_REQUEST_ERROR_CODE, message);
    }
	
	public RequestException(String message, Object request) throws IOException {
        super(ApiError.BAD_REQUEST_ERROR_CODE, message, request);
    }*/
	
	public RequestException(String message) throws IOException {
        super(message);
    }
	
	public RequestException(String errorCode, String message) throws IOException {
		super(errorCode, message);
    }
}
