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
import com.rijyos.ms.sensor.entity.COSensorData;
import com.rijyos.ms.sensor.entity.H2SSensorData;
import com.rijyos.ms.sensor.entity.HumiditySensorData;
import com.rijyos.ms.sensor.entity.NO2SensorData;
import com.rijyos.ms.sensor.entity.PMSensorData;
import com.rijyos.ms.sensor.entity.RHSensorData;
import com.rijyos.ms.sensor.entity.SO2SensorData;
import com.rijyos.ms.sensor.entity.SmokeSensorData;
import com.rijyos.ms.sensor.entity.TempSensorData;
import com.rijyos.ms.sensor.entity.VOCSensorData;
import com.rijyos.ms.sensor.jpa.CO2SensorRepository;
import com.rijyos.ms.sensor.jpa.COSensorRepository;
import com.rijyos.ms.sensor.jpa.H2SSensorRepository;
import com.rijyos.ms.sensor.jpa.HumiditySensorRepository;
import com.rijyos.ms.sensor.jpa.NO2SensorRepository;
import com.rijyos.ms.sensor.jpa.PMSensorRepository;
import com.rijyos.ms.sensor.jpa.RHSensorRepository;
import com.rijyos.ms.sensor.jpa.SO2SensorRepository;
import com.rijyos.ms.sensor.jpa.SmokeSensorRepository;
import com.rijyos.ms.sensor.jpa.TempSensorRepository;
import com.rijyos.ms.sensor.jpa.VOCSensorRepository;
import com.rijyos.ms.user.UserRepository;

@RestController
public class SensorController {
    
    @Autowired(required = true)
    private UserRepository userRepository;
    
    @Autowired(required = true)
    private MonitoringDeviceRepository deviceRepository;
    
    @Autowired(required = true)
    private COSensorRepository coSensorRepository;
    
    @Autowired(required = true)
    private CO2SensorRepository co2SensorRepository;
    
    @Autowired(required = true)
    private H2SSensorRepository h2sSensorRepository;
    
    @Autowired(required = true)
    private HumiditySensorRepository humiditySensorRepository;
    
    @Autowired(required = true)
    private NO2SensorRepository no2SensorRepository;
    
    @Autowired(required = true)
    private PMSensorRepository pmSensorRepository;
    
    @Autowired(required = true)
    private RHSensorRepository rhSensorRepository;
    
    @Autowired(required = true)
    private SO2SensorRepository so2SensorRepository;
    
    @Autowired(required = true)
    private TempSensorRepository tempSensorRepository;
    
    @Autowired(required = true)
    private VOCSensorRepository vocSensorRepository;
    
