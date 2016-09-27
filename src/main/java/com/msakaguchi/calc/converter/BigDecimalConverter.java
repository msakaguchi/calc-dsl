package com.msakaguchi.calc.converter;

import static com.msakaguchi.calc.converter.NumberUtil.instanceOfNumber;
import static com.msakaguchi.calc.converter.NumberUtil.onlyDecimalDigits;

import java.math.BigDecimal;

import static com.msakaguchi.calc.util.ReflectionUtils.newObjectInstance;

public class BigDecimalConverter {

	public <T> BigDecimal apply(T value) {

		if (value != null) {
			
			if (instanceOfNumber(value)) {
				return (BigDecimal) newObjectInstance(BigDecimal.class, value.toString());
			}

			if (value instanceof String) {
				if (onlyDecimalDigits(value.toString())) {
					return (BigDecimal) newObjectInstance(BigDecimal.class, value);
				} else {
					throw new RuntimeException("objeto: " + value.toString() + " invalido para a expressao");
				}
			}

			throw new RuntimeException("objeto: " + value.toString() + " invalido para a expressao");

		}

		return null;
	}
	
}
