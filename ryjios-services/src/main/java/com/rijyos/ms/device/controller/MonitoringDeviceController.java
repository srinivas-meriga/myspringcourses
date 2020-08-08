package com.rijyos.ms.device.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rijyos.ms.device.entity.MonitoringDevice;
import com.rijyos.ms.device.jpa.MonitoringDeviceRepository;
import com.rijyos.ms.user.UserRepository;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiResponses(value = { @ApiResponse(code = 500, message = MonitoringDeviceController.HTTP_500_MESSAGE) })
@ResponseBody
public class MonitoringDeviceController {

    static final String HTTP_500_MESSAGE = "Failure - Internal Service Error";

    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired(required = true)
    private MonitoringDeviceRepository deviceRepository;

    // Register Device
    @PostMapping(path = "/rjam/devices")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request parameters") })
    public ResponseEntity<Object> createDevice(@Valid @RequestBody MonitoringDevice device) {
        System.out.println("before creating device = " + device);
        URI location = null;
        String deviceId = device.getDeviceId();
        Optional<MonitoringDevice> deviceOptional = deviceRepository.findByDeviceMacId(deviceId);
        if (deviceOptional.isPresent()) {
            MonitoringDevice existingDevice = deviceOptional.get();
            existingDevice = deviceRepository.save(device);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(existingDevice.getDeviceId()).toUri();
        } else {
            MonitoringDevice savedDevice = deviceRepository.save(device);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedDevice.getDeviceId()).toUri();
        }
        return ResponseEntity.created(location).build();
    }

    // Fetch Device Details
    @GetMapping(path = "/rjam/devices")
    public List<MonitoringDevice> retrieveAllDevices() {
        return deviceRepository.findAll();
    }

    // Fetch All devices for user
    @GetMapping(path = "/rjam/users/devices/{userId}")
    public List<MonitoringDevice> retrieveAllDevicesForUser(@PathVariable String userId) {
        
        return deviceRepository.findByUserId(userId);
        
    }

    // Fetch device details devivce id
    @GetMapping(path = "/rjam/devices/{deviceId}")
    public MonitoringDevice retrieveDeviceByDeviceId(@PathVariable String deviceId) {
        Optional<MonitoringDevice> deviceOptional = deviceRepository.findByDeviceMacId(deviceId);
        if (!deviceOptional.isPresent())
            throw new RuntimeException("No device with deviceId = " + deviceId);

        return deviceOptional.get();

    }

    // Delete Device
    // TODO

    // Update Device Details
    @PostMapping(path = "/rjam/devices/{id}")
    public ResponseEntity<Object> updateDevice(@RequestBody MonitoringDevice device, @PathVariable String id) {

        Optional<MonitoringDevice> deviceOptional = deviceRepository.findById(id);

        if (!deviceOptional.isPresent())
            return ResponseEntity.notFound().build();

        device.setDeviceId(id);

        deviceRepository.save(device);

        return ResponseEntity.noContent().build();
    }

}
