package com.web_kabinet.controller;

import com.web_kabinet.domain.Driver;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DriverController {
    @Autowired
    DriverRepo driverRepo;

    @GetMapping("/driver")
    public String driver(Model model) {
        Iterable<Driver> drivers = driverRepo.findAll();
        model.addAttribute("drivers", drivers);
        return "driver";
    }

    @PostMapping("/driver")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String driverName,
                      @RequestParam String driverLicense,
                      Map<String, Object> model) {
        if (!driverName.equals("")) {

            Driver driver = new Driver(driverName, driverLicense);
            driverRepo.save(driver);
        }

        Iterable<Driver> drivers = driverRepo.findAll();
        model.put("drivers", drivers);
        return "driver";
    }
}
