package org.steinko.bank;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* An account that a customer has in a bank where he can manage money.
*/
@Entity
public final class BankAccount implements Serializable {

    private static final long serialVersionUID = -5979549426057649442L;

    /**
     * Identifies bank account.
     * Spring Boot JPA generates the id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The money on the account.
     */
    private int  balance;

    /**
    * Constructor.
    * @param amount inital amount
    */
    public    BankAccount(final int amount) {
       this.balance = amount;
    }

    /**
     * Hidden Constructor convention for @Entity.
     */
    protected BankAccount() { }

    /**
     * @return identifies bank account
     */
    public long getId() {
       return id;
    }

    /**
     * Place a amount on the account.
     * @param amount the amount placed on the account
     */
    public void gi(final int amount) {
        this.balance += amount;
    }

    /**
     * Tells how much money that are placed on the account.
     * @return the amount placed on the account
     */
    public int saldo() {
         return balance;
    }

    /**
     * Take money out of the account.
     * @param amount the amount to take out of the account
     */
    public void ta(final int amount) {
        this.balance -= amount;
    }
}
