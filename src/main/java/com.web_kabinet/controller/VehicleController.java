package com.web_kabinet.controller;

import com.web_kabinet.domain.User;
import com.web_kabinet.domain.Vehicle;
import com.web_kabinet.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class VehicleController {
    @Autowired
    VehicleRepo vehicleRepo;

    @GetMapping("/vehicle")
    public String vehicle(Model model) {
        Iterable<Vehicle> vehicles = vehicleRepo.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle";
    }

    @PostMapping("/vehicle")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String carModel,
                      @RequestParam String carNumber,
                      Map<String, Object> model) {
        if (!carModel.equals("") && !carNumber.equals("")) {

            Vehicle vehicle = new Vehicle(carModel, carNumber);
            vehicleRepo.save(vehicle);
        }

        Iterable<Vehicle> vehicles = vehicleRepo.findAll();
        model.put("vehicles", vehicles);
        return "vehicle";
    }
}
