package org.steinko.bank.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Customer service.
 */
@Service
public class CustomerServiceImp implements CustomerService{
	/**
	 * Customer repository.
	 */
	
	private final CustomerRepository repository;
	
	/**
	 * Customer service creator.
	 * @param repository repository
	 */
	public CustomerServiceImp(CustomerRepository repository) {
		this.repository = repository;
	}
	

	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerServiceImp.class);
	
	/**
	 * Create customer.
	 * @param customer customer
	 * @return customer
	 */
	public Customer createCustomer(Customer customer) {
		logger.info("start metode create customer", 
		  keyValue("category", "component"));
		return repository.save(customer);
	}
	
	/**
	 * Get customer.
	 * @param personId person id
	 * @return customer
	 */
	public Customer getCustomer(long personId) {
		return repository.findByPersonId(personId);
	}
	
	/**
	 * Delete customer.
	 * @param personId person id
	 * @return id
	 */
	public Long  deleteCustomer(long personId) {
		return repository.deleteByPersonId(personId);
	}
	
	/**
	 * Update customer.
	 * @param customer customer
	 * @return customer
	 */
	public Customer updateCustomer(Customer customer) {		
		return repository.save(customer);
	}
}