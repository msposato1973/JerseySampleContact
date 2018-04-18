package test.com.concretepage;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class TestComsumerService {

private static final String BASE_URI = "http://localhost:8080/JerseySampleContact/resteasy/manage/";
	

	public static void main(String[] args) throws Exception {

		// setting & invoking first request
		System.out.println("Executing POST request for @FormParameter");
		String url = "http://localhost:8080/RestEasy-FormParam/resteasy/customer/custinfo";
		String responseString = testFormParameterForPost("add");
		System.out.println("Response String for @FormParam : " + responseString);
	}
	
	/**
	 * using ClientRequest and ClientResponse classes from  org.jboss.resteasy.client
	 * @param url
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String testFormParameterForPost(String urlMethod) throws Exception {
		
		ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(BASE_URI.concat(urlMethod));
        Form form = new Form();
        
        String sId = new String(BaseCryptingTest.executeEncoded("122"));
		String sname = new String(BaseCryptingTest.executeEncoded("Atul"));
		String scompany = new String(BaseCryptingTest.executeEncoded("JP Morgan"));
        
        form.param("id", sId).param("name", sname).param("company", scompany);
        Entity<Form> entity = Entity.form(form);
        Response response = target.request(MediaType.TEXT_HTML).post(entity);
        String value = response.readEntity(String.class);
        System.out.println(value);
        response.close();
        
        
		return value;  
	}
	

}
