package vn.easycredit.entity.esign;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import vn.easycredit.entity.BaseInfoEntity;

@Setter
@Getter
@Entity
@Table(name = "econtract_agreement_uuid_history")
public class ESignAgreementUuidHistoryEntity extends BaseInfoEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Size(min = 1, max = 45)
	@Column(name = "id")
	private String id;

	@Column(name = "agreement_uuid")
	private String agreementUUID;

	@Column(name = "response_code")
	private Integer responseCode;

	@Column(name = "response_message")
	private String responseMessage;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contract_number")
	private ESignPrepareCertificateEntity prepareCertificateEntity;

	public ESignAgreementUuidHistoryEntity() {
		super();
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	public ESignAgreementUuidHistoryEntity(String agreementUUID, Integer responseCode, String responseMessage,
			ESignPrepareCertificateEntity prepareCertificateEntity) {
		super();
		this.agreementUUID = agreementUUID;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.prepareCertificateEntity = prepareCertificateEntity;
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	
}
