package com.jaffar.aop.aspects;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;


@Aspect
public class MultiAspect{

	
	@Before("execution(* com.jaffar.aop.beans.GenericList.getStringList())")
    public void getBeforeAdvice(){
        System.out.println("BEFORE - Executing Advice on getStringList()");
    }
	
	@After("execution(* com.jaffar.aop.beans.GenericList.getStringList())")
    public void getAfterAdvice(){
        System.out.println("AFTER - Executing Advice on getStringList()");
    }
	
	@Around("execution(* com.jaffar.aop.beans.GenericList.getStringList())")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("AROUND - Before invoking method");
        Object value = null;
        
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        try {
			Type returnType = method.getGenericReturnType();

			if(returnType instanceof ParameterizedType){
			    ParameterizedType type = (ParameterizedType) returnType;
			    Type[] typeArguments = type.getActualTypeArguments();
			    for(Type typeArgument : typeArguments){
			    	
			    	Class typeArgClass=null;
			    	
			    	if(typeArgument instanceof Class){
			    		
			    		typeArgClass = (Class) typeArgument;
			    		System.out.println("Type Arg Class = " + typeArgClass);
			    		
			    	}else if(typeArgument instanceof WildcardType){
			    		
			    		WildcardType wildcardType = (WildcardType)typeArgument;
			    		
			    		System.out.println("Wild Card Type = " + wildcardType.getTypeName());
			    		
			    		Type[] upperBounds = wildcardType.getUpperBounds();
			    		for (int i = 0; i < upperBounds.length; i++) {
			    			typeArgClass = (Class)upperBounds[i];
			    			System.out.println("Type Arg Class (upper bound) = " + typeArgClass);
						}
			    		Type[] lowerBounds = wildcardType.getLowerBounds();
			    		for (int i = 0; i < lowerBounds.length; i++) {
			    			typeArgClass = (Class)lowerBounds[i];
			    			System.out.println("Type Arg Class (upper bound) = " + typeArgClass);
						}
			    		
			    	}
			    	
			        
			    }
			    
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}
        
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AROUND - After invoking method. Return value="+value);
        return value;
    }
	
}