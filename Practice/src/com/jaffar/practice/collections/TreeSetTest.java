package com.jaffar.practice.collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Set<TreeSetEntry> treeSet = new TreeSet<TreeSetEntry>();
		
		TreeSetEntry firstRecord = new TreeSetEntry(1);
		TreeSetEntry secondRecord = new TreeSetEntry(2);
		TreeSetEntry thirdRecord = new TreeSetEntry(3);
		
		treeSet.add(firstRecord);
		treeSet.add(secondRecord);
		treeSet.add(thirdRecord);
		
		System.out.println("Treeset size = "+treeSet.size());
		
		
	}
}
