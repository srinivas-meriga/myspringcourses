package com.rijyos.ms.sensor.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.sensor.entity.HumiditySensorData;

@Repository
public interface HumiditySensorRepository extends JpaRepository<HumiditySensorData, Integer> {
    
    public List<HumiditySensorData> findByDeviceId(Integer deviceId);

}