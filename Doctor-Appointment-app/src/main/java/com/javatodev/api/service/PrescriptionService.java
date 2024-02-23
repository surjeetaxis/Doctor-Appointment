package com.javatodev.api.service;

import com.javatodev.api.model.request.Prescription;
import com.javatodev.api.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription getPrescriptionById(String id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deletePrescription(String id) {
        prescriptionRepository.deleteById(id);
    }

    public Prescription updatePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public Prescription updatePrescriptionAndAppointment(Prescription prescription) {
        // Implement logic for updating prescription and appointment
        return prescriptionRepository.save(prescription);
    }
}
