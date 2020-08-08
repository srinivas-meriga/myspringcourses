package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.H2SSensorData;

@Repository
public interface H2SSensorRepository extends JpaRepository<H2SSensorData, Integer> {
    
    public List<H2SSensorData> findByDeviceId(Integer deviceId);

}
