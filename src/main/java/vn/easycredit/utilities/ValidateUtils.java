package vn.easycredit.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ValidateUtils {

	public static final Pattern PATTERN_INTEGER = Pattern.compile("^[0-9]+$");
	
	public static boolean checkIntegerMatch(final String identity) {
		Matcher matcher = PATTERN_INTEGER.matcher(identity);
		return matcher.matches();
	}
}
