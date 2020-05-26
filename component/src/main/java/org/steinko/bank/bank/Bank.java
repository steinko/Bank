package org.steinko.bank.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.steinko.bank.customer.Customer;

/**
 *  Bank the root of the Entity.
 */
@Entity
public class Bank implements Serializable {
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(Bank.class);
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id for a bank.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Customers join with bank id.
	 */
	@JoinColumn(name = "BANK_ID") 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();
	  
	
	/**
	 * Hidden creator.
	 */   
    public Bank() { 
    	     System.out.println(this.toString());
    }
   
   /**
    * Get the id of the bank.
    * @return id for the bank
    */
    public Long getId() {
   		return id;
    }
   
   /**
    * Find the customer with the person id.
    * @param personId for the customer to find
    * @return a customer or null
    */
	public Customer findCustomerByPersonId(Long personId) {
		   for (Customer customer : customers) {
			   if (customer.getPersonId().equals(personId)) {
			     return customer;
			   }
		   }
		   return null;
	 }
	
	/**
	 * Create a customer.
	 * @param name of the customer
	 * @param personId for the customer
	 * @param customerNumber for the customer
	 * @param pin for the customer
	 */
	 public void createCustomer(String name, long personId,
			 Long customerNumber, int pin) {	
		Customer customer = 
                 new Customer(name, personId, customerNumber, pin);
		customers.add(customer);
	  }
	 
	 /**
	  * Find a customer by name.
	  * @param name for the customer thao one want to find
	  * @return found customer or null
	  */

	  public Customer findCustomerByName(String name) {
	
		for (Customer customer : customers) {
			if (customer.getName().equals(name)) {
			   return customer;
			}
		}
		return null;
	  }
	  
	  /**
	   * Find customer by customer number.
	   * @param customerNumber to the customer one want to find
	   * @return customer or null
	   */
	   public Customer findCustomerByCustomerNumber(Long customerNumber) {
		   
			for (Customer customer: customers) {
				if (customer
						.getCustomerNumber()
						.compareTo(customerNumber) 
						 == 0) {
					return customer;
				}
			}
		   return null;
	    }
	
	/**
	 * Create customers from file.
	 */
	public void createCustomersFromFile() { 
	    customers = new ArrayList<>();
		File file;
		file = new File("src/test/resources/Customers");
		Long customerNumber;
		int pin;
		String surname;
		String familyname;
		String name;
		Long personId;
		Customer customer;
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				surname = scanner.next();
				familyname = scanner.next();
				name = surname + familyname;
				personId = scanner.nextLong();
				customerNumber = scanner.nextLong();
				pin = scanner.nextInt();
				customer = 
				  new Customer(name, personId, 
					customerNumber, pin);
			    customers.add(customer);
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("File not found");
		} finally {
			if (scanner != null)  {
			   scanner.close();
		    }
		}	
	}
}

