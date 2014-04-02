package de.fhws.apiprog.vorlesung2.restdemo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/ping")
public class Ping {

	@GET
	public String ping( @QueryParam("text")String text) {
		if( text == null || text.isEmpty() )
		{
			return "OK";
		}
		else
		{
			return text.toUpperCase();
		}
	}
	
	@POST
	public Response post( String text )
	{
		return Response.ok(text.toLowerCase()).build();
	}

}