package com.example.Servico.Strategy;

import com.example.Agregado.Venda;

public interface CalculadoraImposto {
    double calcular(Venda venda);
}