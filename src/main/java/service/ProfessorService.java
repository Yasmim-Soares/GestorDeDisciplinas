package service;

import model.Professor;
import org.springframework.stereotype.Service;
import repository.ProfessorRepository;

import java.util.Optional;

@Service
public class ProfessorService {
    public final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor salvarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public Optional<Professor> buscarProfessorPorId(Long id){
        return professorRepository.findById(id);
    }

    public Professor atualizarProfessor(Long id, Professor professorAtualizado){
        professorAtualizado.setId_professor(id);
        return professorRepository.save(professorAtualizado);
    }

    public void deletarProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
