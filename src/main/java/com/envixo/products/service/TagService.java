package com.envixo.products.service;

import com.envixo.products.dto.TagDto;
import com.envixo.products.model.Tag;
import com.envixo.products.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends GenericService<TagDto, Tag> {

    public TagService(TagRepository repository) {
        super(repository);
    }

    @Override
    Class<TagDto> getDtoClass() {
        return TagDto.class;
    }

    @Override
    Class<Tag> getModelClass() {
        return Tag.class;
    }
}
