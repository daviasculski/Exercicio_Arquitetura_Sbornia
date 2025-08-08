package com.example.Servico.impl;

import com.example.Entidade.Produto;
import com.example.Servico.ProdutoRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ProdutoRepositoryMemoria implements ProdutoRepository {

    private final Map<Long, Produto> produtos = new HashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    @Override
    public Produto salvar(Produto produto) {
        if (produto.getCodigo() == 0) {
            produto.setCodigo(proximoId.getAndIncrement());
        }
        produtos.put(produto.getCodigo(), produto);
        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(long id) {
        return Optional.ofNullable(produtos.get(id));
    }
}