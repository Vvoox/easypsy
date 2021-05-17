package com.easypsy.demo.controllers;

import com.easypsy.demo.models.Diagnosis;
import com.easypsy.demo.models.Scale;
import com.easypsy.demo.services.DiagnosisServices;
import com.easypsy.demo.services.ScaleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/diagnosis")
@RequiredArgsConstructor
@RestController
public class DiagnosisController {

    private final DiagnosisServices diagnosisServices;

    @PostMapping("/add")
    public Diagnosis addDiagnosis(@RequestBody Diagnosis diagnosis){
        return diagnosisServices.addDiagnosis(diagnosis);
    }

    @GetMapping("/{id}")
    public Diagnosis getDiagnosis(@PathVariable long id){
        return diagnosisServices.getDiagnosisById(id);
    }

    @PutMapping("/{id}/modify")
    public Diagnosis modifyDiagnosis(@PathVariable long id, @RequestBody Diagnosis diagnosis){
        return diagnosisServices.modifyDiagnosis(id,diagnosis);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteDiagnosis(@PathVariable long id){
        return diagnosisServices.deleteDiagnosis(id);
    }
}
