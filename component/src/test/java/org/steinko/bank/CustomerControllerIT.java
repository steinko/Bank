package org.steinko.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIT  {
	
	
	 @LocalServerPort
	 private  int localServerPort;
	 private String url;
	 private static Logger logger = LogManager.getLogger(CustomerControllerIT.class);
	 
  @BeforeEach
  void setUp()  {
	url =  "http://localhost:" + localServerPort + "/customer";
	logger.info(url);	
  }
  
  @Autowired
  private WebApplicationContext webApplicationContext;
   
  

  @Test
  void shoulCreatCustomer() throws JsonProcessingException{
	  
	   
	   given()
	      .webAppContextSetup(webApplicationContext)
	   .when()
        .post(url)
      .then()
        .statusCode(CREATED.value());
      
  } 
 }


