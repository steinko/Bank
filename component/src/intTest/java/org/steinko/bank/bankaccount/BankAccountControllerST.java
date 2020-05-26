package org.steinko.bank.bankaccount;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BankAccountControllerST {
	
	@Autowired
	  private BankAccountController controller;
	
	@Test
	  public void shouldloadApplicationContext() {
		  assertNotNull(controller);
	  }

}

