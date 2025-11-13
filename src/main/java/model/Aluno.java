package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    private String nome;
    private int faltas;
    private String justificativa;


}
