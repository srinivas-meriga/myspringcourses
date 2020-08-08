package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.PMSensorData;
import com.rijyos.ms.sensor.entity.RHSensorData;

@Repository
public interface PMSensorRepository extends JpaRepository<PMSensorData, Integer> {
    
    public List<PMSensorData> findByDeviceId(Integer deviceId);

}
