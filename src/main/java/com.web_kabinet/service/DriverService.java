package com.web_kabinet.service;

import com.web_kabinet.domain.Driver;
import com.web_kabinet.repos.DriverRepo;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    public Driver findDriverByUUID (String driverId){
        return driverRepo.findById(driverId).orElseThrow(NullPointerException::new);
    }
}
