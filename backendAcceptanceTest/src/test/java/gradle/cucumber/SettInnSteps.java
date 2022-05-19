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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SettInnSteps {
	
	
	/**
	 * person id.
	 */
	private Long personId;
	
	/**
	 * Backen url.
	 */
	private String backendUrl;
	
	/**
	 * Logger.
	 */
	 private static Logger logger = 
			LoggerFactory.getLogger(SettInnSteps.class);
	
   
	
	@Given("Jer person med person id {string}")
	public void jer_person_med_person_id(String personId) throws Exception { 
		   
		   this.backendUrl = System.getenv("BACKEND_URL");
		   logger.info("Backend url: " + this.backendUrl);
    	   if (backendUrl==null) throw new Exception("No envioment variable");
		
		   long lpersonId=Long.parseLong(personId);  
		   this.personId = lpersonId;
		 
		   JSONObject person = new JSONObject();
		   person.put("personId",this.personId);
		   String body = person.toJSONString();
		   String createCustomerUrl = this.backendUrl + "/customer";
		   logger.info("Create customer url: " + createCustomerUrl);
		 
		   given().
		      contentType("application/json").
		      body(body). 
		   when().
	          post(createCustomerUrl).  
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
          put(this.backendUrl + "/savingsaccount/{personId}/{amount}").  
        then().
          statusCode(200); 
		
		given().
		  pathParam("personId", this.personId). 
	    when().
           get(this.backendUrl + "/savingsaccount/{personId}").  
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
          put(this.backendUrl + "/savingsaccount/{personId}/{amount}").  
        then().
          statusCode(200);  
	}

	
	@Then("kontoen skal ha en saldo på {int} kr")
	public void kontoen_skal_ha_en_saldo_på_kr(Integer balance) {
		
		given().
		  pathParam("personId", this.personId). 
	    when().
          get( this.backendUrl + "/savingsaccount/{personId}").  
        then().
          statusCode(200).
          body("balance",equalTo(balance));
	}


}
