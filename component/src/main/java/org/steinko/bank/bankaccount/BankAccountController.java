package org.steinko.bank.bankaccount;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Bank account controller.
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class BankAccountController {
	
	/**
	 * Service.
	 */
	@Autowired
	private BankAccountService service;
	
	/**
	 * Get savings account data. 
	 * @param personId
	 * @return savings account data
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/savingsaccount/{personId}")
	public BankAccountDto getSavingsAccount(
			@PathVariable Long personId) {
		BankAccount savingsaccount = 
				service.getSavingsAccount(personId);
		return convertToDto(savingsaccount);
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
		BankAccount savingsaccount = 
				service.depositToSavingsAccount(
						personId,
						amount);
		return convertToDto(savingsaccount);
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
