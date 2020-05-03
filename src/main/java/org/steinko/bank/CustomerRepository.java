package org.steinko.bank;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

}
