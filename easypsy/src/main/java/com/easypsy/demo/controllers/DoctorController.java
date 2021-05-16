package com.easypsy.demo.controllers;


import com.easypsy.demo.models.Doctor;
import com.easypsy.demo.repositories.DoctorRepository;
import com.easypsy.demo.services.DoctorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServices doctorServices;

//    @Bean
//    public RouterFunction<ServerResponse> productListing(DoctorRepository doctorRepository) {
//        return route().GET("/doctor", req -> ok().body(doctorRepository.findAll()))
//                .build();
//    }

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
