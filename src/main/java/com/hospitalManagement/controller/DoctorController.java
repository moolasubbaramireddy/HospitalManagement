package com.hospitalManagement.controller;

import com.hospitalManagement.entity.Doctor;
import com.hospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping()
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
           Doctor createDoctor= doctorService.createDoctor(doctor);
            return new ResponseEntity<>( createDoctor, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors=doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor updateDoctor){
       Doctor doctor= doctorService.updateDoctor(id,updateDoctor);
       if(doctor != null){
           return new ResponseEntity<>(doctor,HttpStatus.OK);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        boolean deleted = doctorService.deleteDoctor(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
