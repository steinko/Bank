package org.steinko.bank;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletResponse;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

/**
 * Customer Controller.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerController.class);
	
	/**
	 * Constructor.
	 */
	public CustomerController() {
		
	}
	
	/**
	 * Create customer API.
	 * @param customer customer data
	 * @param response response
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDto customer,
			                   HttpServletResponse response) {
		
		try { 
			  logger.info("customer id: " + customer.getPersonId(),keyValue("category", "component"));
			                               
		      if (customer.getPersonId() == "26076144444") {
		    	  logger.info("person id  alredy exists",keyValue("category", "component"));
			      throw new CustomerExistException(
			      "Person with this person Id already exist");  }
			  else  {
			      logger.info("person id do not exists",keyValue("category", "component"));
			      
			 } 
		  
		} catch (CustomerExistException exc) { 
			  logger.info("Person with this person Id already exist",keyValue("category", "component"));
			  throw new ResponseStatusException(
			  HttpStatus.CONFLICT, 
			  "Person with this person Id already exist",
			  exc);
		}
		
	}
	
	
	@GetMapping(value = "/{personId}")
	public CustomerDto getCustomer(@PathVariable Long personId){
		return new CustomerDto();
	}
	
	@DeleteMapping(value = "/{personId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long personId){
	}
	
	@PutMapping(value = "/{personId}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@PathVariable Long personId , @RequestBody CustomerDto customer ){
	}
	
}