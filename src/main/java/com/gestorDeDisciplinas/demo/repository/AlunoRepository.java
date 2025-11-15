package com.gestorDeDisciplinas.demo.repository;

import com.gestorDeDisciplinas.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,  Long> {
}
