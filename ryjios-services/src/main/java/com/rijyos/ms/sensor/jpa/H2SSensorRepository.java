package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.H2SSensorData;

@Repository
public interface H2SSensorRepository extends JpaRepository<H2SSensorData, String> {
    
    public List<H2SSensorData> findByDeviceId(String deviceId);
    
    public H2SSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
