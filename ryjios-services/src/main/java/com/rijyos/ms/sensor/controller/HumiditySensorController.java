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
import com.rijyos.ms.sensor.entity.HumiditySensorData;
import com.rijyos.ms.sensor.jpa.HumiditySensorRepository;

@RestController
public class HumiditySensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private HumiditySensorRepository humiditySensorRepository;

    // ============================= Humidity
    // =========================================
    // Capture Humidity Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/hum/{deviceCode}")
    public ResponseEntity<Object> createHumReadingEntry(@Valid @RequestBody HumiditySensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        HumiditySensorData savedReading = humiditySensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All Humidity readings for a device
    @GetMapping(path = "/rjam/sensors/hum/{deviceId}")
    public List<HumiditySensorData> retrieveAllHumReadings(@Valid @PathVariable String deviceId) {
        return humiditySensorRepository.findByDeviceId(deviceId);
    }

    // Fetch latest humidity reading Details for a device
    @GetMapping(path = "/rjam/sensors/hum/latest/{deviceId}")
    public HumiditySensorData retrieveLatestHumReadings(@Valid @PathVariable String deviceId) {
        return humiditySensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
