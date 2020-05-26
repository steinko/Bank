package org.steinko.bank.customer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer Repository.
 */
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
	/**
	 * Find customer by person id.
	 * @param personId person id
	 * @return customer
	 */
   Customer findByPersonId(Long personId);
}
