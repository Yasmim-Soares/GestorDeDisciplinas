package com.gestorDeDisciplinas.demo.controller;

import com.gestorDeDisciplinas.demo.model.Disciplina;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestorDeDisciplinas.demo.service.DisciplinaService;

import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    public final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }


    @GetMapping("/{id}")
    public Optional<Disciplina> buscarDisciplina(@PathVariable Long id){
        return disciplinaService.buscarDisciplina(id);
    }

    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada){
        return disciplinaService.atualizarDisciplina(id, disciplinaAtualizada);
    }

}
