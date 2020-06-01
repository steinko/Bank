package org.steinko.bank.customer;

public interface CustomerService {
	    Customer createCustomer(Customer customer);
	    Customer getCustomer(long personId);
	    Long  deleteCustomer(long personId);
	    Customer updateCustomer(Customer customer);
}
