package com.Springboot.PMAS.Controller;

import com.Springboot.PMAS.Entity.Patient;
import com.Springboot.PMAS.Service.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*") // Reminder: this allows frontend calls
public class PatientController {

    @Autowired
    private PatientServices patientService;

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient saved = patientService.registerPatient(patient);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getById(id);
    }

//    @PostMapping
//    public Patient addPatient(@RequestBody Patient patient) {
//        return patientService.save(patient);
//    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }

    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return null;
    }
}
