package org.steinko.bank.bankaccount;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.steinko.bank.bankaccount.BankAccount;
import org.steinko.bank.bankaccount.BankAccountRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.test.context.ActiveProfiles;
import java.util.ArrayList;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Integration test to verify that BankAccout is stored in  database 
 * with use of Bank Account Repositiry
 */
@Disabled
@DataJpaTest
public class BankAccountRepositoryIT {
 

	  /**
	   * Bank Account Repository.
	   */
	  @Autowired
	    private BankAccountRepository bankAccountRepository;

	  @BeforeEach
	  public void setUp() {
		  bankAccountRepository.deleteAll();
	  }
	  

	  /**
	   * Test save bank account to bank account repository.
	   */
	  @Test
	    public void shouldSaveBankAccount() {
		      BankAccount bankAccount = new BankAccount(100);
		      bankAccountRepository.save(bankAccount);
		      assertEquals(bankAccountRepository.findById(bankAccount
		    		        .getId())
		    		        .get()
		    		        .getId(), bankAccount.getId()); 
      }

	  /**
	   * Test delete bank account from bank account repository.
	   */
	 
	  @Test
	    public void shouldDeleteBackAccount() {
          BankAccount bankAccount = new BankAccount(100); 
          bankAccountRepository.save(bankAccount);
	      bankAccountRepository.delete(bankAccount);
	      ArrayList<BankAccount> empty = new ArrayList<BankAccount>();
	      assertEquals(bankAccountRepository.findAll(), empty);
	    }

	  
}
