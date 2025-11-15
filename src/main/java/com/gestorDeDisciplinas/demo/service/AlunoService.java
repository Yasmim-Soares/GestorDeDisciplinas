package com.gestorDeDisciplinas.demo.service;

import com.gestorDeDisciplinas.demo.model.Aluno;
import org.springframework.stereotype.Service;
import com.gestorDeDisciplinas.demo.repository.AlunoRepository;

import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno (Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado){
        alunoAtualizado.setId_aluno(id);
        return alunoRepository.save(alunoAtualizado);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
