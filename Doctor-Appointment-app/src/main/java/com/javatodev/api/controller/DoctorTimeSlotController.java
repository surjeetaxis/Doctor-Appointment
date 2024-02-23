package com.javatodev.api.controller;

import com.javatodev.api.model.request.DoctorTimeSlot;
import com.javatodev.api.service.DoctorTimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/timeslot")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorTimeSlotController {

    private final DoctorTimeSlotService doctorTimeSlotService;

    @Autowired
    public DoctorTimeSlotController(DoctorTimeSlotService doctorTimeSlotService) {
        this.doctorTimeSlotService = doctorTimeSlotService;
    }

    @GetMapping("/my-slot")
    public ResponseEntity<List<DoctorTimeSlot>> getMyTimeSlot(@RequestParam String doctorId) {
        List<DoctorTimeSlot> timeSlots = doctorTimeSlotService.getAllTimeSlots();
        return new ResponseEntity<>(timeSlots, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorTimeSlot> getTimeSlot(@PathVariable String id) {
        Optional<DoctorTimeSlot> timeSlot = doctorTimeSlotService.getTimeSlotById(id);
        return timeSlot.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/appointment-time/{id}")
    public ResponseEntity<?> getAppointmentTimeOfEachDoctor(@PathVariable String id) {
        // Implement logic to get appointment times for each doctor
        return new ResponseEntity<>("createdTimeSlot", HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<DoctorTimeSlot> createTimeSlot(@RequestBody DoctorTimeSlot timeSlot) {
        DoctorTimeSlot createdTimeSlot = doctorTimeSlotService.createTimeSlot(timeSlot);
        return new ResponseEntity<>(createdTimeSlot, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DoctorTimeSlot>> getAllTimeSlot() {
        List<DoctorTimeSlot> timeSlots = doctorTimeSlotService.getAllTimeSlots();
        return new ResponseEntity<>(timeSlots, HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<DoctorTimeSlot> updateTimeSlot(@RequestBody DoctorTimeSlot timeSlot) {
        DoctorTimeSlot updatedTimeSlot = doctorTimeSlotService.updateTimeSlot(timeSlot);
        return new ResponseEntity<>(updatedTimeSlot, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteTimeSlot(@RequestParam String id) {
        doctorTimeSlotService.deleteTimeSlot(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


