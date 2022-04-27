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
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.json.JSONObject;
import org.json.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerControllerTest.class);
	
	
	@Mock
	private CustomerRepository repository;
	
	
	@InjectMocks
	CustomerController controller;
	
	@BeforeEach 
	public void setUp() {
		 RestAssuredMockMvc.standaloneSetup(controller);
		 
	}
	
	
	
	@Test
	  public void shouldCreateCustomer() throws JSONException {
		
		logger.info("start unit test should create customer " );
		Long personId = 26076144575L;
		Customer customer = new Customer("",personId,0L,0 );
		CustomerDto body = new CustomerDto(personId);
	   
	    
	    logger.info("CustomerDto.toString " + body.toString() );
	    
	    given(repository.save(any(Customer.class))).willReturn(customer);
	    
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
	    logger.info("end unit test should create customer " );
	  }
	
	@Disabled
	@Test
	  void shoulGetCustomersDetails() throws JSONException,JsonProcessingException {
		   Long personId = 26076144574L;
		   List<Customer> customers = new ArrayList<Customer>();
		   Customer customer1 = new Customer("",personId,0L,0 );
		   Customer customer2 = new Customer("",26892844574L,0L,0 );
		   customers.add(customer1);
		   customers.add(customer2);
		   
		   
		   
		   //List<CustomerDto> customersDto = CustomerConverter.convertToDto(customers);
		   //String result = new ObjectMapper().writeValueAsString(customersDto);
		   String result = "";
		   
		   given(repository.findAll()).willReturn(customers);
		   
		   given()
		   .when()
	        .get("customer")
	      .then()
	      .body(is(equalTo(result)))
	        .statusCode(OK.value());  
	  } 
	
	@Test
	  void shoulGetCustomerDetails() throws JSONException {
		   Long personId = 26076144574L;
		   Customer customer = new Customer("",personId,0L,0 );
		   given(repository.findByPersonId(personId)).willReturn(customer);
		   
		   given()
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
		   CustomerDto body =  new  CustomerDto(personId);
	       
	       Customer customer = new Customer("",personId,0L,0 );
		   given(repository.save(any(Customer.class))).willReturn(customer);
	    
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
		Long personId = 26076144679L;
		CustomerDto customerDto  = new CustomerDto(personId);
	
		Customer customer = controller.convertToEntity(customerDto);
		assertEquals(customer.getPersonId(),personId);
	}
	
	
	
	

}
