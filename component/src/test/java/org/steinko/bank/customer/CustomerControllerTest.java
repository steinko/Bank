package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;
import static io.restassured.http.ContentType.JSON;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;

import java.text.ParseException;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.json.JSONObject;
import org.json.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;



@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerControllerTest.class);
	
	
	@Mock
	private CustomerService service;
	
	
	@InjectMocks
	CustomerController controller;
	
	@BeforeEach 
	public void setUp() {
		 RestAssuredMockMvc.standaloneSetup(controller);
		 
	}
	
	
	
	@Test
	  public void shouldCreateCustomer() throws JSONException {
		
		logger.info("start unit test should create customer " ,keyValue("category", "component"));
		Long personId = 26076144575L;
		Customer customer = new Customer("",personId,0L,0 );
		CustomerDto body = new CustomerDto();
	    body.setPersonId(personId);
	    
	    logger.info("CustomerDto.toString " + body.toString() ,keyValue("category", "component"));
	    
	    given(service.createCustomer(any(Customer.class))).willReturn(customer);
	    
	    String url = "/customer";
	    
	    given()
	     .contentType("application/json")
	     .body(body).
	    when()
	       .post(url).
	    then()
	        .assertThat()
	           .contentType("application/json")
	           .statusCode(CREATED.value())
	           .body("personId",equalTo(personId));
	    logger.info("end unit test should create customer " ,keyValue("category", "component"));
	  }
	
	
	@Test
	  void shoulGetCustomerDetails() throws JSONException {
		   Long personId = 26076144574L;
		   Customer customer = new Customer("",personId,0L,0 );
		   given(service.getCustomer(personId)).willReturn(customer);
		   
		   given()
		    //  .standaloneSetup(controller)
		   .when()
	        .get("customer/{personId}", personId)
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	@Test
	  void shoulDeletCustomer() throws JSONException {
		  
		   given()
		   //   .standaloneSetup(controller)
		   .when()
	        .delete("customer/{personId}", 26076144574L)
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	@Test
	  void shoulUpdateCustomer() throws JSONException {
		
		   Long personId = 26076144574L;
		   CustomerDto body =  new  CustomerDto();
	       body.setPersonId(personId);
	    
	       Customer customer = new Customer("",personId,0L,0 );
		   given(service.updateCustomer(any(Customer.class))).willReturn(customer);
	    
		   given()
		      .contentType("application/json")
			  .body(body)
		   .when()
	        .put("/customer")
	      .then()
	        .statusCode(OK.value());  
	  } 
	
	
	@Test 
	 void  shouldReurnPersonId() {
		Customer customer = new Customer( "", 26076144679L, 0L, 0);
		CustomerDto customerDto = controller.convertToDto(customer);
		assertEquals(customerDto.getPersonId(),26076144679L);
	}
	
	@Test 
	 void  shouldReurnCustomerWithPeronId() throws ParseException {
		CustomerDto customerDto  = new CustomerDto();
		customerDto.setPersonId(26076144679L);
		Customer customer = controller.convertToEntity(customerDto);
		assertEquals(customer.getPersonId(),26076144679L);
	}
	
	
	
	

}
