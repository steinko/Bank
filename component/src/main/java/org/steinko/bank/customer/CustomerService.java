package org.steinko.bank.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import org.springframework.stereotype.Service;

/**
 * Customer service.
 */
@Service
public class CustomerService {
	
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerDto.class);
	
	/**
	 * Create customer.
	 * @param customer customer
	 * @return customer
	 */
	public Customer createCustomer(Customer customer) {
		logger.info("start metode create customer", 
		  keyValue("category", "component"));
		return customer;
	}
	
	/**
	 * Get customer.
	 * @param l l
	 * @return customer
	 */
	public Customer getCustomer(long l) {
		return new Customer();
	}
	
	/**
	 * Delete customer.
	 * @param l l
	 */
	public void  deleteCustomer(long l) {	
	}
	
	/**
	 * Update customer.
	 * @param customer customer
	 * @return customer
	 */
	public Customer updateCustomer(Customer customer) {		
		return customer;
	}
}
