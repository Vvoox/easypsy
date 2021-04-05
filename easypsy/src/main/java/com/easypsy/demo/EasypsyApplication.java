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
    private final AnalyseRepository analyseRepository;
    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    public static void main(String[] args) {
        SpringApplication.run(EasypsyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Question question = Question.builder()
                .question("How do you feel?")
                .score(100)
                .questionsState(QuestionsState.GOOD)
                .build();

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        Test test = Test.builder()
                .testName("skizo")
                .questionList(questionList)
                .build();

        List<Test> tests = new ArrayList<>();
        tests.add(test);
        Analyse analyse = Analyse.builder()
                .analyseName("Skizo Analyse")
                .test(tests)
                .build();

        List<Analyse> analyseList = new ArrayList<>();
        analyseList.add(analyse);
        Patient patient = Patient.builder()
                .firstName("Khalil")
                .lastName("Daoulat")
                .address("Marrakech")
                .analyseList(analyseList)
                .email("daoulat.khalil@gmail.com")
                .build();

        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        Doctor doctor = Doctor.builder()
                .firstName("Doctor")
                .lastName("house")
                .address("Casablanca")
                .patientList(patientList)
                .phoneNumber("+212645789685")
                .email("doctor.house@gmail.com")
                .build();

        questionRepository.save(question);
        testRepository.save(test);
        analyseRepository.save(analyse);
        patientRepository.save(patient);
        doctorRepository.save(doctor);

    }

}
