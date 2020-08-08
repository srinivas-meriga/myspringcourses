package com.rijyos.ms.sensor.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class COSensorData {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String readingId;

    private String deviceId;

    private BigDecimal reading;

    private Timestamp capturedTime;

    private String status;

    public COSensorData() {

    }

    public COSensorData(String readingId, String deviceId, BigDecimal reading, Timestamp capturedTime, String status) {
        super();
        this.readingId = readingId;
        this.deviceId = deviceId;
        this.reading = reading;
        this.capturedTime = capturedTime;
        this.status = status;
    }

    /**
     * @return the readingId
     */
    public String getReadingId() {
        return readingId;
    }

    /**
     * @param readingId the readingId to set
     */
    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    @Override
    public String toString() {
        return "COSensorData [readingId=" + readingId + ", deviceId=" + deviceId + ", reading=" + reading
                + ", capturedTime=" + capturedTime + ", status=" + status + "]";
    }

}
