//package com.easypsy.demo.models;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Test {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String testName;
//    private String address;
//    private long globalScore;
//
//    @ManyToOne
//    private Analyse analyse;
//
//    @OneToMany
//    private List<Question> questionList;
//
//    @CreationTimestamp
//    private LocalDate createDate;
//
//    @UpdateTimestamp
//    private LocalDate modifiedDate;
//
//}
