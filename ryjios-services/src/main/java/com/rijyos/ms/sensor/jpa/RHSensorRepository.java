package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.RHSensorData;

@Repository
public interface RHSensorRepository extends JpaRepository<RHSensorData, String> {
    
    public List<RHSensorData> findByDeviceId(String deviceId);
    
    public RHSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
