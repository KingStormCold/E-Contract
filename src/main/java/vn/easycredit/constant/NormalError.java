package vn.easycredit.constant;

/**
 * Centralized error constants
 * 
 * @author HienNT
 */
public enum NormalError {

    /* invalid request */
    INVALID_REQUEST_PARAMETERS("ERR2000", "Invalid request parameters"),
    /** exception */
    SYSTEM_ERROR("ERR2300", "System error"),
    /** custom exception */
	SYSTEM_FAIL("ERR2400", "System processing fail"),
	SYSTEM_NOT_FOUND("ERR2500", "Not found");
	

    private final String errorCode;
    private final String errorMessage;

    private NormalError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "NormalError{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                "} ";
    }
}
