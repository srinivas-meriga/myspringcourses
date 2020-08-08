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
import com.rijyos.ms.sensor.entity.H2SSensorData;
import com.rijyos.ms.sensor.jpa.H2SSensorRepository;

@RestController
public class H2SSensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private H2SSensorRepository h2sSensorRepository;

    // ============================= H2S =========================================
    // Capture H2S Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/h2s/{deviceCode}")
    public ResponseEntity<Object> createH2SReadingEntry(@Valid @RequestBody H2SSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        H2SSensorData savedReading = h2sSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All H2S readings for a device
    @GetMapping(path = "/rjam/sensors/h2s/{deviceId}")
    public List<H2SSensorData> retrieveAllH2SReadings(@Valid @PathVariable String deviceId) {
        return h2sSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest H2S reading Details for a device
    @GetMapping(path = "/rjam/sensors/h2s/latest/{deviceId}")
    public H2SSensorData retrieveLatestH2SReadings(@Valid @PathVariable String deviceId) {
        return h2sSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }
}
