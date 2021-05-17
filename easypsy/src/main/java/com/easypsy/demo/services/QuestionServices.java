package com.easypsy.demo.services;

import com.easypsy.demo.models.Answer;
import com.easypsy.demo.models.Formule;
import com.easypsy.demo.models.Question;
import com.easypsy.demo.models.Scale;
import com.easypsy.demo.repositories.FormuleRepository;
import com.easypsy.demo.repositories.QuestionRepository;
import com.easypsy.demo.repositories.ScaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class QuestionServices {

    private final QuestionRepository questionRepository;
    private final ScaleRepository scaleRepository;
    private final FormuleServices formuleServices;
    private final ScaleServices scaleServices;


    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(long id) {
        return questionRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Question not found")
        );
    }

    public Question modifyQuestion(long id, Question question) {
        Question oldQuestion = getQuestionById(id);
        oldQuestion.setId(question.getId());
        return questionRepository.save(question);
    }

    public Map<String, String> deleteQuestion(long id) {
        getQuestionById(id);
        questionRepository.deleteById(id);
        return Map.of("Success","Done");
    }

    public Question addAnswerToQuestion(long scaleId , long formuleId, long questionId, long answerId){
        Scale scale = scaleServices.getScaleById(scaleId);
        Formule formule = scale.getFormules().stream().filter(
                formule1 -> formuleId == formule1.getId()
        ).findAny().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Formula t found"));

        Question oldQuestion = formule.getQuestionList().stream().filter(
                question -> questionId == question.getId())
                .findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Question not found !"));

        Answer answer = formule.getAnswersPossibles().stream()
                .filter(
                    answer1 ->  answerId == answer1.getId())
                .findAny()
                .orElseThrow(
                    ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Answer with id = "+answerId+" not found"));
        if(oldQuestion.getAnswer() == null){
            scale.setFinalScore(scale.getFinalScore() + answer.getScore());
        } else {
            scale.setFinalScore(scale.getFinalScore() - oldQuestion.getAnswer().getScore() + answer.getScore());
        }
        oldQuestion.setAnswer(answer);
        scaleRepository.save(scale);
        return questionRepository.save(oldQuestion);

    }
}
