package com.rijyos.ms.sensor.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rijyos.ms.device.entity.MonitoringDevice;
import com.rijyos.ms.device.jpa.MonitoringDeviceRepository;
import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.jpa.SensorRepository;
import com.rijyos.ms.user.UserRepository;

@RestController
public class SensorController {
    
    @Autowired(required = true)
    private UserRepository userRepository;
    
    @Autowired(required = true)
    private MonitoringDeviceRepository deviceRepository;
    
    @Autowired(required = true)
    private SensorRepository sensorRepository;
    
    
  //Capture Sensor Reading
    @PostMapping(path = "/rjam/sensors/{deviceCode}/{sensorType}/{reading}/{status}")
    public ResponseEntity<Object> createReadingEntry(@Valid @PathVariable String deviceCode, @PathVariable String sensorType, @PathVariable BigDecimal reading, @PathVariable String status) {
       
        CO2SensorData sensorData = new CO2SensorData();
        
        MonitoringDevice device = deviceRepository.findByDeviceId(deviceCode);
        sensorData.setDevice(device);
        sensorData.setReading(reading);
        sensorData.setStatus(status);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        CO2SensorData savedReading = sensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Capture Sensor Reading
    @PostMapping(path = "/rjam/sensors/{deviceCode}/{sensorType}")
    public ResponseEntity<Object> createReadingEntry(@Valid @RequestBody CO2SensorData sensorData, @PathVariable String deviceCode) {
       
        
        MonitoringDevice device = deviceRepository.findByDeviceId(deviceCode);
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        CO2SensorData savedReading = sensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    //Fetch Device Details
    @GetMapping(path = "/rjam/sensors/{deviceId}")
    public List<CO2SensorData> retrieveAllReadings(@Valid @PathVariable int deviceId) {
        return sensorRepository.findByDeviceId(deviceId);
    }

}
