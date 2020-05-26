package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


@DataJpaTest
public class CustomerRepositoryTest {
	
	   /**
	   * Customer Repository.
	   */
	   @Autowired
	   private CustomerRepository customerRepository;

	  @BeforeEach
	  public void setUp() {
		  customerRepository.deleteAll();
	  }
	   
	   
	   
	   /**
	   * Test save cutomer to customer repository.
	   */
	  @Test
	    public void shouldSaveCustomer() {
		      Long personId;
		      personId = 2367987665l;
		      Customer customer = new Customer("Martin Luther",personId ,1l,123);
		      customerRepository.save(customer);
		      assertEquals(customerRepository.findById(customer
		    		        .getId())
		    		        .get()
		    		        .getId(), customer.getId()); 
   }
	  
	  /**
	   * Test delete customer from customer repository.
	   */
	  @Test
	    public void shouldDeleteBackAccount() {
		  Long personId;
	      personId = 2367987665l;
	      Customer customer = new Customer("Martin Luther",personId ,1l,123);
	      customerRepository.save(customer);
	      customerRepository.delete(customer);
	      ArrayList<Customer> empty = new ArrayList<Customer>();
	      assertEquals(customerRepository.findAll(), empty);
	    }
	  
	  /**
	   * Test save  two bank accounts to bank account repository.
	   */
	  @Test
	    public void shouldHaveTwoCustomers() {
		  Long personId1;
	      personId1 = 2367987665l;
	      Customer customer1 = new Customer("Martin Luther",personId1 ,1l,123);
	      customerRepository.save(customer1);
	      Long personId2;
	      personId2 = 2367987666l;
	      Customer customer2 = new Customer("Martin Lutt",personId2 ,2l,123);
	      customerRepository.save(customer2);
	      assertEquals(customerRepository.findAll().size(), 2);
	    }


}
