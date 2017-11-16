package com.objectway.stage.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@Import(
        {
                SpringConfiguration.class,
                AppointmentConfiguration.class,
                PhysicianConfiguration.class,
                NurseConfiguration.class,
                PatientConfiguration.class
        })
@EnableJpaRepositories("com.objectway.stage")
public class ScanConfiguration {




}
