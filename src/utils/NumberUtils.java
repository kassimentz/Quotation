package utils;

public class NumberUtils {

	public static boolean isValid(Number value) {
		if(value.doubleValue() > 0) {
			return true;
		} else {
			throw new IllegalArgumentException("Number must be > 0");
		}
	}

}
