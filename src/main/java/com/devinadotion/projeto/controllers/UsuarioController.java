package com.devinadotion.projeto.controllers;

import com.devinadotion.projeto.models.Usuario;
import com.devinadotion.projeto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Map<String, String> dadosUsuario) {
        String nome = dadosUsuario.get("nome");
        String email = dadosUsuario.get("email");
        String senha = dadosUsuario.get("senha");

        return usuarioService.criarUsuario(nome, email, senha);
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<String> realizarLogin(@RequestParam String email, @RequestParam String senha) {
        if (!usuarioService.realizarLogin(email, senha)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
        return ResponseEntity.ok("Login realizado com sucesso");
    }
}
