package com.example.petclinic.bootstrap;

import com.example.petclinic.models.Owner;
import com.example.petclinic.models.Pet;
import com.example.petclinic.models.PetType;
import com.example.petclinic.models.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = createOwner("Piet", "Friet");
        Owner owner2 = createOwner( "Kees", "Kroket");

        createVet("Marlies", "de Vries");
        createVet( "Fred", "Feestbeest");

        petTypeService.save(new PetType("dog"));
        petTypeService.save(new PetType("cat"));
        PetType birdType = petTypeService.save(new PetType("bird"));

        Pet bird = new Pet();
        bird.setOwner(owner1);
        bird.setPetType(birdType);

        owner1.addPet(bird);

        System.out.println(bird.getOwner().getFirstName());
    }

    private Owner createOwner(String name, String lastName) {
        Owner owner = new Owner();
        owner.setFirstName(name);
        owner.setLastName(lastName);
        owner.setAddress("Weteringstraat 18");
        owner.setCity("Breda");
        owner.setTelephone("239048123");
        ownerService.save(owner);
        return owner;
    }

    private Vet createVet(String name, String lastName) {
        Vet vet = new Vet();
        vet.setFirstName(name);
        vet.setLastName(lastName);
        vetService.save(vet);
        return vet;
    }

}
