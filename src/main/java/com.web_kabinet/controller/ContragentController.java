package com.web_kabinet.controller;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.ContragentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ContragentController {
    @Autowired
    ContragentRepo contragentRepo;

    @GetMapping("/contragent")
    public String contragent(Model model) {
        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);
        return "contragent";
    }

    @PostMapping("/contragent")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String contragentName,

                      Map<String, Object> model) {
        if (!contragentName.equals("")) {

            Contragent contragent = new Contragent(contragentName);
            contragentRepo.save(contragent);
        }

        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.put("contragents", contragents);
        return "contragent";
    }
}
