package com.example.Servico.impl;

import com.example.Agregado.Venda;
import com.example.Servico.VendaRepository;
import java.util.HashMap;
import java.util.Map;

public class VendaRepositoryMemoria implements VendaRepository {

    private final Map<Long, Venda> vendas = new HashMap<>();

    @Override
    public Venda salvar(Venda venda) {
        vendas.put(venda.getId(), venda);
        return venda;
    }
}