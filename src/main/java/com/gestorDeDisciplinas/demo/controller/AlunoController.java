package com.gestorDeDisciplinas.demo.controller;

import com.gestorDeDisciplinas.demo.dto.AlunoRequestDTO;
import com.gestorDeDisciplinas.demo.dto.AlunoResponseDTO;
import com.gestorDeDisciplinas.demo.model.Aluno;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestorDeDisciplinas.demo.service.AlunoService;

import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    public final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponseDTO salvarAluno(@RequestBody @Valid AlunoRequestDTO dto){
        return alunoService.salvarAluno(dto);
    }

    @GetMapping("/{id}")
    public Optional<AlunoResponseDTO> buscarAlunoPorId(@PathVariable Long id){
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDTO dto){
        return alunoService.atualizarAluno(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
