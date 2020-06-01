package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;

import org.springframework.boot.test.context.TestConfiguration;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	
	
	@Mock
	CustomerRepository  repository;
   
	@InjectMocks 
	CustomerServiceImp service;
	
	@Test
	public void shouldExsist() {
	      assertNotNull( service);
	}
	
	@Test
	public void shouldSavedACustomer() {
	  Long personId = 26076144574L;
	  final Customer customer = new Customer("",personId,0L,0);
	  when(repository.save(any(Customer.class))).thenReturn(customer);
	  Customer savedCustomer = service.createCustomer(customer);
	  assertEquals(savedCustomer.getPersonId(),personId);
	}
	
	@Test
	public void shouldGetdACustomer() {
	  Long personId = 26076144574L;
	  final Customer customer = new Customer("", personId,0L,0);
	  when(repository.findByPersonId(personId)).thenReturn(customer);
	  Customer foundCustomer = service.getCustomer(personId);
	  assertEquals(foundCustomer.getPersonId(),personId);
	}
	
	@Test
	public void shouldDelete () {
		Long personId = 23456744444L;
		Long id = 1L;
		when(repository.deleteByPersonId(personId)).thenReturn(id);
		Long deletedId = service.deleteCustomer(personId);
		assertEquals(deletedId,id);
	}
	
	@Test
	public void shouldBeUpdate() {
		final Customer customer = new Customer("",26076144574L,0L,0);
		when(repository.save(any(Customer.class))).thenReturn(customer);
		assertNotNull(service.updateCustomer(customer));
	}
}
