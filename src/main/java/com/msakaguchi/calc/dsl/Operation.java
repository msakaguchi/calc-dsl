package com.msakaguchi.calc.dsl;

import java.math.BigDecimal;

import com.msakaguchi.calc.core.Expression;

public interface Operation {
	
	public <L,R> Operation add(L leftValue, R rightValue);
	
	public <L,R> BigDecimal newAdd(L leftValue, R rightValue);
	
	public <R> Operation add(R rightValue);
	
	public Operation add(Expression leftExpression, Expression rightExpression);
	
	public <L,R> Operation subtract(L leftValue, R rightValue);
	
	public <L,R> BigDecimal newSubtract(L leftValue, R rightValue);
	
	public <R> Operation subtract(R rightValue);
	
	public Operation subtract(Expression leftExpression, Expression rightExpression);
	
	public <L,R> BigDecimal newMultiply(L leftValue, R rightValue);
	
	public <L,R> Operation multiply(L leftValue, R rightValue);
	
	public <R> Operation multiply(R rightValue);
	
	public Operation multiply(Expression leftExpression, Expression rightExpression);
	
	public <L,R> BigDecimal newDivide(L leftValue, R rightValue);
	
	public <L,R> Operation divide(L leftValue, R rightValue);
	
	public <R> Operation divide(R rightValue);
	
	public Operation divide(Expression leftExpression, Expression rightValue);
	
	public <L,R> BigDecimal newPow(L leftValue, R rightValue);
	
	public <L,R> Operation pow(L leftValue, R rightValue);
	
	public Operation pow(Expression leftExpression, Expression rightExpression);
	
	public <R> Operation pow(R rightValue);
	
	public BigDecimal gimme();
	
	public Operation withScale(int scale);
	
	public Operation withVisitor();
	
	public <T extends Number> T gimme(Class<? extends Number> clazz);
	
}
