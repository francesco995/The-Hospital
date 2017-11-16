package com.objectway.stage.configuration;

import com.objectway.stage.model.Appointment;
import com.objectway.stage.service.AppointmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Set;


//@ImportResource("/home/prometheus/IdeaProjects/TheHospital/src/main/webapp/WEB-INF/spring-servlet.xml")
@ContextConfiguration(classes = {
        ScanConfiguration.class
})

@RunWith(SpringJUnit4ClassRunner.class)
public class ScanConfigurationTest {

    private Logger logger = LoggerFactory.getLogger(SpringJUnit4ClassRunner.class);

    @Autowired
    private AppointmentService appointmentService;




    @Test
    public void testAppointmentServiceConfiguration() {

        Set<Appointment> appointments = appointmentService.getAllAppointments();

        for (Appointment appointment : appointments) {
            logger.info(appointment.toString());
        }

        Assert.notEmpty(appointments);


    }

}