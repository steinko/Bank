package gradle.cucumber;

import io.cucumber.java8.En;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateCustomerSteps implements En {
	
	public CreateCustomerSteps() {
	
	Given("Customer number {int}", (Integer int1) -> {
	   
	});

	Given("customer name {string}", (String string) -> {
	   
	});

	Given("person number {long}", (Long int1) -> {
	   
	});

	Given("pin {int}", (Integer int1) -> {
	   
	});

	When("I create person", () -> {
		RestAssured.baseURI = "localhost:9001";
	     when().
         post("/customer").
        then().
          statusCode(201);   
	});

	Then("A customer is created in the bank", () -> {
	   
	});
	
	}

}
