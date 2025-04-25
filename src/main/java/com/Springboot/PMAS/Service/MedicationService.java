package com.Springboot.PMAS.Service;

import com.Springboot.PMAS.Entity.Medication;
import com.Springboot.PMAS.Repository.MedicationRepository;

import java.util.List;

public interface MedicationService {
    Medication saveMedication(Medication medication);
    List<Medication> getAllMedications();
    Medication getMedicationById(Long id);
    Medication updateMedication(Long id, Medication medication);
    void deleteMedication(Long id);
}
