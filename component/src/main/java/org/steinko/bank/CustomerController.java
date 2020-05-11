package org.steinko.bank;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import  org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController("customerController")
public class CustomerController {
	private static Logger logger = LogManager.getLogger(CustomerController.class);
	
	public CustomerController() {
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value= "/customer")
	public void createCustomer() {

	}
}