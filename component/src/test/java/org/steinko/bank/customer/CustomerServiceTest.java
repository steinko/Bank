package org.steinko.bank.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@InjectMocks  
	CustomerService service;
	
	@MockBean
	CustomerRepository  repository;
	
	
	@BeforeEach 
	public void setUp() {
		service = new CustomerService();
	}
		
	@Test
	public void shouldExsist() {
	      assertNotNull( new CustomerService());
	}
	
	@Test
	public void shouldSavedACustomer() {
	  Customer customer = new Customer("",26076144574L,0L,0);
	  when(repository.save(customer)).thenReturn(customer);
	  assertNotNull(service.createCustomer(customer));
	}
	
	@Test
	public void shouldGetdACustomer() {
	  Long personId = 26076144574L;
	  Customer customer = new Customer("", personId,0L,0);
	  when(repository.findByPersonId(personId)).thenReturn(customer);
	  assertNotNull(service.getCustomer(personId));
	}
	
	
	@Test
	public void shouldDelete () {
		//assertDoesNotThrow(customerService.deleteCustomer(23456744444L));
	}
	
	@Test
	public void shouldBeUpdate() {
		Customer customer = new Customer("",26076144574L,0L,0);
		 when(repository.save(customer)).thenReturn(customer);
		assertNotNull(service.updateCustomer(customer));
	}
}
