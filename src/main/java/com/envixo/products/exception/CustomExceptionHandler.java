package com.envixo.products.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

    final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity exception(EmptyResultDataAccessException exception) throws JsonProcessingException {
        return buildNotFoundError(exception);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity exception(EntityNotFoundException exception) throws JsonProcessingException {
        return buildNotFoundError(exception);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity exception(MethodArgumentNotValidException exception) throws JsonProcessingException {
        return buildBadRequestError(exception);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity exception(NullPointerException exception) throws JsonProcessingException {
        return buildInternalServerError(exception);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity exception(IllegalArgumentException exception) throws JsonProcessingException {
        return buildInternalServerError(exception);
    }

    private ResponseEntity buildBadRequestError(Throwable throwable) throws JsonProcessingException {
        return buildError(throwable, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity buildInternalServerError(Throwable throwable) throws JsonProcessingException {
        return buildError(throwable, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity buildNotFoundError(Throwable throwable) throws JsonProcessingException {
        return buildError(throwable, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity buildError(Throwable throwable, HttpStatus status) throws JsonProcessingException {
        final CustomError error = CustomError.builder().status(status).message(throwable.getMessage()).build();
        return new ResponseEntity(objectMapper.writeValueAsString(error), error.getStatus());
    }
}
