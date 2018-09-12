package com.sbi.StartUp;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;


public class ValidatorUtil {
	private static Logger Log = Logger.getLogger(ValidatorUtil.class);
	private static final Pattern PATTERN_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern PATTERN_PHONE = Pattern.compile("^[0-9-+]{9,15}$");
	
	private static final Pattern PATTERN_NAME = Pattern.compile("^[A-Za-z]{1,}[._-]{0,1}[A-Za-z]{0,}$");
	private static final Pattern PATTERN_NUMBER = Pattern.compile("^[0-9 ()-/+/(/)]+$");
	private static final Pattern PATTERN_SP_CHAR = Pattern.compile("^[a-zA-Z0-9 !@,._-]*$");

	public static String checkRemoveXSSVeranablity(String value) {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
		value = value.replaceAll("script", "");
		value = value.replaceAll("javascript", "");
		return value;
	}

	public static boolean validateSpecialCharacter(String value) {
		return PATTERN_SP_CHAR.matcher(value).matches();
	}
	
	public static boolean validateName(String value) {
		return PATTERN_NAME.matcher(value).matches();
	}
	
	public static boolean validateNumber(String value) {
		return PATTERN_NUMBER.matcher(value).matches();
	}

	public static boolean validateEmail(String value) {
		return PATTERN_EMAIL.matcher(value).matches();
	}

	public static boolean validatePhone(String value) {
		return PATTERN_PHONE.matcher(value).matches();
	}
	
	public static boolean isAlfaNum(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i)) && !Character.isLetter(value.charAt(i))) {				
					return false;				
			}
		}
		return true;
	}
	
	public static boolean isNumeric(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {				
					return false;				
			}
		}
		return true;
	}

	public static boolean isLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;

	}

}