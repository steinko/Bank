package org.steinko.bank;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import org.steinko.bank.bank.Bank;
import org.steinko.bank.bank.BankRepository;

import org.steinko.bank.bankaccount.BankAccount;
import org.steinko.bank.bankaccount.BankAccountController;
import org.steinko.bank.bankaccount.BankAccountService;
import org.steinko.bank.bankaccount.BankAccountRepository;

import org.steinko.bank.customer.Customer;
import org.steinko.bank.customer.CustomerController;
import org.steinko.bank.customer.CustomerService;
import org.steinko.bank.customer.CustomerRepository;

public class WebServerST {
	
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
	
	@Test
	public void whenDependentClassIsPresent_thenBeanCreated() {
	    this.contextRunner.withUserConfiguration(WebServer.class)
	    .run(context -> {
	    	Bank bank = context.getBean(Bank.class);
	    	assertNotNull(bank);
	    	BankRepository bankRepository = context.getBean(BankRepository.class);
	    	assertNotNull(bankRepository);
	    	BankAccountController bankAccountController = context.getBean(BankAccountController.class);
	    	assertNotNull(bankAccountController);
	    	BankAccountService bankAccountService = context.getBean(BankAccountService.class);
	    	assertNotNull(bankAccountService);
	    	BankAccountRepository bankAccountRepository = context.getBean(BankAccountRepository.class);
	    	assertNotNull(bankAccountRepository);
	    	BankAccount bankAccount = context.getBean(BankAccount.class);
	    	assertNotNull(bankAccount);
	    	
	    	CustomerController customerController = context.getBean(CustomerController.class);
	    	assertNotNull(bankAccountController);
	    	CustomerService customerService = context.getBean(CustomerService.class);
	    	assertNotNull(bankAccountService);
	    	CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
	    	assertNotNull(customerRepository);
	    	Customer customer = context.getBean(Customer.class);
	    	assertNotNull(customer);
	    	
	    	
	        Object datasource =context.getBean("datasource");
	    	assertNotNull(datasource);
	    });
	}

}
