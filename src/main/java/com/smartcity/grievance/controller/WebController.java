package com.smartcity.grievance.controller;
import com.smartcity.grievance.GrievanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.smartcity.grievance.Grievance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.HashMap;
import java.util.Map;
    @Controller
    public class WebController {
        private static final Map<String, String> DEPARTMENTS = new HashMap<>();

        static {

            DEPARTMENTS.put("roads", "Roads Department");
            DEPARTMENTS.put("electricity", "Electrical Department");
            DEPARTMENTS.put("water supply", "Water Supply Department");
            DEPARTMENTS.put("sanitation", "Sanitation Department");
            DEPARTMENTS.put("other", "General Municipal Department");

        }

        private final GrievanceRepository grievanceRepository;

        public WebController(GrievanceRepository grievanceRepository) {
            this.grievanceRepository = grievanceRepository;
        }

        @GetMapping("/")
        public String home(Model model) {
            model.addAttribute("grievances", grievanceRepository.findAll());
            return "index";
        }

        @PostMapping("/submit-grievance")
        public String submitGrievance(
                @RequestParam String title,
                @RequestParam String description,
                @RequestParam String location,
                @RequestParam String category,
                RedirectAttributes redirectAttributes) {

            Grievance grievance = new Grievance();
            grievance.setTitle(title);
            grievance.setDescription(description);
            grievance.setLocation(location);
            grievance.setCategory(category);

            String department = DEPARTMENTS.get(category.trim().toLowerCase());

            if (department == null) {
                department = "General Municipal Department";
            }

            grievance.setDepartment(department);
            grievanceRepository.save(grievance);

            redirectAttributes.addFlashAttribute(
                    "message", "Grievance submitted successfully!");

            return "redirect:/";
        }

        @PostMapping("/update-status")
        public String updateStatus(
                @RequestParam Long id,
                @RequestParam String status,
                RedirectAttributes redirectAttributes) {

            Grievance grievance = grievanceRepository.findById(id).orElse(null);

            if (grievance != null &&
                    (status.equals("PENDING")
                            || status.equals("IN_PROGRESS")
                            || status.equals("RESOLVED"))) {

                grievance.setStatus(status);
                grievanceRepository.save(grievance);

                redirectAttributes.addFlashAttribute(
                        "message", "Grievance status updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute(
                        "message", "Unable to update grievance status.");
            }

            return "redirect:/admin";

        }
    }

