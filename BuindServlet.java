package com.concretepage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.concretepage.ConsumerFormBean;
import com.concretepage.client.ClientService;
import com.concretepage.crypt.BaseCrypting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BuindServlet extends HttpServlet {
 
     

	/**
	 * 
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ClientService restClient = null;
    	String sId  = request.getParameter("id");
    	String sName  =request.getParameter("name");
    	String sCompany = request.getParameter("company");
		StringBuilder outputContent = new StringBuilder();
				
    	try {
    		
    		 restClient= new ClientService() ;
    		 String jsonString = restClient.callOutServiceRest(sId,sName,sCompany);
    		 ConsumerFormBean bean = toEntity(jsonString);
    		 
	   		  outputContent.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">");
	   		  outputContent.append("<title>Insert title here</title></head><body>");
	   		  outputContent.append("<form action=\"test\" method=\"GET\">");
	   		  outputContent.append("<fieldset id=\"decriptF\"><legend>Decripte param : </legend>");
	   		  outputContent.append("<p><label>ID : </label><input name=\"Id\" type=\"text\" value ='"+bean.getId()+"' readonly /></p>");
	   		  outputContent.append("<p><label>Name : </label><input name=\"name\" type=\"text\" value ='"+bean.getName()+"' readonly /></p>");
	   		  outputContent.append("<p><label>Compamy : </label><input name=\"company\" type=\"text\"  value='"+bean.getCompany()+"' readonly /></p>");
	   		  outputContent.append("</form>");  
	   		  outputContent.append("</fieldset>");
	   		  outputContent.append("<p></p>");
	   		 
	   		  String encId = new String(BaseCrypting.executeEncoded(bean.getId()));
	   		  String encsName = new String(BaseCrypting.executeEncoded(bean.getName()));
	   		  String encsCompany = new String(BaseCrypting.executeEncoded(bean.getCompany()));
	   		  
	   		  outputContent.append("<fieldset id=\"encriptF\"> <legend>Encripted param : </legend>");
	   		  outputContent.append("<p>Id     : " + encId + " </p>");
	   		  outputContent.append("<p>Name   : " + encsName + " </p>");
	   		  outputContent.append("<p>Company: " + encsCompany + " </p>");
	   		  outputContent.append("</fieldset>");
	   		  outputContent.append("</body></html>");     
	   		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
    	
    
    	response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(outputContent.toString());
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
       
        doGet(request, response);
    }
    
  //Covert json string to class object
    private static ConsumerFormBean toEntity(String jsonString) {
        try{
        	Gson gson = new GsonBuilder().create();
        	ConsumerFormBean formBean = gson.fromJson(jsonString, ConsumerFormBean.class); 
         	return formBean;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     

}
