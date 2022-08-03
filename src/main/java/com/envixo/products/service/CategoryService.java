package com.envixo.products.service;

import com.envixo.products.dto.CategoryDto;
import com.envixo.products.model.Category;
import com.envixo.products.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<CategoryDto, Category> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    @Override
    Class<CategoryDto> getDtoClass() {
        return CategoryDto.class;
    }

    @Override
    Class<Category> getModelClass() {
        return Category.class;
    }
}
