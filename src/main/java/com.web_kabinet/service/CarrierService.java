package com.web_kabinet.service;

import com.web_kabinet.domain.Carrier;
import com.web_kabinet.repos.CarrierRepo;
import org.springframework.stereotype.Service;

@Service
public class CarrierService {
    private CarrierRepo carrierRepo;


    public CarrierService(CarrierRepo carrierRepo) {
        this.carrierRepo = carrierRepo;
    }

    public Carrier findCarrierByUUID(String carrierId) {
        return carrierRepo.findById(carrierId).orElseThrow(NullPointerException::new);
    }
}
