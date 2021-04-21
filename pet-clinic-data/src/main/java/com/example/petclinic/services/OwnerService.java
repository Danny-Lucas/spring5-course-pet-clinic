package com.example.petclinic.services;

import com.example.petclinic.models.Owner;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
