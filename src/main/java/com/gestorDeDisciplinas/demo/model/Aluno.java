package com.gestorDeDisciplinas.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina")
    private Disciplina disciplina;

    private int faltas;
    private String nome;
    private String justificativa;


}
