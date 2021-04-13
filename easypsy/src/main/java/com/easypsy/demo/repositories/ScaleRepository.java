package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScaleRepository extends JpaRepository<Scale,Long> {
}
