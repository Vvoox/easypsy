package com.easypsy.demo;

import com.easypsy.demo.enumerations.QuestionsState;
import com.easypsy.demo.enumerations.TypeState;
import com.easypsy.demo.models.*;
import com.easypsy.demo.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
@RequiredArgsConstructor
public class EasypsyApplication implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ScaleRepository scaleRepository;
    private final QuestionRepository questionRepository;
    private final DiagnosisRepository diagnosticRepository;
    private final FormuleRepository formuleRepository;
    private final  AnswerRepository answerRepository;
    public static void main(String[] args) {
        SpringApplication.run(EasypsyApplication.class, args);
    }


    @Bean
    public Supplier<String> hello(){
        return ()-> "Hello";
    }
    @Override
    public void run(String... args) throws Exception {

//        Answer answer0 = Answer.builder().score(0).answer("Jamais").build();
//        Answer answer1 = Answer.builder().score(1).answer("Plusieurs jours").build();
//        Answer answer2 = Answer.builder().score(2).answer("Plus de sept jours").build();
//        Answer answer3 = Answer.builder().score(3).answer("Presque tous les jours").build();
//
//        answerRepository.save(answer0);answerRepository.save(answer1);answerRepository.save(answer2);
//        answerRepository.save(answer3);
//
//        List<Answer> answerList = new ArrayList<>(){{add(answer0);add(answer1);add(answer2);add(answer3);}};
//
//        Question question1 = Question.builder()
//                .question("Se sentir triste, déprimé(e) ou désespéré(e)")
//                .answer(answer1)
//                .build();
//
//        Question question = Question.builder()
//                .question("Peu d’intérêt ou de plaisir à faire des choses")
//                .answer(answer2)
//                .build();
//
//        questionRepository.save(question);
//        questionRepository.save(question1);
//
//        List<Question> questions = new ArrayList<>(){{add(question);add(question1);}};
//
//        Formule formule = Formule.builder()
//                .nameFormule("Au cours des deux dernières semaines , à quelle fréquence avez-vous été dérangé(e) par les\n" +
//                        "problèmes suivants?")
//                .questionList(questions)
//                .answersPossibles(answerList)
//                .build();
//
//        formuleRepository.save(formule);
//
//        List<Formule> formuleList = new ArrayList<>(){{add(formule);}};
//
//        Scale scale = Scale.builder()
//                .scaleName("QUESTIONNAIRE SUR LA SANTÉ DU PATIENT-9")
//                .formules(formuleList)
//                .type(TypeState.NUMERIC)
//                .build();
//        scaleRepository.save(scale);
//
//
//        List<Scale> scales = new ArrayList<>(){{add(scale);}};
//
//        Diagnosis diagnose  = Diagnosis.builder()
//                .name("Le trouble panique")
//                .scale(scales)
//                .build();
//        diagnosticRepository.save(diagnose);
//
//        List<Diagnosis> diagnoses = new ArrayList<>(){{add(diagnose);}};
//
//        Patient patient = Patient.builder()
//                .firstName("Khalil")
//                .lastName("Daoulat")
//                .address("Marrakech")
//                .diagnosis(diagnoses)
//                .email("daoulat.khalil@gmail.com")
//                .build();
//        patientRepository.save(patient);
//
//        List<Patient> list = new ArrayList<>(){{add(patient);}};
//
//        Doctor doctor = Doctor.builder()
//                .firstName("Doctor")
//                .lastName("house")
//                .address("Casablanca")
//                .phoneNumber("+212645789685")
//                .email("doctor.house@gmail.com")
//                .patientList(list)
//                .build();
//        doctorRepository.save(doctor);



    }

}
