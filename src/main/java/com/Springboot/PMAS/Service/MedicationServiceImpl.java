package com.Springboot.PMAS.Service;

import com.Springboot.PMAS.Entity.Medication;
import com.Springboot.PMAS.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
    }

    @Override
    public Medication updateMedication(Long id, Medication medication) {
        Medication existing = getMedicationById(id);
        existing.setName(medication.getName());
        existing.setDosage(medication.getDosage());
        existing.setPatient(medication.getPatient());
        return medicationRepository.save(existing);
    }

    @Override
    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
