package com.msakaguchi.calc.converter;

import static com.msakaguchi.calc.converter.NumberUtil.instanceOfNumber;
import static com.msakaguchi.calc.converter.NumberUtil.onlyDecimalDigits;

import java.math.BigDecimal;

public class BigDecimalConverter {

	public <T> BigDecimal apply(T value) {

		if (value != null) {

			if (value instanceof BigDecimal) {
				return (BigDecimal) value;
			}

			if (instanceOfNumber(value)) {
				return new BigDecimal(value.toString());
			}

			if (value instanceof String) {
				if (onlyDecimalDigits(value.toString())) {
					return new BigDecimal(value.toString());
				} else {
					throw new RuntimeException("objeto: " + value.toString()
							+ " invalido para a expressao");
				}
			}

			throw new RuntimeException("objeto: " + value.toString()
					+ " invalido para a expressao");

		}

		return null;
	}
}
