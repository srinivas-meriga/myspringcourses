package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.HumiditySensorData;

@Repository
public interface HumiditySensorRepository extends JpaRepository<HumiditySensorData, String> {
    
    public List<HumiditySensorData> findByDeviceId(String deviceId);
    
    public HumiditySensorData findTop1ByDeviceIdOrderByCapturedTimeDesc(String deviceId);

}
