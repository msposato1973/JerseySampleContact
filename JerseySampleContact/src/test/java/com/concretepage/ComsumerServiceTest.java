package com.concretepage;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.concretepage.crypt.BaseCrypting;

public class ComsumerServiceTest {

	private static final String BASE_URI = "http://localhost:8080/JerseySampleContact/resteasy/manage/saveform";
	private ConsumerFormBean formBean;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		 formBean = new ConsumerFormBean();
		 formBean.setId("123456");
		 formBean.setName("massimo");
		 formBean.setCompany("vodafone srl");
		 
	}
	
	@Test
	public final void testBaseCrypting() {
		
		String sDecId = "";
		String sDecName = "";
		String sDecCompany = "";
		
		try {
			if(formBean!=null) {
				sDecId = new String(BaseCrypting.executeEncoded(formBean.getId()));
				Assert.assertEquals("MTIzNDU2", sDecId);	
				sDecId = new String(BaseCrypting.executeDecoded("MTIzNDU2"));
				Assert.assertEquals("123456", sDecId);
				
				sDecName = new String(BaseCrypting.executeEncoded(formBean.getName()));
				Assert.assertEquals("bWFzc2ltbw==", sDecName);
				sDecName = new String(BaseCrypting.executeDecoded("bWFzc2ltbw=="));
				Assert.assertEquals("massimo", sDecName);
			
			    sDecCompany = new String(BaseCrypting.executeEncoded(formBean.getCompany()));
				Assert.assertEquals("dm9kYWZvbmUgc3Js", sDecCompany);
				sDecCompany = new String(BaseCrypting.executeDecoded("dm9kYWZvbmUgc3Js"));
				Assert.assertEquals("vodafone srl", sDecCompany);
				
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public final void testClientRestSaveformPost() throws  Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(BASE_URI);
        Form form = new Form();
        
        String sId = "";
        String sname = "";
        String scompany = "";
		try {
			if(formBean!=null) {
				sId = new String(BaseCrypting.executeEncoded(formBean.getId()));
				sname = new String(BaseCrypting.executeEncoded(formBean.getName()));
				scompany = new String(BaseCrypting.executeEncoded(formBean.getCompany()));
			}
			
	        form.param("id", sId).param("name", sname).param("company", scompany);
	        Entity<Form> entity = Entity.form(form);
	        Response response = target.request(MediaType.APPLICATION_FORM_URLENCODED).post(entity);
	        String value = response.readEntity(String.class);
	        System.out.println(value);
	        response.close();  
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public final void testClientRestSaveformGet() throws  Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(BASE_URI);
        Form form = new Form();
        
        String sId = "";
        String sname = "";
        String scompany = "";
		try {
			
			sId = new String(BaseCrypting.executeEncoded(formBean.getId()));
			sname = new String(BaseCrypting.executeEncoded(formBean.getName()));
			scompany = new String(BaseCrypting.executeEncoded(formBean.getCompany()));
	        
	        form.param("id", sId).param("name", sname).param("company", scompany);
	        Entity<Form> entity = Entity.form(form);
	        String response = target.request(MediaType.APPLICATION_FORM_URLENCODED).get(String.class);
	      
	        System.out.println(response);
	        System.out.printf("response without  param:%n%s%n", response); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
