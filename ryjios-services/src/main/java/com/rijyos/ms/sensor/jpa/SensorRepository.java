package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;

@Repository
public interface SensorRepository extends JpaRepository<CO2SensorData, Integer> {
    
    public List<CO2SensorData> findByDeviceId(Integer deviceId);

}
