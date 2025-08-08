package com.example.Servico.Strategy;

import com.example.Agregado.ItemVenda;
import com.example.Agregado.Venda;
import com.example.Entidade.CategoriaProduto;

public class CalculoImpostoBebidas implements CalculadoraImposto {
    @Override
    public double calcular(Venda venda) {
        return venda.getItens().stream()
                .filter(item -> item.getProduto().getCategoria() == CategoriaProduto.BEBIDAS_ALCOOLICAS)
                .mapToDouble(item -> item.getSubtotal() * 1.00)
                .sum();
    }
}