package com.rijyos.ms.device.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.user.User;

@Entity
public class MonitoringDevice {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String deviceId;

    private String deviceMacId;

    private String deviceName;

    private String userId;

    
}
