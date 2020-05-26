package org.steinko.bank;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	
	/**
	    * Build a Swagger.
	    * @return Swagger bean
	    */
	   @Bean
	   public Docket api() { 
	       return new Docket(DocumentationType.SWAGGER_2)  
	         .select()                                  
	         .apis(RequestHandlerSelectors.any())              
	         .paths(PathSelectors.any())                          
	         .build();                                           
	   }

}
