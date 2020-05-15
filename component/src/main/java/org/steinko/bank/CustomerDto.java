package org.steinko.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;
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
	private String personId;
	
	/**
	 * Get person id
	 * @return person id
	 */
	public String getPersonId() {
		logger.info("personId: " + personId + " {}",keyValue("category", "component"));
		return personId;
	}
	
	/**
	 * Set customer id
	 * @param personId customers person id
	 */
	public void setPersonId(String personId) {
		logger.info("personId: " + personId,keyValue("category", "component"));
		this.personId = personId;
	}
	
	

}
