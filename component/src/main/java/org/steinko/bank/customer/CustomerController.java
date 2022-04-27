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

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Customer Controller.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	/**
	 * Repository.
	 */
	 private final CustomerRepository repository;
	
	/**
	 * Create customer.
	 * @param repository customer repository.
	 */
	 CustomerController(CustomerRepository repository) {
	    this.repository = repository;
	 }
	
	
	/**
	 * Logger.
	 */
	 private static Logger logger = 
			LoggerFactory.getLogger(CustomerController.class);
	
	
	
	
	/**
	 * Create customer.
	 * @param customerDto customer data transfer object 
	 * @return  customer data transfer object
	 */
	 @ResponseStatus(HttpStatus.CREATED)
	 @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 public CustomerDto createCustomer(
			 @RequestBody CustomerDto customerDto) {
		
		logger.info("start methode create customer  input customerDto" 
	    + customerDto.toString());
		
		 Customer customer = null;
		 try {    
		       customer = convertToEntity(customerDto);
		       
		     } catch (ParseException pe) {
	        	logger.error(pe.toString());
	         }      
        Customer customerCreated = repository.save(customer);
        return convertToDto(customerCreated);
	 }
	
	
	/**
	 * Get customers.
	 * @return customers. 
	 */
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping
	 public List<CustomerDto> getCustomers() {
		Iterable<Customer> customers = repository.findAll();
		
		return convertToDto(customers);
	 }
	
	
	/**
	 * Get the customer with a spesific person id.
	 * @param personId person id to get
	 * @return Customer data. 
	 */
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping(value = "/{personId}")
	 public CustomerDto getCustomer(@PathVariable Long personId) {
		Customer customer = repository.findByPersonId(personId);
		return convertToDto(customer);
	 }
	
	
	/**
	 * Delete the customer with the spesific person id.
	 * @param personId person id to delete
	 */
	 @DeleteMapping(value = "/{personId}")
	 @ResponseStatus(HttpStatus.OK)
	 public void deleteCustomer(@PathVariable Long personId) {
		     repository.deleteByPersonId(personId);
	 }
	
	
	/**
	 * Update  the customer with the data from the data transfere object.
	 * @param customerDto customer data transfer object.
	 * @return customer data.
	 */
	 @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(HttpStatus.OK)
	 public CustomerDto updateCustomer(
			@RequestBody CustomerDto customerDto) {
		
		Customer customer = null;
		try  {    
		       customer = convertToEntity(customerDto);    
		     } catch (ParseException pe) {
	        	logger.error(pe.toString());
	         }  
		 Customer customerCreated = 
				 repository.save(customer);
	     return convertToDto(customerCreated);	
	 }
	
	
	/**
	 * Convert Customer object to Customer data transfer object.
	 * @param customer the Customer object to convert
	 * @return data transfer object with converted data
	 */
	 public CustomerDto convertToDto(Customer customer) {
		CustomerDto customerDto = 
				new CustomerDto(customer.getPersonId());
	    return customerDto;
	 }
	
	
	/**
	 * Convert customer objects to customer data transfer objects.
	 * @param customers  customer objects that should be converted.
	 * @return data transfer objects with converted data.
	 */
	 public List<CustomerDto> convertToDto(Iterable<Customer> customers) {
		 
		List<CustomerDto> customersDto = new ArrayList<CustomerDto>();
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			CustomerDto cutomerDto = convertToDto(iterator.next());
			customersDto.add(cutomerDto);
		}
	    return customersDto;
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
	    return customer;
	 }
	
}