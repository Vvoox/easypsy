package com.easypsy.demo.controllers;

import com.easypsy.demo.models.Doctor;
import com.easypsy.demo.models.Question;
import com.easypsy.demo.models.Scale;
import com.easypsy.demo.services.QuestionServices;
import com.easypsy.demo.services.ScaleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/scale")
@RequiredArgsConstructor
@RestController
public class ScaleController {

    private final ScaleServices scaleServices;
    private final QuestionServices questionServices;

    @PostMapping("/add")
    public Scale addAnalyse(@RequestBody Scale scale){
        return scaleServices.addScale(scale);
    }

    @GetMapping("/{id}")
    public Scale getAnalyse(@PathVariable long id){
        return scaleServices.getScaleById(id);
    }

    @PutMapping("/{id}/modify")
    public Scale modifyAnalyse(@PathVariable long id, @RequestBody Scale scale){
        return scaleServices.modifyScale(id,scale);
    }

    @PutMapping("/{scaleId}/add-answer")
    public Question addAnswerToQuestion(@PathVariable long scaleId,@RequestParam long formula, @RequestParam long question , @RequestParam long answer){
        return questionServices.addAnswerToQuestion(scaleId,formula,question,answer);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteAnalyse(@PathVariable long id){
        return scaleServices.deleteScale(id);
    }
}
