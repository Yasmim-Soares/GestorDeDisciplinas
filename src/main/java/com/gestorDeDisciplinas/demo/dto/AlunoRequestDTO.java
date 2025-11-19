package com.gestorDeDisciplinas.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoRequestDTO(
    @NotNull(message = "Disciplina é obrigatória")
    Long id_disciplina,

    @NotBlank(message = "Nome deve ser preenchido")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    String nome,

    String justificativa
) {}
