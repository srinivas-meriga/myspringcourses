package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.NO2SensorData;

@Repository
public interface NO2SensorRepository extends JpaRepository<NO2SensorData, Integer> {
    
    public List<NO2SensorData> findByDeviceId(Integer deviceId);

}
