package com.smartcity.grievance.service;

import com.smartcity.grievance.Grievance;
import com.smartcity.grievance.GrievanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class GrievanceService {

        private final GrievanceRepository grievanceRepository;

        public GrievanceService(GrievanceRepository grievanceRepository) {
            this.grievanceRepository = grievanceRepository;
        }

        public Grievance createGrievance(Grievance grievance) {
            return grievanceRepository.save(grievance);
        }

        public List<Grievance> getAllGrievances() {
            return grievanceRepository.findAll();
        }

        public Optional<Grievance> getGrievanceById(Long id) {
            return grievanceRepository.findById(id);
        }


        public Grievance updateGrievance(Long id, Grievance updatedGrievance) {
            Optional<Grievance> result = grievanceRepository.findById(id);

            if (result.isPresent()) {
                Grievance existing = result.get();

                existing.setTitle(updatedGrievance.getTitle());
                existing.setDescription(updatedGrievance.getDescription());
                existing.setLocation(updatedGrievance.getLocation());
                existing.setCategory(updatedGrievance.getCategory());
                existing.setDepartment(updatedGrievance.getDepartment());
                existing.setStatus(updatedGrievance.getStatus());

                return grievanceRepository.save(existing);
            }

            return null;
        }


        public boolean deleteGrievance(Long id) {
            if (grievanceRepository.existsById(id)) {
                grievanceRepository.deleteById(id);
                return true;
            }

            return false;
        }
    }


