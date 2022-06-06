package org.steinko.bank;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class StreamLamdaHandler implements RequestStreamHandler {
	
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
}
