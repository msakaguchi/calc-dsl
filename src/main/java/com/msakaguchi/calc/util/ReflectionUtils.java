package com.msakaguchi.calc.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionUtils {
	
	public static <T> Constructor<?> findConstructor(Class<?> clazz, T object) {

		for (Constructor<?> constr : clazz.getConstructors()) {
			Class<?>[] params = constr.getParameterTypes();
			
			if(params.length == 1) {
				if (params[0].isInstance(object)) {
					return constr;
				}
			}
		}
		
		throw new RuntimeException("constructor not found");
	}
	
	public static <T> Object getObjectInstance(Class<?> clazz, T object) {
		Constructor<?> constructor = findConstructor(clazz, object);
		try {
			return  constructor.newInstance(object);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
}
