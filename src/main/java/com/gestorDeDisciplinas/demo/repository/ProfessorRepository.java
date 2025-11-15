package com.gestorDeDisciplinas.demo.repository;

import com.gestorDeDisciplinas.demo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
