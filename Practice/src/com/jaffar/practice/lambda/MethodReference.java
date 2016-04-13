package com.jaffar.practice.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MethodReference {

	public static void main(String[] args) {
        
        List<String> names = new ArrayList<String>();
            names.add("David");
            names.add("Richard");
            names.add("Samuel");
            names.add("Rose");
            names.add("John");
 
 
            
 
            Map<String, Integer> items = new HashMap<String, Integer>();
        	items.put("A", 10);
        	items.put("B", 20);
        	items.put("C", 30);
        	items.put("D", 40);
        	items.put("E", 50);
        	items.put("F", 60);
        	
        	MethodReference.printList(names, MethodReference::printEntry);
        	MethodReference.printMapBiConsumer(items, MethodReference::printEntry);
        	MethodReference.printMapTriConsumer(items, MethodReference::printEntry);
    }
	
	private static void printList(List<String> names, Consumer<String> c ){
		names.forEach(x->c.accept(x));
    }
	
	private static void printMapBiConsumer(Map<String, Integer> items, BiConsumer<String, Integer> c){
		
		items.forEach((k,v)->c.accept(k, v));
    }
	
	private static void printMapTriConsumer(Map<String, Integer> items, TriConsumer<String, Integer, String> c){
		
		items.forEach((k,v)->c.accept(k, v, "Hello World"));
    }
	
	private static void printEntry(String value){
		System.out.println("value="+value);
    }
	
	private static void printEntry(String key, Integer value){
		System.out.println("Key="+key+" :: value="+value);
    }
	
	private static void printEntry(String key, Integer value, String message){
		System.out.println("Key="+key+" :: value="+value+" :: message="+message);
    }
	
}

@FunctionalInterface
interface TriConsumer<T, U, V> {
     
    void accept(T t, U u, V v);
}
