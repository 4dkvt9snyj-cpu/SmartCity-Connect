package com.smartcity.grievance.controller;

import com.smartcity.grievance.GrievanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final GrievanceRepository repository;

    public AdminController(GrievanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("grievances", repository.findAll());
        return "admin";
    }

}