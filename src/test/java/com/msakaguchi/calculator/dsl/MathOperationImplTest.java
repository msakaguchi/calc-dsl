package com.msakaguchi.calculator.dsl;

import static com.msakaguchi.calc.dsl.MathOperation.Math;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathOperationImplTest {

	
	public void avaliarExpressao() {
		assertEquals(new Integer(125), new Integer(Math().add(2, 3).multiply(100).divide(4).gimme().toString()));
	}
	
	@Test
	public void avaliaExpressaoCombinada() {

		// ((3+4)+(213))

		System.out.println("\nres: "+Math().add(Math().newAdd(3, 4),Math().newSubtract(2, 1)).withScale(2).gimme(Double.class));

		

	}

	
	public void avaliaExpressaoCombinadaComPotenciacao() {

		// ((2.2700000000/30) * 30) / 100
		// resultado: 0.022768970190
		//TODO showExpression usar pattern visitor or observer

		Double resultado = Math().multiply(
								Math().newDivide(0.0435284056f, "30"), 
								30.0)
						   		  .divide("100")
						   		  .withScale(12)
						   		  .gimme(Double.class);
		

		assertEquals(0.000435284056, resultado, 0.001);
	}


}
