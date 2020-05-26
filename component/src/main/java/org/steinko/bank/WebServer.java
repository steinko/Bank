package org.steinko.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Manage the running of the bank component.
*/

@SpringBootApplication
public class WebServer {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LogManager.getLogger(WebServer.class);
	
   /**
    * Stating the component.
    * @param args arguments
    */
   public static void main(String[] args) {
	   logger.info("Start bank spring component");
       SpringApplication.run(WebServer.class, args);
   }
   
}
