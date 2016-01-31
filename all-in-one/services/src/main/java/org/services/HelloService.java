package org.services;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.softified.core.Response;

@WebService
public interface HelloService {

	public Response hello(@WebParam(name="name") String name);
	
}
