package com.example.petclinic.services.map;

import com.example.petclinic.model.BaseEntity;
import com.example.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T extends BaseEntity, ID> implements CrudService<T, ID> {
    Map<ID, T> map = new HashMap<>();
    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T obj) {
        return map.put((ID) obj.getId(), obj);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(obj -> obj.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
