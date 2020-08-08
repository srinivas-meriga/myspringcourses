package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.TempSensorData;

@Repository
public interface TempSensorRepository extends JpaRepository<TempSensorData, String> {
    
    public List<TempSensorData> findByDeviceId(String deviceId);
    
    public TempSensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
