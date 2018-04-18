package com.concretepage.crypt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseCryptingTest {

	public String sId ;
	public String sname ;
	public String scompany ;
	
	@Before
	public void setUp() throws Exception {
		sId = "123456" ;
		sname = "massimo";
		scompany ="vodafone srl";
	}

	@Test
	public final void testExecuteEncoded() {
		String	sCompanyEncoded = "dm9kYWZvbmUgc3Js";
		try {
			assertEquals(sCompanyEncoded, BaseCrypting.executeEncoded(scompany));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void testExecuteDecoded() {
		String	sCompanyEncoded = "dm9kYWZvbmUgc3Js";
		try {
			assertEquals(scompany, BaseCrypting.executeDecoded(sCompanyEncoded));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public final void testExecuteEncodeToString() {
		 
		try {
			System.out.print(BaseCrypting.executeEncodeToString(scompany));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public final void testExecuteDecodedToString() {
		String	sCompanyEncoded = "dm9kYWZvbmUgc3Js";
		try {
			System.out.print(BaseCrypting.executeDecodedToString(sCompanyEncoded));
			System.out.print(scompany);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
