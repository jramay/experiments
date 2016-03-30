package com.jaffar.practice.oops;

public class MainDriver {

	public void printInt(Integer i){
		System.out.println("integer i = "+i);
	}
	
	
	
	public void printInt(int i){
		System.out.println("int i = "+i);
	}
	
	public void printInt(int i, int b){
		System.out.println("int i b= "+i);
	}
	
	public void printInt(int... i){
		System.out.print("int... i = ");
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j]+",");	
		}
	}
	
	
	public static void main(String[] args) {
		Parent oopsObject = new Child();
		Parent.testStatic();
		System.out.println("Static Int "+oopsObject.staticInt);
		System.out.println("Instance Int "+oopsObject.instanceInt);
		
		MainDriver driver = new MainDriver();
		driver.printInt(1);
		driver.printInt(1,2);

	}

}
