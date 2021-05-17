package com.easypsy.demo.models;


import com.easypsy.demo.enumerations.QuestionsState;
import com.easypsy.demo.enumerations.TypeState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Formule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameFormule;

    @OneToMany
    private List<Answer> answersPossibles;
//    private QuestionsState state;

//    @ManyToOne
//    private Scale scale;

    @OneToMany
    private List<Question> questionList;





}
