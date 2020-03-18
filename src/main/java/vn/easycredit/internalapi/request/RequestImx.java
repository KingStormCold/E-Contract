package vn.easycredit.internalapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestImx {
	@JsonProperty("barcode_number")
	@SerializedName("barcode_number")
	private String barcodeNumber;
	
	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;
	
	@JsonProperty("identity_card_id")
	@SerializedName("identity_card_id")
	private String identityCardId;
}