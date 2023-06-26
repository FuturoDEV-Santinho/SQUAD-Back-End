package com.devinadotion.projeto.controllers;

import com.devinadotion.projeto.models.Armazem;
import com.devinadotion.projeto.services.ArmazemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    @GetMapping("/{id}")
    public ResponseEntity<Armazem> buscarArmazemPorId(@PathVariable Long id) {
        try{
            Armazem armazem = armazemService.buscarArmazemPorId(id);
            if (armazem != null){
                return ResponseEntity.ok(armazem);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public Armazem cadastrarArmazem(@RequestBody Armazem armazem) {
        return armazemService.cadastrarArmazem(armazem);
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