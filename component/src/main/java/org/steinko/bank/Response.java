package org.steinko.bank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Respons.
 *
 */
public class Response {
	/**
	 * Sucess.
	 */
    @JsonProperty("success")
    private boolean success;
    
    /**
     * Message.
     */
    @JsonProperty("message")
    private String message;
    
    /**
     * Creator.
     * @param success sucess
     * @param message message
     */

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}