package org.steinko.bank.bankaccount;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
*  Mananage storage of bank account.
*/

public interface BankAccountRepository
  extends JpaRepository<BankAccount, Long> {
	/**
	 * Get Customer by the persons id. 
	 * @param id identifies the bank account.
	 * @return bank account
	 */
	Optional<BankAccount> findById(Long id);
}
