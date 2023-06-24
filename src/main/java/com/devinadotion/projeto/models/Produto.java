package com.devinadotion.projeto.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeArmazem;
    private TipoAnimal tipoAnimal;
    private TipoProduto tipoProduto;
    private int quantidade;
    private Categoria categoria;

    @ManyToOne
    private Armazem armazem;
}
