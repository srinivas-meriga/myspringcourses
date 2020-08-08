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
import com.rijyos.ms.sensor.entity.NO2SensorData;
import com.rijyos.ms.sensor.jpa.NO2SensorRepository;

@RestController
public class NO2SensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private NO2SensorRepository no2SensorRepository;

    // ============================= NO2 =========================================
    // Capture NO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/no2/{deviceCode}")
    public ResponseEntity<Object> createNO2ReadingEntry(@Valid @RequestBody NO2SensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        NO2SensorData savedReading = no2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All NO2 readings for a device
    @GetMapping(path = "/rjam/sensors/no2/{deviceId}")
    public List<NO2SensorData> retrieveAllNO2Readings(@Valid @PathVariable String deviceId) {
        return no2SensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest NO2 reading Details for a device
    @GetMapping(path = "/rjam/sensors/no2/latest/{deviceId}")
    public NO2SensorData retrieveLatestNO2Readings(@Valid @PathVariable String deviceId) {
        return no2SensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
