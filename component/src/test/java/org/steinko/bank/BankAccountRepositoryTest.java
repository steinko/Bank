package org.steinko.bank;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.EntityManager;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test for BankAccount class.
 */
//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BankAccountRepositoryTest {
       /**
       * Data source.
       */
      @Autowired
      private DataSource dataSource;

       /**
       * Jdbc Template.
       */
      @Autowired
      private JdbcTemplate jdbcTemplate;

       /**
       * Entity Manager.
       */
      @Autowired
       private EntityManager entityManager;

       /**
	   * Test Entity Manager.
	   */
	  @Autowired
	   private TestEntityManager testEntityManager;

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
	   * Test repository configuration.
	   */
	  @Test
	  void injectedComponentsAreNotNull() {
	    assertNotNull(dataSource);
	    assertNotNull(jdbcTemplate);
	    assertNotNull(testEntityManager);
	    assertNotNull(entityManager);
	    assertNotNull(bankAccountRepository);
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
	  @Disabled
	  @Test
	    public void shouldDeleteBackAccount() {
          BankAccount bankAccount = new BankAccount(100); 
          bankAccountRepository.save(bankAccount);
	      bankAccountRepository.delete(bankAccount);
	      ArrayList<BankAccount> empty = new ArrayList<BankAccount>();
	      assertEquals(bankAccountRepository.findAll(), empty);
	    }

	  
}
