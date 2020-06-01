package org.steinko.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.steinko.bank.customer.CustomerRepository;
import org.steinko.bank.customer.CustomerService;
import org.steinko.bank.customer.CustomerServiceImp;
import org.springframework.context.annotation.Bean;


@Configuration
public class BeanConfig {
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Bean
	  CustomerService customerService() {
		return new CustomerServiceImp(customerRepository);
		
	}
}
