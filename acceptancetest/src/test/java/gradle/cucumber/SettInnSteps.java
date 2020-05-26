package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SettInnSteps {
	
	Long personId;
	String body;
	
	@Given("Jer person med person id {long}")
	public void jer_person_med_person_id(Long personId) {
	   this.personId = personId;
	}

	@Given("Jeg har {int} kr på sparekonto")
	public void jeg_har_kr_på_sparekonto(Integer balance) {
		given().
		  pathParam("personId", personId). 
	     when().
           get("http://localhost:9001/savingsaccount/{personId}").  
         then().
           statusCode(200).
           .body("balance",equalTo(balance));
	}

	@When("jeg setter inn {int} kr")
	public void jeg_setter_inn_kr(Integer amount) {
	 body =	 given().
		  pathParam("personId", personId). 
		  param("amount", amount).
	     when().
         put("http://localhost:9001/savingsaccount/{personId}").  
       then().
         statusCode(200).
         log().body();
         
	}

	@Then("kontoen skal ha en saldo på {int} kr")
	public void kontoen_skal_ha_en_saldo_på_kr(Integer int1) {
	   assertEquals(body, "{balance: 400");
	}


}
