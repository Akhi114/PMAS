package com.Springboot.PMAS.Controller;

import com.Springboot.PMAS.Entity.Medication;
import com.Springboot.PMAS.Service.MedicationService;
import com.Springboot.PMAS.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String listMedications(Model model) {
        model.addAttribute("medications", medicationService.getAllMedications());
        return "medications";
    }

    @GetMapping("/add")
    public String showAddMedicationForm(Model model) {
        model.addAttribute("medication", new Medication());
        model.addAttribute("patients", patientService.getAllPatients());
        return "add-medication";
    }

    @PostMapping("/add")
    public String addMedication(@ModelAttribute Medication medication) {
        medicationService.saveMedication(medication);
        return "redirect:/medications";
    }

    @GetMapping("/edit/{id}")
    public String showEditMedicationForm(@PathVariable Long id, Model model) {
        Medication medication = medicationService.getMedicationById(id);
        model.addAttribute("medication", medication);
        model.addAttribute("patients", patientService.getAllPatients());
        return "edit-medication";
    }

    @PostMapping("/update/{id}")
    public String updateMedication(@PathVariable Long id, @ModelAttribute Medication medication) {
        medicationService.updateMedication(id, medication);
        return "redirect:/medications";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return "redirect:/medications";
    }
}
