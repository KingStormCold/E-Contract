package vn.easycredit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import vn.easycredit.config.setting.SftpServerConfig;

@Slf4j
@Setter
@Getter
public class SftpServerConnection {
	
	public static final String FILE_TYPE_PDF = "pdf";

	private String sftpHost;
	private Integer sftpPort;
	private String sftpUser;
	private String sftpPassword;
	private String sftpWorkingDir;

	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;

	public SftpServerConnection() {
		super();
	}
	
	public SftpServerConnection(SftpServerConfig sftpServerConfig) {
		super();
		this.sftpUser = sftpServerConfig.getUserName();
		this.sftpPassword = sftpServerConfig.getPassword();
		
		this.sftpHost = sftpServerConfig.getHost();
		this.sftpPort = sftpServerConfig.getPort();
		this.sftpWorkingDir = sftpServerConfig.getWorkingDir();
	}

	public boolean connect() {
		try {
			JSch jsch = new JSch();
			this.session = jsch.getSession(this.sftpUser, this.sftpHost, this.sftpPort);
			this.session.setPassword(this.sftpPassword);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			this.session.setConfig(config);
			this.session.connect();
			this.channel = session.openChannel("sftp");
			this.channel.connect();
			this.channelSftp = (ChannelSftp) channel;
			log.info("connect sftp server success");
			return true;
		} catch (Exception e) {
			log.info("Failed to connect sftp server" + e.toString(), e);
			return false;
		}
	}

	public void disconnect() {
		log.info("disconnect");
		if (this.session != null && this.session.isConnected()) {
			this.channelSftp.exit();
			this.channel.disconnect();
			this.session.disconnect();
		}
	}

	public String uploadFile(File file, String desDir) {
		String fileName = "";
		try {
			log.info("uploadFile start!!");
			this.channelSftp.cd(desDir);
			fileName = file.getName();
			this.channelSftp.put(new FileInputStream(file), fileName);
		} catch (Exception ex) {
			log.info("uploadFile failed: " + ex.toString(), ex);
			return "";
		}
		return fileName;
	}
	
	public InputStream getFile(String fullFilePath) throws SftpException {
		try {
			return this.channelSftp.get(fullFilePath);
		} catch (SftpException e) {
			log.info("Failed to get file from sftp server: " + e.toString(), e);
			return null;
		}
	}

	public void moveFile(String srcDir, String dstDir) throws SftpException{
		this.channelSftp.rename(srcDir, dstDir);
	}
	
	public List<FileWrapper> listFile(String folderPath, String fileType) throws SftpException {
        return collectToWrapperList(channelSftp.ls(folderPath + "/*." + fileType));
    }
	
	private List<FileWrapper> collectToWrapperList(List<ChannelSftp.LsEntry> entries) {
        return entries.stream()
        .filter(entry -> !entry.getAttrs().isDir())
        .map(entry -> FileWrapper.from(entry.getAttrs().getMtimeString(), entry.getFilename(), entry.getAttrs().getSize()))
        .collect(Collectors.toList());
    }
}
