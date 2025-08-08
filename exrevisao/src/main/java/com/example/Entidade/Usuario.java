package com.example.Entidade;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private int numeroDeDependentes;

    public Usuario(long id, String nome, LocalDate dataNascimento, int numeroDeDependentes) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroDeDependentes = numeroDeDependentes;
    }

    public int getIdade() {
        if (this.dataNascimento == null) {
            return 0;
        }
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNumeroDeDependentes() {
        return numeroDeDependentes;
    }

    public void setNumeroDeDependentes(int numeroDeDependentes) {
        this.numeroDeDependentes = numeroDeDependentes;
    }
}