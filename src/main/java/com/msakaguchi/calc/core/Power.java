package com.msakaguchi.calc.core;

import java.math.BigDecimal;

import com.msakaguchi.calc.visitor.Visitor;


public class Power implements Expression {

	private Expression left;
	private Expression right;
	
	public Power(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public BigDecimal eval() {
		
		BigDecimal leftValue = left.eval();
		BigDecimal rightValue = right.eval();
		
		return    pow(leftValue, rightValue);
	}

	private BigDecimal pow(BigDecimal leftValue, BigDecimal rightValue) {
		return BigDecimal.valueOf(Math.pow(leftValue.doubleValue(), rightValue.doubleValue()));
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitPower(this);
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
	
	
}
