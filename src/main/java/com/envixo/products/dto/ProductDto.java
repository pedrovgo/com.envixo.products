package com.envixo.products.dto;

import com.envixo.products.dto.search.ProductSearchDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto extends ProductSearchDto {
    CategoryDto category;
    List<TagDto> tags;
    List<String> imagesBase64;
}
