package com.Springboot.PMAS.Controller;

import com.Springboot.PMAS.Entity.Appointment;
import com.Springboot.PMAS.Service.AppointmentService;
import com.Springboot.PMAS.Service.DoctorService;
import com.Springboot.PMAS.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @GetMapping("/add")
    public String showAddAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "add-appointment";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/edit/{id}")
    public String showEditAppointmentForm(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "edit-appointment";
    }

    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute Appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}