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
import com.rijyos.ms.sensor.entity.TempSensorData;
import com.rijyos.ms.sensor.jpa.TempSensorRepository;

@RestController
public class TempSensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private TempSensorRepository tempSensorRepository;

    // ============================= Temprature
    // =========================================

    // Capture Temp Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/temp/{deviceCode}")
    public ResponseEntity<Object> createTempReadingEntry(@Valid @RequestBody TempSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        TempSensorData savedReading = tempSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All Temp readings for a device
    @GetMapping(path = "/rjam/sensors/temp/{deviceId}")
    public List<TempSensorData> retrieveAllTempReadings(@Valid @PathVariable String deviceId) {
        return tempSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest Temp reading Details for a device
    @GetMapping(path = "/rjam/sensors/temp/latest/{deviceId}")
    public TempSensorData retrieveLatestTempReadings(@Valid @PathVariable String deviceId) {
        return tempSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }
}
