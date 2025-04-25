package com.Springboot.PMAS.Repository;

import com.Springboot.PMAS.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
