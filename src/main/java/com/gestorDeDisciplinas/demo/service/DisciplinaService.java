package com.gestorDeDisciplinas.demo.service;

import com.gestorDeDisciplinas.demo.model.Disciplina;
import org.springframework.stereotype.Service;
import com.gestorDeDisciplinas.demo.repository.DisciplinaRepository;

import java.util.Optional;

@Service
public class DisciplinaService {
    public final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Optional<Disciplina> buscarDisciplina(Long id){
        return disciplinaRepository.findById(id);
    }

    public Disciplina atualizarDisciplina(Long id, Disciplina disciplinaAtualizada){
        disciplinaAtualizada.setId_disciplina(id);
        return disciplinaRepository.save(disciplinaAtualizada);
    }

}
