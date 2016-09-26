package com.msakaguchi.calc.core;

import java.math.BigDecimal;

import com.msakaguchi.calc.visitor.Visitor;

public interface Expression {
	
	public BigDecimal eval();
	
	public void accept(Visitor visitor);
	
	
}
