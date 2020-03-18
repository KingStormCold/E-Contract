package vn.easycredit.domain;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.Constant;
import vn.easycredit.constant.InflowUri;
import vn.easycredit.exception.RequestException;

/**
 * 
 * @author HienNT
 *
 */
@Slf4j
public final class Utilities {
	
	public static final String PARTNER_CODE_SAC = "SAC";
	public static final String PARTNER_CODE_VTB = "VTB";
	public static final String PARTNER_CODE_VIETTEL_PAY = "VTT";
	public static final String PARTNER_CODE_VIETTEL_TELECOM = "VTL";
	public static final String PARTNER_CODE_EASY = "EASY";
	
	public static final String FORMAT = "%s %s";
	public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
	public static final String MY_TIME_ZONE = "Asia/Bangkok";
	
	
	public static final String PATTERN_TYPE_INTEGER = "int-type";
	public static final String PATTERN_TYPE_STRING = "string-type";
	public static final String PATTERN_TYPE_STRING_SPACE = "string-space-type";
	
	public static final String PATTERN_TYPE_STRING_INTEGER = "string-int-type";
	public static final String PATTERN_TYPE_STRING_INTEGER_SPACE = "string-int-space-type";
	
	public static final String PATTERN_TYPE_DATE = "date-type"; // dd/MM/yyyy
	public static final String PATTERN_TYPE_DATE_SPECIAL = "date-special-type"; // ddmmyyyy
	public static final String PATTERN_TYPE_DATEHOUR = "datehour-type"; // dd/mm/yyyy hh:mm
	public static final String PATTERN_TYPE_DATETIME = "datetime-type"; // dd/mm/yyyy hh:mm:ss
	public static final String PATTERN_TYPE_DATETIME_YYMD_HMS = "datetime-yymd-hms-type"; // yyyy/mm/dd hh:mm:ss
	public static final String PATTERN_TYPE_DATETIME_YYMD_HMS_VIETTEL = "datetime-yyyymmddhhmmss-type"; // yyyymmddhhmmss 
	
	public static final String PATTERN_TYPE_NOTE_VIETNAMESE_DIACRITIC_CHARACTERS = "string_note_vietnamese_space_type";
//	public static final Pattern PATTERN_NOTE_VIETNAMESE_DIACRITIC_CHARACTERS =
//			Pattern.compile("^[a-zA-Z0-9ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]"
//					+ "+([\\s./:,#\\-&&[^\\t]]"
//					+ "+[a-zA-Z0-9ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]+)*"
//					,Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	
	
