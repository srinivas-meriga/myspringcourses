package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.SO2SensorData;

@Repository
public interface SO2SensorRepository extends JpaRepository<SO2SensorData, Integer> {
    
    public List<SO2SensorData> findByDeviceId(Integer deviceId);

}
