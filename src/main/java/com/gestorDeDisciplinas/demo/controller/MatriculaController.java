package com.gestorDeDisciplinas.demo.controller;

import com.gestorDeDisciplinas.demo.model.Matricula;
import com.gestorDeDisciplinas.demo.service.MatriculaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    private MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService){
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public Matricula salvarMatricula(@RequestBody Matricula matricula){
       return matriculaService.salvarMatricula(matricula);
    }
    
}
