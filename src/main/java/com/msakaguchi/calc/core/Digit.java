package com.msakaguchi.calc.core;

import static com.msakaguchi.calc.builder.BigDecimalBuilder.BigDecimal;

import java.math.BigDecimal;

import com.msakaguchi.calc.visitor.Visitor;

public class Digit implements Expression {

	private BigDecimal digit;

	public <D> Digit(D digit) {
		this.digit = BigDecimal().valueOf(digit);
	}

	@Override
	public BigDecimal eval() {
		return digit;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitDigit(this);
	}

	public BigDecimal getDigit() {
		return digit;
	}
}
