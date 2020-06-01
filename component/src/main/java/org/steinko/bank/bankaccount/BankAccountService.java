package org.steinko.bank.bankaccount;

public interface BankAccountService {
	 BankAccount getSavingsAccount(Long personId);
	 BankAccount depositToSavingsAccount( Long personId, Integer amount);
}
