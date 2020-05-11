package org.steinko.bank;

import org.junit.jupiter.api.Test;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.post;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;


public class CustomerControllerTest {
	
	@Test
	  public void shouldCreateCustomer()  {
	    
	    String url = "/customer";
	    
	     
	    given()
	     .standaloneSetup(new CustomerController()).
	    when()
	       .post(url).
	    then()
	        .statusCode(CREATED.value());
	  }
	
	

}
