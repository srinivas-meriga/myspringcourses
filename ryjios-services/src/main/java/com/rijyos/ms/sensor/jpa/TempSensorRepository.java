package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.TempSensorData;

@Repository
public interface TempSensorRepository extends JpaRepository<TempSensorData, Integer> {
    
    public List<TempSensorData> findByDeviceId(Integer deviceId);

}
