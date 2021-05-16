package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Answer;
import com.easypsy.demo.models.Formule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
