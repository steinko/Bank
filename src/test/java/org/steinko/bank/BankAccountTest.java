package org.steinko.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit Test bank account. 
 */
public class BankAccountTest {
/**
 * Test gi.
 */
	@Test
	public void shouldContainSaldo100() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		assertEquals(bankaccount.saldo(), 100);
	}
	
	/**
	 * Test ta.
	 */
	@Test
	public void shouldContainSaldo0() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		bankaccount.ta(100);
		assertEquals(bankaccount.saldo(), 0);
	}

}
