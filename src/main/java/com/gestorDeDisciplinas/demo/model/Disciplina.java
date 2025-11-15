package com.gestorDeDisciplinas.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    private String nome;

    @OneToMany(mappedBy = "disciplina")
    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "professor")
    private Professor professor;


}
