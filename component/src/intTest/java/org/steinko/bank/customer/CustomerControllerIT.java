package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.hamcrest.CoreMatchers.equalTo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;


import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import org.json.JSONObject;
import org.json.JSONException;

import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomerControllerIT  {
	
  private static Logger logger = LogManager.getLogger(CustomerControllerIT.class);
	 
  @Autowired
  private WebApplicationContext webApplicationContext;
   

  @Test
  void shoulCreateCustomer() throws JSONException {
	  
	   logger.info("start integration test should create customer " ,keyValue("category", "component"));
	   Long personId = 26076144574L;
	   CustomerDto body = new CustomerDto();
	   body.setPersonId(personId);
	      
	   logger.info("person Id: " + body.toString(),keyValue("category", "component"));
	   
	   given()
	      .webAppContextSetup(webApplicationContext)
	      .contentType("application/json")
	      .body(body)
	   .when()
         .post("/customer")
       .then()
          .statusCode(CREATED.value())
          .body("personId", equalTo(personId));
	   
	    given()
	      .webAppContextSetup(webApplicationContext)
	    .when()
          .get( "/customer/{personId}",personId)
        .then()
          .statusCode(OK.value())
	      .body("personId", equalTo(personId));
	   
	   logger.info("end integration test should create customer " ,keyValue("category", "component"));
  } 
  
  @Test
  void shoulNotFindCustomer() throws JSONException {
	  
	   logger.info("start integration test should not find customer " ,keyValue("category", "component"));
	   Long personId = 26076144574L;
	   CustomerDto body = new CustomerDto();
	   body.setPersonId(personId);
	      
	   logger.info("person Id: " + body.toString(),keyValue("category", "component"));
	   
	   given()
	      .webAppContextSetup(webApplicationContext)
	      .contentType("application/json")
	      .body(body)
	   .when()
         .post("/customer")
       .then()
          .statusCode(CREATED.value())
          .body("personId", equalTo(personId));
	   
	    given()
	      .webAppContextSetup(webApplicationContext)
	    .when()
          .get( "/customer/{26076144533}",personId)
        .then()
          .statusCode(OK.value()).
          .body("personId", equalTo(null));
	   
	   logger.info("end integration test should create customer " ,keyValue("category", "component"));
  } 
  
  @Test
  void shoulGetCustomerDetails() throws JSONException {
	   Long personId = 26076144444L;
	   given()
	      .webAppContextSetup(webApplicationContext)
	   .when()
        .get( "/customer/{personId}",personId)
      .then()
        .statusCode(OK.value())
	    .body("personId", equalTo(personId));
      
  } 
  
  @Test
  void shoulDeliverCustomers() throws JSONException {
	  
	   logger.info("start integration test should deliver customers " ,keyValue("category", "component"));
	   Long personId = 26076144574L;
	   CustomerDto person1 = new CustomerDto(personId);
	   
	   personId = 26076144575L;
	   CustomerDto person2 = new CustomerDto(personId);
	   
	   CustomersDto customers = new CustomersDto();
	   customers.add(person1);
	   customers.add(person2);
	      
	   logger.info("person Id: " + body.toString(),keyValue("category", "component"));
	   
	   given()
	      .webAppContextSetup(webApplicationContext)
	      .contentType("application/json")
	      .body(person1)
	   .when()
         .post("/customer")
       .then()
          .statusCode(CREATED.value());
          
	   given()
	      .webAppContextSetup(webApplicationContext)
	      .contentType("application/json")
	      .body(person2)
	   .when()
      .post("/customer")
    .then()
       .statusCode(CREATED.value());
       
	   
	    given()
	      .webAppContextSetup(webApplicationContext)
	    .when()
          .get( "/customer")
        .then()
          .statusCode(OK.value())
	      .body( equalTo(customers));
	   
	   logger.info("end integration test should deliver customers " ,keyValue("category", "component"));
  } 
  
 }


