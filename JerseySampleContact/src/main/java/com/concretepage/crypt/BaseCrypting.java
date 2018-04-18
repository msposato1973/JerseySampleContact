package com.concretepage.crypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;


public class BaseCrypting {
	
	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	
	/***
	 * 
	 * @param msg
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String executeEncoded(String msg) throws UnsupportedEncodingException {
		System.out.println("executeEncoded - msg : "+msg);
		byte[] message = msg.getBytes(UTF_8);
		System.out.println("executeEncoded - message : "+message);
		String encoded = DatatypeConverter.printBase64Binary(message);
		System.out.println("executeEncoded - encoded : "+encoded);
		
		return encoded;
		
	}
	
	/***
	 * 
	 * @param msg
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String executeDecoded(String msg) throws UnsupportedEncodingException {
		System.out.println("executeDecoded - msg : "+msg);
		byte[] decoded = DatatypeConverter.parseBase64Binary(msg);
		System.out.println("executeDecoded - decoded : "+decoded);
		String sDecode = new String(decoded, UTF_8);
		System.out.println("executeDecoded - sDecode : "+sDecode);
		return sDecode;
	}
	
	
	/***
	 * 
	 * @param msg
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String executeEncodeToString(String msg) throws UnsupportedEncodingException {
		System.out.println("executeEncodeToString - msg : "+msg);
		String encodedAuthString = new Base64().encodeToString(msg.getBytes());
		System.out.println("executeEncodeToString - encodedAuthString : "+encodedAuthString);
		return encodedAuthString;
	}
	
	/***
	 * 
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String executeDecodedToString(String content) throws UnsupportedEncodingException {
	  	  System.out.println("executeDecodedToString - content : "+content);
		  byte[] contentBytes=content.getBytes();
		  System.out.println("executeDecodedToString - contentBytes : "+contentBytes);
		  
		  Base64 base64=new Base64();
		  String  value=new String(Base64.decodeBase64(contentBytes),"UTF-8");
		  System.out.println("executeDecodedToString - value : "+value);
		  
		  return value;
	}
	

}