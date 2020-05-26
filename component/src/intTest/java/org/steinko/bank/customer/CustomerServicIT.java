package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CustomerServicIT {
	
	@Autowired
	CustomerService customerService;
	
	 @MockBean
	    private CustomerRepository repository;
	 
	 Customer customer;
	 
	 
	 @BeforeEach
	 public void setUp() {
	    customer = new Customer("", 23456144444L,0L,0);
	  
	     when(repository.save(customer))
	       .thenReturn(customer);
	 }
	
	@Test
	public void shoulBeACompnent() {
		assertNotNull(customerService);
	}
	
	@Test
	public void shouldHaveBeenSaved() {
		
		 when(repository.findByPersonId(customer.getPersonId()))
         .thenReturn(customer);
		Customer created = customerService.createCustomer(customer);
			assertEquals(customer,created);
	}

}
