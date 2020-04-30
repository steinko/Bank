package org.steinko.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.steinko.bank.BankAccount;

public class BankAccountTest {

	@Test
	public void testgi() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		assertEquals(bankaccount.saldo(),100);
	}
	
	@Test
	public void testta() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		bankaccount.ta(100);
		assertEquals(bankaccount.saldo(),0);
	}

}
