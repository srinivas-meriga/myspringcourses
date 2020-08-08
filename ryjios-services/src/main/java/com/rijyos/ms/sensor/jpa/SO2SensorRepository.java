package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.SO2SensorData;

@Repository
public interface SO2SensorRepository extends JpaRepository<SO2SensorData, String> {
    
    public List<SO2SensorData> findByDeviceId(String deviceId);
    
    public SO2SensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
