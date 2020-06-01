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

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIT  {
	
	
	 @LocalServerPort
	 private  int localServerPort;
	 private String url;
	 private static Logger logger = LogManager.getLogger(CustomerControllerIT.class);
	 
  @BeforeEach
  void setUp()  {
	url =  "http://localhost:" + localServerPort;
	logger.info("url: " + url, keyValue("category", "component"));	
  }
  
  @Autowired
  private WebApplicationContext webApplicationContext;
  
  
   
  @MockBean
	private CustomerService service;
  
  

  @Test
  void shoulCreatCustomer() throws JSONException {
	  
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
         .post(url + "/customer")
       .then()
          .statusCode(CREATED.value())
          .body("personId", equalTo(personId));
	   
	    given()
	      .webAppContextSetup(webApplicationContext)
	    .when()
          .get(url + "/customer/{personId}",personId)
        .then()
          .statusCode(OK.value())
	      .body("personId", equalTo(personId));
	   
	   logger.info("end integration test should create customer " ,keyValue("category", "component"));
  } 
  
  @Test
  void shoulGetCustomerDetails() throws JSONException {
	   Long personId = 26076144444L;
	   given()
	      .webAppContextSetup(webApplicationContext)
	   .when()
        .get(url + "/customer/{personId}",personId)
      .then()
        .statusCode(OK.value())
	    .body("personId", equalTo(personId));
      
  } 
  
 }


