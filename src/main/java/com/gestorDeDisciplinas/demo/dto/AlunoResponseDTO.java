package com.gestorDeDisciplinas.demo.dto;

import com.gestorDeDisciplinas.demo.model.Aluno;

import java.util.List;

public record AlunoResponseDTO(
        Long id_aluno,
        String nome,
        String justificativa
) {
    public AlunoResponseDTO(Aluno aluno){
        this(
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getJustificativa()
        );
    }
}
