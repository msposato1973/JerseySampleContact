package com.concretepage.client;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.concretepage.crypt.BaseCrypting;

/***
 * 
 * @author m.sposato
 *
 */
public class RESTEasyClient {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/JerseySampleContact/resteasy/manage/add");
        Form form = new Form();
        
        String sId = new String(BaseCrypting.executeEncoded("123456"));
		String sname = new String(BaseCrypting.executeEncoded("massimo"));
		String scompany = new String(BaseCrypting.executeEncoded("vodafone srl"));
        
        form.param("id", sId).param("name", sname).param("company", scompany);
        Entity<Form> entity = Entity.form(form);
        Response response = target.request(MediaType.TEXT_HTML).post(entity);
        String value = response.readEntity(String.class);
        System.out.println(value);
        response.close();  

        
	}
	

}
