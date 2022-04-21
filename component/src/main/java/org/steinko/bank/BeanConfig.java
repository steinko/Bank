package org.steinko.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.steinko.bank.bankaccount.BankAccountRepository;
import org.steinko.bank.bankaccount.BankAccountService;
import org.steinko.bank.bankaccount.BankAccountServiceImp;
import org.steinko.bank.customer.CustomerRepository;
import org.steinko.bank.customer.CustomerService;
import org.steinko.bank.customer.CustomerServiceImp;
import org.springframework.context.annotation.Bean;

/**
 * Bean configuration.
 *
 */

@Configuration
public class BeanConfig {
	
	/**
	 * Customer repository.
	 */
	
	@Autowired 
	private CustomerRepository customerRepository;

	
	/**
	 * Create customer servive bean.
	 * @return customer service bean.
	 */
	@Bean
	  public CustomerService customerService() {
		return new CustomerServiceImp(customerRepository);
		
	}
	
	/**
	 * Bank account repository.
	 */
	@Autowired 
	private BankAccountRepository bankAccountRepository;

	
	/**
	 * Create a bank account service bean.
	 * @return bank account service bean.
	 */
	@Bean
	  public BankAccountService bankAccountService() {
		return new BankAccountServiceImp(bankAccountRepository);
		
	}
}
