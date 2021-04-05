package com.easypsy.demo.services;

import com.easypsy.demo.models.Doctor;
import com.easypsy.demo.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DoctorServices {

    private final DoctorRepository doctorRepository;

    public Doctor getDctorById(long id){
        return doctorRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor not found!")
        );
    }

    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor modifyDoctor(long id, Doctor doctor){
        Doctor doctor1 = getDctorById(id);
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public Map<String,String> deleteDoctor(long id){
        getDctorById(id);
        doctorRepository.deleteById(id);
        return Map.of("Success","Done");
    }
}
