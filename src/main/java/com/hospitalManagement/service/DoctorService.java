package com.hospitalManagement.service;

import com.hospitalManagement.repository.DoctorRepository;
import com.hospitalManagement.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor updateDoctor){
       Optional<Doctor> optionalDoctor= doctorRepository.findById(id);

       if(optionalDoctor.isPresent()){
           Doctor doctor=optionalDoctor.get();
               doctor.setFirstName(updateDoctor.getFirstName());
               doctor.setLastName(updateDoctor.getLastName());
               doctor.setSpeciality(updateDoctor.getSpeciality());
               doctor.setEmail(updateDoctor.getEmail());
               doctor.setPhoneNumber(updateDoctor.getPhoneNumber());

               return  doctorRepository.save(doctor);

       }else {
           return null;
       }
    }

    public boolean deleteDoctor(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            doctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
