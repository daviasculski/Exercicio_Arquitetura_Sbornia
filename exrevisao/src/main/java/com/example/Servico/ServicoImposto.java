package com.example.Servico;

import com.example.Agregado.Venda;
import com.example.Entidade.CategoriaProduto;
import com.example.Servico.Strategy.CalculoImpostoAlimenticios;
import com.example.Servico.Strategy.CalculoImpostoAutomotivos;
import com.example.Servico.Strategy.CalculoImpostoBase;
import com.example.Servico.Strategy.CalculoImpostoBebidas;
import com.example.Servico.Strategy.CalculadoraImposto;

import java.util.HashMap;
import java.util.Map;

public class ServicoImposto {

    private final Map<CategoriaProduto, CalculadoraImposto> estrategias;

    public ServicoImposto() {
        estrategias = new HashMap<>();
        estrategias.put(CategoriaProduto.ALIMENTICIOS, new CalculoImpostoAlimenticios());
        estrategias.put(CategoriaProduto.AUTOMOTIVOS, new CalculoImpostoAutomotivos());
        estrategias.put(CategoriaProduto.BEBIDAS_ALCOOLICAS, new CalculoImpostoBebidas());
        estrategias.put(CategoriaProduto.OUTROS, new CalculoImpostoBase());
    }

    public double calcularImpostoDaVenda(Venda venda) {
        double impostoTotal = 0;
        double impostoBebidas = 0;

        if (venda.getUsuario().getIdade() > 60) {
            impostoTotal = this.estrategias.get(CategoriaProduto.BEBIDAS_ALCOOLICAS).calcular(venda);
            return impostoTotal;
        }

        for (CategoriaProduto categoria : this.estrategias.keySet()) {
            double impostoCalculado = this.estrategias.get(categoria).calcular(venda);
            if (categoria == CategoriaProduto.BEBIDAS_ALCOOLICAS) {
                impostoBebidas = impostoCalculado;
            }
            impostoTotal += impostoCalculado;
        }

        if (venda.getUsuario().getNumeroDeDependentes() > 3) {
            double impostoNaoBebidas = impostoTotal - impostoBebidas;
            double desconto = impostoNaoBebidas * 0.50;
            impostoTotal -= desconto;
        }

        return impostoTotal;
    }
}