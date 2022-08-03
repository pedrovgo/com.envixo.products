package com.envixo.products.service;

import com.envixo.products.dto.GenericDto;
import com.envixo.products.dto.ResultDto;
import com.envixo.products.dto.ResultListDto;
import com.envixo.products.model.GenericModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericService<T extends GenericDto, M extends GenericModel> {

    protected final JpaRepository<M, Long> repository;

    protected GenericService(JpaRepository<M, Long> repository) {
        this.repository = repository;
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    abstract Class<T> getDtoClass();

    abstract Class<M> getModelClass();

    protected List<T> map(List<M> models) {
        final ResultListDto<T, List<T>> result = new ResultListDto(null);
        Optional.ofNullable(models).ifPresent(ms -> {
            final List<T> list = ms.stream().map(m -> map(m)).collect(Collectors.toList());
            result.setResult(list);
        });
        return result.getResult();
    }

    protected T map(M model) {
        return objectMapper.convertValue(model, getDtoClass());
    }

    public T get(Long id) {
        final ResultDto<T> result = new ResultDto(null);
        repository.findById(id).ifPresent(m -> result.setResult(map(m)));
        return result.getResult();
    }

    public List<T> get() {
        return map(repository.findAll());
    }

    public T save(T dto) {
        M model = objectMapper.convertValue(dto, getModelClass());
        model = repository.save(model);
        postSave(dto, model);
        return objectMapper.convertValue(model, getDtoClass());
    }

    protected void postSave(T dto, M model) {

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
