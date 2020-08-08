package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.COSensorData;

@Repository
public interface COSensorRepository extends JpaRepository<COSensorData, Integer> {
    
    public List<COSensorData> findByDeviceId(Integer deviceId);

}
