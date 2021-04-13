package com.easypsy.demo;

import com.easypsy.demo.enumerations.QuestionsState;
import com.easypsy.demo.models.*;
import com.easypsy.demo.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EasypsyApplication implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ScaleRepository scaleRepository;
    private final QuestionRepository questionRepository;
    public static void main(String[] args) {
        SpringApplication.run(EasypsyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Doctor doctor = Doctor.builder()
//                .firstName("Doctor")
//                .lastName("house")
//                .address("Casablanca")
//                .phoneNumber("+212645789685")
//                .email("doctor.house@gmail.com")
//                .build();
//        doctorRepository.save(doctor);
//
//        Patient patient = Patient.builder()
//                .firstName("Khalil")
//                .lastName("Daoulat")
//                .address("Marrakech")
//                .email("daoulat.khalil@gmail.com")
//                .doctor(doctor)
//                .build();
//        patientRepository.save(patient);
//
//        Scale scale = Scale.builder()
//                .scaleName("Skizo Analyse")
//                .patient(patient)
//                .build();
//        scaleRepository.save(scale);
//
//        Question question = Question.builder()
//                .question("How do you feel?")
//                .score(100)
//                .scale(scale)
//                .build();
//
//        questionRepository.save(question);

    }

}
