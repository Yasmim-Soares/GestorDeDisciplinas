package com.gestorDeDisciplinas.demo.controller;

import com.gestorDeDisciplinas.demo.model.Professor;
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
    public Professor salvarProfessor(@RequestBody Professor professor){
        return professorService.salvarProfessor(professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id){
        return  professorService.buscarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado){
        return professorService.atualizarProfessor(id, professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProfessor(@PathVariable Long id){
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
