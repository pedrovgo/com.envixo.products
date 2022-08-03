package com.envixo.products.controller;


import com.envixo.products.dto.ProductDto;
import com.envixo.products.enums.Status;
import com.envixo.products.model.Product;

import com.envixo.products.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends GenericController<ProductDto, Product, ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return super.get(id);
    }

    @GetMapping
    public List<ProductDto> get(@RequestParam(required=false) String status) {
        return service.get(status);
    }

    @PostMapping
    public ProductDto create(@RequestBody @Valid ProductDto dto) {
        return super.create(dto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody @Valid ProductDto dto) {
        return super.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
