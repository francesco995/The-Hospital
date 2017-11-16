package com.objectway.stage.configuration;


import com.objectway.stage.repository.NurseRepository;
import com.objectway.stage.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurseConfiguration {

    @Autowired
    private NurseRepository nurseRepository;

    @Bean
    public NurseService nurseService() {
        return new NurseService().nurseRepository(nurseRepository);
    }



}
