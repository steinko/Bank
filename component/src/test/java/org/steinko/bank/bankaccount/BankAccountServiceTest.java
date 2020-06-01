package org.steinko.bank.bankaccount;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTest {
	
	@Mock
	BankAccountRepository repository;
	
	@InjectMocks 
	BankAccountServiceImp service;
	
	@Test 
	public void shouldExists() {
		assertNotNull(service);
	}
	
	@Test
	public void shouldGetSavingAccount() {
		     Long personId = 2304817777L;
		     Integer balance = 400;
		     BankAccount savingsAccount = new BankAccount(balance);
		     given(repository.getByPersonId(personId)).willReturn(savingsAccount);
	         BankAccount returBankAccount = service.getSavingsAccount(personId);
	         assertEquals(returBankAccount.getBalance(),balance);
	}
	
	 @Test 
	 public void shouldHaveAddedDeposit() {
		 Long personId = 2345687654L;
		 Integer amount = 400;
		 BankAccount savingsAccount = new BankAccount(amount);
	     given(repository.getByPersonId(personId)).willReturn(savingsAccount);
		 BankAccount returnBankAccount = service.depositToSavingsAccount(personId,amount);
		 assertEquals(returnBankAccount.getBalance(),800);
	 }

}
