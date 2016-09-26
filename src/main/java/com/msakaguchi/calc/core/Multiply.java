package com.msakaguchi.calc.core;

import java.math.BigDecimal;

import com.msakaguchi.calc.visitor.Visitor;

public class Multiply implements Expression {
	
	private Expression left;
	private Expression right;
	
	public Multiply(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public BigDecimal eval() {
		
		BigDecimal leftValue = left.eval();
		BigDecimal rightValue = right.eval();
		
		return leftValue.multiply(rightValue);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitMultiply(this);
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
	
	
}
