package com.ryjios.ms.sensor.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryjios.ms.sensor.entity.BaseSensorData;
import com.ryjios.ms.sensor.entity.CO2SensorData;

@Repository
public interface SensorRepository extends JpaRepository<CO2SensorData, Integer> {

}
