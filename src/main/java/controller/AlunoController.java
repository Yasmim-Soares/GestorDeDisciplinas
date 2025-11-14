package controller;

import model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AlunoService;

import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    public final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping("/{id}")
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id){
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        return alunoService.atualizarAluno(id, alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
