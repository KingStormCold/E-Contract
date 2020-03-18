package vn.easycredit.constant;

/**
 * @author HienNT
 *
 */

public final class Constant {
	
	public static final String TYPE = "resent";
	public static final String IMX = "IMX";
	public static final String EPAY = "EPA";
	public static final String MIDDLEWARE = "MW";
	public static final String VTB = "VTB";
	
	public static final String REQ1 = "REQ1";
	public static final String REQ2 = "REQ2";
	public static final String REQ4 = "REQ4";
	
	public static final String GET_TOKEN_FAIL_FROM_IMX = "Cannot get token from IMX";
	public static final String GET_TOKEN_FAIL_FROM_3RD = "Cannot get token from 3rd";
	
	
	public static final String RESPONSE_CODE_IMX = "S200-DIS";
	public static final String RESPONSE_CODE_VTT_SUCCESS = "00";

	public static final String SUCCESS_MESSAGE = "Success";
	public static final String INTERNALERROR_MESSAGE = "Internal Server Error";
	public static final String BADREQUEST_MESSAGE = "Bad Request";

	public static final String DISBURSEMENT_INFO_INFLOW = "disbursement_info_api";
	public static final String DISBURSEMENT_SUCCESS_INFLOW = "disbursement_success_api";
	public static final String DISBURSEMENT_FUND_TRANSFER_REQUEST_INFLOW = "disbursement_fund_transfer_request_api";
	public static final String DISBURSEMENT_FUND_TRANSFER_RESULT_INFLOW = "disbursement_fund_transfer_result_api";
	public static final String DISBURSEMENT_FUND_TRANSFER_CHECK_STATUS_INFLOW = "disbursement_fund_transfer_check_status_api";
	public static final String DISBURSEMENT_VIRTUAL_ACCOUNT_CREATE_INFLOW = "disbursement_virtual_account_create_inflow";
	public static final String DISBURSEMENT_VIRTUAL_ACCOUNT_CANCEL_INFLOW = "disbursement_virtual_account_cancel_inflow";
	public static final String DISBURSEMENT_VIRTUAL_ACCOUNT_CHECK_INFLOW = "disbursement_virtual_account_check_inflow";
	public static final String DISBURSEMENT_VIRTUAL_ACCOUNT_UPDATE_INFLOW = "disbursement_virtual_account_update_inflow";
	public static final String DISBURSEMENT_CHECK_STATUS_VIETTELPAY_INFLOW = "disbursement_check_status_viettelpay_api";
	public static final String DISBURSEMENT_ACTIVE_CONTRACT_VIETTELPAY_INFLOW = "disbursement_active_contract_viettelpay_api";
	
	public static final String LOGS_STATUS_INSERT_WORKING_LOG = "insert_working_log";
	public static final String LOGS_STATUS_UPDATE_WORKING_LOG = "update_working_log";
	public static final String LOGS_STATUS_INSERT_HISTORY = "insert_history";
	
	public static final String STATUS_PENDING = "pending";
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_PROCESSED = "processed";
	public static final String STATUS_FAIL = "fail";
	
	public static final String RESPONSE_CODE_SUCCESS = "200";
	public static final String RESPONSE_CODE_FAIL = "400";
	public static final String RESPONSE_CODE_ERROR = "500";
	public static final String RESPONSE_CODE_ERROR_NOT_IMPLEMENTED = "501";
	
	public static final String RESPONSE_FAIL_FROM_THIRD_PARTY = "Cannot get infomation";
	public static final String RESPONSE_FAIL_FROM_IMX = "Cannot get infomation";
	
	public static final String CANNOT_GET_TOKEN_FROM_IMX = "Cannot Get Token From IMX";
	public static final String CANNOT_GET_TOKEN_FROM_3RD = "Cannot Get Token From 3RD";

	public static final String EMPTY_VALUE = "";
	
	public static final String CONVERT_TO_DOUBLE_ERROR = "CONVERT_TO_DOUBLE_ERROR";
	
	//-----------------------E-singing-------------------//
	public static final String TERM_TRUE = "true";
	
	private Constant() {
	}
}
