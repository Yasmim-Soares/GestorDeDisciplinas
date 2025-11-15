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
    private final DisciplinaRepository disciplinaRepository;

    public AlunoService(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public AlunoResponseDTO salvarAluno (AlunoRequestDTO dto) {
        Disciplina disciplina = disciplinaRepository.findById(dto.id_disciplina())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com ID " + dto.id_disciplina() + " não econtrada"));

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(dto.nome());
        novoAluno.setDisciplina(disciplina);
        novoAluno.setFaltas(0);
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

        Disciplina disciplina = disciplinaRepository.findById(dto.id_disciplina())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com ID" + dto.id_disciplina() + " não encontrado"));

        alunoExistente.setNome(dto.nome());
        alunoExistente.setDisciplina(disciplina);

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
