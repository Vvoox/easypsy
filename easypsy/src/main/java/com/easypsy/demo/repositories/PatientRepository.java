package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
