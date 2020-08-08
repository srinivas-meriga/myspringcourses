package com.rijyos.ms.device.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijyos.ms.device.entity.MonitoringDevice;

@Repository
public interface MonitoringDeviceRepository extends JpaRepository<MonitoringDevice, Integer>{

    public List<MonitoringDevice> findByUserId(Integer userId);
    
    public Optional<MonitoringDevice> findByDeviceId(String deviceId);
}
