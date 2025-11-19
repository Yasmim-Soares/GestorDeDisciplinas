package com.gestorDeDisciplinas.demo.repository;

import com.gestorDeDisciplinas.demo.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
