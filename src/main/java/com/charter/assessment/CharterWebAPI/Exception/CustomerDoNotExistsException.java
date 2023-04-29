package com.charter.assessment.CharterWebAPI.Exception;

public class CustomerDoNotExistsException extends Exception  {
	
	public CustomerDoNotExistsException(String errorMessage) {
		super(errorMessage);
	}

}
