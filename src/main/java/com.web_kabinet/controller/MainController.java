package com.web_kabinet.controller;


import com.web_kabinet.domain.*;
import com.web_kabinet.repos.TtnRepo;
import com.web_kabinet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class MainController {


    @Autowired
    private TtnRepo ttnRepo;

    @Autowired
    private TtnService ttnService;

    @Autowired
    private CarrierService carrierService;

    @Autowired
    private ContragentService contragentService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private NomenclatureService nomenclatureService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
                       Model model) {
        Iterable<Ttn> ttns;
        if (user.isAdmin()) {
            ttns = ttnRepo.findAll();
        } else {
            ttns = ttnRepo.findAllByContragentId(user.getContragent().getId());
        }
//        Iterable<Carrier> carriers = carrierRepo.findAll();
//        ttns = ttnRepo.findByTagContaining(filter);
        model.addAttribute("ttns", ttns);
//        model.addAttribute("carriers", carriers);
//        model.addAttribute("filter", filter);

        return "main";
    }


    @GetMapping("/ttnEdit")
    public String ttnEdit(Model model) {
        Iterable<Ttn> ttns = ttnRepo.findAll();
        model.addAttribute("ttns", ttns);
        return "ttnEdit";
    }


    @PostMapping("/ttnEdit")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String carrier_id,
                      @RequestParam String contragent_id,
                      @RequestParam String driver_id,
                      @RequestParam String elevator_id,
                      @RequestParam String nomenclature_id,
                      @RequestParam String vehicle_id,
                      @RequestParam String weight,
                      @RequestParam String rubbish,
                      @RequestParam String humidity,
                      @RequestParam(required = false, defaultValue = "") String filter,
                      Map<String, Object> model) {

        Contragent contragent = contragentService.findContragentByUUID(contragent_id);
        Carrier carrier = carrierService.findCarrierByUUID(carrier_id);
        Driver driver = driverService.findDriverByUUID(driver_id);
        Elevator elevator = elevatorService.findElevatorByUUID(elevator_id);
        Nomenclature nomenclature = nomenclatureService.findNomenclatureByUUID(nomenclature_id);
        Vehicle vehicle = vehicleService.findVehicleByUUID(vehicle_id);
        Long num = ttnService.getNumber();


        Ttn ttn = new Ttn(user, carrier, contragent, driver, elevator, nomenclature, vehicle, num, Float.valueOf(weight), Float.valueOf(rubbish), Float.valueOf(humidity));

        ttnRepo.save(ttn);

        Iterable<Ttn> ttns = ttnRepo.findAll();
        model.put("ttns", ttns);
        return "redirect:/main";
    }

}
