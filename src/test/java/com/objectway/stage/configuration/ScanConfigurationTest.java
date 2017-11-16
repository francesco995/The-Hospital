package com.objectway.stage.configuration;

import com.objectway.stage.model.*;
import com.objectway.stage.service.AppointmentService;
import com.objectway.stage.service.NurseService;
import com.objectway.stage.service.PatientService;
import com.objectway.stage.service.PhysicianService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Set;

import static java.awt.SystemColor.info;


//@ImportResource("/home/prometheus/IdeaProjects/TheHospital/src/main/webapp/WEB-INF/spring-servlet.xml")
@ContextConfiguration(classes = {
        ScanConfiguration.class
})

@RunWith(SpringJUnit4ClassRunner.class)
public class ScanConfigurationTest {

    private Logger logger = LoggerFactory.getLogger(SpringJUnit4ClassRunner.class);

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PhysicianService physicianService;




    @Test
    public void testAppointmentServiceConfiguration() {

        Set<Appointment> appointments = appointmentService.getAllAppointments();
        Set<Nurse> nurses = nurseService.getAllNourses();
        Set<Patient> patients = patientService.getAllPatients();
        Set<Physician> physicians = physicianService.getAllPhysicians();




        Assert.notEmpty(appointments);
        Assert.notEmpty(nurses);
        Assert.notEmpty(patients);
        Assert.notEmpty(physicians);

        log(appointments);
        log(nurses);
        log(patients);
        log(physicians);


    }

    private void log(Collection collection) {
        collection.stream().forEach(o -> logger.info(o.toString()));
    }


}