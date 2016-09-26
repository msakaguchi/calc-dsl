package com.msakaguchi.calc.visitor;

import com.msakaguchi.calc.core.Digit;
import com.msakaguchi.calc.core.Divide;
import com.msakaguchi.calc.core.Multiply;
import com.msakaguchi.calc.core.Power;
import com.msakaguchi.calc.core.Subtract;
import com.msakaguchi.calc.core.Sum;

public interface Visitor {
	
	void visitDigit(Digit digit);
	
	void visitSum(Sum sum);
	
	void visitSubtract(Subtract subtract);
	
	void visitMultiply(Multiply multiply);
	
	void visitDivide(Divide divide);
	
	void visitPower(Power power);
	
}
