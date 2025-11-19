package com.gestorDeDisciplinas.demo.service;

import com.gestorDeDisciplinas.demo.dto.MatriculaRequestDTO;
import com.gestorDeDisciplinas.demo.model.Matricula;
import com.gestorDeDisciplinas.demo.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula salvarMatricula(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

    public void deletarMatricula(Long id){
        matriculaRepository.deleteById(id);
    }
}
