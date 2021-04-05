package com.easypsy.demo.services;

import com.easypsy.demo.models.Patient;
import com.easypsy.demo.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientServices {

    private final PatientRepository patientRepository;

    public Patient getPatientById(long id){
        return patientRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND ,"Patient not found")
        );
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient modifyPatient(long id , Patient patient){
        getPatientById(id);
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public Map<String,String> deletePatient(long id){
        getPatientById(id);
        patientRepository.deleteById(id);
        return Map.of("Success","Done");
    }
}
