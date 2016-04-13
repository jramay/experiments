package com.jaffar.aop.beans;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

		  protected List<?> stringList = new ArrayList<String>();

		  public List<?> getStringList(){
		    return this.stringList;
		  }
	
}
