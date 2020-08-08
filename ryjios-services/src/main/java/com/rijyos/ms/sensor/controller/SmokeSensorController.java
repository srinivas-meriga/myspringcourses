package com.rijyos.ms.sensor.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
import com.rijyos.ms.sensor.entity.SmokeSensorData;
import com.rijyos.ms.sensor.jpa.SmokeSensorRepository;
import com.rijyos.ms.user.UserRepository;

@RestController
public class SmokeSensorController {

    @Autowired(required = true)
    public UserRepository userRepository;

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    public SmokeSensorRepository smokeSensorRepository;

    // ============================= Smoke =========================================

    // Capture Smoke Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/smoke/{deviceCode}")
    public ResponseEntity<Object> createSmokeReadingEntry(@Valid @RequestBody SmokeSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        SmokeSensorData savedReading = smokeSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{deviceId}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All smoke readings for a device
    @GetMapping(path = "/rjam/sensors/smoke/{deviceId}")
    public List<SmokeSensorData> retrieveAllSmokeReadings(@Valid @PathVariable String deviceId) {
        return smokeSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest Smoke reading Details for a device
    @GetMapping(path = "/rjam/sensors/smoke/latest/{deviceId}")
    public SmokeSensorData retrieveLatestSmokeReadings(@Valid @PathVariable String deviceId) {
        return smokeSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }
}