    @Autowired(required = true)
    private SmokeSensorRepository smokeSensorRepository;
  
    
  //Capture CO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/co2/{deviceCode}")
    public ResponseEntity<Object> createCO2ReadingEntry(@Valid @RequestBody CO2SensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        CO2SensorData savedReading = co2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    //Fetch All CO2 reading details for a device
    @GetMapping(path = "/rjam/sensors/co2/{deviceId}")
    public List<CO2SensorData> retrieveAllCO2Readings(@Valid @PathVariable int deviceId) {
        return co2SensorRepository.findByDeviceId(deviceId);
        
    }
    
//  //Fetch latest CO2 reading Details for a device
//    @GetMapping(path = "/rjam/sensors/co2/{deviceId}")
//    public CO2SensorData retrieveLatestCO2Readings(@Valid @PathVariable int deviceId) {
//        return co2SensorRepository.findTop10ByDeviceIdAndByCapturedTimeDesc(deviceId);
//    }
    
    
  //Capture CO Sensor reading for a device
    @PostMapping(path = "/rjam/sensors/co/{deviceCode}")
    public ResponseEntity<COSensorData> createCOReadingEntry(@Valid @RequestBody COSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        COSensorData savedReading = coSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getCOReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All CO readings for a device
    @GetMapping(path = "/rjam/sensors/co/{deviceId}")
    public List<COSensorData> retrieveAllCOReadings(@Valid @PathVariable int deviceId) {
        return coSensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture H2S Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/h2s/{deviceCode}")
    public ResponseEntity<Object> createH2SReadingEntry(@Valid @RequestBody H2SSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        H2SSensorData savedReading = h2sSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getH2SReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All H2S readings for a device
    @GetMapping(path = "/rjam/sensors/h2s/{deviceId}")
    public List<H2SSensorData> retrieveAllH2SReadings(@Valid @PathVariable int deviceId) {
        return h2sSensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture Humidity Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/hum/{deviceCode}")
    public ResponseEntity<Object> createHumReadingEntry(@Valid @RequestBody HumiditySensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        HumiditySensorData savedReading = humiditySensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getHumReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All Humidity readings for a device
    @GetMapping(path = "/rjam/sensors/hum/{deviceId}")
    public List<HumiditySensorData> retrieveAllHumReadings(@Valid @PathVariable int deviceId) {
        return humiditySensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture NO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/no2/{deviceCode}")
    public ResponseEntity<Object> createNO2ReadingEntry(@Valid @RequestBody NO2SensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        NO2SensorData savedReading = no2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All NO2 readings for a device
    @GetMapping(path = "/rjam/sensors/no2/{deviceId}")
    public List<NO2SensorData> retrieveAllNO2Readings(@Valid @PathVariable int deviceId) {
        return no2SensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture PM Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/pm/{deviceCode}")
    public ResponseEntity<Object> createPMReadingEntry(@Valid @RequestBody PMSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        PMSensorData savedReading = pmSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All PM readings for a device
    @GetMapping(path = "/rjam/sensors/pm/{deviceId}")
    public List<PMSensorData> retrieveAllPMReadings(@Valid @PathVariable int deviceId) {
        return pmSensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture RH Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/rh/{deviceCode}")
    public ResponseEntity<Object> createRHReadingEntry(@Valid @RequestBody RHSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        RHSensorData savedReading = rhSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All PM readings for a device
    @GetMapping(path = "/rjam/sensors/rh/{deviceId}")
    public List<RHSensorData> retrieveAllRHReadings(@Valid @PathVariable int deviceId) {
        return rhSensorRepository.findByDeviceId(deviceId);
    }
    
    
  //Capture SO2 Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/so2/{deviceCode}")
    public ResponseEntity<Object> createSO2ReadingEntry(@Valid @RequestBody SO2SensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        SO2SensorData savedReading = so2SensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All SO2 readings for a device
    @GetMapping(path = "/rjam/sensors/so2/{deviceId}")
    public List<SO2SensorData> retrieveAllSO2Readings(@Valid @PathVariable int deviceId) {
        return so2SensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture Temp Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/temp/{deviceCode}")
    public ResponseEntity<Object> createTempReadingEntry(@Valid @RequestBody TempSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        TempSensorData savedReading = tempSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All Temp readings for a device
    @GetMapping(path = "/rjam/sensors/temp/{deviceId}")
    public List<TempSensorData> retrieveAllTempReadings(@Valid @PathVariable int deviceId) {
        return tempSensorRepository.findByDeviceId(deviceId);
    }
    
  //Capture VOC Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/voc/{deviceCode}")
    public ResponseEntity<Object> createVOCReadingEntry(@Valid @RequestBody VOCSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        VOCSensorData savedReading = vocSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All VOC readings for a device
    @GetMapping(path = "/rjam/sensors/voc/{deviceId}")
    public List<VOCSensorData> retrieveAllVOCReadings(@Valid @PathVariable int deviceId) {
        return vocSensorRepository.findByDeviceId(deviceId);
    }

  //Capture VOC Sensor Reading for a device
    @PostMapping(path = "/rjam/sensors/smoke/{deviceCode}")
    public ResponseEntity<Object> createSmokeReadingEntry(@Valid @RequestBody SmokeSensorData sensorData, @PathVariable String deviceCode) {
       
        Optional<MonitoringDevice> existingDevice = deviceRepository.findByDeviceId(deviceCode);
        if (!existingDevice.isPresent())
            return ResponseEntity.notFound().build();
                
        MonitoringDevice device = existingDevice.get();
        sensorData.setDevice(device);
        sensorData.setCapturedTime(new Timestamp(System.currentTimeMillis()));
        SmokeSensorData savedReading = smokeSensorRepository.save(sensorData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getReadingId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
  //Fetch All VOC readings for a device
    @GetMapping(path = "/rjam/sensors/smoke/{deviceId}")
    public List<SmokeSensorData> retrieveAllSmokeReadings(@Valid @PathVariable int deviceId) {
        return smokeSensorRepository.findByDeviceId(deviceId);
    }
}
