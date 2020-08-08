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
import com.rijyos.ms.sensor.entity.PMSensorData;
import com.rijyos.ms.sensor.jpa.PMSensorRepository;

@RestController
public class PMSensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private PMSensorRepository pmSensorRepository;

    // ============================= PM =========================================
    // Capture PM Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/pm/{deviceCode}")
    public ResponseEntity<Object> createPMReadingEntry(@Valid @RequestBody PMSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        PMSensorData savedReading = pmSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All PM readings for a device
    @GetMapping(path = "/rjam/sensors/pm/{deviceId}")
    public List<PMSensorData> retrieveAllPMReadings(@Valid @PathVariable String deviceId) {
        return pmSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest PM reading Details for a device
    @GetMapping(path = "/rjam/sensors/pm/latest/{deviceId}")
    public PMSensorData retrieveLatestPMReadings(@Valid @PathVariable String deviceId) {
        return pmSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
