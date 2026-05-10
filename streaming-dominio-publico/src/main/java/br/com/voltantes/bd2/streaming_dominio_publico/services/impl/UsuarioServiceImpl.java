package br.com.voltantes.bd2.streaming_dominio_publico.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;
import br.com.voltantes.bd2.streaming_dominio_publico.repositories.UsuarioRepository;
import br.com.voltantes.bd2.streaming_dominio_publico.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioEntity saveUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity saveUsuario(Long id, UsuarioEntity usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> findAllUsuarios() {
        return StreamSupport.stream(
                usuarioRepository.findAll()
                .spliterator()
                ,false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioEntity> findOneUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public boolean exists(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public UsuarioEntity partialUpdate(long id, UsuarioEntity usuario) {
        usuario.setId(id);
        return usuarioRepository.findById(id).map(
            existingUsuario -> {
                Optional.ofNullable(usuario.getNome()).ifPresent(existingUsuario::setNome);
                Optional.ofNullable(usuario.getCpf()).ifPresent(existingUsuario::setCpf);
                Optional.ofNullable(usuario.getEmail()).ifPresent(existingUsuario::setEmail);
                Optional.ofNullable(usuario.getSenha()).ifPresent(existingUsuario::setSenha);
                Optional.ofNullable(usuario.getData_nascimento()).ifPresent(existingUsuario::setData_nascimento);
                return usuarioRepository.save(existingUsuario);
            }
        ).orElseThrow(() -> new RuntimeException("Usuario não existe."));
    }

    @Override
    public void delete(long id){
        usuarioRepository.deleteById(id);
    }
}
