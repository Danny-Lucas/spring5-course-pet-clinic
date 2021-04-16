package com.example.petclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(ID id);
    T save(T type);
    Set<T> findAll();
    void delete (T object);
    void deleteById(Long id);
}
