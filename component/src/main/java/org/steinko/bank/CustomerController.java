package org.steinko.bank;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletResponse;  

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Customer Controller.
 */
@CrossOrigin(origins = "*")
@RestController("customerController")
public final class CustomerController {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LogManager.getLogger(CustomerController.class);
	
	/**
	 * Constructor.
	 */
	public CustomerController() {
		
	}
	
	/**
	 * Create customer API.
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/customer")
	public void createCustomer(@RequestParam String personId, HttpServletResponse response) {
		
		try { 
			   if (personId == "26076144444")
				  throw new CustomerExistException("Person with this person Id already exist");
				
		   }
	   catch (CustomerExistException exc) { 
			       throw new ResponseStatusException( HttpStatus.CONFLICT, "Person with this person Id already exist", exc);
		    }
		
	}
}