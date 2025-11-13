package model;

import jakarta.persistence.*;
import jdk.jfr.Recording;
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
    @JoinColumn(name = "id_professor")
    private Professor professor;


}
