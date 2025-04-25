package com.Springboot.PMAS.Repository;

import com.Springboot.PMAS.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
