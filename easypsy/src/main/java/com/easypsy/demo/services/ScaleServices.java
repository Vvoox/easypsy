package com.easypsy.demo.services;

import com.easypsy.demo.models.Scale;
import com.easypsy.demo.repositories.ScaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScaleServices {

    private final ScaleRepository scaleRepository;

    public Scale getScaleById(long id){
        return scaleRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"sclae not found!")
        );
    }
    public Scale addScale(Scale scale){
        return scaleRepository.save(scale);
    }

    public Scale modifyScale(long id , Scale scale){
        Scale oldAnalyse = getScaleById(id);
        scale.setId(oldAnalyse.getId());
        return scaleRepository.save(scale);
    }

    public Map<String,String> deleteScale(long id){
        getScaleById(id);
        return Map.of("Success","Done");
    }
}
