package org.steinko.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;
import static io.restassured.http.ContentType.JSON;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;

import org.json.JSONObject;
import org.json.JSONException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;


public class CustomerControllerTest {
	
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LogManager.getLogger(CustomerControllerTest.class);
	
	
	@Test
	  public void shouldCreateCustomer() throws JSONException {
	    
	    String url = "/customer";
	    JSONObject  body =  new  JSONObject();
	    body.put("personId","26076144574");
	     logger.info("test should create customer" + body.toString(),keyValue("category", "component"));
	    given()
	     .standaloneSetup(new CustomerController())
	     .contentType("application/json")
	     .body(body.toString()).
	    when()
	       .post(url).
	    then()
	        .statusCode(CREATED.value());
	  }
	
	@Disabled
	@Test
	  public void shouldThrowExeption() throws JSONException {
	    
	    String url = "/customer";
	    JSONObject  body =  new  JSONObject();
	    body.put("personId","26076144444");
	    logger.info("test should throw exception" + body.toString(),keyValue("category", "component"));
	    given()
	     .standaloneSetup(new CustomerController())
	     .contentType("application/json")
	     .body(body.toString()).
	    when()
	       .post(url).
	    then()
	        .statusCode(CONFLICT.value());
	  }
	
	@Test
	  void shoulGetCustomerDetails() throws JSONException {
		   
		   given()
		      .standaloneSetup(new CustomerController())
		   .when()
	        .get("customer/{personId}", 26076144574L)
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	@Test
	  void shoulDeletCustomer() throws JSONException {
		   
		   given()
		      .standaloneSetup(new CustomerController())
		   .when()
	        .delete("customer/{personId}", 26076144574L)
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	@Test
	  void shoulUpdateCustomer() throws JSONException {
		  
		JSONObject  body =  new  JSONObject();
	    body.put("personId","26076144444");
		   given()
		      .standaloneSetup(new CustomerController())
		      .contentType("application/json")
			  .body(body.toString())
		   .when()
	        .put("customer/{personId}", 26076144574L)
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	

}
