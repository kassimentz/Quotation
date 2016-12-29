package utils;

public class StringUtils {

	public static boolean isValid(String string) throws IllegalArgumentException{
		if(string != null && !string.isEmpty()) {
			return true;
		}else {
			throw new IllegalArgumentException("String not valid");
		}
	}

}
