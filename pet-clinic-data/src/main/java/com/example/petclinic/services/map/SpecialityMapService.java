package com.example.petclinic.services.map;

import com.example.petclinic.models.Speciality;
import com.example.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {
}
