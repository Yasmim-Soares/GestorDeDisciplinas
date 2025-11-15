package com.gestorDeDisciplinas.demo.dto;

public record ErroResponseDTO(
        int status,
        String erro,
        String mensagem
) {
}
