package exception;

import java.util.regex.Pattern;

public class Validator {
	public static boolean validatePhoneNumber(String phone) {
		Pattern p = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
		if (p.matcher(phone).find()) {
			return true;
		}
		return false;
	}
	
	public static boolean validateEmail(String email) {
		Pattern p = Pattern.compile("^[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+$");
		if (p.matcher(email).find()) {
			return true;
		}
		return false;
	}
}
