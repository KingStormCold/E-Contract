package vn.easycredit.domain;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class Email {

	@JsonProperty("from")
	@SerializedName("from")
	private String emailFrom;

	@JsonProperty("to")
	@SerializedName("to")
	private List<EmailAddress> emailTo;

	@JsonProperty("cc")
	@SerializedName("cc")
	private List<EmailAddress> emailCc;

	@JsonProperty("bcc")
	@SerializedName("bcc")
	private List<EmailAddress> emailBcc;

	@JsonProperty("subject")
	@SerializedName("subject")
	private String subject;

	private Map<String, Object> model;

	@JsonProperty("content")
	@SerializedName("content")
	private String content;
	
	private File attachment;
	
	@JsonProperty("templateName")
	@SerializedName("templateName")
	private String templateName;


	public String[] getListEmailTo() {
		String[] listStringEmail = null;
		if (this.emailTo != null && this.emailTo.size() > 0) {
			listStringEmail = new String[this.emailTo.size()];
			for (int i = 0; i < this.emailTo.size(); i++) {
				listStringEmail[i] = this.emailTo.get(i).getEmailAddress();
			}
		}
		return listStringEmail;
	}

	public String[] getListEmailCc() {
		String[] listStringEmail = null;
		if (this.emailCc != null && this.emailCc.size() > 0) {
			listStringEmail = new String[this.emailCc.size()];
			for (int i = 0; i < this.emailCc.size(); i++) {
				listStringEmail[i] = this.emailCc.get(i).getEmailAddress();
			}
		}
		return listStringEmail;
	}

	public String[] getListEmailBcc() {
		String[] listStringEmail = null;
		if (this.emailBcc != null && this.emailBcc.size() > 0) {
			listStringEmail = new String[this.emailBcc.size()];
			for (int i = 0; i < this.emailBcc.size(); i++) {
				listStringEmail[i] = this.emailBcc.get(i).getEmailAddress();
			}
		}
		return listStringEmail;
	}

	// public boolean validateInfo() throws RequestException, IOException {
	// // emailForm
	//// if (this.emailFrom == null ||this.emailFrom.isEmpty()) {
	//// Utilities.validateError(InvalidError.FROM_EMAIL_MISSING.getErrorCode(),
	//// InvalidError.FROM_EMAIL_MISSING.getErrorMessage());
	//// }
	//// Utilities.validateEmail(this.emailFrom);
	//
	// // emailTo
	// if (this.emailTo == null || this.emailTo.size() <= 0) {
	// Utilities.validateError(InvalidError.TO_EMAIL_MISSING.getErrorCode(),
	// InvalidError.TO_EMAIL_MISSING.getErrorMessage());
	// }
	// for (int i = 0; i < this.emailTo.size(); i++) {
	// this.emailTo.get(i).validateInfo();
	// }
	//
	// // emailCc
	// if (this.emailCc != null && this.emailCc.size() > 0) {
	// for (int i = 0; i < this.emailCc.size(); i++) {
	// this.emailCc.get(i).validateInfo();
	// }
	// }
	//
	// // emailCc
	// if (this.emailBcc != null && this.emailBcc.size() > 0) {
	// for (int i = 0; i < this.emailBcc.size(); i++) {
	// this.emailBcc.get(i).validateInfo();
	// }
	// }
	// return true;
	// }
}
