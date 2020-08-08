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
import com.rijyos.ms.sensor.entity.CO2SensorData;
import com.rijyos.ms.sensor.jpa.CO2SensorRepository;
import com.rijyos.ms.sensor.jpa.COSensorRepository;

@RestController
public class CO2SensorController {

    @Autowired(required = true)
    public MonitoringDeviceRepository deviceRepository;

    @Autowired(required = true)
    private CO2SensorRepository co2SensorRepository;

    // ============================= CO2 =========================================
    // Capture CO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/co2/{deviceCode}")
    public ResponseEntity<Object> createCO2ReadingEntry(@Valid @RequestBody CO2SensorData sensorData,
            @PathVariable String deviceCode) {

        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceMacId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice device = existingDevice.get();
        sensorData.setDeviceId(device.getDeviceId());
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        CO2SensorData savedReading = co2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{deviceId}")
                .buildAndExpand(savedReading.getReadingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Fetch All CO2 reading details for a device
    @GetMapping(path = "/rjam/sensors/co2/{deviceId}")
    public List<CO2SensorData> retrieveAllCO2Readings(@Valid @PathVariable String deviceId) {
        return co2SensorRepository.findByDeviceId(deviceId);

    }

    // Fetch latest CO2 reading Details for a device
    @GetMapping(path = "/rjam/sensors/co2/latest/{deviceId}")
    public CO2SensorData retrieveLatestCO2Readings(@Valid @PathVariable String deviceId) {
        return co2SensorRepository.findTop1ByDeviceIdOrderByCapturedTimeDesc(deviceId);
    }

}
