package com.devinadotion.projeto.repositories;

import com.devinadotion.projeto.models.Armazem;
import com.devinadotion.projeto.models.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem, Long> {
    Optional<Armazem> findByNomeAndTipoAnimal(String nome, TipoAnimal tipoAnimal);
}