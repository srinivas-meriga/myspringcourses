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
import com.rijyos.ms.sensor.entity.RHSensorData;
import com.rijyos.ms.sensor.jpa.RHSensorRepository;

@RestController
public class RHSensorController {
    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private RHSensorRepository rhSensorRepository;

    // ============================= RH =========================================

    // Capture RH Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/rh/{deviceCode}")
    public ResponseEntity<Object> createRHReadingEntry(@Valid @RequestBody RHSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        RHSensorData savedReading = rhSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All RH readings for a device
    @GetMapping(path = "/rjam/sensors/rh/{deviceId}")
    public List<RHSensorData> retrieveAllRHReadings(@Valid @PathVariable String deviceId) {
        return rhSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest RH reading Details for a device
    @GetMapping(path = "/rjam/sensors/rh/latest/{deviceId}")
    public RHSensorData retrieveLatestRHReadings(@Valid @PathVariable String deviceId) {
        return rhSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }
}
