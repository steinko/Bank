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
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import static org.hamcrest.Matchers.equalTo;

	

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
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
	  
	  
	 @Test
	 void shoulGetBackAccount() {
		 
		   logger.info("start integration test should bank account " ,keyValue("category", "component"));  
		   Long personId = 26076144574L;
		   Integer amount = 400; 
		   logger.info("start integration test should create customer " ,keyValue("category", "component"));
		
		   CustomerDto body = new CustomerDto();
		   body.setPersonId(personId);
		    
		   logger.info("person Id: " + body.toString(),keyValue("category", "component"));
		   
		   given()
		      .webAppContextSetup(webApplicationContext)
		      .contentType("application/json")
		      .body(body)
		   .when()
	          .post(url + "/customer")
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
		    
		   logger.info("end integration test should bank account " ,keyValue("category", "component"));
	  } 
	  

}
