package com.jaffar.practice.collections;

public class TreeSetEntry implements Comparable<TreeSetEntry>{

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

}
