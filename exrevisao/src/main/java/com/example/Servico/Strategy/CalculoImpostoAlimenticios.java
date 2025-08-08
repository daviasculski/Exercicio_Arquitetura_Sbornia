package com.example.Servico.Strategy;

import com.example.Agregado.ItemVenda;
import com.example.Agregado.Venda;
import com.example.Entidade.CategoriaProduto;

public class CalculoImpostoAlimenticios implements CalculadoraImposto {
    @Override
    public double calcular(Venda venda) {
        return venda.getItens().stream()
                .filter(item -> item.getProduto().getCategoria() == CategoriaProduto.ALIMENTICIOS)
                .mapToDouble(item -> item.getSubtotal() * 0.05)
                .sum();
    }
}