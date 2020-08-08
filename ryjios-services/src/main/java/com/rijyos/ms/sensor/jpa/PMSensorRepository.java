package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.PMSensorData;

@Repository
public interface PMSensorRepository extends JpaRepository<PMSensorData, String> {
    
    public List<PMSensorData> findByDeviceId(String deviceId);
    
    public PMSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
