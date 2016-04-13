package com.jaffar.practice.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDriver {

	public static void main(String[] args) {
		Method method;
		try {
			method = GenericDummyList.class.getMethod("getStringList", null);
			Type returnType = method.getGenericReturnType();

			if(returnType instanceof ParameterizedType){
			    ParameterizedType type = (ParameterizedType) returnType;
			    Type[] typeArguments = type.getActualTypeArguments();
			    for(Type typeArgument : typeArguments){
			        Class typeArgClass = (Class) typeArgument;
			        System.out.println("typeArgClass = " + typeArgClass);
			    }
			    
			}
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		
	}
}
