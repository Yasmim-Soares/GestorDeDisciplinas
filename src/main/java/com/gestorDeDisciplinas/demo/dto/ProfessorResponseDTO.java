package com.gestorDeDisciplinas.demo.dto;

import com.gestorDeDisciplinas.demo.model.Disciplina;
import com.gestorDeDisciplinas.demo.model.Professor;

import java.util.List;
import java.util.stream.Collectors;

public record ProfessorResponseDTO (
        Long id_professor,
        String nome,
        String avisos,
        List<String> disciplinas
){
    public ProfessorResponseDTO(Professor professor){
        this(
                professor.getId_professor(),
                professor.getNome(),
                professor.getAvisos(),
                professor.getDisciplinas() != null ? professor.getDisciplinas().stream().map(Disciplina::getNome).collect(Collectors.toList()) : List.of()
        );
    }
}
