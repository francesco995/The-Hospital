package com.objectway.stage.service;


import com.objectway.stage.model.Patient;
import com.objectway.stage.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Set<Patient> getAllPatients() {

        Set<Patient> patients = new HashSet<>();

        patientRepository.findAll().iterator().forEachRemaining(p -> patients.add(p));

        return patients;
    }




}
