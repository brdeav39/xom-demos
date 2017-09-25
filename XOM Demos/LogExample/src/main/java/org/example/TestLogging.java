package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("log")
public class TestLogging {

	private final Logger log = LoggerFactory.getLogger(TestLogging.class);

	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		
		log.warn("Repeating the message: {}", msg);
		
		String output = "Logging the message : " + msg;

		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/square/{value}")
	public Response getSquare(@PathParam("value") Integer value ) {
		if ( value == null ) value = 48;
		
		double returnValue = Math.pow(value, 2);
		
		return Response.status(200).entity("Square of " + value + " is : " + returnValue).build();
	}
}