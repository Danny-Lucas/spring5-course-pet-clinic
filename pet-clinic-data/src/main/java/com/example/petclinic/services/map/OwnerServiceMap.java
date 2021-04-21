package com.example.petclinic.services.map;

import com.example.petclinic.models.Owner;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetService;
import com.example.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null && !owner.getPets().isEmpty()) {
                boolean verified = owner.getPets().stream().anyMatch(pet -> pet.getPetType() == null);
                if (!verified) {
                    throw new RuntimeException("PetType can't be null");
                }
            }
            return super.save(owner);
        }
        return null;
    }
}
