package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.VOCSensorData;

@Repository
public interface VOCSensorRepository extends JpaRepository<VOCSensorData, String> {
    
    public List<VOCSensorData> findByDeviceId(String deviceId);
    
    public VOCSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
