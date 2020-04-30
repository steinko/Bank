package org.steinko.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
* Manage the running of the bank component.
*/
@SpringBootApplication
public class WebServer {

   /**
    * Stating the component.
    * @param args argiments
    */
   public static void main(String[] args) {
       SpringApplication.run(WebServer.class, args);
   }

}
