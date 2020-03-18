package vn.easycredit.config.setting;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SftpServerConfig {
	private String host;
	private Integer port;
	private String userName;
	private String password;
	private String workingDir;

	public SftpServerConfig() {
		super();
	}
	
	public SftpServerConfig(String sftpHost, Integer sftpPort, String sftpUser, String sftpPassword,
			String sftpWorkingDir) {
		super();
		this.host = sftpHost;
		this.port = sftpPort;
		this.userName = sftpUser;
		this.password = sftpPassword;
		this.workingDir = sftpWorkingDir;
	}

}
