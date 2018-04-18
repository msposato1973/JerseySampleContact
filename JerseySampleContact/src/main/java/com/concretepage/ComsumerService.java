package com.concretepage;

 
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.util.Base64;
import org.json.JSONObject;

import com.concretepage.crypt.BaseCrypting;
import com.concretepage.exception.ConcreteApplicationException;

@Path("/manage" )
public class ComsumerService implements IComsumerService{
	
	private Map<String, Object> data = new HashMap<String, Object>();
	private Map<String,String> map = new HashMap<String,String>();
	 
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
		
    
    
    private boolean checkId(String id) throws Exception{
    	boolean validate=false;
    	
    	try {
    		String sId = "";
			if(id == null) {
				throw new ConcreteApplicationException("id is not present in request !!");
			}else {
				sId = new String(BaseCrypting.executeDecoded(id));
			 	Integer.parseInt(sId);
				validate  = true;
			}
			
		} catch(NumberFormatException e) {
			throw new ConcreteApplicationException("id is not a number !!");
		}
		
		 
		return validate;
    }
    
    private boolean checkName(String name) throws Exception{
    	boolean validate=false;
    	
    	try {
    		String sname = "";
			if(name == null) {
				throw new ConcreteApplicationException("name is not present in request !!");
			}else {
				sname = new String(BaseCrypting.executeDecoded(name));
			 	validate  = true;
			}
			
		} catch(NumberFormatException e) {
			throw new ConcreteApplicationException("name is not a number !!");
		}
		
		 
		return validate;
    }
    
    private boolean checkCompany(String company) throws Exception{
    	boolean validate=false;
    	
    	try {
    		String scompany = "";
			if(company == null) {
				throw new ConcreteApplicationException("company is not present in request !!");
			}else {
				scompany = new String(BaseCrypting.executeDecoded(company));
			 	validate  = true;
			}
			
		} catch(NumberFormatException e) {
			throw new ConcreteApplicationException("company is not a number !!");
		}
		
		 
		return validate;
    }
    
    
   
    public Response addUser(@FormParam("name") String name,	@FormParam("id") String id, @FormParam("company") String company, @Context HttpServletResponse servletResponse) throws Exception {
    	
    	String usernameAndPassword = new String(Base64.decode(name));
    	
    	System.out.println("usernameAndPassword :"+ usernameAndPassword);
    	
    	String sDencryptId = BaseCrypting.executeDecoded(id);
    	String sDencryptName = BaseCrypting.executeDecoded(name);
    	String sDencryptCompany = BaseCrypting.executeDecoded(company); 
    	
    	System.out.println("id:"+ sDencryptId);
    	System.out.println("name:"+ sDencryptName);
    	System.out.println("company:"+ sDencryptCompany);
		return Response.status(200).entity("id : " + sDencryptId + ", name : " + sDencryptName + ", company : " + sDencryptCompany) .build();
        
	}

    
   
    
    
    public Response getOrders(@Context UriInfo info) throws Exception{
    	BaseCrypting bc = new BaseCrypting();
        String sId = info.getQueryParameters().getFirst("id");
        String sName = info.getQueryParameters().getFirst("name");
        String sCompany = info.getQueryParameters().getFirst("company");
        for (String name : info.getQueryParameters().keySet()){
            System.out.println("query param name: " + name + " value: " + info.getQueryParameters().getFirst(name));
        }

        return Response.ok().entity("orders with Id: " + sId + ", name: " + sName + ", company: " + sCompany).build();
       
    }
    
    
    
    
    
  
    public Response saveformPost(@Form ConsumerFormBean form) throws Exception {
    	
    	if(form!=null) {
    		
	    	String sDencryptId = (null!=form.getId()) ? BaseCrypting.executeDecoded(form.getId()) : "";
	    	String sDencryptName = (null!=form.getName()) ?BaseCrypting.executeDecoded(form.getName()): "";
	    	String sDencryptCompany =  (null!=form.getCompany()) ? BaseCrypting.executeDecoded(form.getCompany()): ""; 
			    	
	    	map.put("id", sDencryptId);
	    	map.put("name", sDencryptName);
	    	map.put("company", sDencryptCompany);
    	}
    	
    	JSONObject json = new JSONObject(map);
        return Response.ok(json.toString()).build();
    }
    
    
    
    public Response saveformGet(@Form ConsumerFormBean form) throws Exception {
    	
    	if(form!=null) {
    	
	    	String sDencryptId = (null!=form.getId()) ? BaseCrypting.executeDecoded(form.getId()) : "";
	    	String sDencryptName = (null!=form.getName()) ?BaseCrypting.executeDecoded(form.getName()): "";
	    	String sDencryptCompany =  (null!=form.getCompany()) ? BaseCrypting.executeDecoded(form.getCompany()): ""; 
			
	    	map.put("id", sDencryptId);
	    	map.put("name", sDencryptName);
	    	map.put("company", sDencryptCompany);
    	}
    	JSONObject json = new JSONObject(map);
        return Response.ok(json.toString()).build();
    }
    


         
}