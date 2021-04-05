package com.easypsy.demo.controllers;


import com.easypsy.demo.models.Analyse;
import com.easypsy.demo.models.Doctor;
import com.easypsy.demo.services.DoctorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServices doctorServices;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorServices.addDoctor(doctor);
    }

    @GetMapping("/all")
    public List<Doctor> getDoctor(){
        return doctorServices.getAllDoctor();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable long id){
        return doctorServices.getDctorById(id);
    }

    @PutMapping("/{id}/modify")
    public Doctor modifyDoctor(@PathVariable long id, @RequestBody Doctor doctor){
        return doctorServices.modifyDoctor(id,doctor);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteDoctor(@PathVariable long id){
        return doctorServices.deleteDoctor(id);
    }
}
