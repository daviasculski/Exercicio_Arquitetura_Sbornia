package com.example.Agregado;

import com.example.Entidade.Produto;
import com.example.Entidade.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private long id;
    private Usuario usuario;
    private List<ItemVenda> itens;

    public Venda(long id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemVenda(produto, quantidade));
    }

    public double getValorTotalItens() {
        return this.itens.stream()
                .mapToDouble(ItemVenda::getSubtotal)
                .sum();
    }

    public long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<ItemVenda> getItens() {
        return new ArrayList<>(itens);
    }
}