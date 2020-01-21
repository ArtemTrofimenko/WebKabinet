package com.web_kabinet.controller;


import com.web_kabinet.domain.Role;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping
    public String userList (Model model){
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }
    @GetMapping("{user}")
    public String userEditForm(

            @PathVariable User user,
                               Model model){
        model.addAttribute("user", user);
        model.addAttribute("active", user.isActive());
        model.addAttribute("roles", Role.values());
        model.addAttribute("fullname", user.getFullname());

        return "userEdit";
    }
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam String userEmail,
            @RequestParam Integer userPhoneNumber,
            @RequestParam(name = "activeUs", required = false, defaultValue = "") String active,
            @RequestParam(name = "fullname", required = false, defaultValue = "Введите ФИО") String fullname,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        user.setFullname(fullname);
        user.setUserEmail(userEmail);
        user.setUserPhoneNumber(userPhoneNumber);
        user.setUsername(username);
        user.setActive(!active.equals(""));
        userRepo.save(user);
        return "redirect:/user";
    }
}
