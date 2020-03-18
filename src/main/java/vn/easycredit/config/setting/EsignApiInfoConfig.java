package vn.easycredit.config.setting;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EsignApiInfoConfig {

	private String servicesUrl;
	private String agreementUuid;
	private String passCode;
	private String relyingParty;
	private String relyingPartyUser;
	private String relyingPartyPassword;
	private String relyingPartySignature;
	private String relyingPartyKeyStore;
	private String relyingPartyKeyStorePassword;

	public EsignApiInfoConfig() {
		super();
	}

}