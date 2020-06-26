package org.steinko.bank.bankaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
*  Mananage storage of bank account.
*/
@Repository
public interface BankAccountRepository
  extends JpaRepository<BankAccount, Long> {
	/**
	 * Get Customer by the persons id. 
	 * @param personId
	 * @return bank account
	 */
	BankAccount getByPersonId(Long personId);
}
