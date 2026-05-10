package br.com.voltantes.bd2.streaming_dominio_publico.services;

import java.util.List;
import java.util.Optional;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;

public interface UsuarioService {
    
    public UsuarioEntity saveUsuario(UsuarioEntity usuario);

    public UsuarioEntity saveUsuario(Long id, UsuarioEntity usuario);

    public List<UsuarioEntity> findAllUsuarios();

    public Optional<UsuarioEntity> findOneUsuario(Long id);

    public boolean exists(Long id);

    public UsuarioEntity partialUpdate(long id, UsuarioEntity usuario);

    public void delete(long id);

}
