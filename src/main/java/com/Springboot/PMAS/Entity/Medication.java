package com.Springboot.PMAS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dosage;
    private String frequency;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDosage() { return dosage; }

    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getFrequency() { return frequency; }

    public void setFrequency(String frequency) { this.frequency = frequency; }

    public String getDuration() { return duration; }

    public void setDuration(String duration) { this.duration = duration; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }
}
