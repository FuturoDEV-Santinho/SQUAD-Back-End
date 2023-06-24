package com.devinadotion.projeto.services;

import com.devinadotion.projeto.models.Categoria;
import com.devinadotion.projeto.models.Produto;
import com.devinadotion.projeto.models.TipoAnimal;
import com.devinadotion.projeto.models.TipoProduto;
import com.devinadotion.projeto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    public List<Produto> listarProdutosEstoque() {
        List<Produto> armazenarValor = produtoService.listarProdutosEstoque();
        return null;
    }

    public Map<TipoAnimal, Map<Categoria,Map<TipoProduto, Double>>> agruparTodos () {
        List<Produto> produto = produtoRepository.findAll();
        Map<TipoAnimal, Map<Categoria,Map<TipoProduto, Double>>> agrupamento = produto.stream()
                .collect(
                        Collectors.groupingBy(Produto::getTipoAnimal,
                        Collectors.groupingBy(Produto::getCategoria,
                                Collectors.groupingBy(Produto::getTipoProduto,
                                        Collectors.summingDouble(Produto::getQuantidade)

                ))));



        System.out.println(agrupamento);
        return agrupamento;
    }

    public String obterInformacoesAnimais(String grupo, String tipo, int totalAnimais) {
        String kgRacao;
        String antiparasitaria;
        String antipulgas;


        return ("");
    }

}
