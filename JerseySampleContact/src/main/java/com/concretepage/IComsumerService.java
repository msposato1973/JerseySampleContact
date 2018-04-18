package com.concretepage;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

public interface IComsumerService {

	@POST
	@Path("/add")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public  Response addUser(@FormParam("name") String name,	@FormParam("id") String id, @FormParam("company") String company, @Context HttpServletResponse servletResponse) throws Exception;
	
	
	@GET
    @Consumes( MediaType.APPLICATION_JSON)
    @Formatted
    public Response getOrders(@Context UriInfo info) throws Exception;
	
	
	
	   
    @POST
    @Path("/saveform")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON})
    @Formatted
    public Response saveformPost(@Form ConsumerFormBean form) throws Exception;

    
    @GET
    @Path("/saveform")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON})
    @Formatted
    public Response saveformGet(@Form ConsumerFormBean form) throws Exception ;


}
	
