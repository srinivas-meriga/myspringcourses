package com.rijyos.ms.device.controller;

import java.net.URI;
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
import com.rijyos.ms.user.UserRepository;

@RestController
public class MonitoringDeviceController {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired(required = true)
    private MonitoringDeviceRepository deviceRepository;

    // Register Device
    @PostMapping(path = "/rjam/devices")
    public ResponseEntity<Object> createDevice(@Valid @RequestBody MonitoringDevice device) {
        System.out.println("before creating device = " + device);
        URI location = null;
        String deviceId = device.getDeviceId();
        Optional<MonitoringDevice> deviceOptional = deviceRepository.findByDeviceId(deviceId);
        if (deviceOptional.isPresent()) {
            MonitoringDevice existingDevice = deviceOptional.get();
            if (null == existingDevice.getUser()) {
                existingDevice.setUser(device.getUser());
                existingDevice = deviceRepository.save(device);
                location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(existingDevice.getId()).toUri();
            }
        } else {
            MonitoringDevice savedDevice = deviceRepository.save(device);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedDevice.getId()).toUri();
        }
        return ResponseEntity.created(location).build();
    }

    // Fetch Device Details
    @GetMapping(path = "/rjam/devices")
    public List<MonitoringDevice> retrieveAllDevices() {
        return deviceRepository.findAll();
    }

    // Fetch All devices for user
    @GetMapping(path = "/rjam/devices/{userId}")
    public List<MonitoringDevice> retrieveAllDevicesForUser(@PathVariable int userId) {
        return deviceRepository.findByUserId(userId);
    }

    // Fetch All devices for user
    @GetMapping(path = "/rjam/devices/{deviceId}")
    public ResponseEntity<Object> retrieveDeviceByDeviceId(@PathVariable String deviceId) {
        URI location = null;
        Optional<MonitoringDevice> deviceOptional = deviceRepository.findByDeviceId(deviceId);
        if (!deviceOptional.isPresent())
            return ResponseEntity.notFound().build();

        MonitoringDevice existingDevice = deviceOptional.get();
        location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(existingDevice.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    // Delete Device
    // TODO

    // Update Device Details
    @PostMapping(path = "/rjam/devices/{id}")
    public ResponseEntity<Object> updateDevice(@RequestBody MonitoringDevice device, @PathVariable int id) {

        Optional<MonitoringDevice> deviceOptional = deviceRepository.findById(id);

        if (!deviceOptional.isPresent())
            return ResponseEntity.notFound().build();

        device.setId(id);

        deviceRepository.save(device);

        return ResponseEntity.noContent().build();
    }

}
