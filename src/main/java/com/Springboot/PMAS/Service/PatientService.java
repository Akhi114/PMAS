package com.Springboot.PMAS.Service;

import com.Springboot.PMAS.Entity.Patient;
import com.Springboot.PMAS.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        return patientRepository.save(patient);
    }



    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatePatient) {
        Patient existing = patientRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatePatient.getName());
            existing.setEmail(updatePatient.getEmail());
            existing.setPhone(updatePatient.getPhone());
            existing.setGender(updatePatient.getGender());
            existing.setDob(updatePatient.getDob());
            existing.setAddress(updatePatient.getAddress());
            existing.setDisease(updatePatient.getDisease());
            existing.setAdmissionDate(updatePatient.getAdmissionDate());
            return patientRepository.save(existing);
        }
        return null;
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patientRepository.delete(patient);
    }
}
