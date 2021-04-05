package com.easypsy.demo.controllers;

import com.easypsy.demo.models.Analyse;
import com.easypsy.demo.models.Doctor;
import com.easypsy.demo.repositories.AnalyseRepository;
import com.easypsy.demo.services.AnalyseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/analyse")
@RequiredArgsConstructor
public class AnalyseController {

    private final AnalyseServices analyseServices;

    @PostMapping("/add")
    public Analyse addAnalyse(@RequestBody Analyse analyse){
        return analyseServices.addAnalyse(analyse);
    }

    @GetMapping("/{id}")
    public Analyse getAnalyse(@PathVariable long id){
        return analyseServices.getAnaylseById(id);
    }

    @PutMapping("/{id}/modify")
    public Analyse modifyAnalyse(@PathVariable long id, @RequestBody Analyse analyse){
        return analyseServices.modifyAnalyse(id,analyse);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteAnalyse(@PathVariable long id){
        return analyseServices.deleteAnalyse(id);
    }
}
