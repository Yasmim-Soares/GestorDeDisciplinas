package com.gestorDeDisciplinas.demo.dto;

import com.gestorDeDisciplinas.demo.model.Aluno;

public record AlunoResponseDTO(
        Long id_aluno,
        String nome,
        String nomeDisciplina
) {
    public AlunoResponseDTO(Aluno aluno){
        this(
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getDisciplina() != null ? aluno.getDisciplina().getNome() : "Sem disciplina"
        );
    }
}
