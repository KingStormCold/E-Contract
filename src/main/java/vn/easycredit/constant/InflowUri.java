package vn.easycredit.constant;

public enum InflowUri {
	DISBURSEMENT_INFO_INFLOW("disbursement_info_api","/v1/cash/checkContractInfo"),
	DISBURSEMENT_SUCCESS_INFLOW("disbursement_success_api","/v1/cash/disburseSucceed"),
	DISBURSEMENT_FUND_TRANSFER_REQUEST_INFLOW("disbursement_fund_transfer_request_api","/v1/account/disburseRequest"),
	DISBURSEMENT_FUND_TRANSFER_RESULT_INFLOW("disbursement_fund_transfer_result_api","/v1/account/disburseResult"),

	;
	 
	 private final String inflow;
	 private final String uri;
	 
	 private InflowUri(String inflow, String uri) {
		 this.inflow = inflow;
		 this.uri = uri; 
	 }

	public String getInflow() {
		return inflow;
	}

	public String getUri() {
		return uri;
	}

}
