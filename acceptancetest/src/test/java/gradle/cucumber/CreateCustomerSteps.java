package gradle.cucumber;

import io.cucumber.java8.En;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

public class CreateCustomerSteps implements En {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CreateCustomerSteps.class);
	
	
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
		
		try {	
			   JSONObject  body =  new  JSONObject();
			   body.put("personId","26076144574");
		    } catch (JSONException ex ) {
			   logger.info("Error in put personid" + " {}",keyValue("category", "component"));
			   throw new JSONException(ex);
			}
		
	     when().
         post("/customer").
         
        then().
          statusCode(201);   
	});

	Then("A customer is created in the bank", () -> {
	   
	});
	
	}

}
