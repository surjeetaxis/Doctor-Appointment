package com.javatodev.api.service;

import com.javatodev.api.model.request.Medicine;
import com.javatodev.api.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(String id) {
        return medicineRepository.findById(id);
    }

    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(String id) {
        medicineRepository.deleteById(id);
    }

    public Medicine updateMedicine(String id, Medicine newMedicine) {
        if (medicineRepository.existsById(id)) {
            newMedicine.setId(id);
            return medicineRepository.save(newMedicine);
        } else {
            throw new RuntimeException("Medicine with id " + id + " not found");
        }
    }
}
