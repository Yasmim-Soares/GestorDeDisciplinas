package com.gestorDeDisciplinas.demo.controller;

import com.gestorDeDisciplinas.demo.dto.ProfessorRequestDTO;
import com.gestorDeDisciplinas.demo.dto.ProfessorResponseDTO;
import com.gestorDeDisciplinas.demo.model.Professor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestorDeDisciplinas.demo.service.ProfessorService;

import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private ProfessorService professorService;

    public  ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorResponseDTO salvarProfessor(@RequestBody @Valid ProfessorRequestDTO dto){
        return professorService.salvarProfessor(dto);
    }

    @GetMapping("/{id}")
    public Optional<ProfessorResponseDTO> buscarProfessorPorId(@PathVariable Long id){
        return  professorService.buscarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    public ProfessorResponseDTO atualizarProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorRequestDTO dto){
        return professorService.atualizarProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProfessor(@PathVariable Long id){
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
