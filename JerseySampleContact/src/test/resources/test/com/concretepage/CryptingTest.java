package test.com.concretepage;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CryptingTest {

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
			assertEquals(sCompanyEncoded, BaseCryptingTest.executeEncoded(scompany));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void testExecuteDecoded() {
		String	sCompanyEncoded = "dm9kYWZvbmUgc3Js";
		try {
			assertEquals(scompany, BaseCryptingTest.executeDecoded(sCompanyEncoded));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void testExecuteEncodeToString() {
		 
		try {
			System.out.print(BaseCryptingTest.executeEncodeToString(scompany));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void testExecuteDecodedToString() {
		String	sCompanyEncoded = "dm9kYWZvbmUgc3Js";
		try {
			System.out.print(BaseCryptingTest.executeDecodedToString(sCompanyEncoded));
			System.out.print(scompany);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
