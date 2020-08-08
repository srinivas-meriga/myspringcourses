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
import com.rijyos.ms.sensor.entity.SO2SensorData;
import com.rijyos.ms.sensor.jpa.SO2SensorRepository;

@RestController
public class SO2SensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private SO2SensorRepository so2SensorRepository;

    // ============================= SO2 =========================================

    // Capture SO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/so2/{deviceCode}")
    public ResponseEntity<Object> createSO2ReadingEntry(@Valid @RequestBody SO2SensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        SO2SensorData savedReading = so2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All SO2 readings for a device
    @GetMapping(path = "/rjam/sensors/so2/{deviceId}")
    public List<SO2SensorData> retrieveAllSO2Readings(@Valid @PathVariable String deviceId) {
        return so2SensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest SO2 reading Details for a device
    @GetMapping(path = "/rjam/sensors/so2/latest/{deviceId}")
    public SO2SensorData retrieveLatestSO2Readings(@Valid @PathVariable String deviceId) {
        return so2SensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }
}
