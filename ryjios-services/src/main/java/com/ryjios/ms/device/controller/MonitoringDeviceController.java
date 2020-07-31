package com.ryjios.ms.device.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ryjios.ms.device.entity.MonitoringDevice;
import com.ryjios.ms.device.jpa.MonitoringDeviceRepository;
import com.ryjios.ms.user.User;
import com.ryjios.ms.user.UserRepository;

@RestController
public class MonitoringDeviceController {
    
    @Autowired(required = true)
    private UserRepository userRepository;
    
    @Autowired(required = true)
    private MonitoringDeviceRepository deviceRepository;
    
  //Register Device
    @PostMapping(path = "/rjam/devices")
    public ResponseEntity<Object> createDevice(@Valid @RequestBody MonitoringDevice device) {
        System.out.println("before creating device = " + device);
        MonitoringDevice savedDevice = deviceRepository.save(device);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDevice.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    //Fetch Device Details
    @GetMapping(path = "/rjam/devices")
    public List<MonitoringDevice> retrieveAllDevices() {
        return deviceRepository.findAll();
    }
    
    //Fetch All devices for user
    @GetMapping(path = "/rjam/devices/{userId}")
    public List<MonitoringDevice> retrieveAllDevicesForUser(@PathVariable int userId) {
        return deviceRepository.findByUserId(userId);
    }
    
    
    //Delete Device
    // TODO
    
    //Update Device Details
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
