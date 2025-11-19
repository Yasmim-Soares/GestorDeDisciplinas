package com.gestorDeDisciplinas.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    private String nome;

    @OneToMany(mappedBy = "disciplina")
    private List<Matricula> matriculas;

    @ManyToOne
    @JoinColumn(name = "professor")
    private Professor professor;
}
