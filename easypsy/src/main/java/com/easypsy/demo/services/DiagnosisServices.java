package com.easypsy.demo.services;

import com.easypsy.demo.models.Diagnosis;
import com.easypsy.demo.models.Scale;
import com.easypsy.demo.repositories.DiagnosisRepository;
import com.easypsy.demo.repositories.ScaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiagnosisServices {

    private final DiagnosisRepository diagnosisRepository;


    public Diagnosis addDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public Diagnosis getDiagnosisById(long id) {
        return diagnosisRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Diagnosis not found")
        );
    }

    public Diagnosis modifyDiagnosis(long id, Diagnosis diagnosis) {
        Diagnosis oldDiagnosis = getDiagnosisById(id);
        oldDiagnosis.setId(diagnosis.getId());
        return diagnosisRepository.save(diagnosis);
    }

    public Map<String, String> deleteDiagnosis(long id) {
        getDiagnosisById(id);
        diagnosisRepository.deleteById(id);
        return Map.of("Success","Done");
    }
}
