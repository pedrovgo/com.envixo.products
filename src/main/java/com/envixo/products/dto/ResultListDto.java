package com.envixo.products.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ResultListDto<R extends GenericDto, C extends Collection<R>> {

    public ResultListDto(C result){
        this.result = result;
    }

    private C result;
}
