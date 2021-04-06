package com.easypsy.demo.controllers;


import com.easypsy.demo.models.Patient;
import com.easypsy.demo.services.PatientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/patient")
@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientServices patientServices;

    @GetMapping("/all")
    private List<Patient> getAllPatient(){
        return patientServices.getAllPatient();
    }

    @PostMapping("/add")
    private Patient addPatient(@RequestBody Patient patient){
        return patientServices.addPatient(patient);
    }

    @GetMapping("/{id}")
    private Patient getPatientById(@PathVariable long id){
        return patientServices.getPatientById(id);
    }

    @PostMapping("/{id}/modify")
    private Patient modifyPatient(@PathVariable long id ,@RequestBody Patient patient){
        return patientServices.modifyPatient(id,patient); }

    @DeleteMapping("/{id}/delete")
    private Map<String, String> deletePatient(@PathVariable long id){
        return patientServices.deletePatient(id); }

}
