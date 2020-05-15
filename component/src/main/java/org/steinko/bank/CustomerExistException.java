package org.steinko.bank;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that are thrown when the customer exists.
 */

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CustomerExistException extends Exception {

	/**
	 *  Identifier of the class.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor of exception.
	 * @param errorMessage error message
	 */
	public CustomerExistException(String errorMessage) {
		super(errorMessage);
	}
	

}
