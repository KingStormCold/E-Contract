package vn.easycredit.config.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "econtract-configurations")
public class EcontractConfigSetting {
	private String queueLog;
	private ThirdPartyApiInfoConfig thirdPartyApiInfo;
	private SftpServerConfig sftpServer;
	private InternalApiInfo internalApiInfo;
}