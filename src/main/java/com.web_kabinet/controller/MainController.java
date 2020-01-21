package com.web_kabinet.controller;


import com.web_kabinet.domain.*;
import com.web_kabinet.repos.*;
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
    private CarrierRepo carrierRepo;
    @Autowired
    private ContragentRepo contragentRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ElevatorRepo elevatorRepo;
    @Autowired
    private NomenclatureRepo nomenclatureRepo;
    @Autowired
    private VehicleRepo vehicleRepo;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Ttn> ttns = ttnRepo.findAll();
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
                      @RequestParam(required = false, defaultValue = "") String filter,
                      Map<String, Object> model) {
        Carrier carrier = carrierRepo.findById(Long.valueOf(carrier_id)).stream().
                findFirst().
                get();
        Contragent contragent = contragentRepo.findById(Long.valueOf(contragent_id)).stream().
                findFirst().
                get();
        Driver driver = driverRepo.findById(Long.valueOf(driver_id)).stream().
                findFirst().
                get();
        Elevator elevator = elevatorRepo.findById(Long.valueOf(elevator_id)).stream().
                findFirst().
                get();
        Nomenclature nomenclature = nomenclatureRepo.findById(Long.valueOf(nomenclature_id)).stream().
                findFirst().
                get();
        Vehicle vehicle = vehicleRepo.findById(Long.valueOf(vehicle_id))
                .stream().
                        findFirst().
                        get();

        Ttn ttn = new Ttn(user, carrier, contragent, driver, elevator, nomenclature, vehicle);
        ttnRepo.save(ttn);

        Iterable<Ttn> ttns = ttnRepo.findAll();
        model.put("ttns", ttns);
        return "redirect:/main";
    }

}
