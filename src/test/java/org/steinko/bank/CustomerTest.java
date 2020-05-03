package org.steinko.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CustomerTest {

	@Test
	public void customerShouldBecreated() {
		Long personId;
		personId = 2367987665l;
		Customer customer = new Customer("Martin Luther",personId ,1l,123);
		assertEquals(customer.getName(),"Martin Luther");
		
		assertEquals(customer.getPersonId(),personId );
		 Long customberNuber;
		customberNuber = 1l;	
		assertEquals(customer.getCustomerNumber(),customberNuber);
		assertEquals(123,customer.getPin());
		

		
	}

}
