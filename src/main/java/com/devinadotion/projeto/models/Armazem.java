package com.devinadotion.projeto.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
        return false;
    }
}