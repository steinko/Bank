package org.steinko.bank.bankaccount;

import org.steinko.bank.customer.Customer;
import org.steinko.bank.customer.CustomerController;
import org.steinko.bank.customer.CustomerRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Bank account controller.
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class BankAccountController {
	
	/**
	 * Logger.
	 */
	 private static Logger logger = 
			LoggerFactory.getLogger(BankAccountController.class);
	
	
	/**
	 * Customer Repository.
	 */
	private final CustomerRepository customerRepository;
	
	/**
	 * Bank Account Repository.
	 */
	private final BankAccountRepository bankAccountRepository;
	
	/**
	 * Create repository.
	 * @param repository created repository.
	 */
	 BankAccountController(CustomerRepository customerRepository , BankAccountRepository bankAccountRepository) {
	    this.customerRepository = customerRepository;
	    this.bankAccountRepository = bankAccountRepository;
	 }
	
	  
	/**
	 * Get savings account data. 
	 * @param personId
	 * @return savings account data
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/savingsaccount/{personId}")
	public BankAccountDto getSavingsAccount(
			@PathVariable Long personId) {
		       
		    BankAccountDto  bankAccountDto = new BankAccountDto();
		
		    Customer customer = 
			customerRepository.findByPersonId(personId);
		        
		    if (customer != null) {
		    
		           BankAccount savingsAccount = customer.savingAccount();
		           Integer balance =  savingsAccount.getBalance();
		           logger.info("Bank account savings account balance in get savings account" 
		        		    + balance.toString());
		           bankAccountDto = convertToDto(savingsAccount);
		                  
		        } else {
		        	
		            bankAccountDto = new BankAccountDto();
		            throw new BankAccountNotFoundExeption(
		            new Throwable("Bank Account not found, personId: " 
		                        + personId)
		            );
		                  
		        }
		        	
		        
		     return bankAccountDto;
	}
	
	/**
	 * Deposit to savings account.
	 * @param personId
	 * @param amount
	 * @return saving account data.
	 */
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/savingsaccount/{personId}/{amount}")
	public BankAccountDto depositToSavingsAccount(
			@PathVariable Long personId, 
			@PathVariable Integer amount) {
		
		    BankAccountDto  bankAccountDto = new BankAccountDto();
		
		    Customer customer = 
					customerRepository.findByPersonId(personId);
		        
		    if (customer != null) {
		        	
		          BankAccount savingsAccount = 
		        		 customer.savingAccount();
		          savingsAccount.gi(amount);
		          Integer balance =  savingsAccount.getBalance();
		          logger.info("Bank account savings account balance "
		          		+ "before save in despoint to savings account" 
		        		+ balance.toString());
		           bankAccountRepository.save(savingsAccount);
		           customer = customerRepository.findByPersonId(personId);
		           savingsAccount = customer.savingAccount();
		           balance =  savingsAccount.getBalance();
		           logger.info("Bank account savings account balance after save" 
		        		    + balance.toString());
		         
		          bankAccountDto = convertToDto(savingsAccount);
		                  
		     } else {
		        	
		          bankAccountDto = new BankAccountDto();
		          throw new BankAccountNotFoundExeption(
		             new Throwable("Bank Account not found, personId: " 
		                   + personId)
		          );
		     }
		        
		     return bankAccountDto;
		        
	}
	
	/**
	 * Convert to bank account data transfer object.
	 * @param account bank account
	 * @return bank account data transfer object
	 */
	public BankAccountDto convertToDto(BankAccount account) {
		BankAccountDto dto = new BankAccountDto();
		dto.setBalance(account.getBalance());
		return dto;
	}
}
