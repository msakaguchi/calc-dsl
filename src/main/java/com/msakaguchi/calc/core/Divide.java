package com.msakaguchi.calc.core;

import java.math.BigDecimal;
import java.math.MathContext;

import com.msakaguchi.calc.visitor.Visitor;

public class Divide implements Expression {

	private Expression left;
	private Expression right;
	
	public Divide(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public BigDecimal eval() {
		
		BigDecimal leftValue = left.eval();
		BigDecimal rightValue = right.eval();
		
		if(dividendIsNotNegative(leftValue) || dividerIsLessOrEqualThanZero(rightValue)) {
			throw new ArithmeticException("erro na divisao. Verifique se os parametros da expessao sao validos.");
		}
		
		return leftValue.divide(rightValue, MathContext.DECIMAL64);
	}

	private boolean dividendIsNotNegative(BigDecimal leftValue) {
		return leftValue.compareTo(BigDecimal.ZERO)== -1;
	}

	private boolean dividerIsLessOrEqualThanZero(BigDecimal rightValue) {
		return rightValue.compareTo(BigDecimal.ZERO) == 0  || rightValue.compareTo(BigDecimal.ZERO) == -1;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitDivide(this);
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
	
	


}
