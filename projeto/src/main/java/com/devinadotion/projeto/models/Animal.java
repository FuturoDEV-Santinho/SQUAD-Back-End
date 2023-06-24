package com.devinadotion.projeto.models;

public class Animal {
    private String tipo;
    private String idade;
    private String grupo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Animal(String tipo, String idade, String grupo) {
        this.tipo = tipo;
        this.idade = idade;
        this.grupo = grupo;
    }
}
