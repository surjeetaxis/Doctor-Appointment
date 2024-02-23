package com.javatodev.api.service;

import com.javatodev.api.model.request.DoctorTimeSlot;
import com.javatodev.api.repository.DoctorTimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorTimeSlotService {

    private final DoctorTimeSlotRepository doctorTimeSlotRepository;

    @Autowired
    public DoctorTimeSlotService(DoctorTimeSlotRepository doctorTimeSlotRepository) {
        this.doctorTimeSlotRepository = doctorTimeSlotRepository;
    }

    public List<DoctorTimeSlot> getAllTimeSlots() {
        return doctorTimeSlotRepository.findAll();
    }

    public Optional<DoctorTimeSlot> getTimeSlotById(String id) {
        return doctorTimeSlotRepository.findById(id);
    }

    public DoctorTimeSlot createTimeSlot(DoctorTimeSlot timeSlot) {
        return doctorTimeSlotRepository.save(timeSlot);
    }

    public void deleteTimeSlot(String id) {
        doctorTimeSlotRepository.deleteById(id);
    }

    public DoctorTimeSlot updateTimeSlot(DoctorTimeSlot timeSlot) {
        return doctorTimeSlotRepository.save(timeSlot);
    }
}
