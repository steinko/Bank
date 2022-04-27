package org.steinko.bank.bankaccount;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(
	    value = HttpStatus.NOT_FOUND, 
	    reason = "Requested bank account does not exist"
	)

public class BankAccountNotFoundExeption 
	 extends RuntimeException {
		 
	/**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  
	  /**
	   * Creator.
	   * @param t throw message.
	   */
	  public BankAccountNotFoundExeption(Throwable t) {
		        super(t);
		    }
	
}
