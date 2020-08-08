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
import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.jpa.COSensorRepository;

@RestController
public class COSensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private COSensorRepository coSensorRepository;

    // ============================= CO =========================================
    // Capture CO Sensor reading for a device
    @PostMapping(path = "/rjam/sensors/co/{deviceCode}")
    public ResponseEntity<COSensorData> createCOReadingEntry(@Valid @RequestBody COSensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());

        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        COSensorData savedReading = coSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All CO readings for a device
    @GetMapping(path = "/rjam/sensors/co/{deviceId}")
    public List<COSensorData> retrieveAllCOReadings(@Valid @PathVariable String deviceId) {
        return coSensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest CO reading Details for a device
    @GetMapping(path = "/rjam/sensors/co/latest/{deviceId}")
    public COSensorData retrieveLatestCOReadings(@Valid @PathVariable String deviceId) {
        return coSensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
