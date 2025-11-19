package com.gestorDeDisciplinas.demo.service;

import com.gestorDeDisciplinas.demo.dto.AlunoResponseDTO;
import com.gestorDeDisciplinas.demo.dto.ProfessorRequestDTO;
import com.gestorDeDisciplinas.demo.dto.ProfessorResponseDTO;
import com.gestorDeDisciplinas.demo.model.Disciplina;
import com.gestorDeDisciplinas.demo.model.Professor;
import com.gestorDeDisciplinas.demo.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.gestorDeDisciplinas.demo.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    public final ProfessorRepository professorRepository;
    public final DisciplinaRepository disciplinaRepository;

    public ProfessorService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository) {
        this.professorRepository = professorRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public ProfessorResponseDTO salvarProfessor(ProfessorRequestDTO dto){
        Disciplina disciplina = disciplinaRepository.findById(dto.id_disciplina().getId_disciplina())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com ID " + dto.id_disciplina() + "não encontrada"));

        Professor novoProfessor = new Professor();
        novoProfessor.setNome(dto.nome());
        novoProfessor.setAvisos(dto.avisos());

        Professor professorSalvo = professorRepository.save(novoProfessor);

        disciplina.setProfessor(professorSalvo);
        disciplinaRepository.save(disciplina);
        professorSalvo.setDisciplinas(List.of(disciplina));

       return new ProfessorResponseDTO(professorSalvo);
    }

    public Optional<ProfessorResponseDTO> buscarProfessorPorId(Long id){
        return professorRepository.findById(id).map(ProfessorResponseDTO::new);
    }

    public ProfessorResponseDTO atualizarProfessor(Long id, ProfessorRequestDTO dto){
        Professor professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor com ID" + id + " não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.id_disciplina().getId_disciplina())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com ID" + dto.id_disciplina() + " não encontrada"));

        professorExistente.setNome(dto.nome());
        professorExistente.setAvisos(dto.avisos());

        Professor professorAtualizado = professorRepository.save(professorExistente);
        disciplina.setProfessor(professorAtualizado);
        disciplinaRepository.save(disciplina);

        return new ProfessorResponseDTO(professorAtualizado);
    }

    public void deletarProfessor(Long id){
        if(!professorRepository.existsById(id)){
            throw new EntityNotFoundException("Professor com ID " + id + "não encontrado");
        }
        professorRepository.deleteById(id);
    }
}
