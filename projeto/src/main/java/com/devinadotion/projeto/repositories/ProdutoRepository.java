package com.devinadotion.projeto.repositories;

import com.devinadotion.projeto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
