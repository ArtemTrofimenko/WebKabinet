package com.web_kabinet.controller;


import com.web_kabinet.component.TtnComponent;
import com.web_kabinet.domain.*;
import com.web_kabinet.repos.TtnRepo;
import com.web_kabinet.service.*;
import com.web_kabinet.ttn.Ttn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
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

    @Autowired
    private TtnComponent ttnComponent;


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
//

            return "main";
        } else {
            String contragent_id = user.getContragent().getId();
//            Iterable<Contragent> CAlist = contragentService.findAll();

            Iterable<Contragent> CAlist = contragentService.findAllContragentByUUID(contragent_id);
            List<String> ca = ttnService.getContragentsId((List<Contragent>) CAlist);
            ttns = (List<Ttn>) ttnService.getTtnForContragent(ca);
            List<Nomenclature> nomenclatures = ttnService.getNomenclatureFromTtn((List<Ttn>) ttns);
            Map<String, String> totalTtn = ttnComponent.totTtn((List<Ttn>) ttns, nomenclatures);
            model.addAttribute("ttnComponent", totalTtn);

//            ttns = ttnService.getTtnForContragent(user.getContragent().getId());

        }


        model.addAttribute("ttns", ttns);
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
                      @RequestParam String datepicker,
                      @RequestParam String operation,
                      @RequestParam(required = false, defaultValue = "")
                      Map<String, Object> model) throws ParseException {

        Contragent contragent = contragentService.findContragentByUUID(contragent_id);
        Carrier carrier = carrierService.findCarrierByUUID(carrier_id);
        Driver driver = driverService.findDriverByUUID(driver_id);
        Elevator elevator = elevatorService.findElevatorByUUID(elevator_id);
        Nomenclature nomenclature = nomenclatureService.findNomenclatureByUUID(nomenclature_id);
        Vehicle vehicle = vehicleService.findVehicleByUUID(vehicle_id);
        Long num = ttnService.getNumber();
        Timestamp timestamp =  ttnService.getTimestamp(datepicker);
        Ttn ttn = Ttn.builder()
                .author(user)
                .contragent(contragent)
                .carrier(carrier)
                .driver(driver)
                .elevator(elevator)
                .nomenclature(nomenclature)
                .vehicle(vehicle)
                .weight(weight)
                .rubbish(rubbish)
                .humidity(humidity)
                .ttnTime(timestamp)
                .num(num)
                .operation(operation)
                .build();

        ttnRepo.save(ttn);
        Iterable<Ttn> ttns = ttnRepo.findAll();
        model.put("ttns", ttns);
        return "redirect:/main";
    }

    @GetMapping("/ttnSearch")
    public String search(@AuthenticationPrincipal User user,
                      @RequestParam (defaultValue = "") String contragent_id,
                         Map<String, Object> model) throws ParseException{

        List<Ttn> ttns;
        Map<String, String> totalTtn;
        if (contragent_id.equals("")){
            Iterable<Contragent> CAlist = contragentService.findAll();
            List <String> ca = ttnService.getContragentsId((List<Contragent>) CAlist);
            ttns = (List<Ttn>) ttnService.getTtnForContragent(ca);
            List<Nomenclature> nomenclatures = ttnService.getNomenclatureFromTtn(ttns);
            totalTtn = ttnComponent.totTtn(ttns, nomenclatures);
        }
        else {
            Iterable<Contragent> CAlist = contragentService.findAllContragentByUUID(contragent_id);
            List<String> ca = ttnService.getContragentsId((List<Contragent>) CAlist);
            ttns = (List<Ttn>) ttnService.getTtnForContragent(ca);
        List<Nomenclature> nomenclatures = ttnService.getNomenclatureFromTtn(ttns);
        totalTtn = ttnComponent.totTtn(ttns, nomenclatures);}
        model.put("ttns", ttns);
        model.put("ttnComponent", totalTtn);
        return "main";
    }
}
