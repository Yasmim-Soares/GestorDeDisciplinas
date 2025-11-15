package com.gestorDeDisciplinas.demo.controller.exceptions;

import com.gestorDeDisciplinas.demo.dto.ErroResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponseDTO> handleEntityNotFound(EntityNotFoundException ex){
        ErroResponseDTO erro = new ErroResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<List<ErroResponseDTO>> handleValidationErrors(MethodArgumentNotValidException ex){
        List<ErroResponseDTO> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErroResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                fieldError.getDefaultMessage()
        ))
                .toList();

        return ResponseEntity.badRequest().body(erros);
    }
}
