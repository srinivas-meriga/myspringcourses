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
import com.rijyos.ms.sensor.entity.VOCSensorData;
import com.rijyos.ms.sensor.jpa.VOCSensorRepository;

@RestController
public class VOCSensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private VOCSensorRepository vocSensorRepository;

    // ============================= VOC =========================================

    // Capture VOC Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/voc/{deviceCode}")
    public ResponseEntity<Object> createVOCReadingEntry(@Valid @RequestBody VOCSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        VOCSensorData savedReading = vocSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All VOC readings for a device
    @GetMapping(path = "/rjam/sensors/voc/{deviceId}")
    public List<VOCSensorData> retrieveAllVOCReadings(@Valid @PathVariable String deviceId) {
        return vocSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest VOC reading Details for a device
    @GetMapping(path = "/rjam/sensors/voc/latest/{deviceId}")
    public VOCSensorData retrieveLatestVOCReadings(@Valid @PathVariable String deviceId) {
        return vocSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
