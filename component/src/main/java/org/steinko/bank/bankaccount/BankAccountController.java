package org.steinko.bank.bankaccount;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

/**
 * Bank account controller.
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class BankAccountController {
	
	/**
	 * Repository.
	 */
	private final BankAccountRepository repository;
	
	
	/**
	 * Create repository.
	 * @param repository created repository.
	 */
	 BankAccountController(BankAccountRepository repository) {
	    this.repository = repository;
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
		
		    Optional<BankAccount> optionalSavingsAccount = 
			repository.findById(personId);
		        
		    if (optionalSavingsAccount.isPresent()) {
		        	
		           BankAccount savingsAccount = 
		           optionalSavingsAccount.get();
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
		
		    Optional<BankAccount> optionalSavingsAccount = 
				repository.findById(personId);
		        
		    if (optionalSavingsAccount.isPresent()) {
		        	
		          BankAccount savingsAccount = 
		          optionalSavingsAccount.get();
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
