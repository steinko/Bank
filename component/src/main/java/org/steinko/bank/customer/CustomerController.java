package org.steinko.bank.customer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

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
	 * Customer service.
	 */
	
	private final CustomerService service;
	
	/**
	 * Constructor.
	 */
	public CustomerController(CustomerService service) {
		this.service = service;
		
	}
	
	/**
	 * Create customer API.
	 * @param customerDto customer data transfer object 
	 * @return  customer data transfer object
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDto createCustomer(
			 @RequestBody CustomerDto customerDto) {
		
		logger.info("start methode create customer  input customerDto" 
	    + customerDto.toString(), keyValue("category", "component"));
		
		 Customer customer = null;
		 try {    
		       customer = convertToEntity(customerDto);
		       
		     } catch (ParseException pe) {
	        	logger.error(pe.toString(), 
	        	  keyValue("category", "component"));
	         }      
        Customer customerCreated = service.createCustomer(customer);
        return convertToDto(customerCreated);
	}
	
	/**
	 * Get Customer API.
	 * @param personId person id
	 * @return Customer data. 
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{personId}")
	public CustomerDto getCustomer(@PathVariable Long personId) {
		Customer customer = service.getCustomer(personId);
		return convertToDto(customer);
	}
	
	/**
	 * Delete Customer API.
	 * @param personId person id
	 */
	@DeleteMapping(value = "/{personId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long personId) {
		     service.deleteCustomer(personId);
	}
	
	/**
	 * Update Customer.
	 * @param customerDto customer data transfer object
	 * @return customer data
	 */
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto updateCustomer(
			@RequestBody CustomerDto customerDto) {
		
		Customer customer = null;
		try  {    
		       customer = convertToEntity(customerDto);    
		     } catch (ParseException pe) {
	        	logger.error(pe.toString(), 
	        		keyValue("category", "component"));
	         }  
		 Customer customerCreated = 
				 service.updateCustomer(customer);
	     return convertToDto(customerCreated);	
	}
	
	/**
	 * Convert Customer to Customer data transfer object.
	 * @param customer the customer
	 * @return customer data
	 */

	public CustomerDto convertToDto(Customer customer) {
		//ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = new CustomerDto();
		customerDto.setPersonId(customer.getPersonId());
	    //CustomerDto customerDto = 
		    //modelMapper.map(customer, CustomerDto.class);
	    return customerDto;
	}
	
	
	/**
	 * Convert to Customer from customer data.
	 * @param customerDto customer data transfer object
	 * @return customer
	 * @throws ParseException error in conversion
	 */
	public  Customer convertToEntity(CustomerDto customerDto) 
			  throws ParseException {
		
		Customer customer = new Customer("", 
				customerDto.getPersonId(), 0L, 0);
		
		//ModelMapper modelMapper = new ModelMapper();
	//	Customer customer = null;
	//	try {
	//	       customer = modelMapper.map(customerDto, Customer.class);
	  //   	} catch (IllegalArgumentException Iae )  {
	    // 		 logger.error("IllegalArgument:"+ 
		//     Iae.toString(),keyValue("category", "component"));
	     //		
	     //	} catch (ConfigurationException ce) {
	    // 		logger.error("Configuration error:" 
		//  + ce.toString(),keyValue("category", "component"));
	     		
	     //	} catch (MappingException me) { 
		//        logger.error("Mapping error:"+  me.toString(), 
		//    keyValue("category", "component"));
	     //	}
	    return customer;
	}
	
}