package com.devinadotion.projeto.controllers;

import com.devinadotion.projeto.models.Armazem;
import com.devinadotion.projeto.services.ArmazemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armazem")
public class ArmazemController {
    private final ArmazemService armazemService;

    @Autowired
    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }

    @GetMapping
    public List<Armazem> listarArmazens() {
        return armazemService.listarArmazens();
    }

    @PostMapping
    public Armazem cadastrarArmazem(@RequestBody Armazem armazem) {
        return armazemService.cadastrarArmazem(armazem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Armazem> buscarArmazemPorId(@PathVariable Long id) {
        Armazem armazem = armazemService.buscarArmazemPorId(id);
        return ResponseEntity.ok(armazem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Armazem> editarArmazem(@PathVariable Long id, @RequestBody Armazem armazem) {
        Armazem armazemAtualizado = armazemService.editarArmazem(id, armazem);
        return ResponseEntity.ok(armazemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirArmazem(@PathVariable Long id) {
        try {
            armazemService.excluirArmazem(id);
            return ResponseEntity.ok("Armazém excluído com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
