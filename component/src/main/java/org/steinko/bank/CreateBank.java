package org.steinko.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.steinko.bank.bank.BankRepository;
import org.steinko.bank.bank.Bank;
import org.steinko.bank.bankaccount.BankAccount;

import org.steinko.bank.customer.Customer;

/**
 * Create Bank when WebServer boots.
 */
@Component
public class CreateBank implements CommandLineRunner {
	
    /**
     * bank repository.
     */
	private  BankRepository bankRepository;
	
	/**
	 * Creator.
	 * @param  bankRepository bank repository
	 */
	public CreateBank(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
	
	/**
     * Creates the bank.
	 * @param args arguments for the main method on WebServer.
	 * @throws Exception  An exception
	 */
	 @Override
	 public void  run(String... args) throws Exception {
	    	     
		    Bank bank = new Bank();
		    bank.createCustomer("", 0L, 101L, 4567);
		    Customer customer = bank.findCustomerByCustomerNumber(101L);
		    BankAccount savingAccount = customer.savingAccount();
		    savingAccount.gi(400);
		    bank.createCustomer("", 0L, 100L, 1234);
		    customer = bank.findCustomerByCustomerNumber(100L);
		    BankAccount checkingAccount = customer.checkingAccount();
		    checkingAccount.gi(600);
		    bank.createCustomer("", 0L, 102L, 1234);
		    customer = bank.findCustomerByCustomerNumber(102L);
		    savingAccount = customer.savingAccount();
		    savingAccount.gi(400);
		    bank.createCustomer("", 0L, 103L, 1234);
		    customer = bank.findCustomerByCustomerNumber(103L);
		    savingAccount = customer.savingAccount();
		    savingAccount.gi(600);
	        bankRepository.save(bank);
	   }
}
