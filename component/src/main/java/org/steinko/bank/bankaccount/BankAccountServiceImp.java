package org.steinko.bank.bankaccount;

/**
 * Bank Account Service.
 */
public class BankAccountServiceImp implements BankAccountService {
	
	private final BankAccountRepository repository;
	
	/**
	 * Creator.
	 * @param repository Repository
	 */
	
	public BankAccountServiceImp(BankAccountRepository repository){
		this.repository = repository;
	}
	
   /**
    * Get savings account.
    * @param personId
    * @return bank account
    */
	public BankAccount getSavingsAccount(Long personId) {
		return repository.getByPersonId(personId);
	}
	
	/**
	 * Deposit to savings account.
	 * @param personId
	 * @param amount
	 * @return bank account
	 */
	public BankAccount depositToSavingsAccount(
			Long personId, 
			Integer amount) {
		BankAccount returnBankAccount = repository.getByPersonId(personId);
		returnBankAccount.gi(amount);
		return returnBankAccount;
	}

}
