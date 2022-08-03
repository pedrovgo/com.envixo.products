package com.envixo.products.controller;

import com.envixo.products.dto.CategoryDto;
import com.envixo.products.model.Category;
import com.envixo.products.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends GenericController<CategoryDto, Category, CategoryService> {

    public CategoryController(CategoryService service) {
        super(service);
    }

    @GetMapping("/{id}")
    public CategoryDto get(@PathVariable Long id) {
        return super.get(id);
    }

    @GetMapping
    public List<CategoryDto> get() {
        return super.get();
    }

    @PostMapping
    public CategoryDto create(@RequestBody @Valid CategoryDto dto) {
        return super.create(dto);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody @Valid CategoryDto dto) {
        return super.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
