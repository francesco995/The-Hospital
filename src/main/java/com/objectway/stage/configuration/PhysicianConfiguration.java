package com.objectway.stage.configuration;


import com.objectway.stage.repository.PhysicianRepository;
import com.objectway.stage.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhysicianConfiguration {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Bean
    public PhysicianService physicianService() {
        return new PhysicianService().physicianRepository(physicianRepository);
    }

}
