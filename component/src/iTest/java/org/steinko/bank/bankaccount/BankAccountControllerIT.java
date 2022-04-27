package org.steinko.bank.bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.steinko.bank.customer.CustomerDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import static org.hamcrest.Matchers.equalTo;
import org.springframework.test.web.servlet.MockMvc;
	

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BankAccountControllerIT {
		
	
	 private static Logger logger = LogManager.getLogger(BankAccountControllerIT.class);
		 
	  
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	  
	 @Disabled
	 @Test
	 void shoulGetBackAccount() {
		 
		   logger.info("start integration test should bank account " );  
		   Long personId = 26076144574L;
		   Integer amount = 400; 
		   logger.info("start integration test should create customer " );
		
		   CustomerDto body = new CustomerDto();
		   body.setPersonId(personId);
		    
		   logger.info("person Id: " + body.toString());
		   
		   given()
		      .webAppContextSetup(webApplicationContext)
		      .contentType("application/json")
		      .body(body)
		   .when()
	          .post( "/customer")
	      .then()
	          .statusCode(CREATED.value());
		   
		   given()
		      .webAppContextSetup(webApplicationContext)
		   .when()
	          .get("/savingsaccount/{personId}", personId)
	       .then()
	         .assertThat()
	           .statusCode(OK.value())
	           .body("balance",equalTo(0));
		   
		    given()
		     .webAppContextSetup(webApplicationContext)
	        .when()
              .put("/savingsaccount/{personId}/{amount}", personId, amount)
            .then()
              .statusCode(OK.value())
              .body("balance",equalTo(amount)); 
		    
		   logger.info("end integration test should bank account " );
	  } 
	  

}
