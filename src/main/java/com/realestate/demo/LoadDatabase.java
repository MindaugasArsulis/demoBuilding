package com.realestate.demo;

import com.realestate.demo.bl.repositories.BuildingRepository;
import com.realestate.demo.model.BuildingEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BuildingRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new BuildingEntity("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new BuildingEntity("Frodo Baggins", "thief")));
        };
    }
}
