package com.example.projetojpa1.dominius;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Classe -> PascalCase
Tabelas -> snake_case
*/


@Entity
public class Praia {

    @Id
    private Integer id;

    private String nome;

    private Double tamanho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }
}
