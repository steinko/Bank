package org.steinko.bank.bankaccount;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.http.ContentType.JSON;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
;

import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.when;


	
	@ExtendWith(SpringExtension.class)
	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	public class BankAccountControllerIT {
		
		
	@LocalServerPort
	 private  int localServerPort;
	 private String url;
	private static Logger logger = LogManager.getLogger(BankAccountControllerIT.class);
		 
   @BeforeEach
	void setUp()  {
		url =  "http://localhost:" + localServerPort;
		logger.info("url: " + url, keyValue("category", "component"));	
	  }
	  
	  @Autowired
	  private WebApplicationContext webApplicationContext;
	  
	  
	   
	  @MockBean
	  private BankAccountService service;
	  
	  

	  @Test
	  void shoulGetBackAccount() {
		  
		   logger.info("start integration test should bank account " ,keyValue("category", "component"));
		   
		   Long personId = 26076144574L;
		   Integer amount = 400;
		   BankAccount savingAccount = new BankAccount(amount);
		   
		   when(service.getSavingsAccount(personId)).thenReturn(savingAccount);
			 
		   given()
		    .webAppContextSetup(webApplicationContext)
		   .when()
	          .get("/savingsaccount/{personId}", personId)
	       .then()
	         .statusCode(OK.value());
		   logger.info("end integration test should bank account " ,keyValue("category", "component"));
	  } 
	  

}
