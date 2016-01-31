package org.services;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.softified.core.Response;

@WebService(endpointInterface="org.services.HelloService")
public class HelloServiceSOAP implements HelloService {

	@Autowired
	HelloServiceImpl service;
	
	public Response hello(String name) {
		return service.hello(name);
	}

}
