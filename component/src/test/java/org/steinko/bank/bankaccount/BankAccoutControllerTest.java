package org.steinko.bank.bankaccount;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;
import static io.restassured.http.ContentType.JSON;

import static org.springframework.http.HttpStatus.OK;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.equalTo;



@ExtendWith(MockitoExtension.class)
public class BankAccoutControllerTest {
	
	
    @InjectMocks
	BankAccountController controller;
	
	@Mock
	BankAccountService service;
	
	
	
	@Test
	void getSavingBankAccount() {
		  Long personId = 26076144574L;
		  Integer amount = 400;
		  BankAccount savingAccount = new BankAccount(amount);
		  when(service.getSavingsAccount(personId)).thenReturn(savingAccount);
		 
		  given()
	        .standaloneSetup(controller)
	      .when()
            .get("/savingsaccount/{personId}", personId)
          .then()
             .statusCode(OK.value())
             .body("balance",equalTo(amount)); 
	}
	
	
	@Test
	void depositToSavingsBankAccount() {
		  Long personId = 26076144574L;
		  Integer amount = 400;
		  BankAccount savingAccount = new BankAccount(700);
		 
		  when(service.depositToSavingsAccount(personId,amount)).thenReturn(savingAccount);
		 
		  given()
	        .standaloneSetup(controller)
	      .when()
            .put("/savingsaccount/{personId}/{amount}", personId, amount)
          .then()
            .statusCode(OK.value())
            .body("balance",equalTo(700)); 
	}
	

}
