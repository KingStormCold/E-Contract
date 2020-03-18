//package vn.easycredit.domain;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.google.gson.annotations.SerializedName;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import vn.easycredit.domain.Utilities;
//
///**
// * 
// * @author HienNT
// *
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(Include.NON_EMPTY)
//public class IMXContractInfoRES implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@JsonProperty("Response_code")
//	@SerializedName("Response_code")
//	private String responseCode;
//
//	@JsonProperty("Response_message")
//	@SerializedName("Response_message")
//	private String responseMessage;
//
//	@JsonProperty("Body")
//	@SerializedName("Body")
//	private List<ResponseBody> dataBody;
//	
//	@Data
//	@AllArgsConstructor
//	@NoArgsConstructor
//	public static class ResponseBody{
//		
//		@JsonProperty("barcode_number")
//		@SerializedName("barcode_number")
//		private String barcodeNumber;
//		
//		@JsonProperty("partner_code")
//		@SerializedName("partner_code")
//		private String partnerCode;
//		
//		@JsonProperty("contract_number")
//		@SerializedName("contract_number")
//		private String contractNumber;
//		
//		@JsonProperty("identity_card_id")
//		@SerializedName("identity_card_id")
//		private String identityCardId;
//		
//		@JsonProperty("customer_name")
//		@SerializedName("customer_name")
//		private String customerName;
//		
//		@JsonProperty("phone_number")
//		@SerializedName("phone_number")
//		private String phoneNumber;
//		
//		@JsonProperty("loan_amount")
//		@SerializedName("loan_amount")
//		private String loanAmount;
//		
//		@JsonProperty("loan_tenor")
//		@SerializedName("loan_tenor")
//		private String loanTenor;
//		
//		@JsonProperty("product_type_code")
//		@SerializedName("product_type_code")
//		private String productTypeCode;
//		
//		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = Utilities.MY_TIME_ZONE)
//		@JsonProperty("approved_date")
//		@SerializedName("approved_date")
//		private Date approvedDate;
//		
//		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = Utilities.MY_TIME_ZONE)
//		@JsonProperty("active_date")
//		@SerializedName("active_date")
//		private Date activeDate;
//		
//		@JsonProperty("sale_channel_code")
//		@SerializedName("sale_channel_code")
//		private String saleChannelCode;
//		
//		@JsonProperty("contract_status_code")
//		@SerializedName("contract_status_code")
//		private String contractStatusCode;
//	}
//
//}