package org.steinko.bank.bank;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
public class BankRepositoryTest  {
	private final static Logger logger = LoggerFactory.getLogger(BankRepositoryTest.class);
	
	@Autowired
	private BankRepository bankRepository;
	
	
	@BeforeEach
	public void setUp() {
		bankRepository.deleteAll();
	}
	
	@Test 
	public void shouldNotBeNull () {
		assertNotNull(bankRepository);
	}
	
	
	@Test
	public void shouldFindNoBanks() {
		Iterable<Bank> banks = bankRepository.findAll();
		assertThat(banks).isEmpty();
				
	}	
	
	 @Test
	public void shuoldFindOneBank() {
		 Bank bank = new Bank();
		 bankRepository.save(bank);
		 Long banks =   bankRepository.count();
			  assertEquals(1l,banks);
	}
	 
	 @Test
	 public void shouldDeleteAllBanks() {
		 Bank bank = new Bank();
		 bankRepository.save(bank);
		 bankRepository.deleteAll();
		 assertThat( bankRepository.findAll()).isEmpty();
	} 

}

