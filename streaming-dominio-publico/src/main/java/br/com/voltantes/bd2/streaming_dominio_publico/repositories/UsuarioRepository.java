package br.com.voltantes.bd2.streaming_dominio_publico.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    @Query("SELECT u FROM UsuarioEntity u WHERE u.email = ?1")
    UsuarioEntity findByEmail(String email);
    
}