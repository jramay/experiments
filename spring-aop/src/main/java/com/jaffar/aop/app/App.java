package com.jaffar.aop.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;


import com.jaffar.aop.beans.GenericList;

public class App {
	public static void main(String[] args) {
		
				ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("context.xml");
				

		GenericList genericList = (GenericList) appContext.getBean("genericList");

		System.out.println("*************************");
		List<?> list = genericList.getStringList();
		System.out.println("*************************");
		

	}
}