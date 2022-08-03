package com.envixo.products.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GenericDto {
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;

    public GenericDto(){}
}
