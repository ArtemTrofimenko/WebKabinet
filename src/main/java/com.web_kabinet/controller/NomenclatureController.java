package com.web_kabinet.controller;

import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.NomenclatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class NomenclatureController {
    @Autowired
    NomenclatureRepo nomenclatureRepo;

    @GetMapping("/nomenclature")
    public String nomenclature(Model model) {
        Iterable<Nomenclature> nomenclatures = nomenclatureRepo.findAll();
        model.addAttribute("nomenclatures", nomenclatures);
        return "nomenclature";
    }

    @PostMapping("/nomenclature")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String name,

                      Map<String, Object> model) {
        if (!name.equals("")) {

            Nomenclature nomenclature = new Nomenclature(name);
            nomenclatureRepo.save(nomenclature);
        }

        Iterable<Nomenclature> nomenclatures = nomenclatureRepo.findAll();
        model.put("nomenclatures", nomenclatures);
        return "nomenclature";
    }

}
