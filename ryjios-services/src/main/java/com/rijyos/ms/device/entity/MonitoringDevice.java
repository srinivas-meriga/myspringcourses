package com.rijyos.ms.device.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.user.User;

@Entity
public class MonitoringDevice {
    
    @Id
    @GeneratedValue
    private Integer id;

    private String deviceId;
    
    private String deviceName;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;
    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<COSensorData> coSensor;
    
    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<CO2SensorData> co2Sensor;
    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<NO2SensorData> no2Sensor;
//    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<SO2SensorData> so2Sensor;
//    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<H2SSensorData> h2sSensor;
//    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<VOCSensorData> vocSensor;
//    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<RHSensorData> rhSensor;
//    
//    @OneToMany(mappedBy = "device")
//    @JsonIgnore
//    private List<PMSensorData> pmSensor;

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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

//    /**
//     * @return the coSensor
//     */
//    public List<COSensorData> getCoSensor() {
//        return coSensor;
//    }
//
//    /**
//     * @param coSensor the coSensor to set
//     */
//    public void setCoSensor(List<COSensorData> coSensor) {
//        this.coSensor = coSensor;
//    }

    /**
     * @return the co2Sensor
     */
    public List<CO2SensorData> getCo2Sensor() {
        return co2Sensor;
    }

    /**
     * @param co2Sensor the co2Sensor to set
     */
    public void setCo2Sensor(List<CO2SensorData> co2Sensor) {
        this.co2Sensor = co2Sensor;
    }

//    /**
//     * @return the no2Sensor
//     */
//    public List<NO2SensorData> getNo2Sensor() {
//        return no2Sensor;
//    }
//
//    /**
//     * @param no2Sensor the no2Sensor to set
//     */
//    public void setNo2Sensor(List<NO2SensorData> no2Sensor) {
//        this.no2Sensor = no2Sensor;
//    }
//
//    /**
//     * @return the so2Sensor
//     */
//    public List<SO2SensorData> getSo2Sensor() {
//        return so2Sensor;
//    }
//
//    /**
//     * @param so2Sensor the so2Sensor to set
//     */
//    public void setSo2Sensor(List<SO2SensorData> so2Sensor) {
//        this.so2Sensor = so2Sensor;
//    }
//
//    /**
//     * @return the h2sSensor
//     */
//    public List<H2SSensorData> getH2sSensor() {
//        return h2sSensor;
//    }
//
//    /**
//     * @param h2sSensor the h2sSensor to set
//     */
//    public void setH2sSensor(List<H2SSensorData> h2sSensor) {
//        this.h2sSensor = h2sSensor;
//    }
//
//    /**
//     * @return the vocSensor
//     */
//    public List<VOCSensorData> getVocSensor() {
//        return vocSensor;
//    }
//
//    /**
//     * @param vocSensor the vocSensor to set
//     */
//    public void setVocSensor(List<VOCSensorData> vocSensor) {
//        this.vocSensor = vocSensor;
//    }
//
//    /**
//     * @return the rhSensor
//     */
//    public List<RHSensorData> getRhSensor() {
//        return rhSensor;
//    }
//
//    /**
//     * @param rhSensor the rhSensor to set
//     */
//    public void setRhSensor(List<RHSensorData> rhSensor) {
//        this.rhSensor = rhSensor;
//    }
//
//    /**
//     * @return the pmSensor
//     */
//    public List<PMSensorData> getPmSensor() {
//        return pmSensor;
//    }
//
//    /**
//     * @param pmSensor the pmSensor to set
//     */
//    public void setPmSensor(List<PMSensorData> pmSensor) {
//        this.pmSensor = pmSensor;
//    }

    

    
    
    
}
