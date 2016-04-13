package org.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.softified.core.Response;

@Path("/")
public class HelloServiceRest implements HelloService {

	@Autowired
	HelloServiceImpl service;
	
	@GET
	@Path("/hello")
	@Produces({"application/xml","application/json"})
	public Response hello(@QueryParam("name") String name) {
		return service.hello(name);
	}

}
