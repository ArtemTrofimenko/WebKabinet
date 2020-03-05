package com.web_kabinet.service;

import com.web_kabinet.domain.Vehicle;
import com.web_kabinet.repos.VehicleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepo vehicleRepo;

    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public Vehicle findVehicleByUUID (String vehicleId){
        return vehicleRepo.findById(vehicleId).orElseThrow(NullPointerException::new);
    }

    public Vehicle findFirst (){
        List<Vehicle> vehicles = (List<Vehicle>)vehicleRepo.findAll();
        return vehicles.get(0);
    }

}
