package com.example.petclinic.services.map;

import com.example.petclinic.models.BaseEntity;
import com.example.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    Map<Long, T> map = new HashMap<>();
    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T obj) {
        if (obj != null) {
            if (obj.getId() == null) {
                obj.setId(getNextId());
            }
            map.put(obj.getId(), obj);
        } else {
            throw new RuntimeException("Object cannot be null.");
        }
        return obj;
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

    protected Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
