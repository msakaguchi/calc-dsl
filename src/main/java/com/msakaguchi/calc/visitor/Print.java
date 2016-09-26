package com.msakaguchi.calc.visitor;

import com.msakaguchi.calc.core.Digit;
import com.msakaguchi.calc.core.Divide;
import com.msakaguchi.calc.core.Multiply;
import com.msakaguchi.calc.core.Power;
import com.msakaguchi.calc.core.Subtract;
import com.msakaguchi.calc.core.Sum;

public class Print implements Visitor {

	@Override
	public void visitDigit(Digit digit) {
		System.out.print(digit.eval());
	}

	@Override
	public void visitSum(Sum sum) {
		
		System.out.print("(");
		
		sum.getLeft().accept(this);
		
		System.out.print(" + ");
		
		sum.getRight().accept(this);
		
		System.out.print(")");

	}

	@Override
	public void visitSubtract(Subtract subtract) {
		System.out.print("(");
		
		subtract.getLeft().accept(this);
		
		System.out.print(" - ");
		
		subtract.getRight().accept(this);
		
		System.out.print(")");

	}

	@Override
	public void visitMultiply(Multiply multiply) {
		
		System.out.print("(");
		
		multiply.getLeft().accept(this);
		
		System.out.print(" * ");
		
		multiply.getRight().accept(this);
		
		System.out.print(")");

	}

	@Override
	public void visitDivide(Divide divide) {
		
		System.out.print("(");
		
		divide.getLeft().accept(this);
		
		System.out.print(" / ");
		
		divide.getRight().accept(this);
		
		System.out.print(")");

	}

	@Override
	public void visitPower(Power power) {
		
		System.out.print("(");
		
		power.getLeft().accept(this);
		
		System.out.print(" ˆ ");
		
		power.getRight().accept(this);
		
		System.out.print(")");
		

	}

}
