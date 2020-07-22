package com.stanley.rest.ws.restfuldemo.user.exception;
import java.util.Date;

public class ExceptionResponse {
    
    private Date timeOfOccurance;
    
    private String message;
    
    private String details;

    public ExceptionResponse(Date timeOfOccurance, String message, String details) {
        super();
        this.timeOfOccurance = timeOfOccurance;
        this.message = message;
        this.details = details;
    }

    /**
     * @param timeOfOccurance the timeOfOccurance to set
     */
    public void setTimeOfOccurance(Date timeOfOccurance) {
        this.timeOfOccurance = timeOfOccurance;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return the timeOfOccurance
     */
    public Date getTimeOfOccurance() {
        return timeOfOccurance;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }
    
    


}
