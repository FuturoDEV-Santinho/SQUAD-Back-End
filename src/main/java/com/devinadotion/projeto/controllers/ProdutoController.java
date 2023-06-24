package com.devinadotion.projeto.controllers;

import com.devinadotion.projeto.models.Produto;
import com.devinadotion.projeto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping("/estoque")
    public List<Produto> listarProdutosEstoque() {
        return produtoService.listarProdutosEstoque();
    }

    @PutMapping("/{id}/estoque")
    public Produto editarProdutoEstoque(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.editarProdutoEstoque(id, produto);
    }

    @DeleteMapping("/{id}/estoque")
    public ResponseEntity<String> removerProdutoEstoque(@PathVariable Long id) {
        try {
            produtoService.removerProdutoEstoque(id);
            return ResponseEntity.ok("Produto excluído com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}