package com.gestorDeDisciplinas.demo.service;

import com.gestorDeDisciplinas.demo.dto.AlunoRequestDTO;
import com.gestorDeDisciplinas.demo.dto.AlunoResponseDTO;
import com.gestorDeDisciplinas.demo.model.Aluno;
import com.gestorDeDisciplinas.demo.model.Disciplina;
import com.gestorDeDisciplinas.demo.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.gestorDeDisciplinas.demo.repository.AlunoRepository;

import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponseDTO salvarAluno (AlunoRequestDTO dto) {

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(dto.nome());
        novoAluno.setJustificativa(null);

        Aluno alunoSalvo = alunoRepository.save(novoAluno);

        return new AlunoResponseDTO(alunoSalvo);
    }

    public Optional<AlunoResponseDTO> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id).map(AlunoResponseDTO::new);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO dto){
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno com ID" + id + " não encontrado"));

        alunoExistente.setNome(dto.nome());
        alunoExistente.setJustificativa(null);

        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);

        return new AlunoResponseDTO(alunoAtualizado);
    }

    public void deletarAluno(Long id){
        if (!alunoRepository.existsById(id)){
            throw new EntityNotFoundException("Aluno com ID " + id + "não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
