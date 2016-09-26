package com.msakaguchi.calc.converter;

import java.math.BigDecimal;

public class NumberConverter {

	@SuppressWarnings("unchecked")
	public static <T extends Number> T from(Class<? extends Number> clazz, T object) {
		
		String clazzName = clazz.getSimpleName();
		
		if(clazzName.equals("Integer")) {
			return (T) Integer.valueOf(object.toString());
		}
		
		if(clazzName.equals("Double")) {
			return (T) Double.valueOf(object.toString());
		}
		
		if(clazzName.equals("Float")) {
			return (T) Float.valueOf(object.toString());
		}
		
		if(clazzName.equals("Long")) {
			return (T) Long.valueOf(object.toString());
		}
		
		if(clazzName.equals("BigDecimal")){
			if(object instanceof BigDecimal) {
				return object;
			}
			else{
				return (T) new BigDecimal(object.toString());
			}
		} 
		
		
		return object;
		
	}
	
	}
