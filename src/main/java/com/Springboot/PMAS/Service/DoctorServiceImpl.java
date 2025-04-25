package com.Springboot.PMAS.Service;

import com.Springboot.PMAS.Entity.Doctor;
import com.Springboot.PMAS.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = getDoctorById(id);
        existing.setName(doctor.getName());
        existing.setSpecialty(doctor.getSpecialty());
        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
