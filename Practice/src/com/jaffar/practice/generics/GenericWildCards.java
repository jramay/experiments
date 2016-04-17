package com.jaffar.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWildCards {

	public static void main(String[] args) {
		
		List<? extends ChildA> lowerBoundList = new ArrayList<ChildA>();
		//lowerBoundList.add();
		
		Parent element1 = lowerBoundList.get(1);
		element1.printP();
		ChildA element2 = lowerBoundList.get(1);
		element2.printP();
		element2.printA();

		
		List<? super ChildA> upperBoundList = new ArrayList<ChildA>();
		//upperBoundList.add(new Parent());
		upperBoundList.add(new ChildA());
		upperBoundList.add(new GrandChildA());
		
		//upperBoundList.add(new Parent());
		Object object = upperBoundList.get(1);
		

	}

}
