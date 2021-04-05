package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
}
