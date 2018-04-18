package com.concretepage.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BuindServletTest {
	
	 
	 @Mock
	 HttpServletRequest request;
	 
	 @Mock
	  HttpServletResponse response;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public final void test() throws IOException, ServletException {
		
		when(request.getParameter("id")).thenReturn("123456");
		when(request.getParameter("name")).thenReturn("massimo");
		when(request.getParameter("company")).thenReturn("vodafone srl");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(response.getWriter()).thenReturn(pw);

		
		BuindServlet buindServlet =new BuindServlet();
		buindServlet.doGet(request, response);

		
		String result = sw.getBuffer().toString().trim();
        //assertEquals("text/html", response.getContentType());
       
	}

}
