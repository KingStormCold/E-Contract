package vn.easycredit.internalapi.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.easycredit.domain.Utilities;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImxContractInfo {
	@JsonProperty("barcode_number")
	@SerializedName("barcode_number")
	private String barcodeNumber;

	@JsonProperty("partner_code")
	@SerializedName("partner_code")
	private String partnerCode;

	@JsonProperty("contract_number")
	@SerializedName("contract_number")
	private String contractNumber;

	@JsonProperty("identity_card_id")
	@SerializedName("identity_card_id")
	private String identityCardId;

	@JsonProperty("customer_name")
	@SerializedName("customer_name")
	private String customerName;

	@JsonProperty("phone_number")
	@SerializedName("phone_number")
	private String phoneNumber;

	@JsonProperty("living_address")
	@SerializedName("living_address")
	private String livingAddress;

	@JsonProperty("loan_amount")
	@SerializedName("loan_amount")
	private Double loanAmount;

	@JsonProperty("loan_tenor")
	@SerializedName("loan_tenor")
	private Integer loanTenor;

	@JsonProperty("product_type_code")
	@SerializedName("product_type_code")
	private String productTypeCode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = Utilities.MY_TIME_ZONE)
	@JsonProperty("approved_date")
	@SerializedName("approved_date")
	private Date approvedDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = Utilities.MY_TIME_ZONE)
	@JsonProperty("active_date")
	@SerializedName("active_date")
	private Date activeDate;

	@JsonProperty("sale_channel_code")
	@SerializedName("sale_channel_code")
	private String saleChannelCode;

	@JsonProperty("contract_status_code")
	@SerializedName("contract_status_code")
	private String contractStatusCode;
}
