package org.steinko.bank;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	/**
	 * Id for customer.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/**
	 *  A one to ome relation to checking account.
	 */
	@JoinColumn(name = "CHECKINGACCOUNT_ID") 
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount checkingAccount;
	
	/**
	 *  A one to one relation to saving account.
	 */
	@JoinColumn(name = "SAVINGACCONUT_ID") 
    @OneToOne(cascade = CascadeType.ALL) 
	private BankAccount savingsAccount;
	
	/**
	 * customer number.
	 */
	private Long customerNumber;
	
	/**
	 * pin.
	 */
	private int pin;
	
	/**
	 * name.
	 */
	private String name;
	
	/**
	 * person id.
	 */
	private Long personId;
	
	/**
	 * Hidden constructor.
	 */
	protected Customer() { }
	
	/**
	 * Constuct a customer.
	 * @param aName cutomers name
	 * @param aPersonId customers person id
	 * @param aCustomerNumber customer number
	 * @param aPin customers pin
	 */
	public Customer(String aName, 
			long aPersonId, Long aCustomerNumber, int aPin) {
	   this.customerNumber = aCustomerNumber;
	   this.name = aName;
	   this.personId = aPersonId; 
	   this.pin = aPin;
	   savingsAccount = new BankAccount(0);
	   checkingAccount = new BankAccount(0);
    }
	
	/**
	 * get saving account.
	 * @return saving account
	 */
	public BankAccount savingAccount() {	
		return savingsAccount;
	}
	
	/**
	 * get checking account.
	 * @return checking account
	 */
	public BankAccount checkingAccount() {
		return checkingAccount;
	}
	
	/**
	 * customer number.
	 * @return customer number
	 */
	public Long getCustomerNumber() {		
		return customerNumber;
	}
	
	/**
	 * person id.
	 * @return person id
	 */
	public Long getPersonId() {		
		return personId;
	}
	
	/**
	 * get name.
	 * @return name
	 */
	public String getName() {		
		return name;
	}

	/**
	 * pin.
	 * @return pin
	 */
	public int getPin() {	
		return pin;
	}
	
	/**
	 * id.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
}
