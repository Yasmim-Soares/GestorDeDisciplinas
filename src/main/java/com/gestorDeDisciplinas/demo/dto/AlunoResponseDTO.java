package com.gestorDeDisciplinas.demo.dto;

import com.gestorDeDisciplinas.demo.model.Aluno;

public record AlunoResponseDTO(
        Long id_aluno,
        String nome,
        String justificativa,
        int faltas,
        String nomeDisciplina

) {
    public AlunoResponseDTO(Aluno aluno){
        this(
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getJustificativa(),
                aluno.getFaltas(),
                aluno.getDisciplina() != null ? aluno.getDisciplina().getNome() : "Sem disciplina"
        );
    }
}
