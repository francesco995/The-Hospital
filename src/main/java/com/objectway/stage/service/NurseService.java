package com.objectway.stage.service;

import com.objectway.stage.model.Nurse;
import com.objectway.stage.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;


    @Transactional
    public Set<Nurse> getAllNourses() {

        Set<Nurse> nurses = new HashSet<>();

        nurseRepository.findAll().iterator().forEachRemaining(n -> nurses.add(n));

        return nurses;
    }

}
