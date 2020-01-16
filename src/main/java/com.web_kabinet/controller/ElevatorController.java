package com.web_kabinet.controller;

import com.web_kabinet.domain.Elevator;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.ElevatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ElevatorController {
    @Autowired
    ElevatorRepo elevatorRepo;

    @GetMapping("/elevator")
    public String main(Model model) {
        Iterable<Elevator> elevators = elevatorRepo.findAll();
        model.addAttribute("elevators", elevators);
        return "elevator";
    }

    @PostMapping("/elevator")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String elevatorName,
                      @RequestParam Integer elevatorEDRPOU,
                      Map<String, Object> model) {
        if (!elevatorEDRPOU.equals("") && !elevatorName.equals("")) {

            Elevator elevator = new Elevator(elevatorName, elevatorEDRPOU);
            elevatorRepo.save(elevator);
        }

        Iterable<Elevator> elevators = elevatorRepo.findAll();
        model.put("elevators", elevators);
        return "main";
    }
}
