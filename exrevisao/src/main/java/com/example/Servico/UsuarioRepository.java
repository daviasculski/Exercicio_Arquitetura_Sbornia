package com.example.Servico;

import com.example.Entidade.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(long id);
}