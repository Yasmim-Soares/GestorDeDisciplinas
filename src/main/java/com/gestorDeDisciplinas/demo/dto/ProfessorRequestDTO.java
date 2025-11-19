package com.gestorDeDisciplinas.demo.dto;

import com.gestorDeDisciplinas.demo.model.Disciplina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequestDTO(
 @NotNull(message = "Disciplina é obrigatória")
 Disciplina id_disciplina,

 @NotBlank(message = "Nome não pode estar em branco")
 String nome,

 String avisos
) {
}
