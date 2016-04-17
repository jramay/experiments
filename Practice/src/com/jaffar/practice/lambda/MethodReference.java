package com.jaffar.practice.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

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
        	
        	MethodReference.printNames(names);
        	MethodReference.printList(names, MethodReference::printEntry);
        	MethodReference.printMapBiConsumer(items, MethodReference::printEntry);
        	
        	
        	//MethodReference.printMapTriConsumer(items, MethodReference::printEntry);
        	//OR
        	TriConsumer<String,Integer,String> triConsumer = MethodReference::printEntry;
        	MethodReference.printMapTriConsumer(items, triConsumer);
        	
    }
	
	private static void printList(List<String> names, Consumer<String> c ){
		
		names.forEach(c);
		names.forEach(x->c.accept(x));
    }
	
	private static void printNames(List<String> names) {
		names.stream()
                .filter(t->t.equalsIgnoreCase("David"))
                .map(n -> n+" Final")
                .forEach(name -> System.out.println("Name = "+name));
    }
	
	private static void printMapBiConsumer(Map<String, Integer> items, BiConsumer<String, Integer> c){
		
		items.forEach((k,v)->c.accept(k, v));
    }
	
	private static void printMapTriConsumer(Map<String, Integer> items, TriConsumer<String, Integer, String> c){
		System.out.println("Starts = printMapTriConsumer");
		items.forEach((k,v)->{
				c.accept(k, v, "Hello World");
				c.printName(k);
				}
		);
    }
	
	private static void printEntry(String value){
		System.out.println("list value="+value);
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
     
    public void accept(T t, U u, V v);
    
    default void printName(String name){
    	System.out.println("Hello World "+name);
    }
    
}
