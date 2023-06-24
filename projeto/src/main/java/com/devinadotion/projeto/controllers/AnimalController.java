package com.devinadotion.projeto.controllers;


import com.devinadotion.projeto.models.Categoria;
import com.devinadotion.projeto.models.Produto;
import com.devinadotion.projeto.models.TipoAnimal;
import com.devinadotion.projeto.services.AnimalService;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animais")
public class AnimalController {


    @Autowired
    private AnimalService animalService;


    @GetMapping("/{grupo}/{tipo}/{totalAnimais}")
    public String obterInformacoesAnimais(@PathVariable String grupo, @PathVariable int totalAnimais, @PathVariable String tipo) {
        return animalService.obterInformacoesAnimais(grupo, tipo, totalAnimais);
    }

    @GetMapping("/agruparTodos")
    public Object agruparTodos() {
        return animalService.agruparTodos();

    }

}
