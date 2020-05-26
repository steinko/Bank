package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerControllerSmokeTest {
	
	@Autowired
	  private CustomerController controller;
	
	@Test
	  public void shouldloadApplicationContext() {
		  assertNotNull(controller);
	  }

}
