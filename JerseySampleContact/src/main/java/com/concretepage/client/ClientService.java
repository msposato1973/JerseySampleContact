package com.concretepage.client;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIDereferencer;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.proxy.processors.invocation.URIParamProcessor;
import org.jboss.resteasy.spi.touri.URIResolver;
import org.jboss.resteasy.spi.touri.URIableURIResolver;

import com.concretepage.crypt.BaseCrypting;
public class ClientService {

	public ClientService() {}
	
	
	public  String callOutServiceRest(String id,String name, String company) {
		
		String value = "";
		Response clientResponse = null;
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(getUrlService());
			
			String sId = new String(BaseCrypting.executeEncoded(id));
			String sname = new String(BaseCrypting.executeEncoded(name));
			String scompany = new String(BaseCrypting.executeEncoded(company));
			
			Form form = new Form();
			form.param("id", sId).param("name", sname).param("company", scompany);
			Entity<Form> entity = Entity.form(form);
			clientResponse = target.request(MediaType.APPLICATION_JSON).post(entity);
			value = clientResponse.readEntity(String.class);
			System.out.println("ClientService response : "+ value);
			clientResponse.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clientResponse.close();
		} 
		
	  
        
        return value;
	}
	
	

	
	
	
	public  URI getUrlService() throws Exception {
		URI sUri = new URI("http://localhost:8080/JerseySampleContact/resteasy/manage/saveform");
		return sUri;
	}
	 
}
