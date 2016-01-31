package org.services;

import com.softified.core.Response;

public class HelloServiceImpl implements HelloService{

	public Response hello(String name) {
		Response response = new Response();
		response.setMessage("Hello "+name);
		return response;
	}

}
