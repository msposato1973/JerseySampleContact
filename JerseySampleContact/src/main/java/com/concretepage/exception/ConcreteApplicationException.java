package com.concretepage.exception;

import java.io.Serializable;

public class ConcreteApplicationException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public ConcreteApplicationException()
	{
		super();
	}
	
	public ConcreteApplicationException(String msg)
	{
		super(msg);
	}
	
	public ConcreteApplicationException(String msg, Exception e)
	{
		super(msg, e);
	}
}
