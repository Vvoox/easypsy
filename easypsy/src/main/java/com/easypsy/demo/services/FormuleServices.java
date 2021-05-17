package com.easypsy.demo.services;

import com.easypsy.demo.models.Diagnosis;
import com.easypsy.demo.models.Formule;
import com.easypsy.demo.repositories.DiagnosisRepository;
import com.easypsy.demo.repositories.FormuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class FormuleServices {

    private final FormuleRepository formuleRepository;


    public Formule addFormule(Formule formule) {
        return formuleRepository.save(formule);
    }

    public Formule getFormuleByById(long id) {
        return formuleRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Formula not found")
        );
    }

    public Formule modifyFormule(long id, Formule formule) {
        Formule oldFormule = getFormuleByById(id);
        oldFormule.setId(formule.getId());
        return formuleRepository.save(formule);
    }

    public Map<String, String> deleteFormule(long id) {
        getFormuleByById(id);
        formuleRepository.deleteById(id);
        return Map.of("Success","Done");
    }
}
