package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerControllerST {
	
	/**
	 * Customer controller.
	 */
	@Autowired
	  private CustomerController controller;
	
	/**
	 * Test that application context exists.
	 */
	
	@Test
	  public void shouldloadApplicationContext() {
		  assertNotNull(controller);
	  }

}
