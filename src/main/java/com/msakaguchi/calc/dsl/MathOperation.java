package com.msakaguchi.calc.dsl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.msakaguchi.calc.converter.NumberConverter;
import com.msakaguchi.calc.core.Digit;
import com.msakaguchi.calc.core.Divide;
import com.msakaguchi.calc.core.Expression;
import com.msakaguchi.calc.core.Multiply;
import com.msakaguchi.calc.core.Power;
import com.msakaguchi.calc.core.Subtract;
import com.msakaguchi.calc.core.Sum;
import com.msakaguchi.calc.visitor.Print;



public class MathOperation implements Operation {

	private Print print;
	private Expression expression;
	private int scale;
	private boolean visitor;
	
	public static Operation Math() {
		return new MathOperation();
	}
	
	public MathOperation() {
		expression = new Digit(BigDecimal.ZERO);
		print = new Print();
	}

	@Override
	public <L, R> Operation add(L leftValue, R rightValue) {
		expression = new Sum(expression, new Sum(new Digit(leftValue), new Digit(rightValue)));
		return this;
	}

	@Override
	public <R> Operation add(R rightValue) {
		expression = new Sum(expression, new Digit(rightValue));
		return this;
	}

	@Override
	public Operation add(Expression leftExpression, Expression rightExpression) {
		expression = new Sum(expression, new Sum(leftExpression, rightExpression));
		return this;
	}

	@Override
	public <L, R> Operation subtract(L leftValue, R rightValue) {
		expression = new Sum(expression, new Subtract(new Digit(leftValue), new Digit(rightValue)));
		return this;
	}

	@Override
	public <R> Operation subtract(R rightValue) {
		expression = new Subtract(expression, new Digit(rightValue));
		return this;
	}

	@Override
	public Operation subtract(Expression leftExpression, Expression rightExpression) {
		expression = new Sum(expression, new Subtract(leftExpression, rightExpression));
		return this;
	}

	@Override
	public <L, R> Operation multiply(L leftValue, R rightValue) {
		expression = new Sum(expression, new Multiply(new Digit(leftValue), new Digit(rightValue)));
		return this;
	}

	@Override
	public <R> Operation multiply(R rightValue) {
		expression = new Multiply(expression, new Digit(rightValue));
		return this;
	}

	@Override
	public Operation multiply(Expression leftExpression, Expression rightExpression) {
		expression = new Sum(expression, new Multiply(leftExpression, rightExpression));
		return this;
	}

	@Override
	public <L, R> Operation divide(L leftValue, R rightValue) {
		expression = new Sum(expression, new Divide(new Digit(leftValue), new Digit(rightValue)));
		return this;
	}

	@Override
	public <R> Operation divide(R rightValue) {
		expression = new Divide(expression, new Digit(rightValue));
		return this;
	}

	@Override
	public Operation divide(Expression leftExpression, Expression rightExpression) {
		expression = new Sum(expression, new Divide(leftExpression, rightExpression));
		return this;
	}

	@Override
	public <L, R> Operation pow(L leftValue, R rightValue) {
		expression = new Sum(expression, new Power(new Digit(leftValue), new Digit(rightValue)));
		return this;
	}

	@Override
	public <R> Operation pow(R rightValue) {
		expression = new Power(expression, new Digit(rightValue));
		return this;
	}
	
	@Override
	public Operation pow(Expression leftExpression, Expression rightExpression) {
		expression = new Sum(expression, new Power(leftExpression, rightExpression));
		return this;
	}

	@Override
	public <L, R> BigDecimal newAdd(L leftValue, R rightValue) {
		
		Expression sum = new Sum(new Digit(leftValue), new Digit(rightValue)); 
		//sum.accept(print);
		return sum.eval();
		
	}

	@Override
	public <L, R> BigDecimal newSubtract(L leftValue, R rightValue) {
		 
		 Expression subtract =  new Subtract(new Digit(leftValue), new Digit(rightValue));
		 
		 //subtract.accept(print);
		 
		 return subtract.eval();
	}

	@Override
	public <L, R> BigDecimal newMultiply(L leftValue, R rightValue) {
		Expression multiply =  new Multiply(new Digit(leftValue), new Digit(rightValue));
		//multiply.accept(print);
		return multiply.eval();
	}

	@Override
	public <L, R> BigDecimal newDivide(L leftValue, R rightValue) {
		Expression divide = new Divide(new Digit(leftValue), new Digit(rightValue));
		//divide.accept(print);
		return divide.eval();
	}

	@Override
	public <L, R> BigDecimal newPow(L leftValue, R rightValue) {
		Expression power = new Power(new Digit(leftValue), new Digit(rightValue));
		//power.accept(print);
		return power.eval();
	}
	
	@Override
	public BigDecimal gimme() {
		return result().withScale();
	}

	private MathOperation result() {

		if(visitor) {
			expression.accept(print);
		}
		
		return this;
	}
	
	private BigDecimal withScale() {
		if(scale > 0) {
			return expression.eval().setScale(scale, RoundingMode.HALF_UP);
		}
		return expression.eval();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Number> T gimme(Class<? extends Number> clazz) {
		return (T)  NumberConverter.from(clazz, result().withScale());
	}

	@Override
	public Operation withScale(int scale) {
		this.scale = scale;
		return this;
	}

	@Override
	public Operation withVisitor() {
		visitor = true;
		return this;
	}
	
}
