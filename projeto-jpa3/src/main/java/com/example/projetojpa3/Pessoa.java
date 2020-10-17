package com.example.projetojpa3;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Pessoa {
    @NotNull(message = "Digite novamente")
    @Length(min = 2, max = 10)
    private String nome;

    @Min(0)
    @Max(35)
    private Integer filhos;

    @Past
    //PastOrPresent
    //@Future
    private LocalDate nascimento;

    @Pattern(regexp = )
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public void setFilhos(Integer filhos) {
        this.filhos = filhos;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
