package com.Springboot.PMAS.Service;

import com.Springboot.PMAS.Entity.Appointment;
import com.Springboot.PMAS.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existing = getAppointmentById(id);
        existing.setDate(appointment.getDate());
        existing.setDate(appointment.getDate());
        existing.setDoctor(appointment.getDoctor());
        existing.setPatient(appointment.getPatient());
        existing.setTimeSlot(appointment.getTimeSlot());
        return appointmentRepository.save(existing);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
