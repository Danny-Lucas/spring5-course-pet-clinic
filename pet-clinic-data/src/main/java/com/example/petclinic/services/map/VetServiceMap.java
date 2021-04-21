package com.example.petclinic.services.map;

import com.example.petclinic.models.Vet;
import com.example.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}
