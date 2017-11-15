package com.objectway.stage.service;

import com.objectway.stage.model.Physician;
import com.objectway.stage.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepository;



    @Transactional
    public Set<Physician> getAllPhysicians(){

        Set<Physician> physicians = new HashSet<>();

        Iterable<Physician> physicianIterable = physicianRepository.findAll();

        Iterator<Physician> physicianIterator = physicianIterable.iterator();

        physicianIterator.forEachRemaining(p -> physicians.add(p));

        return physicians;
    }




}
