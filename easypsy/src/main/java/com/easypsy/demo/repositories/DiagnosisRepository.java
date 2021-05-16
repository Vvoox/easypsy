package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Diagnosis;
import com.easypsy.demo.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis,Long> {
}
