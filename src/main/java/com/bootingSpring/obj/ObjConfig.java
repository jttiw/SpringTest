package com.bootingSpring.obj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ObjRepository objRepository) {
        return args -> {
            Obj first = new Obj("object1", LocalDate.now(), LocalTime.now());
            Obj scnd = new Obj("object2", LocalDate.now(), LocalTime.now());
            objRepository.saveAll(List.of(first, scnd));
        };
    }
}
