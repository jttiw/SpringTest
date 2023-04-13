package com.me.bootingSpring.obj;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ObjRepository objRepository) {
        return args -> {
            Obj first = new Obj("object1", LocalDateTime.now());
            Obj scnd = new Obj("object2", LocalDateTime.now());
            objRepository.saveAll(List.of(first, scnd));
        };
    }
}
