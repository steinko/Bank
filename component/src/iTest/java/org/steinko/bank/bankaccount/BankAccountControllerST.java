package org.steinko.bank.bankaccount;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@SpringBootTest
public class BankAccountControllerST {
	/**
	 * Bank Accout Controller.
	 */
	@Autowired
	  private BankAccountController controller;
	
	/**
	 * test existence of applicationContext.
	 */
	@Test
	  public void shouldloadApplicationContext() {
		  assertNotNull(controller);
	  }

}

