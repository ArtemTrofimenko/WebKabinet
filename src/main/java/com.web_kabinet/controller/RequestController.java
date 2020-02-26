package com.web_kabinet.controller;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Elevator;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.RequestRepo;
import com.web_kabinet.request.Request;
import com.web_kabinet.service.ContragentService;
import com.web_kabinet.service.ElevatorService;
import com.web_kabinet.service.NomenclatureService;
import com.web_kabinet.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Map;

@Controller
public class RequestController {
    @Autowired
    ContragentService contragentService;

    @Autowired
    ElevatorService elevatorService;

    @Autowired
    NomenclatureService nomenclatureService;

    @Autowired
    RequestService requestService;
    @Autowired
    RequestRepo requestRepo;

    @GetMapping("/request")
    public String getRequests(
            Map<String, Object> model
    ) {

        Iterable<Request> requests = requestRepo.findAll();
        model.put("requests", requests);
        return "request";
    }


    @GetMapping("/requestEdit")
    public String requestEdit(
            Map<String, Object> model
    ) {
        return "requestEdit";
    }

    @PostMapping("/requestEdit")
    public String addRequest(@AuthenticationPrincipal User user,
                             @RequestParam String contragent_id,
                             @RequestParam String elevator_id,
                             @RequestParam String nomenclature_id,
                             @RequestParam String weight,
                             @RequestParam(defaultValue = "false") String isChecked,
                             @RequestParam(required = false, defaultValue = "")
                                     Map<String, Object> model) throws ParseException {

        Contragent contragent = contragentService.findContragentByUUID(contragent_id);
        Elevator elevator = elevatorService.findElevatorByUUID(elevator_id);
        Nomenclature nomenclature = nomenclatureService.findNomenclatureByUUID(nomenclature_id);
        Long num = requestService.getNumber();
        Request request = Request.builder()
                .author(user)
                .contragent(contragent)
                .elevator(elevator)
                .nomenclature(nomenclature)
                .weight(weight)
                .isChecked(isChecked)
                .num(num)
                .build();

        requestRepo.save(request);
        Iterable<Request> requests = requestRepo.findAll();
        model.put("requests", requests);
        return "redirect:/request";
    }
}
