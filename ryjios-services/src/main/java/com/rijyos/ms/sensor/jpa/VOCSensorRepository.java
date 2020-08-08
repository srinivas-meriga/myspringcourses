package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.VOCSensorData;

@Repository
public interface VOCSensorRepository extends JpaRepository<VOCSensorData, Integer> {
    
    public List<VOCSensorData> findByDeviceId(Integer deviceId);

}
