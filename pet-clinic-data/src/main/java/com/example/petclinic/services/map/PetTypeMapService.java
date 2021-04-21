package com.example.petclinic.services.map;

import com.example.petclinic.models.PetType;
import com.example.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
