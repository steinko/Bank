package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

public class CreateCustomerSteps  {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CreateCustomerSteps.class);
	
	private Integer number;
	private String name;
	private Long personId;
	private Integer pin;
	
	@Given("Customer number {int}")
	public void customer_number(Integer number) {
	    this.number = number;
	}

	@Given("customer name {string}")
	public void customer_name(String name) {
	   this.name = name;
	}

	@Given("person id {long}")
	public void person_id(Long personId) {
	    this.personId = personId;
	}

	@Given("pin {int}")
	public void pin(Integer pin) {
	    this.pin = pin;
	}

	@When("I create person")
	public void i_create_person() {
		
        JSONObject  body =  new  JSONObject();
		
		try {	
			   body.put("personId",personId.toString());
			   body.put("name", name);
			   body.put("pin", pin.toString());
		    } catch (JSONException ex ) {
			   logger.info("Error in put personid" + " {}",keyValue("category", "component"));
			   throw new JSONException(ex);
			}
		
		given().
		  contentType("application/json").
		  body(body.toString()).
	     when().
           post("http://localhost:9001/customer").  
         then().
          statusCode(201);   
	}

	@Then("A customer is created in the bank")
	public void a_customer_is_created_in_the_bank() {
		given().
		  pathParam("personId", personId). 
	     when().
         get("http://localhost:9001/customer/{personId}").  
       then().
        statusCode(200);
		
	    
	}

	
	
}	
