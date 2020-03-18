package vn.easycredit.exception;

import vn.easycredit.domain.Utilities.ApiError;

/**
 * @author HienNT
 *
 */
@SuppressWarnings("serial")
public class NotFoundException extends InvalidException {

	 public NotFoundException(String message) {
//       super(ApiError.NO_RESPONSE_ERROR_CODE, message);
       super(message);
   }
  /* 
   public NotFoundException(String message, Object request) {
       super(ApiError.NO_RESPONSE_ERROR_CODE, message, request);
   }*/
}
