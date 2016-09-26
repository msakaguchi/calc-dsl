package com.msakaguchi.calc.converter;

import static com.msakaguchi.calc.converter.NumberUtil.instanceOfNumber;
import static com.msakaguchi.calc.converter.NumberUtil.onlyDecimalDigits;

import java.math.BigDecimal;

import static com.msakaguchi.calc.util.ReflectionUtils.getObjectInstance;

public class BigDecimalConverter {

	public <T> BigDecimal apply(T value) {

		if (value != null) {

			if (value instanceof BigDecimal) {
				return (BigDecimal) getObjectInstance(BigDecimal.class, value.toString());
			}

			if (instanceOfNumber(value)) {
				return (BigDecimal) getObjectInstance(BigDecimal.class, value.toString());
			}

			if (value instanceof String) {
				if (onlyDecimalDigits(value.toString())) {
					return (BigDecimal) getObjectInstance(BigDecimal.class, value);
				} else {
					throw new RuntimeException("objeto: " + value.toString() + " invalido para a expressao");
				}
			}

			throw new RuntimeException("objeto: " + value.toString() + " invalido para a expressao");

		}

		return null;
	}
	
}
