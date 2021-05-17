package com.easypsy.demo.controllers;

import com.easypsy.demo.models.Answer;
import com.easypsy.demo.models.Formule;
import com.easypsy.demo.models.Question;
import com.easypsy.demo.services.FormuleServices;
import com.easypsy.demo.services.QuestionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/question")
@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final QuestionServices questionServices;

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionServices.addQuestion(question);
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable long id){
        return questionServices.getQuestionById(id);
    }

    @PutMapping("/{id}/modify")
    public Question modifyQuestion(@PathVariable long id, @RequestBody Question question){
        return questionServices.modifyQuestion(id,question);
    }

//    @PutMapping("/{formuleId}/{questionId}/add-answer")
//    public Question addAnswerToQuestion(@PathVariable long formuleId, @PathVariable long questionId , @RequestParam long answer){
//        return questionServices.addOrModifyAnswer(formuleId,questionId,answer);
//    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteQuestion(@PathVariable long id){
        return questionServices.deleteQuestion(id);
    }
}
