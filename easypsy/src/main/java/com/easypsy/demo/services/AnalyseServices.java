package com.easypsy.demo.services;

import com.easypsy.demo.models.Analyse;
import com.easypsy.demo.repositories.AnalyseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyseServices {

    private final AnalyseRepository analyseRepository;

    public Analyse getAnaylseById(long id){
        return analyseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"analyse not found!")
        );
    }
    public Analyse addAnalyse(Analyse analyse){
        return analyseRepository.save(analyse);
    }

    public Analyse modifyAnalyse(long id , Analyse analyse){
        Analyse oldAnalyse = getAnaylseById(id);
        analyse.setId(oldAnalyse.getId());
        return analyseRepository.save(analyse);
    }

    public Map<String,String> deleteAnalyse(long id){
        Analyse analyse = getAnaylseById(id);
        return Map.of("Success","Done");
    }
}
