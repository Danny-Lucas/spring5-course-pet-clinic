package com.example.petclinic.config;

import com.example.petclinic.models.PetType;
import com.example.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;

@PropertySource("classpath:datasource.properties")
@Configuration
public class PetConfig {

    @Value("${animal.best}")
    String bestPet;

    PetTypeService service;

    public PetConfig(PetTypeService service) {
        this.service = service;
    }

//    @Bean
//    public HashMap<String, PetType> petTypes() {
//        HashMap<String, PetType> map = new HashMap<>();
//        map.put("dog", getPetType("dog"));
//        map.put("cat", getPetType("cat"));
//        map.put(bestPet, getPetType(bestPet));
//        return map;
//    }
//
//    private PetType getPetType(String type) {
//        PetType a = new PetType();
//        a.setName(type);
//        return a;
//    }
}
