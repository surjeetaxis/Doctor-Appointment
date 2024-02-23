package com.javatodev.api.controller;

import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.request.Prescription;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.AuthService;
import com.javatodev.api.service.PrescriptionService;
import com.javatodev.api.util.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prescription")
@CrossOrigin(origins = "http://localhost:3000")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable String id) {
        return prescriptionService.getPrescriptionById(id);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @PostMapping("/create")
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(prescription);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable String id) {
        prescriptionService.deletePrescription(id);
    }

    @PatchMapping
    public Prescription updatePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.updatePrescription(prescription);
    }

    @PatchMapping("/update-prescription-appointment")
    public Prescription updatePrescriptionAndAppointment(@RequestBody Prescription prescription) {
        return prescriptionService.updatePrescriptionAndAppointment(prescription);
    }
}


