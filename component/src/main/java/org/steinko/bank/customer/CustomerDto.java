package org.steinko.bank.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;
import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty; 

/**
 * Customer Data Transformation Object.
 */
public class CustomerDto {
	
	
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerDto.class);
	
	
	/**
	 * person id.
	 */
	private Long personId;
	
	
	/**
	 * Creator for object.
	 */
	public CustomerDto() {
		
	}
	
	
	/**
	 * Create Json format.
	 * @param personId person id.
	 */
	@JsonCreator
	public CustomerDto(@JsonProperty("personId")  Long personId) {
	   this.personId =  personId;
	}
	
	/**
	 * Get person id.
	 * @return person id.
	 */
	public Long getPersonId() {
		logger.info("getPersonId personId: " + personId + " {}", 
				keyValue("category", "component"));
		return personId;
	}
	
	/**
	 * Set customer id.
	 * @param personId customers person id
	 */
	public void setPersonId(Long personId) {
		logger.info("setPersonId personid: " 
	   + personId, keyValue("category", "component"));
		this.personId = personId;
	}
	
	/**
	 * Get attribute as string.
	 */
	@Override
	public String toString() {
		return "personId: " + personId.toString();
	}
	
	

}
