package com.ryjios.ms.sensor.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryjios.ms.device.entity.MonitoringDevice;

public abstract class BaseSensorData {
    
   
    private BigDecimal reading;
    
    private Timestamp capturedTime;
    
    private String status;
    
    public void BaseSensor() {
        
    }

    

    public BaseSensorData(BigDecimal reading, Timestamp capturedTime, String status) {
        super();
        this.reading = reading;
        this.capturedTime = capturedTime;
        this.status = status;
    }



    /**
     * @return the reading
     */
    public BigDecimal getReading() {
        return reading;
    }

    /**
     * @param reading the reading to set
     */
    public void setReading(BigDecimal reading) {
        this.reading = reading;
    }

    /**
     * @return the capturedTime
     */
    public Timestamp getCapturedTime() {
        return capturedTime;
    }

    /**
     * @param capturedTime the capturedTime to set
     */
    public void setCapturedTime(Timestamp capturedTime) {
        this.capturedTime = capturedTime;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
