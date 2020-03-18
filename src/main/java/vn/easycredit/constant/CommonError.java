package vn.easycredit.constant;

import lombok.Getter;

@Getter
public enum CommonError {
	
	INPUT_EMPTY("EC-BR-00", "Input not empty."),
	INVALID_IDENTITY("EC-BR-01", "Invalid identity. Identity is just number."),
	INVALID_LENGTH_INDENTITY("EC-BR-02", "The length of identity is 9 or 12."),
	INVALID_CONTRACT_NUMBER("EC-BR-03", "Invalid contract number. Contract number is just number."),
	INVALID_LENGTH_CONTRACT_NUMBER("EC-BR-04", "The length of contract number is 10."),
	INVALID_TERM ("EC-BR-05", "Please choose agree."),
	ERROR_NOT_FOUND_CONTRACT("EC-ER-00", "System not found your contract.")
	;
	
	private String code;
	
	private String value;

	private CommonError(String code, String value) {
		this.code = code;
		this.value = value;
	}
}
