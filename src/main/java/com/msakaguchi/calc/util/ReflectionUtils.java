package com.msakaguchi.calc.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionUtils {

	public static Constructor<?> findConstructor(Class<?> clazz, Object... objects) {

		for (Constructor<?> constr : clazz.getConstructors()) {
			Class<?>[] params = constr.getParameterTypes();

			if (params.length == 1) {
				if (params.length == objects.length) {
					boolean erro = false;
					for (int i = 0; i < objects.length; i++) {
						if (!params[i].isInstance(objects[i])) {
							erro = true;
						}
					}
					if (!erro) {
						return constr;
					}

				}
			}
		}

		throw new RuntimeException("constructor not found");
	}

	public static Object newObjectInstance(Class<?> clazz, Object... objects) {
		Constructor<?> constructor = findConstructor(clazz, objects);
		try {
			return constructor.newInstance(objects);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("wrong number of parameters to the constructor");
		}

	}
}
