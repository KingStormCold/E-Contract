package vn.easycredit.internalapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.easycredit.request.LoginRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocApiRequest {
	
	@JsonProperty("partner_code")
	@SerializedName("partner_code")
	private String partnerCode;
	
	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;
	
	@JsonProperty("customer_name")
	@SerializedName("customer_name")
	private String customerName;
	
	@JsonProperty("id_number")
	@SerializedName("id_number")
	private String idNumber;
	
	@JsonProperty("note")
	@SerializedName("note")
	private String note;
	
	@JsonProperty("status")
	@SerializedName("status")
	private String status;

	public static DocApiRequest of(final LoginRequest request) {
		return new DocApiRequest(request.getPartnerCode(), request.getContractNumber(), "", request.getIdentity(), "", "ECN");
	}
}
