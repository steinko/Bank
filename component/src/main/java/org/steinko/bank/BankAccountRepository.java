package org.steinko.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
*  Mananage storage of bank account.
*/
@Repository
public interface BankAccountRepository
  extends JpaRepository<BankAccount, Long> {
}
