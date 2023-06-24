package com.devinadotion.projeto.repositories;

import com.devinadotion.projeto.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    // adicione métodos personalizados, se necessário
}