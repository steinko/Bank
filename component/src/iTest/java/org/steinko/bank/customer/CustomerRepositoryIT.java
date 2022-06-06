package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.steinko.bank.bankaccount.BankAccount;
import org.steinko.bank.bankaccount.BankAccountRepository;
import org.steinko.bank.customer.Customer;
import org.steinko.bank.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;


/**
 * Integration Test on how Customer. 
 * is stored in a database 
 * with use of Customer Repository.
 */
@Disabled
@DataJpaTest
public class CustomerRepositoryIT {
	
	   /**
	   * Customer Repository.
	   */
	   @Autowired
	   private CustomerRepository customerRepository;
	   
	   
	   /**
	   *  Bank Account Repository.
	   */
	   @Autowired
	   private BankAccountRepository bankAccountRepository;
	   
     
	  @BeforeEach
	  public void setUp() {
		  customerRepository.deleteAll();
	  }
	   
	   
	   
	   /**
	   * Test save customer object to customer repository.
	   */
	  @Disabled
	  @Test
	    public void shouldSaveCustomer() {
		  
		      Long personId;
		      personId = 2367987665l;
		      Customer customer = new Customer("Martin Luther",personId ,1l,123);
		      customerRepository.save(customer);
		      
		      Customer  foundCustomer = customerRepository.findByPersonId(personId);
		      assertEquals(foundCustomer.getPersonId(), customer.getPersonId()); 
		      
		      BankAccount savingsAccount = foundCustomer.savingAccount();
		      assertEquals(savingsAccount.getBalance(),0);
		      
		      
   }
	  
	  /**
	   * Test delete customer object from database.
	   */
	  @Disabled
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
	   * Test saving of two bank accounts object to database.
	   */
	  @Disabled
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
