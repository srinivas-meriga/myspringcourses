package com.rijyos.ms.device.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MonitoringDevice {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String deviceId;

    private String deviceMacId;

    private String deviceName;

    private String userId;

    private Date registredDate;

    private Date modifiedDate;

    public MonitoringDevice() {

    }

    public MonitoringDevice(String deviceId, String deviceMacId, String deviceName, String userId, Date registredDate,
            Date modifiedDate) {
        super();
        this.deviceId = deviceId;
        this.deviceMacId = deviceMacId;
        this.deviceName = deviceName;
        this.userId = userId;
        this.registredDate = registredDate;
        this.modifiedDate = modifiedDate;
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
     * @return the deviceMacId
     */
    public String getDeviceMacId() {
        return deviceMacId;
    }

    /**
     * @param deviceMacId the deviceMacId to set
     */
    public void setDeviceMacId(String deviceMacId) {
        this.deviceMacId = deviceMacId;
    }

    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the registredDate
     */
    public Date getRegistredDate() {
        return registredDate;
    }

    /**
     * @param registredDate the registredDate to set
     */
    public void setRegistredDate(Date registredDate) {
        this.registredDate = registredDate;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "MonitoringDevice [deviceId=" + deviceId + ", deviceMacId=" + deviceMacId + ", deviceName=" + deviceName
                + ", userId=" + userId + ", registredDate=" + registredDate + ", modifiedDate=" + modifiedDate + "]";
    }

    

}
