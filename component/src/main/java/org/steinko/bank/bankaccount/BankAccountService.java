package org.steinko.bank.bankaccount;

/**
 *  Bank Account Service.
 */
public interface BankAccountService {
   /**
   * Get savings account.
   * @param personId
   * @return bank account
   */
   BankAccount getSavingsAccount(Long personId);

  /**
   * Deposit to savings account.
   * @param personId
   * @param amount
   * @return bank account
   */
   BankAccount depositToSavingsAccount(Long personId, Integer amount);
}
