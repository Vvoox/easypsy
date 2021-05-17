package com.easypsy.demo.models;


import com.easypsy.demo.enumerations.QuestionsState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
//    private QuestionsState questionsState;

    @ManyToOne
    private Answer answer;

//    @OneToOne
//    private Answer answer;






}
