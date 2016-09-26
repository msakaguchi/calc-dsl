package com.msakaguchi.calc.converter;

import static com.msakaguchi.calc.util.ReflectionUtils.getObjectInstance;

public class NumberConverter {

	@SuppressWarnings("unchecked")
	public static <T extends Number> T from(Class<? extends Number> clazz, T object) {
		return (T) getObjectInstance(clazz, object.toString());
	}
}
