package vn.easycredit.config.setting;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FptPartnerInfoConfig {

	private EsignApiInfoConfig esignApiInfo;

	public FptPartnerInfoConfig() {
		super();
	}
}
