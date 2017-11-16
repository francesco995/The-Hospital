package com.objectway.stage.configuration;

import com.objectway.stage.repository.AppointmentRepository;
import com.objectway.stage.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Bean
    public AppointmentService appointmentService() {

        return new AppointmentService().appointmentRepository(appointmentRepository);

    }


}
