package com.objectway.stage.configuration;


import com.objectway.stage.repository.PatientRepository;
import com.objectway.stage.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {

    @Autowired
    private PatientRepository patientRepository;

    @Bean
    public PatientService patientService() {
        return new PatientService().patientRepository(patientRepository);
    }


}
