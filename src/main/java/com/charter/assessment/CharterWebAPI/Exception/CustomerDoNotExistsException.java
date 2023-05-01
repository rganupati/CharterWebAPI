package com.charter.assessment.CharterWebAPI.Exception;

public class CustomerDoNotExistsException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public CustomerDoNotExistsException(String errorMessage) {
		super(errorMessage);
	}

}
