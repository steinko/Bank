package org.steinko.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
* Manage the running of the bank component.
*/
@SpringBootApplication
public class WebServer {
   
   /**
    * Stating the component.
    * @param args argiments
    */
   public static void main(String[] args) {
       SpringApplication.run(WebServer.class, args);
   }

   @Bean
   public CommandLineRunner createBank(BankRepository bankRepository ) {
   
	   return args -> {
	    Bank bank = Bank.create();
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
       };
   }

}
