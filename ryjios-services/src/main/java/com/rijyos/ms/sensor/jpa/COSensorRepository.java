package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.entity.COSensorData;

@Repository
public interface COSensorRepository extends JpaRepository<COSensorData, String> {
    
    public List<COSensorData> findByDeviceId(String deviceId);
    
    public COSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
