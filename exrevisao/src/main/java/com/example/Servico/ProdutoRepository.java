package com.example.Servico;

import com.example.Entidade.Produto;
import java.util.Optional;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(long id);
}