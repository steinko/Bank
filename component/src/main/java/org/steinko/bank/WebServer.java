

/**
 * Entrypoint to the backend API.
 */
package org.steinko.bank;


import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.HandlerAdapter;

import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.services.lambda.runtime.Context;

@SpringBootApplication
public class WebServer  implements RequestStreamHandler {
	
	/**
	 * Handler.
	 */
	private static final SpringBootLambdaContainerHandler<AwsProxyRequest, 
	                     AwsProxyResponse> HANDLER;

    static {
        try {
            HANDLER = SpringBootLambdaContainerHandler
            		.getAwsProxyHandler(WebServer.class);
        } catch (ContainerInitializationException e) {
            // if we fail here. 
        	// We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException(
            		"Could not initialize Spring Boot application", e);
        }
    }  
   
        /**
         * Handler Mapping Bean.
         * @return handler mapping.
         */
        @Bean
        public HandlerMapping handlerMapping() {
            return new RequestMappingHandlerMapping();
        }

        /**
         * Create required HandlerAdapter.
         * To avoid several 
         * default HandlerAdapter instances being created.
         * @return handler adapter
         */
        @Bean
        public HandlerAdapter handlerAdapter() {
            return new RequestMappingHandlerAdapter();
        }


        /**
         * 
         * @param inputStream input stream.
         * @param outputStream output stream.
         * @param context context.
         * @throws IOException exeption.
         */
        
        @Override
        public void handleRequest(InputStream inputStream, 
        		OutputStream outputStream, Context context) 
        		throws IOException {
                     HANDLER.proxyStream(inputStream, outputStream, context);
        }
   
	
	/**
	 * The start method for the entry point to the backend API.
	 * @param args arguments.
	 */
	
    public static void main(String[] args) {
    	SpringApplication.run(WebServer.class, args);	
    }
}