	public static final Pattern PATTERN_NOTE_VIETNAMESE_DIACRITIC_CHARACTERS = 
			Pattern.compile("^[a-zA-Z0-9\\s.,:\\/\\#\\-\\_\\!()\\&ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]+$"
					,Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	
	public static final String PATTERN_TYPE_NAME = "name_type";
	public static final String PATTERN_TYPE_ADDRESS = "address_type";
	public static final String PATTERN_TYPE_NOTE = "note_type";
	
	public static final String PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN = "string-int-underline-hyphen-type";
	public static final String PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE = "string-int-underline-hyphen-space-type";
	public static final String PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE_DOTS_COMMA = "string-int-underline-hyphen-space-dots-comma-type";
	public static final String PATTERN_TYPE_INTEGER_UNDERLINE_HYPHEN = "int-underline-hyphen-type";
	public static final String PATTERN_TYPE_INTEGER_UNDERLINE_HYPHEN_SPACE = "int-underline-hyphen-space-type";
	public static final String PATTERN_TYPE_FILE_EXTENSION = "file-extension";
	
	public static final String PATTERN_TYPE_DOUBLE = "double_type";
	public static final String PATTERN_TYPE_BOOLEAN = "boolean-type";

	
	public static final Pattern PATTERN_INTEGER = Pattern.compile("^[0-9]+$");
	public static final Pattern PATTERN_STRING = Pattern.compile("^[A-Za-z]+$");
	public static final Pattern PATTERN_STRING_SPACE = Pattern.compile("^[a-zA-Z\\s]+$");
	public static final Pattern PATTERN_STRING_INTEGER = Pattern.compile("^[A-Za-z0-9]+$");
	public static final Pattern PATTERN_STRING_INTEGER_SPACE = Pattern.compile("^[a-zA-Z0-9\\s&&[^\\t]]+$");
	
	public static final Pattern PATTERN_DATE = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)+$");
	public static final Pattern PATTERN_DATE_SPECIAL = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])(0?[1-9]|1[012])((19|20)\\d\\d)+$");
	public static final Pattern PATTERN_DATEHOUR = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]+$");
	public static final Pattern PATTERN_DATETIME = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]+$");
	public static final Pattern PATTERN_DATETIME_YYMD_HMS = Pattern.compile("((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]+$");
	public static final Pattern PATTERN_DATETIME_YYMD_HMS_VIETTEL = Pattern.compile("((19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])([01]?[0-9]|2[0-3])[0-5][0-9][0-5][0-9]+$");
	public static final Pattern PATTERN_DATETIME_YYMD_HMS_VIRTUAL_ACCOUNT = Pattern.compile("((19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])$");
	public static final Pattern PATTERN_DOUBLE = Pattern.compile("^[0-9.]+$");
	public static final Pattern PATTERN_BOOLEAN = Pattern.compile("^[0-1]+$");
	public static final Pattern PATTERN_FILE_EXTENSION = Pattern.compile("([^\\s]+(\\.(?i)(pdf))$)");
	
	public static final Pattern PATTERN_NAME =
			Pattern.compile("^[Ŏŏ\\'a-zA-Z0-9ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]"
					+ "+([\\s\\'\\.]"
					+ "+[Ŏŏ\\'a-zA-Z0-9ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ\\.]+)*"
					,Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	
	public static final Pattern PATTERN_ADDRESS =
			Pattern.compile("^[Ŏŏa-zA-Z0-9\\s.,:\\/\\#\\-\\_\\!()\\&ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđŎŏ]+$"
					,Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	
	public static final Pattern PATTERN_NOTE = 
		Pattern.compile("^[a-zA-Z0-9\\s.,:\\/\\#\\-\\_\\!()\\&ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]+$"
				,Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	
	public static final Pattern PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN = Pattern.compile("^[a-zA-Z0-9\\-\\_]+$");
	public static final Pattern PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE = Pattern.compile("^[a-zA-Z0-9\\-\\_\\s&&[^\\t]]+$");
	public static final Pattern PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE_DOTS_COMMA = Pattern.compile("^[a-zA-Z0-9.,\\-\\_\\s&&[^\\t]]+$");
	public static final Pattern PATTERN_INTEGER_UNDERLINE_HYPHEN = Pattern.compile("^[0-9\\-_]+$");
	public static final Pattern PATTERN_INTEGER_UNDERLINE_HYPHEN_SPACE = Pattern.compile("^[0-9\\-_\\s]+$");
	
	
	public static final Pattern FILENAME_DATE_PATTERN = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])(0?[1-9]|1[012])((19|20)\\d\\d)(_)+$");
//	public static final Pattern FILENAME_DATE_PATTERN = Pattern.compile("((19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])+$");
	
	
	
	public static final String REGEX_INTEGER = "^[0-9]+$";
	public static final String REGEX_DOUBLE = "^[0-9.]+$";
	public static final String REGEX_STRING_INTEGER = "^[A-Za-z0-9]+$";
	public static final String REGEX_STRING_INTEGER_DOTS = "^[A-Za-z0-9.]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_UNDERLINE = "^[A-Za-z0-9_.]+$";
	public static final String REGEX_STRING_SPACE = "^[A-Za-z ]+$";
	public static final String REGEX_STRING_UNDERLINE = "^[A-Za-z_]+$";
	public static final String REGEX_STRING = "^[A-Za-z]+$";
	public static final String REGEX_INTEGER_LIMIT = "^[0-9]{9,12}+$";
	public static final String REGEX_STRING_UPPERCASE = "^[A-Z]+$";
	public static final String REGEX_STRING_INTEGER_UNDERLINE = "^[A-Za-z0-9_]+$";
	public static final String REGEX_STRING_INTEGER_COMMA = "^[A-Za-z0-9,]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_HYPHEN = "^[A-Za-z0-9-.]+$";
	public static final String REGEX_STRING_INTEGER_HYPHEN_UNDERLINE = "^[A-Za-z0-9-_]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_HYPHEN_SPACE = "^[A-Za-z0-9-. ]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_HYPHEN_COMMA = "^[A-Za-z0-9-.,]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_HYPHEN_COMMA_SPACE = "^[A-Za-z0-9-., ]+$";
	public static final String REGEX_STRING_INTEGER_DOTS_HYPHEN_COMMA_SPACE_SLASH = "^[A-Za-z0-9-.,/ ]+$";
	public static final String REGEX_DATE = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)+$";
	public static final String REGEX_DATEHOUR = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]+$";
	public static final String REGEX_DATETIME = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]+$";
	public static final String REGEX_STRING_UPPERCASE_FIN = "^[A-Z0-9 ']+$";
	
	
	public static final String BANK_CODE_TSA = "evnfc_test";
	public static final String BANK_API_KEY_TSA = "bf8b02542517ba786e9b2bab15c78c3a";
	
	public static final String DISBURSEMENT_FUNCTION_NAME_SAC = "InterFundTransfer";
	
	
	
	public static Date getTime() {
		return new Date();
	}
	
	public static boolean checkInValidLenght(int min, int max, String input) {
		if (input.length() >= min && input.length() <= max){
			return false;
		}
		return true;
	}
	
	public static boolean checkValidIdentityCardId(String input) {
		if (input.length() == 9 || input.length() == 12){
			return true;
		}
		return false;
	}
	
	public static boolean checkValidPhoneNumber(String input) {
		if (input.length() == 10 || input.length() == 11){
			return true;
		}
		return false;
	}
	
	public static String parseDateToString(Date date, String pattern){
		if (pattern.equals(PATTERN_TYPE_DATE)){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.format(date);
		} else if (pattern.equals(PATTERN_TYPE_DATETIME_YYMD_HMS_VIETTEL)){
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			return df.format(date);
		} else {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			return df.format(date);
		}
	}
	
	public static void validateError(String errorCode, String errorMessage) throws RequestException, IOException{
		log.error(String.format(FORMAT, errorCode, errorMessage));
//		throw new RequestException(String.format(FORMAT, errorCode, errorMessage));
		throw new RequestException(errorCode, errorMessage);
	}
	
	public enum ApiError {
		BAD_REQUEST_ERROR_CODE("G001", "Bad Request"),
	    VALIDATE_RESPONSE_ERROR_CODE("G002", "Validate Response Error"),
		NO_RESPONSE_ERROR_CODE("G002", "No Response From ThirtParty");

	    private final String errorCode;
	    private final String errorMessage;

	    private ApiError(String errorCode, String errorMessage) {
	        this.errorCode = errorCode;
	        this.errorMessage = errorMessage;
	    }

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public String asErrorCode() {
			return errorCode;
		}
	    
	}
	
	public static boolean checkMatch(String type, String input){
		boolean matches = true;
		Matcher matcher;
		
		if (type.equals(Utilities.PATTERN_TYPE_INTEGER)){
			matcher = Utilities.PATTERN_INTEGER.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING)){
			matcher = Utilities.PATTERN_STRING.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_SPACE)){
			matcher = Utilities.PATTERN_STRING_SPACE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_INTEGER)){
			matcher = Utilities.PATTERN_STRING_INTEGER.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_INTEGER_SPACE)){
			matcher = Utilities.PATTERN_STRING_INTEGER_SPACE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DATE)){
			matcher = Utilities.PATTERN_DATE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DATE_SPECIAL)){
			matcher = Utilities.PATTERN_DATE_SPECIAL.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DATEHOUR)){
			matcher = Utilities.PATTERN_DATEHOUR.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DATETIME)){
			matcher = Utilities.PATTERN_DATETIME.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DATETIME_YYMD_HMS)){
			matcher = Utilities.PATTERN_DATETIME_YYMD_HMS.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_DOUBLE)){
			matcher = Utilities.PATTERN_DOUBLE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_BOOLEAN)){
			matcher = Utilities.PATTERN_BOOLEAN.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_NAME)){
			matcher = Utilities.PATTERN_NAME.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_ADDRESS)){
			matcher = Utilities.PATTERN_ADDRESS.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_NOTE)){
			matcher = Utilities.PATTERN_NOTE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN)){
			matcher = Utilities.PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE)){
			matcher = Utilities.PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE_DOTS_COMMA)){
			matcher = Utilities.PATTERN_STRING_INTEGER_UNDERLINE_HYPHEN_SPACE_DOTS_COMMA.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_INTEGER_UNDERLINE_HYPHEN)){
			matcher = Utilities.PATTERN_INTEGER_UNDERLINE_HYPHEN.matcher(input);
			matches = matcher.matches();
		}
		if (type.equals(Utilities.PATTERN_TYPE_INTEGER_UNDERLINE_HYPHEN_SPACE)){
			matcher = Utilities.PATTERN_INTEGER_UNDERLINE_HYPHEN_SPACE.matcher(input);
			matches = matcher.matches();
		}
		
		return matches;
	}
	
	public static Date parseDate(String strDate){
		try {
            if (PATTERN_DATE.matcher(strDate).matches()) {
            	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            	df.setTimeZone(UTC_TIME_ZONE);
            	df.setLenient(false);
            	return df.parse(strDate);
            } else if (PATTERN_DATETIME.matcher(strDate).matches()) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            	dateFormat.setLenient(false);
            	return dateFormat.parse(strDate);
            } else if (PATTERN_DATETIME_YYMD_HMS.matcher(strDate).matches()) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            	dateFormat.setLenient(false);
            	return dateFormat.parse(strDate);
            } else if (PATTERN_DATE_SPECIAL.matcher(strDate).matches()) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            	dateFormat.setTimeZone(UTC_TIME_ZONE);
            	dateFormat.setLenient(false);
            	return dateFormat.parse(strDate);
            } else if (PATTERN_DATEHOUR.matcher(strDate).matches()) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            	dateFormat.setTimeZone(UTC_TIME_ZONE);
            	dateFormat.setLenient(false);
            	return dateFormat.parse(strDate);
            } else if (PATTERN_DATETIME_YYMD_HMS_VIRTUAL_ACCOUNT.matcher(strDate).matches()) {
            	//convert yyyyMMdd to dd/MM/yyyy
            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            	Date date = dateFormat.parse(strDate);
            	dateFormat.applyPattern("dd/MM/yyyy");
            	String result = dateFormat.format(date);
            	return dateFormat.parse(result);
            } else {
                return null;
            }
        } catch (ParseException e) {
            return null;
        }
	}
	
	public static double parseDouble(String strDouble) throws ParseException{
		return Double.parseDouble(strDouble);
	}
	
	public static boolean checkFileNameDocApi(String fileName){
		if (StringUtils.isEmpty(fileName) || fileName.length() < 10)
		{
			return false;
		} else {
			String prefixName = fileName.substring(0,8);
			Matcher matcher = Utilities.FILENAME_DATE_PATTERN.matcher(prefixName);
			if (matcher.matches() == true){
				try{
					@SuppressWarnings("unused")
					Date date = Utilities.parseDate(prefixName);
					return true;
				}catch (Exception e){
					return false;
				}
			}
			return false;
		}
	}
	
	
	synchronized public static String removeToneMark(String str) {
        return str == null ? null
                : Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                        .replace('Ð', 'D').replace('đ', 'd').replace("Đ", "D").replace("đ", "d");
    }
	
	
	synchronized public static String removeSpecialChar(String str) {
		
		if (StringUtils.isEmpty(str)){
			return null;
		} else {
			return str.replace("-", "").replace("'", "").replace(",", "").replace(".", "").replace("_", "");
		}
    }
	
	public static <T> Object convertJSONStringToObject(String jsonString, Class<T> objectClass){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, objectClass);
		} catch (JsonParseException e) {
			log.warn("JsonParseException: "+e.getMessage()+"\n"+jsonString);
		} catch (JsonMappingException e) {
			log.warn("JsonMappingException: "+e.getMessage()+"\n"+jsonString);
		} catch (IOException e) {
			log.warn("IOException: "+e.getMessage()+"\n"+jsonString);
		}
		return null;
	}	
	
	/**
	 * convert Request object to string Json(for write Log) 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static <T> String convertObjectToJsonLog(T object){
		try {
			Gson builder = new GsonBuilder()
					.registerTypeAdapter(Date.class, new CustomDateJsonSerializer())
					.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
					.create();
			return builder.toJson(object);
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
	}
	
	public static String getInflowApiByUri(String uri){
		String inflowApi = Constant.EMPTY_VALUE;
		try {
			if(uri.equals(InflowUri.DISBURSEMENT_INFO_INFLOW.getUri())) {
				inflowApi = InflowUri.DISBURSEMENT_INFO_INFLOW.getInflow();
			}else if(uri.equals(InflowUri.DISBURSEMENT_SUCCESS_INFLOW.getUri())){
				inflowApi = InflowUri.DISBURSEMENT_SUCCESS_INFLOW.getInflow();
			}else if(uri.equals(InflowUri.DISBURSEMENT_FUND_TRANSFER_REQUEST_INFLOW.getUri())){
				inflowApi = InflowUri.DISBURSEMENT_FUND_TRANSFER_REQUEST_INFLOW.getInflow();
			}else {
				inflowApi = InflowUri.DISBURSEMENT_FUND_TRANSFER_RESULT_INFLOW.getInflow();
			}
			
			return inflowApi;
		} catch (Exception e) {
			return inflowApi;
		}
	}
}
