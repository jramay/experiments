package com.jaffar.practice.collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Set<TreeSetEntry> treeSet = new TreeSet<TreeSetEntry>();
		Set<TreeSetEntry> hashSet = new HashSet<TreeSetEntry>();
		
		TreeSetEntry firstRecord = new TreeSetEntry(1);
		TreeSetEntry secondRecord = new TreeSetEntry(2);
		TreeSetEntry thirdRecord = new TreeSetEntry(3);
		
		treeSet.add(firstRecord);
		treeSet.add(secondRecord);
		treeSet.add(thirdRecord);
		
		hashSet.add(firstRecord);
		hashSet.add(secondRecord);
		hashSet.add(thirdRecord);
		
		System.out.println("Treeset size = "+treeSet.size());
		System.out.println("Hashset size = "+hashSet.size());
		
		
	}
}

class TreeSetEntry implements Comparable<TreeSetEntry>{

	public int id;
	public TreeSetEntry(int id){
		this.id = id;
	}
	@Override
	public int compareTo(TreeSetEntry o) {
		final int SMALL = -1;
	    final int EQUAL = 0;
	    final int BIGGER = 1;
	    
	    if(this.id<o.id){
	    	System.out.println(this.id+" SMALL THAN "+o.id);
	    	return SMALL;
	    }else if(this.id>o.id){
	    	System.out.println(this.id+" BIGGER THAN "+o.id);
	    	return BIGGER;
	    }else{
	    	System.out.println(this.id+" EQUAL THAN "+o.id);
	    	return EQUAL;
	    }
		
	}
	@Override
	public int hashCode() {
		return 1;
	}
	
	

}
