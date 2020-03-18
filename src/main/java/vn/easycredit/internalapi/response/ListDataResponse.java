package vn.easycredit.internalapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDataResponse {

	@JsonProperty("contract_number")
	@SerializedName("contract_number")	
	private String contractNumber;
	
	@JsonProperty("customer_name")
	@SerializedName("customer_name")	
	private String customerName;
	
	@JsonProperty("customer_address")
	@SerializedName("customer_address")	
	private String customerAddress;
	
	@JsonProperty("phone_number")
	@SerializedName("phone_number")	
	private String phoneNumber;
	
	@JsonProperty("identity_card_id")
	@SerializedName("identity_card_id")	
	private String identityCardId;
	
	@JsonProperty("contract_file_name")
	@SerializedName("contract_file_name")	
	private String contractFileName;
	
	@JsonProperty("term_condition")
	@SerializedName("term_condition")	
	private String termCondition;
}
