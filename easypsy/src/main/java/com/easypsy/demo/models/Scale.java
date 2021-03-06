package com.easypsy.demo.models;


import com.easypsy.demo.enumerations.TypeState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String scaleName;
    private LocalDate date;
    private long finalScore;
    private TypeState type;

//    @ManyToOne
//    private Diagnosis diagnosis;


    @OneToMany
    private List<Formule> formules;


    @CreationTimestamp
    private LocalDate createDate;

    @UpdateTimestamp
    private LocalDate modifiedDate;
}
