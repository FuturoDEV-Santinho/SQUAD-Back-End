package com.devinadotion.projeto.services;

import com.devinadotion.projeto.models.Usuario;
import com.devinadotion.projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(String nome, String email, String senha) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente != null) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);

        return usuarioRepository.save(novoUsuario);
    }

    public boolean realizarLogin(String email, String senha) {
        if (email == null || senha == null) {
            throw new IllegalArgumentException("Email e senha são campos obrigatórios.");
        }

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null || !usuario.getSenha().equals(senha)) {
            return false; // Credenciais inválidas
        }

        return true; // Autenticação bem-sucedida
    }
}