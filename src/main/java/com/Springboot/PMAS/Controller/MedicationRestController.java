package com.Springboot.PMAS.Controller;

import com.Springboot.PMAS.Entity.Medication;
import com.Springboot.PMAS.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationRestController {

    @Autowired
    private MedicationService medicationService;

    @PostMapping
    public Medication create(@RequestBody Medication medication) {
        return medicationService.saveMedication(medication);
    }

    @GetMapping
    public List<Medication> getAll() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/{id}")
    public Medication getById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

    @PutMapping("/{id}")
    public Medication update(@PathVariable Long id, @RequestBody Medication medication) {
        return medicationService.updateMedication(id, medication);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicationService.deleteMedication(id);
    }
}
