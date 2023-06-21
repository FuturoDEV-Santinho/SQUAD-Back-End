package com.devinadotion.projeto.services;

import com.devinadotion.projeto.models.Armazem;
import com.devinadotion.projeto.models.Produto;
import com.devinadotion.projeto.models.TipoAnimal;
import com.devinadotion.projeto.repositories.ArmazemRepository;
import com.devinadotion.projeto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ArmazemService armazemService;
    private final ArmazemRepository armazemRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ArmazemService armazemService, ArmazemRepository armazemRepository) {
        this.produtoRepository = produtoRepository;
        this.armazemService = armazemService;
        this.armazemRepository = armazemRepository;
    }

    public Produto cadastrarProduto(Produto produto) {
        // Verificar se o nome do armazém existe e se o tipo de animal corresponde ao armazém
        String nomeArmazem = produto.getNomeArmazem();
        TipoAnimal tipoAnimal = produto.getTipoAnimal();

        Armazem armazem = armazemRepository.findByNomeAndTipoAnimal(nomeArmazem, tipoAnimal)
                .orElseThrow(() -> new IllegalArgumentException("O armazém não existe ou não corresponde ao tipo de animal"));

        // Se o armazém existe e o tipo de animal corresponde, cadastrar o produto
        produto.setArmazem(armazem);
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutosEstoque() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto editarProdutoEstoque(Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produtoExistente.setNomeArmazem(produto.getNomeArmazem());
        produtoExistente.setQuantidade(produto.getQuantidade());

        return produtoRepository.save(produtoExistente);
    }

    public void removerProdutoEstoque(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }
}