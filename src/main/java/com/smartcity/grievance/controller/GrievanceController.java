package com.smartcity.grievance.controller;
import com.smartcity.grievance.Grievance;
import com.smartcity.grievance.service.GrievanceService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class GrievanceController {

    private final GrievanceService grievanceService;

    public GrievanceController(GrievanceService grievanceService) {
        this.grievanceService = grievanceService;
    }

    @PostMapping("/grievances")
    public Grievance submitGrievance(
            @Valid @RequestBody Grievance grievance) {
        return grievanceService.createGrievance(grievance);
    }

    @GetMapping("/grievances")
    public List<Grievance> getAllGrievances() {
        return grievanceService.getAllGrievances();
    }

    @GetMapping("/grievances/{id}")
    public Grievance getGrievanceById(@PathVariable Long id) {
        return grievanceService.getGrievanceById(id).orElse(null);
    }

    @PutMapping("/grievances/{id}")
    public Grievance updateGrievance(
            @PathVariable Long id,
            @Valid @RequestBody Grievance updatedGrievance) {
        return grievanceService.updateGrievance(id, updatedGrievance);
    }

    @DeleteMapping("/grievances/{id}")
    public String deleteGrievance(@PathVariable Long id) {
        if (grievanceService.deleteGrievance(id)) {
            return "Grievance deleted successfully";
        }

        return "Grievance not found";
    }
}
