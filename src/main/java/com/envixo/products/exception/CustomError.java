package com.envixo.products.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Builder
@Getter
public class CustomError {
    private HttpStatus status;
    private Integer code;
    private String message;

    public static class CustomErrorBuilder {
        public CustomErrorBuilder status(HttpStatus status){
            Optional.ofNullable(status).ifPresent(httpStatus -> {
                this.status = httpStatus;
                this.code = httpStatus.value();
            });
            return this;
        }
    }
}
