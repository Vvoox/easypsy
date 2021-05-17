package com.easypsy.demo.repositories;

import com.easypsy.demo.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
