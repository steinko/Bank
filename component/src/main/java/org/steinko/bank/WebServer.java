package org.steinko.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Manage the running of the bank component.
*/
@EnableSwagger2
@SpringBootApplication
public class WebServer {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LogManager.getLogger(WebServer.class);
	
   /**
    * Stating the component.
    * @param args arguments
    */
   public static void main(String[] args) {
	   logger.info("Start bank spring component");
       SpringApplication.run(WebServer.class, args);
   }
   
   /**
    * Create bank. 
    * @param bankRepository bank repository
    * @return command line runner
    */
   @Bean
   public CommandLineRunner createBank(BankRepository bankRepository) {
   
	   return args -> {
	    Bank bank = new Bank();
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
   
   /**
    * Build a Swagger.
    * @return Swagger bean
    */
   @Bean
   public Docket api() { 
       return new Docket(DocumentationType.SWAGGER_2)  
         .select()                                  
         .apis(RequestHandlerSelectors.any())              
         .paths(PathSelectors.any())                          
         .build();                                           
   }

}
