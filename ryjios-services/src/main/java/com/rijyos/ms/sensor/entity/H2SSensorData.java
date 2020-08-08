package com.rijyos.ms.sensor.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rijyos.ms.device.entity.MonitoringDevice;

@Entity
public class H2SSensorData {

    @Id
    @GeneratedValue
    private Integer h2sReadingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private MonitoringDevice device;

    private BigDecimal reading;

    private Timestamp capturedTime;

    private String status;

    public H2SSensorData() {

    }

    public H2SSensorData(BigDecimal reading, Timestamp capturedTime, String status, Integer id,
            MonitoringDevice device) {
        this.h2sReadingId = id;
        this.device = device;
        this.reading = reading;
        this.capturedTime = capturedTime;
        this.status = status;
    }

    

    /**
     * @return the readingId
     */
    public Integer getH2SReadingId() {
        return h2sReadingId;
    }

    /**
     * @param readinId the readinId to set
     */
    public void setH2SReadingId(Integer readingId) {
        this.h2sReadingId = readingId;
    }

    /**
     * @return the device
     */
    public MonitoringDevice getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(MonitoringDevice device) {
        this.device = device;
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
