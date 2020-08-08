package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.RHSensorData;

@Repository
public interface RHSensorRepository extends JpaRepository<RHSensorData, Integer> {
    
    public List<RHSensorData> findByDeviceId(Integer deviceId);

}
