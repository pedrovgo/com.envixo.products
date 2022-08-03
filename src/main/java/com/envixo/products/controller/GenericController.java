package com.envixo.products.controller;

import com.envixo.products.dto.GenericDto;
import com.envixo.products.model.GenericModel;
import com.envixo.products.service.GenericService;

import java.util.List;

public abstract class GenericController<T extends GenericDto, M extends GenericModel, S extends GenericService<T, M>> {

    final protected S service;

    protected GenericController(S service) {
        this.service = service;
    }

    public T get(Long id){
        return service.get(id);
    }

    public List<T> get() { return service.get(); }

    public T create(T dto) {
        dto.setId(0L);
        return service.save(dto);
    }

    public T update(Long id, T dto) {
        dto.setId(id);
        return service.save(dto);
    }

    public void delete(Long id)  {
        service.delete(id);
    }
}
