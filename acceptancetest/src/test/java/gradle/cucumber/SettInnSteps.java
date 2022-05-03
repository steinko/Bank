package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONObject;


public class SettInnSteps {
	
	private Long personId;
	
	@Given("Jer person med person id {string}")
	public void jer_person_med_person_id(String personId) { 
		
		
		   long lpersonId=Long.parseLong(personId);  
		   this.personId = lpersonId;
		 
		   JSONObject person = new JSONObject();
		   person.put("personId",this.personId);
		   String body = person.toJSONString();
		 
		   given().
		      contentType("application/json").
		      body(body). 
		   when().
	          post("http://localhost:9001/customer").  
	       then().
	          statusCode(201);
		   
		   
	}

	

	@Given("Jeg har {int} kr på sparekonto")
	public void jeg_har_kr_på_sparekonto(Integer balance) {
		
		Integer amount;
		amount = 400;
		
		given().
		  pathParam("personId", this.personId). 
		  pathParam("amount", amount). 
	    when().
          put("http://localhost:9001/savingsaccount/{personId}/{amount}").  
        then().
          statusCode(200); 
		
		given().
		  pathParam("personId", this.personId). 
	    when().
           get("http://localhost:9001/savingsaccount/{personId}").  
        then().
           statusCode(200).
           body("balance",equalTo(balance));
	}
	

	@When("jeg setter inn {int} kr")
	public void jeg_setter_inn_kr(Integer amount) {
		
	    given().
		  pathParam("personId", this.personId). 
		  pathParam("amount", amount).
	    when().
          put("http://localhost:9001/savingsaccount/{personId}/{amount}").  
        then().
          statusCode(200);  
	}

	
	@Then("kontoen skal ha en saldo på {int} kr")
	public void kontoen_skal_ha_en_saldo_på_kr(Integer balance) {
		
		given().
		  pathParam("personId", this.personId). 
	    when().
          get("http://localhost:9001/savingsaccount/{personId}").  
        then().
          statusCode(200).
          body("balance",equalTo(balance));
	}


}
