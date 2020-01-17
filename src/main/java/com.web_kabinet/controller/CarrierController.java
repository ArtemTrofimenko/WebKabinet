package com.web_kabinet.controller;

import com.web_kabinet.domain.Carrier;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.CarrierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CarrierController {
    @Autowired
    CarrierRepo carrierRepo;

    @GetMapping("/carrier")
    public String main(Model model) {
        Iterable<Carrier> carriers = carrierRepo.findAll();
        model.addAttribute("carriers", carriers);
        return "carrier";
    }

    @PostMapping("/carrier")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String carrierName,

                      Map<String, Object> model) {
        if (!carrierName.equals("")) {

            Carrier carrier = new Carrier(carrierName);
            carrierRepo.save(carrier);
        }

        Iterable<Carrier> carriers = carrierRepo.findAll();
        model.put("carriers", carriers);
        return "carrier";
    }
}
