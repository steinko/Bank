package org.steinko.bank.customer;

import java.util.List;

public interface CustomerService {
	/**
	 * Create customer.
	 * @param customer customer
	 * @return customer
	 */
	 Customer createCustomer(Customer customer);
	 
	 /**
	 * Get customer.
	 * @param personId person id
	 * @return customer
	 */
	 Customer getCustomer(long personId);
	 
	 /**
	 * Delete customer.
	 * @param personId person id
	 * @return id
	 */
	 Long  deleteCustomer(long personId);
	 
	 /**
	 * Update customer.
	 * @param customer customer
	 * @return customer
	 */
	 Customer updateCustomer(Customer customer);
	 
	 /**
	  * Get the list of customers in the system
	  * @return customers
	  */
	 List<Customer> getCustomers();
}
