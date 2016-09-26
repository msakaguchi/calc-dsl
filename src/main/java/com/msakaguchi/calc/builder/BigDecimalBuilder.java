package com.msakaguchi.calc.builder;

import com.msakaguchi.calc.converter.*;

public class BigDecimalBuilder {

	private BigDecimalConverter transformer;
	
	public static BigDecimalBuilder BigDecimal() {
		return new BigDecimalBuilder();
	}
	
	public BigDecimalBuilder() {
		transformer = new BigDecimalConverter();
	}
	
	public <V> java.math.BigDecimal valueOf(V value) {
		return transformer.apply(value);
	}
	
}
