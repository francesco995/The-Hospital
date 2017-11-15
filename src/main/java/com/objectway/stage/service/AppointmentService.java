package com.objectway.stage.service;

import com.objectway.stage.model.Appointment;
import com.objectway.stage.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Transactional
    public Set<Appointment> getAllAppointments() {

        Set<Appointment> appointments = new HashSet<>();

        appointmentRepository.findAll().iterator().forEachRemaining(a -> appointments.add(a));

        return appointments;
    }


}
