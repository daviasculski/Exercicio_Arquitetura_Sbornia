package com.example.Entidade;

public class Produto {
    private long codigo;
    private String descricao;
    private double precoUnitario;
    private CategoriaProduto categoria;

    public Produto(long codigo, String descricao, double precoUnitario, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
}