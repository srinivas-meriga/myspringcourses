package com.ryjios.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryjios.ms.device.entity.MonitoringDevice;
import com.ryjios.ms.sensor.entity.CO2SensorData;

@Repository
public interface SensorRepository extends JpaRepository<CO2SensorData, Integer> {
    
    public List<CO2SensorData> findByDeviceId(Integer deviceId);

}
