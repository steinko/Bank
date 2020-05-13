package org.steinko.bank;

import org.junit.jupiter.api.Test;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.post;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.CONFLICT;


public class CustomerControllerTest {
	
	@Test
	  public void shouldCreateCustomer()  {
	    
	    String url = "/customer";
	    
	     
	    given()
	     .standaloneSetup(new CustomerController())
	     .param("personId","26076144574").
	    when()
	       .post(url).
	    then()
	        .statusCode(CREATED.value());
	  }
	
	
	@Test
	  public void shouldThrowExeption()  {
	    
	    String url = "/customer";
	    
	     
	    given()
	     .standaloneSetup(new CustomerController())
	     .param("personId","26076144444").
	    when()
	       .post(url).
	    then()
	        .statusCode(CONFLICT.value());
	  }
	
	
	

}
