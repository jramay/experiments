package com.jaffar.practice.lambda;

public class RunnableLambda {

	public static void main(String[] args) {
		
		LambdaIntf lamda = (input) -> {System.out.println("Hi "+input);};
		lamda.LamdaTest("Jaffar");
		
		
	}
}

interface LambdaIntf{
	
	public void LamdaTest(String input);
}
