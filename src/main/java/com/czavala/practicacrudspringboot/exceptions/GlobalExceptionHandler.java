package com.czavala.practicacrudspringboot.exceptions;

import com.czavala.practicacrudspringboot.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice // mapea/controla exceptions
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGlobalException(Exception e, HttpServletRequest request) {
        ApiError error = new ApiError();
        error.setLocalizedMessage(error.getLocalizedMessage());
        error.setMessage("Ha ocurrido un error en la petición");
        error.setUrl(request.getRequestURL().toString());
        error.setMethod(request.getMethod());
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setLocalizedMessage(e.getLocalizedMessage());
        apiError.setMessage(e.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .toList()
                .toString());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setMethod(request.getMethod());
        apiError.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
