package com.envixo.products.dto.search;

import com.envixo.products.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductSearchDto extends GenericSearchDto {
    @NotNull
    @NotBlank
    @NotEmpty
    private String description;
    @NotNull
    private Status status;
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal price;
    private BigDecimal specialPrice;
}
