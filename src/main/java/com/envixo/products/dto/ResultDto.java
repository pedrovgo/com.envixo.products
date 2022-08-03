package com.envixo.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDto<R extends GenericDto> {

    public ResultDto(R result){
        this.result = result;
    }

    private R result;
}
