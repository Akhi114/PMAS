package com.Springboot.PMAS.Repository;

import com.Springboot.PMAS.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
