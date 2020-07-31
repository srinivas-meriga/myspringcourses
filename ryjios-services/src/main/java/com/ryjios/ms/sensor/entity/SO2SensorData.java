package com.ryjios.ms.sensor.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ryjios.ms.device.entity.MonitoringDevice;

public class SO2SensorData extends BaseSensorData {
    
    @Id
    @GeneratedValue
    private Integer id;
        
    @ManyToOne(fetch=FetchType.LAZY)
    private MonitoringDevice device;
    
    public SO2SensorData(BigDecimal reading, Timestamp capturedTime, String status) {
        super(reading, capturedTime, status);
        
    }


    public SO2SensorData(BigDecimal reading, Timestamp capturedTime, String status, Integer id,
            MonitoringDevice device) {
        super(reading, capturedTime, status);
        this.id = id;
        this.device = device;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
    

}
