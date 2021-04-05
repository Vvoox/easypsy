package com.easypsy.demo.models;


import com.easypsy.demo.enumerations.QuestionsState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private long score;
    private QuestionsState questionsState;

    @ManyToOne
    private Test test;

}
