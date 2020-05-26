package org.steinko.bank.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;



public class CustomerTest {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerControllerTest.class);

	@Test
	public void customerShouldBecreated() {
		logger.info("start unit test customerShouldBecreated" ,keyValue("category", "component"));
		Long personId;
		personId = 2367987665l;
		Customer customer = new Customer("Martin Luther",personId ,1l,123);
		assertEquals(customer.getName(),"Martin Luther");
		
		assertEquals(customer.getPersonId(),personId );
		 Long customberNuber;
		customberNuber = 1l;	
		assertEquals(customer.getCustomerNumber(),customberNuber);
		assertEquals(123,customer.getPin());
		logger.info("end unit test customerShouldBecreated " ,keyValue("category", "component"));
	}

}
