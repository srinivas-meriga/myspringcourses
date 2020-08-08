package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.SmokeSensorData;

@Repository
public interface SmokeSensorRepository extends JpaRepository<SmokeSensorData, Integer> {
    
    public List<SmokeSensorData> findByDeviceId(Integer deviceId);

}
