package com.gestorDeDisciplinas.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    private String nome;
    private String avisos;

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;

}
