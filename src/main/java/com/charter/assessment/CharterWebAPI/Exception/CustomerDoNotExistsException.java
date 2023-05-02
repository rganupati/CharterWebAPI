package com.charter.assessment.CharterWebAPI.Exception;

/**
 * Custom Exception is thrown when the Customer is not found.
 * @author rajesh
 *
 */
public class CustomerDoNotExistsException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public CustomerDoNotExistsException(String errorMessage) {
		super(errorMessage);
	}

}
