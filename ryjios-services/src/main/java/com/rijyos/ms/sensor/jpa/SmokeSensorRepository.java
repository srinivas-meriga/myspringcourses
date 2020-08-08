package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.SmokeSensorData;

@Repository
public interface SmokeSensorRepository extends JpaRepository<SmokeSensorData, String> {
    
    public List<SmokeSensorData> findByDeviceId(String deviceId);
    
    public SmokeSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
