package vn.easycredit.constant;

/**
 * Centralized error constants
 * 
 * @author HienNT
 */
public enum InvalidError {
	CONTRACT_UPDATE_SUCCESS		("E200-DIS", "Contract update successfully"),
	DISBURSEMENT_INVALID		("E201-DIS", "Disbursement valid"),
	
	//MISSING REQ 1
	MERCHANT_CODE_MISSING		("E009-DIS", "Merchant code is required."),
	PARTNER_CODE_MISSING		("E009-DIS", "Partner code is required."),
	IDENTITY_CARD_ID_MISSING	("E011-DIS", "Client ID number is required."),
	CONTRACT_NUMBER_MISSING		("E010-DIS", "Contract number is required."),
	KEY_CODE_MISSING			("E017-DIS", "Key code is required."),

	//INVALID REQ 1
	MERCHANT_CODE_INVALID		("MW019-DIS", "Merchant code is invalid"),
	PARTNER_CODE_INVALID		("E019-DIS", "Partner code is invalid"),
	IDENTITY_CARD_ID_INVALID	("E021-DIS", "Client ID is not valid"),
	CONTRACT_NUMBER_INVALID		("E020-DIS", "Contract number is invalid"),
	KEY_CODE_INVALID			("E026-DIS", "Key code is invalid"),
	CONTRACT_NUMBER_MISSING_IMX	("E008-DIS-IMX", "contract number is missing"),
	RESPONSE_CODE_MISSING_IMX	("E009-DIS-IMX", "response code is missing"),
	RESPONSE_MESSAGE_MISSING_IMX("E010-DIS-IMX", "response message is missing"),
	CONTRACT_NUMBER_INVALID_IMX	("E011-DIS-IMX", "contract number is missing"),
	CUSTOMER_NAME_INVALID_IMX	("E012-DIS-IMX", "customer name is invalid"),
	IDENTITY_CARD_ID_INVALID_IMX("E013-DIS-IMX", "identity card id is invalid"),
	ISSUED_DATE_INVALID_IMX		("E024-DIS-IMX", "issued date is invalid"),
	ISSUED_PLACE_INVALID_IMX	("E014-DIS-IMX", "issued place is invalid"),
	AMOUNT_INVALID_IMX			("E015-DIS-IMX", "amount is invalid"),
	CURRENCY_INVALID_IMX		("E016-DIS-IMX", "currency is invalid"),
	RESPONSE_CODE_INVALID_IMX	("E018-DIS-IMX", "response code is invalid"),
	RESPONSE_MESSAGE_INVALID_IMX("E019-DIS-IMX", "response message is invalid"),
	CUSTOMER_NAME_MISSING		("E018-DIS", "Client full name is required"),
	ISSUED_DATE_MISSING			("E012-DIS", "ID Issue date is required."),
	ISSUED_PLACE_MISSING		("E013-DIS", "ID Issued place is required."),
	AMOUNT_MISSING				("E014-DIS", "Disbursement amount is required."),
	DISBURSEMENT_DATE_MISSING	("E016-DIS", "Disbursement date is required"),
	TRANSACTION_ID_MISSING		("E043-DIS", "Transaction_ID is required"),
	CUSTOMER_NAME_INVALID		("E022-DIS", "Client name is not valid"),
	ISSUED_DATE_INVALID			("E044-DIS", "Issued Date is invalid"),
	ISSUED_PLACE_INVALID		("E047-DIS", "Issued place is invalid"),
	SHOPCODE_INVALID			("E038-DIS", "Shop code is invalid"),
	IMX_PAYMENT_REF_MISSING_IMX	("E020-DIS-IMX", "imx payment ref is missing"),
	TRANSACTION_ID_MISSING_IMX	("E021-DIS-IMX", "transaction id is missing"),
	IMX_PAYMENT_REF_INVALID_IMX	("E022-DIS-IMX", "imx payment ref is invalid"),
	TRANSACTION_ID_INVALID_IMX	("E023-DIS-IMX", "transaction id is invalid"),
	
	IMX_PAYMENT_REF_MISSING	("E031-DIS", "Imx pmt ref is required"),
	ACCOUNT_NUMBER_MISSING	("E050-DIS", "account number is missing"),
	BANK_CODE_MISSING		("E051-DIS", "bank code is missing"),
	DESCRIPTION_MISSING		("E052-DIS", "decription is missing"),
	IMX_PAYMENT_REF_INVALID	("E037-DIS", "imx payment ref is invalid"),
	ACCOUNT_NUMBER_INVALID	("E053-DIS", "account number is invalid"),
	BRANCH_CODE_MISSING		("E054-DIS", "branch code is missing"),
	BANK_CODE_INVALID		("E055-DIS", "bank code is invalid"),
	DESCRIPTION_INVALID		("E056-DIS", "decription is invalid"),
	RESP_CODE_MISSING		("E036-DIS", "resp code is missing"),
	RESP_CODE_INVALID		("E042-DIS", "resp code is invalid"),
	BRANCH_CODE_INVALID		("E057-DIS", "branch code is invalid"),
	CURRENCY_MISSING		("E015-DIS", "Currency is required."),
	AMOUNT_INVALID			("E045-DIS", "Disbursement amount is invalid"),
	CURRENCY_INVALID		("E024-DIS", "Currency is invalid"),
	DISBURSEMENT_DATE_INVALID	("E025-DIS", "Disbursement date is invalid"),
	TRANSACTION_ID_INVALID		("E046-DIS", "Transaction ID is invalid"),
	NOTE_INVALID				("E039-DIS", "Note is invalid"),
	
	CUSTOMER_NAME_MISSING_IMX	("E024-DIS-IMX", "customer name is missing"),
	IDENTITY_CARD_ID_MISSING_IMX("E025-DIS-IMX", "identity card is missing"),
	ISSUED_DATE_MISSING_IMX		("E026-DIS-IMX", "issued date is missing"),
	ISSUED_PLACE_MISSING_IMX	("E027-DIS-IMX", "issued place is missing"),
	AMOUNT_MISSING_IMX			("E028-DIS-IMX", "amount is missing"),
	CURRENCY_MISSING_IMX		("E029-DIS-IMX", "currency is missing"),
	
	NOT_FOUND_EXCEPTION			("E404-DIS", "not found information from core system"),
	INTERNAL_SERVER_ERROR		("E500-DIS", "internal server error"),
	BAD_REQUEST_EXCEPTION		("E400-DIS", "Bad request")
	;
	

    private final String errorCode;
    private final String errorMessage;

    private InvalidError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
