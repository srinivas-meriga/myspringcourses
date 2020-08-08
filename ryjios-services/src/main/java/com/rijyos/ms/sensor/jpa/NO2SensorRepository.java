package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.NO2SensorData;

@Repository
public interface NO2SensorRepository extends JpaRepository<NO2SensorData, String> {
    
    public List<NO2SensorData> findByDeviceId(String deviceId);
    
    public NO2SensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
