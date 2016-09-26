package com.msakaguchi.calc.converter;

import java.math.BigDecimal;

public class NumberUtil {

	public static <T> boolean instanceOfNumber(T object) {
		return object instanceof Double || object instanceof Long
				|| object instanceof Integer || object instanceof BigDecimal
				|| object instanceof Float || object instanceof Short;
	}

	public static boolean onlyDigits(String value) {
		return value.matches("^[0-9]+");
	}

	public static boolean onlyDecimalDigits(String value) {
		return value.matches("^[0-9\\.]+");
	}
}
