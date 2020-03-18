package vn.easycredit.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class FileWrapper {

	private static final String TIME_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

	private Date timeStamp;
	private String fileName;
	private Long fileSize;

	private FileWrapper(String timeStamp, String fileName, Long fileSize) throws ParseException {
		this.timeStamp = new SimpleDateFormat(TIME_FORMAT).parse(timeStamp);
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public static FileWrapper from(final String timeStamp, final String fileName, final Long fileSize) {
		try {
			return new FileWrapper(timeStamp, fileName, fileSize);
		} catch (ParseException e) {
			log.info("FileWrapper from ParseException: " + e.toString());
		}
		return null;
	}
}
