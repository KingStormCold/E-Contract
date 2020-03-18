//package vn.easycredit.domain;
//import java.io.Serializable;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.google.gson.annotations.SerializedName;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
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
//public class IMXContractInfoREQ implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
////	@Valid
////	@NotNull
////	@Size(min = 1, max = 20)
////	@Pattern(message = "Invalid partner_code", regexp = Utilities.REGEX_STRING_INTEGER)
//	@JsonProperty("barcode_number")
//	@SerializedName("barcode_number")
//	private String barcodeNumber;
//
////	@Valid
////	@NotNull
////	@Size(min = 1, max = 20)
////	@Pattern(message = "Invalid contract_number", regexp = Utilities.REGEX_STRING_INTEGER)
//	@JsonProperty("contract_number")
//	@SerializedName("contract_number")
//	private String contractNumber;
//
////	@Valid
////	@NotNull
////	@Pattern(message = "Invalid checking_date", regexp = Utilities.REGEX_DATE)
//	@JsonProperty("identity_card_id")
//	@SerializedName("identity_card_id")
//	private String identityCardId;
//
//}