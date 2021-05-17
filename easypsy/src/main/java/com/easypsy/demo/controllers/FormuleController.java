package com.easypsy.demo.controllers;

import com.easypsy.demo.models.Formule;
import com.easypsy.demo.models.Question;
import com.easypsy.demo.services.DiagnosisServices;
import com.easypsy.demo.services.FormuleServices;
import com.easypsy.demo.services.QuestionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/formule")
@RequiredArgsConstructor
@RestController
public class FormuleController {

    private final FormuleServices formuleServices;
    private final QuestionServices questionServices;

    @PostMapping("/add")
    public Formule addFormule(@RequestBody Formule formule){
        return formuleServices.addFormule(formule);
    }

    @GetMapping("/{id}")
    public Formule getFormule(@PathVariable long id){
        return formuleServices.getFormuleByById(id);
    }

    @PutMapping("/{id}/modify")
    public Formule modifyFormule(@PathVariable long id, @RequestBody Formule formule){
        return formuleServices.modifyFormule(id,formule);
    }


    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteFormule(@PathVariable long id){
        return formuleServices.deleteFormule(id);
    }
}
