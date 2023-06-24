package com.devinadotion.projeto.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
@Table(name = "tb_armazem")
public class Armazem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_animal")
    private TipoAnimal tipoAnimal;

    public boolean possuiProdutos() {
        // Implemente a lógica para verificar se o armazém possui produtos associados
        // Retorne true se houver produtos, false caso contrário
        // Exemplo:
        // return !produtos.isEmpty(); // Considerando que o armazém possui uma lista de produtos
        return false;
    }


    //criação dos Getter, Setter e Condtrutores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }


}
