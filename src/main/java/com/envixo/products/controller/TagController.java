package com.envixo.products.controller;

import com.envixo.products.dto.TagDto;
import com.envixo.products.model.Tag;
import com.envixo.products.service.TagService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tags")
public class TagController extends GenericController<TagDto, Tag, TagService> {

    public TagController(TagService service) {
        super(service);
    }

    @GetMapping("/{id}")
    public TagDto get(@PathVariable Long id) {
        return super.get(id);
    }

    @PostMapping
    public TagDto create(@RequestBody @Valid TagDto dto) {
        return super.create(dto);
    }

    @PutMapping("/{id}")
    public TagDto update(@PathVariable Long id, @RequestBody @Valid TagDto dto) {
        return super.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
