package com.example.Servico.impl;

import com.example.Entidade.Usuario;
import com.example.Servico.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UsuarioRepositoryMemoria implements UsuarioRepository {

    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    @Override
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == 0) {
            usuario.setId(proximoId.getAndIncrement());
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(long id) {
        return Optional.ofNullable(usuarios.get(id));
    }
}