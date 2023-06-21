package com.devinadotion.projeto.services;

import com.devinadotion.projeto.models.Armazem;
import com.devinadotion.projeto.models.TipoAnimal;
import com.devinadotion.projeto.repositories.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazemService {
    private final ArmazemRepository armazemRepository;

    @Autowired
    public ArmazemService(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;
    }

    public List<Armazem> listarArmazens() {
        return armazemRepository.findAll();
    }

    public Armazem cadastrarArmazem(Armazem armazem) {
        return armazemRepository.save(armazem);
    }

    public Armazem buscarArmazemPorId(Long id) {
        return armazemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Armazém não encontrado"));
    }

    public Armazem editarArmazem(Long id, Armazem armazem) {
        Optional<Armazem> armazemExistenteOptional = armazemRepository.findById(id);

        if (armazemExistenteOptional.isEmpty()) {
            throw new IllegalArgumentException("ID do armazém não foi encontrado");
        }

        Armazem armazemExistente = armazemExistenteOptional.get();

        armazemExistente.setNome(armazem.getNome());
        armazemExistente.setTipoAnimal(armazem.getTipoAnimal());

        return armazemRepository.save(armazemExistente);
    }

    public void excluirArmazem(Long id) {
        Optional<Armazem> armazemOptional = armazemRepository.findById(id);
        if (armazemOptional.isPresent()) {
            armazemRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Armazém não encontrado");
        }
    }
}
